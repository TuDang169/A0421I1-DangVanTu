package codegym.model;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private List<String> subjects;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getAllSubjects() {
        StringBuffer stringBuffer = new StringBuffer();
        for (String subject: subjects) {
            stringBuffer.append(subject);
            stringBuffer.append(" ");
        }
        return stringBuffer.toString();
    }
}
