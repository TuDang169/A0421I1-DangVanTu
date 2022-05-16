package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 30)
    private String lastName;

    @Pattern(regexp = "[0-9]{9}")
    private String phoneNumber;

    @Min(18)
    private int age;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$")
    private String email;

    public User() {
    }

    public User(Long id, @NotNull @Size(min = 5, max = 30) String firstName, @NotNull @Size(min = 5, max = 30) String lastName, @Pattern(regexp = "[7-9]{1}[0-9]{9}") String phoneNumber, @Min(18) int age, @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
