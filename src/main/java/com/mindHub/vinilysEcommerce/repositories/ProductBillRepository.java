package com.mindHub.vinilysEcommerce.repositories;


import com.mindHub.vinilysEcommerce.models.ProductBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductBillRepository extends JpaRepository<ProductBill, Long> {
}
