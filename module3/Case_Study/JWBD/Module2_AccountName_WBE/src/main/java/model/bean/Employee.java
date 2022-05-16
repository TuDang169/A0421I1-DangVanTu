package model.bean;

public class Employee {
    protected int id;
    protected String name;
    protected String birthday;
    protected String idCard;
    protected double salary;
    protected String phone;
    protected String email;
    protected String address;
    protected int    position_id;
    protected int    education_degree_id;
    protected int    division_id;
    protected String userName;

    public Employee(String name, String birthday, String idCard, double salary, String phone, String email, String address, int position_id, int education_degree_id, int division_id, String userName) {
        this.name           = name;
        this.birthday       = birthday;
        this.idCard         = idCard;
        this.salary         = salary;
        this.phone          = phone;
        this.email          = email;
        this.address        = address;
        this.position_id    = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id    = division_id;
        this.userName       = userName;
    }

    public Employee(int id, String name, String birthday, String idCard, double salary, String phone, String email, String address, int position_id, int education_degree_id, int division_id, String userName) {
        this.id             = id;
        this.name           = name;
        this.birthday       = birthday;
        this.idCard         = idCard;
        this.salary         = salary;
        this.phone          = phone;
        this.email          = email;
        this.address        = address;
        this.position_id    = position_id;
        this.education_degree_id = education_degree_id;
        this.division_id    = division_id;
        this.userName       = userName;
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

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getEducation_degree_id() {
        return education_degree_id;
    }

    public void setEducation_degree_id(int education_degree_id) {
        this.education_degree_id = education_degree_id;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
