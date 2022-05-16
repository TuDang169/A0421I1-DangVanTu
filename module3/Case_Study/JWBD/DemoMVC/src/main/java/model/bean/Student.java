package model.bean;

public class Student {
    private int id;
    private String name;
    private String birthday;
    private int classId;
    private int point;
    private boolean gender;
    private String account;
    private String email;

    public Student() {
    }

    public Student(int id, String name, String birthday, int classId, int point, boolean gender, String account, String email) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.classId = classId;
        this.point = point;
        this.gender = gender;
        this.account = account;
        this.email = email;
    }

    public Student(String name, String birthday, int classId, int point, boolean gender, String email) {
        this.name = name;
        this.birthday = birthday;
        this.classId = classId;
        this.point = point;
        this.gender = gender;
        this.email = email;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
