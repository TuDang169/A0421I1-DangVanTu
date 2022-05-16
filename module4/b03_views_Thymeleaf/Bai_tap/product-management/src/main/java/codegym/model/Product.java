package codegym.model;

public class Product {
    private int id;
    private String name;
    private double pride;
    private String dec;

    public Product() {
    }

    public Product(int id, String name, double pride, String dec) {
        this.id = id;
        this.name = name;
        this.pride = pride;
        this.dec = dec;
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

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }
}
