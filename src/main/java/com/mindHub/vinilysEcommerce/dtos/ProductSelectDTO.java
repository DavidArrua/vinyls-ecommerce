package com.mindHub.vinilysEcommerce.dtos;


import com.mindHub.vinilysEcommerce.models.Delivery;

public class ProductSelectDTO {

    private Long id;

    private Integer quantity;

    private String delivery;


    public ProductSelectDTO() {
    }

    public ProductSelectDTO(Long id, Integer quantity, String delivery) {
        this.id = id;
        this.quantity = quantity;
        this.delivery = delivery;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDelivery() {
        return delivery;
    }
}
