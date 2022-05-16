package b03_array_java.thuc_hanh;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size;
        int[] arr;
        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size does not exceed 20");
        } while (size > 20);
        arr = new int[size];
        int i;
        for(i=0; i < size;i++){
            System.out.println("Nhap gia tri thu "+(i+1)+" :");
            arr[i] = scanner.nextInt();
        }
        System.out.println("Mang vua nhap: ");
        for(i=0; i< size; i++){
            System.out.print(arr[i]+"\t");
        }
        for (int j = 0; j < size / 2; j++) {
            int temp = arr[j];
            arr[j] = arr[size - 1 - j];
            arr[size - 1 - j] = temp;
        }
        System.out.println("\t");
        System.out.println("Mang da doi chieu: ");
        for(i=0; i< size; i++){
            System.out.print(arr[i]+"\t");
        }
    }
}
