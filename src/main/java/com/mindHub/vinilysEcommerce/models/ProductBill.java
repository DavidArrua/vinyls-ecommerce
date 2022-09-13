package com.mindHub.vinilysEcommerce.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class ProductBill {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "bill_id")
    private Bill bill;


    public ProductBill() {
    }

    public ProductBill(Integer quantity, Product product, Bill bill) {
        this.quantity = quantity;
        this.product = product;
        this.bill = bill;
    }


    public long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
