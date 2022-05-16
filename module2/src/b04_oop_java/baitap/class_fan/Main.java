package b04_oop_java.baitap.class_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(fan1.fast);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);

        fan2.setSpeed(fan2.medium);
        fan2.setRadius(fan2.getRadius());
        fan2.setColor(fan2.getColor());
        fan2.setOn(fan2.getOn());

        fan1.toSring();
        fan2.toSring();
    }
}
