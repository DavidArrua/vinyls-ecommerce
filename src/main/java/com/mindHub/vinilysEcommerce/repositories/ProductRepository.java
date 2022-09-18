package com.mindHub.vinilysEcommerce.repositories;


import com.mindHub.vinilysEcommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findProductByName (String name);
}
