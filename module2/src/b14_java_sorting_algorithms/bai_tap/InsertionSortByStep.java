package b14_java_sorting_algorithms.bai_tap;

import java.util.Scanner;

public class InsertionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }

        System.out.println("\nBegin sort processing...");
        insertionSortByStep(list);
    }

    public static void insertionSortByStep(int[] list){
        int pos, x;
        for(int i = 1; i < list.length; i++){
            x = list[i];
            pos = i;
            while(pos > 0 && x < list[pos-1]){
                System.out.println("Swap " + list[pos] + " with " + list[pos - 1]);
                list[pos] = list[pos-1];
                pos--;
            }
            list[pos] = x;
            System.out.print("List after the  " + i + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }

    }
}
