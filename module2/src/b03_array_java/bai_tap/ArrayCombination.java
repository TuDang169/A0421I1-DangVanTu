package b03_array_java.bai_tap;

import java.util.Scanner;

public class ArrayCombination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1,n2,n3,i;

        System.out.print("Nhap do dai cua mang 1: ");
        n1 = scanner.nextInt();
        int[] arr1 = new int[n1];
        System.out.println("Nhap cac phan tu trong mang: ");
        for (i = 0;i < n1; i++){
            System.out.print("Nhap phan tu thu " + i + ": ");
            arr1[i] = scanner.nextInt();
        }

        System.out.print("Nhap do dai cua mang 2: ");
        n2 = scanner.nextInt();
        int[] arr2 = new int[n2];
        System.out.println("Nhap cac phan tu trong mang: ");
        for (i = 0;i < n2; i++){
            System.out.print("Nhap phan tu thu " + i + ": ");
            arr2[i] = scanner.nextInt();
        }
        n3 = n1+n2;
        int[] arr3 = new int[n3];
        for(i= 0; i< n1; i++){
            arr3[i] = arr1[i];
        }
        for (i= 0; i< n2; i++){
            arr3[i+n1] = arr2[i];
        }
        System.out.println("Mang sau khi gộp phần tử là: ");
        for (i = 0; i < n3; i++) {
            System.out.print(arr3[i] + "\t");
        }
    }
}
