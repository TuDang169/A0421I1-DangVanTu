package model.bean;

public class Product {
    protected int id;
    protected String name;
    protected double pride;
    protected int    quantity;
    protected String color;
    protected int    categoryId;

    public Product(String name, double pride, int quantity, String color, int categoryId) {
        this.name = name;
        this.pride = pride;
        this.quantity = quantity;
        this.color = color;
        this.categoryId = categoryId;
    }

    public Product(int id, String name, double pride, int quantity, String color, int categoryId) {
        this.id = id;
        this.name = name;
        this.pride = pride;
        this.quantity = quantity;
        this.color = color;
        this.categoryId = categoryId;
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

    public double getPride() {
        return pride;
    }

    public void setPride(double pride) {
        this.pride = pride;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
