package b03_array_java.thuc_hanh;

import java.util.Scanner;

public class FindMin {
    public static int minValue(int[] arr){
        int min = arr[0];
        for(int i = 0; i<arr.length; i++){
            if (arr[i]<min){
                min = arr[i];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = {4, 12, 7, 8, 1, 6, 9};
        System.out.println(" Min: "+ minValue(arr));
    }
}
