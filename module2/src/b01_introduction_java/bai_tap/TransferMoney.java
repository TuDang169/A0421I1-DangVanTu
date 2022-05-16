package b01_introduction_java.bai_tap;

import java.util.Scanner;

public class TransferMoney {
    public static double vndToUsd(double money){
        double usd = money*23000;
        return usd;
    }
    public static double usdToVnd(double money){
        double vnd = money/23000;
        return vnd;
    }
    public static double insert(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Moi ban nhap so tien: ");
        double money = scanner.nextDouble();
        return money;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu.");
            System.out.println("1. VND to USD");
            System.out.println("2. USD to VND");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(vndToUsd(insert()) + " $");
                    break;
                case 2:
                    System.out.println(usdToVnd(insert()) + " Dong");
                    break;
                case 0:
                    System.exit(0);
            }
        } while (choice !=0);
    }
}
