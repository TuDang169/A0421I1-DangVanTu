package b02_vonglap_java.thuc_hanh;

import java.util.Scanner;

public class UocChungLonNhat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a,b;
        System.out.println("Enter a: ");
        a = scanner.nextInt();
        System.out.println("Enter b: ");
        b = scanner.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            System.out.println("No greatest common factor");
        }
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Ước chung lớn nhất: " + a);
    }
}
