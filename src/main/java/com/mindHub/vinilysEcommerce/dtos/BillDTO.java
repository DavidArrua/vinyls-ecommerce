package com.mindHub.vinilysEcommerce.dtos;

import com.mindHub.vinilysEcommerce.models.Bill;
import com.mindHub.vinilysEcommerce.models.ProductBill;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BillDTO {

    private long id;

    private String number;

    private Double deliveryAmount, grossAmount, netAmount;

    private LocalDateTime date;

    private Set<ProductBillDTO> productBills;

    public BillDTO() {
    }

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.number = bill.getNumber();
        this.deliveryAmount = bill.getDeliveryAmount();
        this.grossAmount = bill.getGrossAmount();
        this.netAmount = bill.getNetAmount();
        this.date = bill.getDate();
        this.productBills = bill.getProductBills().stream().map(productBill -> new ProductBillDTO(productBill)).collect(Collectors.toSet());
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Double getDeliveryAmount() {
        return deliveryAmount;
    }

    public Double getGrossAmount() {
        return grossAmount;
    }

    public Double getNetAmount() {
        return netAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Set<ProductBillDTO> getProductBills() {
        return productBills;
    }
}
