package b01_introduction_java.thuc_hanh;
import java.sql.SQLOutput;
import java.util.Scanner;

public class RetangleProgram {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        System.out.println("Enter height: ");
        height = scanner.nextFloat();

        float area = width * height;
        System.out.println("Retangle Area is: " +area);
    }
}
