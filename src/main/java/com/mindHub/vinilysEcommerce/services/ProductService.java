package com.mindHub.vinilysEcommerce.services;

import com.mindHub.vinilysEcommerce.models.Product;

import java.util.Set;

public interface ProductService {

    public void saveProduct(Product product);

    public Set<Product> getAllProducts();
}
