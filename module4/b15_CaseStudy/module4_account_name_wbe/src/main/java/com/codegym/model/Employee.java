package com.codegym.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.util.Date;
import java.util.List;

@Entity
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;

    @Column(name = "employee_name")
    @NotBlank(message = "Name must not be Blank")
    protected String name;

    @Column(name = "employee_birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    protected Date birthday;

    @Column(name = "employee_id_card")
    @NotBlank(message = "IdCard must not be Blank")
    protected String idCard;

    @Column(name = "employee_salary")
    protected double salary;

    @Column(name = "employee_phone")
    @NotBlank(message = "Phone number must not be Blank")
    protected String phone;

    @Column(name = "employee_email")
    @NotBlank(message = "Email must not be Blank")
    protected String email;

    @Column(name = "employee_address")
    @NotBlank(message = "Address must not be Blank")
    protected String address;

    @ManyToOne
    @JoinColumn(name = "position_id")
    protected Position position;

    @ManyToOne
    @JoinColumn(name = "education_id")
    protected Education education;

    @ManyToOne
    @JoinColumn(name = "division_id")
    protected Division division;

    @OneToOne(targetEntity = User.class)
    protected User user;

    @OneToMany(mappedBy = "employee")
    protected List<Contract> contracts;

    public Employee() {
    }

    public Employee(int id, @NotBlank(message = "Name must not be Blank") String name, @PastOrPresent Date birthday, @NotBlank(message = "IdCard must not be Blank") String idCard, double salary, @NotBlank(message = "Phone number must not be Blank") String phone, @NotBlank(message = "Email must not be Blank") String email, @NotBlank(message = "Address must not be Blank") String address, Position position, Education education, Division division, User user, List<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.education = education;
        this.division = division;
        this.user = user;
        this.contracts = contracts;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
