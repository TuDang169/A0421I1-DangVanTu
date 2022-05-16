package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class CustomerType {

    @Id
    @Column(name = "customer_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "customer_type_name")
    protected String name;

    @OneToMany(targetEntity = Customer.class)
    protected List<Customer> customers;

    public CustomerType() {
    }

    public CustomerType(Long id, String name, List<Customer> customers) {
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

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
