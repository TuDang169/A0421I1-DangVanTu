package b02_vonglap_java.thuc_hanh;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money;
        int month;
        double interestRate;
        System.out.println("Nhập số tiền gửi: ");
        money = scanner.nextDouble();
        System.out.println("Nhập số tháng gửi: ");
        month = scanner.nextInt();
        System.out.println("Nhập lãi xuất: ");
        interestRate = scanner.nextDouble();
        double totalInterest =0;
        for(int i= 0; i< month; i++){
            totalInterest += money * ((interestRate/100)/12) * month;
        }
        System.out.println("Lãi xuất là: " +totalInterest);
    }
}
