package b07_abstractclass_interface.bai_tap.b01_resizeable;

import b07_abstractclass_interface.bai_tap.b02_colorable.Shape;

public class Circle extends Shape implements Resizeable {
    private double radius = 1.0;

    public Circle(){
    }

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled){
        super(color,filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return radius*radius*Math.PI;
    }

    public double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString(){
        return "A Circle with side= " + getArea()
                + " which is a subclass of "
                + super.toString();
    }

    @Override
    public void resizeable(double percent) {
        this.radius += this.radius*(percent/100);
    }
}
