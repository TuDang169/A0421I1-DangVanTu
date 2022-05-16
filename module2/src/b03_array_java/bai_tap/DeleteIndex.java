package b03_array_java.bai_tap;

import java.util.Scanner;

public class DeleteIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, i, c;

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

        System.out.print("Nhap phan tu ban muon xoa: ");
        int index = scanner.nextInt();

        for( c= i= 0; i< n; i++) {
                if (arr[i] != index) {
                    arr[c] = arr[i];
                    c++;
                }
        }
        n = c;

        System.out.println("Mang sau khi xoa phan tu " + index + " là: ");
        for (i = 0; i < n; i++) {
            System.out.print(arr[i] + "\t");
        }
    }
}

