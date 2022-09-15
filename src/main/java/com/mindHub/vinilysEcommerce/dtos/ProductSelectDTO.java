package com.mindHub.vinilysEcommerce.dtos;


public class ProductSelectDTO {

    private Long id;

    private Integer quantity;

    public ProductSelectDTO() {
    }

    public ProductSelectDTO(Long id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
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
}
