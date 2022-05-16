package model.bean;

public class StudentClass {
    private int id;
    private String name;
    private int classTypeId;
    public StudentClass() {
    }
    public StudentClass(int id, String name,int classTypeId) {
        this.id = id;
        this.name = name;
        this.classTypeId =classTypeId;
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
}
