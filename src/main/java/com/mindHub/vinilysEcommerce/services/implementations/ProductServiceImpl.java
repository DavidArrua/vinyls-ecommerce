package com.mindHub.vinilysEcommerce.services.implementations;

import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.repositories.ProductRepository;
import com.mindHub.vinilysEcommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Set<Product> getAllProducts() {
        return productRepository.findAll().stream().collect(Collectors.toSet());
    }

    public Product getProductById(long id){
     return productRepository.findById(id).get();
    }
}
