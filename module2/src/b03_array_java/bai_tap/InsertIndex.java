package b03_array_java.bai_tap;

import java.util.Scanner;

public class InsertIndex {
    public static void main(String[] args) {
        int n, i;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập số bạn muốn thêm vào mảng: ");
        int x = scanner.nextInt();
        System.out.println("Nhập vị trí bạn muốn thêm vào mảng: ");
        int index = scanner.nextInt();

        do {
            System.out.println("Nhập vào số phần tử của mảng: ");
            n = scanner.nextInt();
        } while (n < 1 && n>= x);

        int arr[] = new int[n+1];

        System.out.println("Nhập các phần tử cho mảng: ");
        for (i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + i + ": ");
            arr[i] = scanner.nextInt();
        }

        int[] arr1 = new int[n-index];
        for (i= index;i <n; i++){
            arr1[i-index]= arr[i];
        }
        arr[index] = x;
        for (i= index;i <n; i++){
            arr[i+1]= arr1[i-index];
        }
        arr[index]= x;
        System.out.println("Mảng mới sau khi phần tử " + index + " là: ");
        for (i = 0; i <= n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}
