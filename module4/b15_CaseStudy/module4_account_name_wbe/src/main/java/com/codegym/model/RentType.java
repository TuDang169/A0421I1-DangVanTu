package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class RentType {

    @Id
    @Column(name = "rent_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "rent_type_name")
    protected String name;

    @Column(name = "rent_type_cost")
    protected double cost;

    @OneToMany(targetEntity = Customer.class)
    protected List<Customer> customers;

    public RentType() {
    }

    public RentType(Long id, String name, double cost, List<Customer> customers) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
