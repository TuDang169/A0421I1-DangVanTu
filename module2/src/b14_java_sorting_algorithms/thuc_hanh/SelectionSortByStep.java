package b14_java_sorting_algorithms.thuc_hanh;

import java.util.Scanner;

public class SelectionSortByStep {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list size:");
        int size = scanner.nextInt();
        double[] list = new double[size];
        System.out.println("Enter " + list.length + " values:");
        for (int i = 0; i < list.length; i++) {
            list[i] = scanner.nextInt();
        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }

        System.out.println("\nBegin sort processing...");
        selectionSortByStep(list);
    }

    public static void selectionSortByStep(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if(list[j] < currentMin){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if(currentMinIndex != i){
                System.out.println("Swap " + list[i] + " with " + list[currentMinIndex]);
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
            System.out.print("List after the  " + i + "' sort: ");
            for (int j = 0; j < list.length; j++) {
                System.out.print(list[j] + "\t");
            }
            System.out.println();
        }
    }
}
