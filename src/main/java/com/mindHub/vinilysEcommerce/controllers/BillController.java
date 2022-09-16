package com.mindHub.vinilysEcommerce.controllers;


import com.mindHub.vinilysEcommerce.dtos.ProductSelectDTO;
import com.mindHub.vinilysEcommerce.models.Bill;
import com.mindHub.vinilysEcommerce.models.Client;
import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.models.ProductBill;
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
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

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
    public ResponseEntity <Object> bills (@RequestBody Set<ProductSelectDTO> productSelectDTOSet, Authentication authentication){
        Client client = clientService.getClientByEmail(authentication.getName());
        AtomicReference<Double> total = new AtomicReference<>(0.0);
        Bill bill = new Bill("11",250.00,total.get(), total.get() * 1.21, LocalDateTime.now(),client);
        billRepository.save(bill);
        List<Product>productList = new ArrayList<>();

        productSelectDTOSet.forEach(product ->{

            Product product1 = productService.getProductById(product.getId());
            ProductBill productBill = new ProductBill(product.getQuantity(),product1,bill);

            for (int i = 0; i < product.getQuantity(); i++){
                productList.add(product1);
                Product selectProduct = productService.getProductById(product1.getId());
                selectProduct.setStock(selectProduct.getStock() - 1);
                 double productPrice = selectProduct.getPrice();
                 total.updateAndGet(v -> (double) (v + productPrice));
                productService.saveProduct(selectProduct);
            }
            productBillRepository.save(productBill);



            
        });



//        total += product1.getPrice();


        return new ResponseEntity<>("productList",HttpStatus.CREATED);
    }
}
