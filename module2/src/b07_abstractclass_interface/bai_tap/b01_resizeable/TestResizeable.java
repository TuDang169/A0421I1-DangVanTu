package b07_abstractclass_interface.bai_tap.b01_resizeable;

public class TestResizeable {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle = new Circle(4);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle();
        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);

        Square square = new Square();
        square = new Square(5);
        System.out.println(square);
    }
}