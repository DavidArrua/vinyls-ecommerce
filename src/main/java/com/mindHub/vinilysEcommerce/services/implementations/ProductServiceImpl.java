package com.mindHub.vinilysEcommerce.services.implementations;

import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.repositories.ProductRepository;
import com.mindHub.vinilysEcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
