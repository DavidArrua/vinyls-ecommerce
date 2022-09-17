package com.mindHub.vinilysEcommerce.models;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String name, author, releaseDate, brand;
    @ElementCollection
    private List<String> image;

    @ElementCollection
    private Set<String> genres = new HashSet<>();

    private Integer stock;

    private double price;

    private Boolean firstHand;

    private ProductType productType;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<ProductBill> productBills = new HashSet<>();


    public Product() {
    }

    public Product(String name, String author, String releaseDate, List<String> image, Set<String> genres, Integer stock, double price, Boolean firstHand, ProductType productType, String brand) {
        this.name = name;
        this.author = author;
        this.releaseDate = releaseDate;
        this.image = image;
        this.genres = genres;
        this.stock = stock;
        this.price = price;
        this.firstHand = firstHand;
        this.productType = productType;
        this.brand = brand;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }

    public Set<String> getGenre() {
        return genres;
    }

    public void setGenre(Set<String> genres) {
        this.genres = genres;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getFirstHand() {
        return firstHand;
    }

    public void setFirstHand(Boolean firstHand) {
        this.firstHand = firstHand;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Set<String> getGenres() {
        return genres;
    }

    public void setGenres(Set<String> genres) {
        this.genres = genres;
    }

    public Set<ProductBill> getProductBills() {
        return productBills;
    }

    public void setProductBills(Set<ProductBill> productBills) {
        this.productBills = productBills;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

     public void subtractStock(){this.stock -= 1;}
}
