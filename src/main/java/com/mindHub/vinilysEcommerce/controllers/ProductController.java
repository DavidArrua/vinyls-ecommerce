package com.mindHub.vinilysEcommerce.controllers;

import com.mindHub.vinilysEcommerce.dtos.ProductDTO;
import com.mindHub.vinilysEcommerce.models.Client;
import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.models.ProductType;
import com.mindHub.vinilysEcommerce.services.ClientService;
import com.mindHub.vinilysEcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    @GetMapping("/products")
    public Set<ProductDTO> getProducts(){
        return productService.getAllProducts().stream().map(product -> new ProductDTO(product)).collect(Collectors.toSet());
    }

    @PostMapping("/add/vinyl/products")
    public ResponseEntity<Object> addProductsVinyl(
            @RequestParam String name, @RequestParam String author,
            @RequestParam String releaseDate, @RequestParam List<String> image,
            @RequestParam Set<String> genres, @RequestParam Integer stock,
            @RequestParam Double price, @RequestParam Boolean firstHand,
            @RequestParam String productType, @RequestParam String brand,
            Authentication authentication
            ){

        Client clientAuthentication = clientService.getClientByEmail(authentication.getName());


        if(name.isEmpty() || author.isEmpty() || releaseDate.isEmpty() || image.isEmpty() ||genres.isEmpty() || stock <= 0 || price.isNaN() || price <= 0|| firstHand == null || productType.isEmpty() || brand.isEmpty()){
                return new ResponseEntity<>("Missing data", HttpStatus.FORBIDDEN);
        }


        Product newProduct = new Product(name, author,releaseDate,image,genres,stock,price,firstHand, ProductType.valueOf(productType), brand);
        productService.saveProduct(newProduct);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
