package com.codegym.model;


import javax.persistence.*;
import java.util.List;
@Entity
public class Education {

    @Id
    @Column(name = "education_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Column(name = "education_name")
    protected String name;

    @OneToMany(targetEntity = Employee.class)
    protected List<Employee> employees;

    public Education() {
    }

    public Education(Long id, String name, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
