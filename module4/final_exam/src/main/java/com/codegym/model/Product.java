package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

@Entity
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "product_name")
    @NotBlank(message = "Name must not be Blank")
    protected String name;

    @Column(name = "product_price")
    @NotNull(message = "Price must not be Blank")
    protected double price;

    @Column(name = "product_status")
    @NotNull(message = "status must not be Null")
    protected String status;

    @ManyToOne
    @JoinColumn(name = "product_type_id")
    protected ProductType productType;

    public Product() {
    }

    public Product(Long id, @NotBlank(message = "Name must not be Blank") String name, @NotNull(message = "Price must not be Blank") double price, @NotNull(message = "status must not be Null") String status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
}
