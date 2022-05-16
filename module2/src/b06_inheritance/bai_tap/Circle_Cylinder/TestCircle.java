package b06_inheritance.bai_tap.Circle_Cylinder;

public class TestCircle {
    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(3);

        cylinder = new Cylinder(3,2,"red");
        System.out.println(cylinder);
    }
}
