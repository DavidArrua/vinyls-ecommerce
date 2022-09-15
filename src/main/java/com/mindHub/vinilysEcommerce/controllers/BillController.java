package com.mindHub.vinilysEcommerce.controllers;


import com.mindHub.vinilysEcommerce.dtos.ProductSelectDTO;
import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.repositories.BillRepository;
import com.mindHub.vinilysEcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class BillController {

    @Autowired
    BillRepository billRepository;

    @Autowired
    ProductService productService;

    @PostMapping("/api/bills")
    public ResponseEntity <Object> bills (@RequestBody Set<ProductSelectDTO> productSelectDTOSet){
        double total = 0.0;
        List<Product>productList = new ArrayList<>();
        productSelectDTOSet.forEach(product ->{
            Product product1 = productService.getProductById(product.getId());
            for (int i = 0; i < product.getQuantity(); i++){
                productList.add(product1);
            }
        });
//        total += product1.getPrice();
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
