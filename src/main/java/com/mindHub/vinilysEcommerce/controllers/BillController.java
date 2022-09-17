package com.mindHub.vinilysEcommerce.controllers;


import com.mindHub.vinilysEcommerce.dtos.ProductSelectDTO;
import com.mindHub.vinilysEcommerce.models.*;
import com.mindHub.vinilysEcommerce.repositories.BillRepository;
import com.mindHub.vinilysEcommerce.repositories.ProductBillRepository;
import com.mindHub.vinilysEcommerce.services.ClientService;
import com.mindHub.vinilysEcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RestController
public class BillController {

    @Autowired
    BillRepository billRepository;

    @Autowired
    ProductBillRepository productBillRepository;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    @PostMapping("/api/bills")
    public ResponseEntity <Object> bills (@RequestBody Set<ProductSelectDTO> productSelectDTOSet, @RequestParam String delivery, Authentication authentication){

        Client client = clientService.getClientByEmail(authentication.getName());

        if(productSelectDTOSet.isEmpty()){
            return new ResponseEntity<>("Missing data.",HttpStatus.FORBIDDEN);
        }
        if(delivery.isEmpty()){
            return new ResponseEntity<>("The delivery data is missing",HttpStatus.FORBIDDEN);
        }


        Bill bill = new Bill("11",0.0, Delivery.valueOf(delivery), 0.0, 0.0, 0.0 ,LocalDateTime.now(),client);
        billRepository.save(bill);
        List<Product>productList = new ArrayList<>();
        Map<Product,Integer> productToSell = new HashMap<>();

        List<Product>selectedProductList = productSelectDTOSet.stream().map(productSelectDTO -> productService.getProductById(productSelectDTO.getId())).collect(Collectors.toList());

        productSelectDTOSet.forEach(productSelectDTO -> {
            productToSell.put(productService.getProductById(productSelectDTO.getId()),productSelectDTO.getQuantity());
        });

        for (Map.Entry<Product, Integer> product: productToSell.entrySet()) {

            if (productService.getProductById(product.getKey().getId()) == null) {

                return new ResponseEntity<>("El producto no existe",HttpStatus.FORBIDDEN);
            }

            System.out.println( "key: " + product.getKey().getName() + " value: " + product.getValue());




        }






























        productSelectDTOSet.forEach(product ->{
            Product product1 = productService.getProductById(product.getId());
            if(product1.getStock() > 0 && product.getQuantity() <= product1.getStock()) {

                ProductBill productBill = new ProductBill(product.getQuantity(), product1, bill);

                for (int i = 0; i < product.getQuantity(); i++) {
                        productList.add(product1);
                        Product selectProduct = productService.getProductById(product1.getId());

                        selectProduct.setStock(selectProduct.getStock() - 1);

                        Double productPrice = selectProduct.getPrice();
                        productService.saveProduct(selectProduct);

                        bill.setGrossAmount(bill.getGrossAmount() + productPrice);

                        billRepository.save(bill);
                }
                productBillRepository.save(productBill);
            }
        }

        );

       bill.setNetAmount(bill.getGrossAmount() * 1.21);

        if(bill.getGrossAmount()>0) {

            if (delivery.equals("CABA")) {
                bill.setDeliveryAmount(300.00);
                bill.setTotalAmount(bill.getNetAmount() + 300.00);
            }
            else if (delivery.equals("AMBA")){
                bill.setDeliveryAmount(500.00);
                bill.setTotalAmount(bill.getNetAmount() + 500.00);
            }
            else if (delivery.equals("INTERIOR")) {
                bill.setDeliveryAmount(700.00);
                bill.setTotalAmount(bill.getNetAmount() + 700.00);
            }else {
                return new ResponseEntity<>("The delivery data is missing",HttpStatus.FORBIDDEN);
            }
                billRepository.save(bill);


        } else {
            if (delivery.equals("CABA")) {
                bill.setDeliveryAmount(00.00);
                bill.setTotalAmount(bill.getNetAmount() + 00.00);
            }

            if (delivery.equals("AMBA")) {
                bill.setDeliveryAmount(00.00);
                bill.setTotalAmount(bill.getNetAmount() + 00.00);
            }

            if (delivery.equals("INTERIOR")) {
                bill.setDeliveryAmount(00.00);
                bill.setTotalAmount(bill.getNetAmount() + 00.00);

            }
        }

            billRepository.save(bill);
        return new ResponseEntity<>("productList",HttpStatus.CREATED);
    }
}
