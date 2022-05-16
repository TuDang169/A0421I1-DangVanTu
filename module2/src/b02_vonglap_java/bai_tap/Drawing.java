package b02_vonglap_java.bai_tap;

import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do{
            System.out.println("");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            int i,j;
            switch (choice){
                case 1:{
                    for(i= 0; i<3; i++){
                        System.out.println(" ");
                        for(j= 0; j< 7;j++){
                            System.out.print("*");
                        }
                    }
                    break;
                }
                case 2: {
                    for (i = 1; i <= 5; i++) {
                        System.out.println("\t");
                        for (j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                    }
                    for (i = 5; i >= 1; i--) {
                        System.out.println("\t");
                        for (j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                    }
                    break;
                }
                case 3:{
                    for(i = 1; i <= 7; i++){
                        System.out.println("\t");
                        for(j = 1; j <= 8-i; j++) {
                            System.out.println(" ");
                        }
                        for (j = 1; j<=2*i-1; j++){
                            System.out.print("*");
                        }
                    }
                }
                case 4:{
                    System.exit(4);
                }
            }
        } while (choice != 4);
    }
}
