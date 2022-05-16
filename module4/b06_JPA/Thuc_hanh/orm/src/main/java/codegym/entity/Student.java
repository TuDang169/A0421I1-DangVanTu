package codegym.entity;

import javax.persistence.*;

@Entity
@Table(name = "student")
@NamedQueries(
        @NamedQuery(name = "findByAddress",
                    query = "select s from Student s where s.address like :address")
)
public class Student {
    @Id
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_name", columnDefinition = "nvarchar(50)")
    private String name;
    private int age;
    private String address;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
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
