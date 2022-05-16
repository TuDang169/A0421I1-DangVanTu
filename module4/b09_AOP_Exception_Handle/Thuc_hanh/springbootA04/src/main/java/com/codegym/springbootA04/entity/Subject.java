package com.codegym.springbootA04.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "`subject`")
public class Subject {
    @Id
    @Column(name = "subject_id", columnDefinition = "nvarchar(20)")
    private String subjectId;

    @Column(name = "subject_name", columnDefinition = "nvarchar(50)")
    private String subjectName;

    @Column(columnDefinition = "nvarchar(50)")
    private String teacher;

    @OneToMany(mappedBy = "subject")
    private List<Student> students;

    private String note;

    public Subject() {
    }

    public Subject(String subjectId, String subjectName, String teacher, List<Student> students, String note) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.teacher = teacher;
        this.students = students;
        this.note = note;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> student) {
        this.students = student;
    }
}
