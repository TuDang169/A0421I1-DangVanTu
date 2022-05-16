package chuc_nang.trien_khai;

import chuc_nang.ChucNangSPXuatKhau;
import san_pham.SanPhamXuatKhau;
import tien_ich.DocVaInFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrienKhaiSPXuatKhau implements ChucNangSPXuatKhau {
    private static List<SanPhamXuatKhau> danhSachSPXuatKhau = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void themMoi() {
        System.out.println("Nhập Mã sản phẩm: ");
        String maSanPham = scanner.nextLine();
        System.out.println("Nhập Tên sản phẩm: ");
        String tenSanPham = scanner.nextLine();
        System.out.println("Nhập giá bán: ");
        int giaBan = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int soLuong = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();
        System.out.println("Nhập giá xuất khẩu: ");
        int giaXuatKhau = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập quốc gia xuất khẩu sản phẩm: ");
        String quocGiaNhapSP = scanner.nextLine();
        SanPhamXuatKhau sanPhamXuatKhau = new SanPhamXuatKhau(1, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaXuatKhau, quocGiaNhapSP);
        danhSachSPXuatKhau.add(sanPhamXuatKhau);
        System.out.println("Đã thêm mới thành công");
        DocVaInFile.inFile(danhSachSPXuatKhau, "D:\\A0421I1-DangVanTu\\ProductManager\\src\\du_lieu\\SPXuatKhau.csv");
    }

    @Override
    public void xoa() {

    }

    @Override
    public void xemDanhSach() {
        danhSachSPXuatKhau= (List<SanPhamXuatKhau>) DocVaInFile.docFile("D:\\A0421I1-DangVanTu\\ProductManager\\src\\du_lieu\\SPXuatKhau.csv");
        for (SanPhamXuatKhau sanPhamXuatKhau : danhSachSPXuatKhau) {
            System.out.println(sanPhamXuatKhau.toString());
        }
    }

    @Override
    public void timKiem() {
        danhSachSPXuatKhau= (List<SanPhamXuatKhau>) DocVaInFile.docFile("D:\\A0421I1-DangVanTu\\ProductManager\\src\\du_lieu\\SPXuatKhau.csv");
        System.out.println("Bạn muốn tim theo: " +
                "\n 1. theo Mã sản phẩm"         +
                "\n 2. theo tên sản phẩm");
        int choose = Integer.parseInt(scanner.nextLine());
        String giaTri;
        if(choose== 1){
            System.out.println("MỜi nhập Mã sản phẩm cần tìm: ");
            giaTri = scanner.nextLine();
            for (SanPhamXuatKhau sanPhamXuatKhau: danhSachSPXuatKhau){
                if(sanPhamXuatKhau.getMaSanPham() != null && sanPhamXuatKhau.getMaSanPham().contains(giaTri)){
                    System.out.println(sanPhamXuatKhau.toString());
                }else{
                    System.out.println("Không tìm thấy sản phẩm");
                }
            }
        }
        else if (choose == 2){
            System.out.println("MỜi nhập tên sản phẩm cần tìm: ");
            giaTri = scanner.nextLine();
            for (SanPhamXuatKhau sanPhamXuatKhau: danhSachSPXuatKhau){
                if(sanPhamXuatKhau.getTenSanPham() != null && sanPhamXuatKhau.getTenSanPham().contains(giaTri)){
                    System.out.println(sanPhamXuatKhau.toString());
                }
                else{
                    System.out.println("Không tìm thấy sản phẩm");
                }
            }
        }
        else {
            System.out.println("Bạn đã nhập sai, mời nhập lại!");
            choose = Integer.parseInt(scanner.nextLine());
        }
    }
}
