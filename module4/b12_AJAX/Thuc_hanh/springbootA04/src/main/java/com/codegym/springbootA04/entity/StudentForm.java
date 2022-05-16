package com.codegym.springbootA04.entity;

public class StudentForm {
        private int id;
        private String name;
        private int age;
        private String address;
        private String subjectId;
        public StudentForm() {
        }

        public StudentForm(int id, String name, int age, String address) {
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

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }
}
