package com.mindHub.vinilysEcommerce.dtos;


import com.mindHub.vinilysEcommerce.models.Product;
import com.mindHub.vinilysEcommerce.models.ProductBill;
import com.mindHub.vinilysEcommerce.models.ProductType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProductDTO {
    private long id;

    private String name,author, releaseDate, brand, description ;

    private List<String> image;
    private Set<String> genres;

    private Integer stock;

    private double price;

    private Boolean firstHand;

    private ProductType productType;

    public ProductDTO() {
    }

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.author = product.getAuthor();
        this.description = product.getDescription();
        this.releaseDate = product.getReleaseDate();
        this.image = product.getImage();
        this.genres = product.getGenres();
        this.stock = product.getStock();
        this.price = product.getPrice();
        this.firstHand = product.getFirstHand();
        this.productType = product.getProductType();
        this.brand = product.getBrand();
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public List<String> getImage() {
        return image;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public Integer getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public Boolean getFirstHand() {
        return firstHand;
    }

    public ProductType getProductType() {
        return productType;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }
}
