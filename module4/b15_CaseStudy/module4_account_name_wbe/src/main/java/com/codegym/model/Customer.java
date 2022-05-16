package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.util.List;

@Entity
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "customer_name")
    @NotBlank(message = "Name must not be Blank")
    protected String name;

    @Column(name = "customer_birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    protected String birthday;

    @Column(name = "customer_gender")
    @NotBlank(message = "Gender must not be Blank")
    protected boolean gender;

    @Column(name = "customer_id_card")
    @NotBlank(message = "IdCard must not be Blank")
    protected String idCard;

    @Column(name = "customer_phone")
    @NotNull(message = "Phone Number must not be Null")
    protected String phone;

    @Column(name = "customer_email")
    @NotBlank(message = "Email must not be Blank")
    protected String email;

    @Column(name = "customer_address")
    @NotBlank(message = "Address must not be Blank")
    protected String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    protected CustomerType customerType;

    @OneToMany(mappedBy = "customer")
    protected List<Contract> contracts;

    public Customer() {
    }

    public Customer(Long id, @NotBlank(message = "Name must not be Blank") String name, @PastOrPresent String birthday, boolean gender, @NotBlank(message = "IdCard must not be Blank") String idCard, @NotNull(message = "Phone Number must not be Null") String phone, @NotBlank(message = "Email must not be Blank") String email, @NotBlank(message = "Address must not be Blank") String address, CustomerType customerType, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
