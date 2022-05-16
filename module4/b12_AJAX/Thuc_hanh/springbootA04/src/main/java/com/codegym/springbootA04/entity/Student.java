package com.codegym.springbootA04.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "student")
@NamedQueries(
        @NamedQuery(name = "findByAddress",
                    query = "select s from Student s where s.address like :address")
)
public class Student {
    @Id
    @Column(name = "student_id")
    @Min(value = 2, message = "{items.greateThan}")
    private int id;

    @Column(name = "student_name", columnDefinition = "nvarchar(50)")
    @NotBlank(message = "{items.empty}")
    @Size(min = 2, max = 50)
    private String name;

    @Range(min = 18, max = 30)
    private int age;

    @NotBlank(message = "{items.empty}")
    private String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    @Valid
    private Subject subject;

    public Student() {
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
