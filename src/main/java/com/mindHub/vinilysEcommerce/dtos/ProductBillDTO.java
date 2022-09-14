package com.mindHub.vinilysEcommerce.dtos;


import com.mindHub.vinilysEcommerce.models.Bill;
import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.models.ProductBill;

import java.util.List;

public class ProductBillDTO {
    private long id;
    private Integer quantity;

    private Long product_id;

    private String productName, productAuthor;

    private List<String> productImage;

    private Double productPrice;


    public ProductBillDTO() {
    }

    public ProductBillDTO(ProductBill productBill) {
        this.id = productBill.getId();
        this.quantity = productBill.getQuantity();
        this.productName = productBill.getProduct().getName();
        this.product_id = productBill.getProduct().getId();
        this.productPrice = productBill.getProduct().getPrice();
        this.productImage = productBill.getProduct().getImage();
        this.productAuthor= productBill.getProduct().getAuthor();
    }


    public long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public List<String> getProductImage() {
        return productImage;
    }

    public String getProductAuthor() {
        return productAuthor;
    }

    public Double getProductPrice() {
        return productPrice;
    }
}
