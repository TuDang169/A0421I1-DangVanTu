package chuc_nang.trien_khai;

import chuc_nang.ChucNangSPNhapKhau;
import san_pham.SanPhamNhapKhau;
import tien_ich.DocVaInFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrienKhaiSPNhapKhau implements ChucNangSPNhapKhau {
    private static List<SanPhamNhapKhau> danhSachSPNhapKhau = new ArrayList<>();
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
        System.out.println("Nhập giá nhập khẩu: ");
        int giaNhapKhau = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tỉnh thành nhập khẩu sản phẩm: ");
        String tinhThanhNhap = scanner.nextLine();
        System.out.println("Nhập thuế nhập khẩu: ");
        int thueNhapKhau = Integer.parseInt(scanner.nextLine());
        SanPhamNhapKhau sanPhamNhapKhau = new SanPhamNhapKhau(1, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat, giaNhapKhau, tinhThanhNhap, thueNhapKhau);
        danhSachSPNhapKhau.add(sanPhamNhapKhau);
        System.out.println("Đã thêm mới thành công");
        DocVaInFile.inFile(danhSachSPNhapKhau,"D:\\A0421I1-DangVanTu\\ProductManager\\src\\du_lieu\\SPNhapKhau.csv");
    }

    @Override
    public void xoa() {

    }

    @Override
    public void xemDanhSach() {
        danhSachSPNhapKhau= (List<SanPhamNhapKhau>) DocVaInFile.docFile("D:\\A0421I1-DangVanTu\\ProductManager\\src\\du_lieu\\SPNhapKhau.csv");
        for (SanPhamNhapKhau sanPhamNhapKhau : danhSachSPNhapKhau) {
            System.out.println(sanPhamNhapKhau.toString());
        }
    }

    @Override
    public void timKiem() {
        danhSachSPNhapKhau= (List<SanPhamNhapKhau>) DocVaInFile.docFile("D:\\A0421I1-DangVanTu\\ProductManager\\src\\du_lieu\\SPNhapKhau.csv");
            System.out.println("MỜi nhập tên sản phẩm cần tìm: ");
            String giaTri = scanner.nextLine();
            for (SanPhamNhapKhau sanphamNhapKhau: danhSachSPNhapKhau){
                if(sanphamNhapKhau.getTenSanPham() != null && sanphamNhapKhau.getTenSanPham().contains(giaTri)){
                    System.out.println(sanphamNhapKhau.toString());
                } else{
                    System.out.println("Không tìm thấy sản phẩm");
                }
            }

    }
}
