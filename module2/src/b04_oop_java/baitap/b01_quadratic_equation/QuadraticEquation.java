package b04_oop_java.baitap.b01_quadratic_equation;

public class QuadraticEquation {
    private double a, b, c;
    public QuadraticEquation(double a,double b,double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA(){
        return this.a;
    }
    public void setA(double a){
        this.a = a;
    }

    public double getB(){
        return this.b;
    }
    public void setB(double b){
        this.b = b;
    }

    public double getC(){
        return this.c;
    }
    public void setC(double c){
        this.c = c;
    }

    public double getDiscriminant(){
        return (this.b*b -(4*this.a*this.c));
    }

    public double getRoot1(){
        return (-this.b + Math.sqrt(this.b*this.b-4*this.a*this.c))/2;
    }

    public double getRoot2(){
        return (-this.b - Math.sqrt(this.b*this.b-4*this.a*this.c))/2;
    }

}
