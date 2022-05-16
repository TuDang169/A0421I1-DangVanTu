package b03_array_java.bai_tap;

import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i, min;

        do {
            System.out.print("Nhap do dai cua mang: ");
            n = scanner.nextInt();
        }while (n<=0);

        int[] arr = new int[n];

        System.out.println("Nhap cac phan tu trong mang: ");
        for (i = 0;i < n; i++){
            System.out.print("Nhap phan tu thu " + i + ": ");
            arr[i] = scanner.nextInt();
        }
        min = arr[0];

        for(i= 1; i< n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        System.out.println("Gia tri nho nhat trong mang la: " + min);
    }
}
