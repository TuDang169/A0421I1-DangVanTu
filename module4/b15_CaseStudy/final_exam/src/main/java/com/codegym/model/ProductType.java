package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductType {
    @Id
    @Column(name = "product_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "product_type_name")
    protected String name;

    @OneToMany(targetEntity = Product.class)
    protected List<Product> customers;

    public ProductType() {
    }

    public ProductType(Long id, String name, List<Product> customers) {
        this.id = id;
        this.name = name;
        this.customers = customers;
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

    public List<Product> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Product> customers) {
        this.customers = customers;
    }
}
