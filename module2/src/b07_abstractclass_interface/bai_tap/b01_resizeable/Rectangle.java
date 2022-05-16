package b07_abstractclass_interface.bai_tap.b01_resizeable;

import b07_abstractclass_interface.bai_tap.b02_colorable.Shape;

public class Rectangle extends Shape implements Resizeable{
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle(){};

    public Rectangle(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }

    public double getArea(){
        return getLength()*getWidth();
    }

    public double getPerimeter(){
        return (getLength()+getWidth())*2;
    }

    @Override
    public String toString() {
        return "A Rectangle with width "+ getWidth()
                + " and " +getLength()
                + " with side= " +getArea()
                + " which is a subclass "
                + super.toString();
    }

    @Override
    public void resizeable(double percent) {
        this.width +=this.width*(percent/100);
        this.length+=this.length*(percent/100);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four side: "+super.getColor());
    }
}