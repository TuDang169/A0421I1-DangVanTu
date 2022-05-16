package b03_array_java.thuc_hanh;

import java.util.Scanner;

public class FindElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = false;
        String[] danhSachSv = { "Christian", "Michael", "Camila", "Sienna",
                                "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Nhap ten sinh vien ban muon tim:");
        String tenSv = scanner.nextLine();
        for (int i= 0; i <danhSachSv.length; i++){
            if(danhSachSv[i].equals(tenSv)){
                System.out.println("Sinh vien "+tenSv+" o vi tri: "+(i+1));
                check = true;
                break;
            }
        }
        if(!check){
            System.out.println("Khong tim thay sinh vien "+tenSv);
        }
    }
}
