package com.mindHub.vinilysEcommerce.repositories;

import com.mindHub.vinilysEcommerce.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BillRepository extends JpaRepository<Bill, Long> {
}
