package b06_inheritance.bai_tap.Circle_Cylinder;

public class Cylinder extends Circle{
    private double height = 1.0;

    public Cylinder(){

    }

    public Cylinder(double height){
        this.height = height;
    }

    public Cylinder(double height, double radius , String color){
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea()+(getHeight()*super.getRadius());
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter()*getHeight();
    }

    @Override
    public String toString() {
        return "Area: " + getArea()
                +" Perimeter " + getPerimeter()
                +" color: " +super.getColor();
    }
}
