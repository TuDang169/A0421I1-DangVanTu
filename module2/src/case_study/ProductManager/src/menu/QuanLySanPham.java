package menu;

import chuc_nang.trien_khai.TrienKhaiSPNhapKhau;
import chuc_nang.trien_khai.TrienKhaiSPXuatKhau;
import san_pham.SanPhamNhapKhau;
import san_pham.SanPhamXuatKhau;

import java.util.Scanner;

public class QuanLySanPham {

    private static Scanner scanner = new Scanner(System.in);
    private static int choice = 0;
    static TrienKhaiSPNhapKhau spNhapKhau = new TrienKhaiSPNhapKhau();
    static TrienKhaiSPXuatKhau spXuatKhau = new TrienKhaiSPXuatKhau();

    public static void main(String[] args) {
        menuQuanLySanPham();
    }

    public static void menuQuanLySanPham(){

        while (true){
            System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM--");
            System.out.println( "Chọn chức năng theo số(để tiếp tục): " +
                                "\n 1. Thêm mới"                        +
                                "\n 2. Xoá"                             +
                                "\n 3. Xem danh sách các sản phẩm"      +
                                "\n 4. Tìm kiếm"                        +
                                "\n 5. Thoát" );
            System.out.println("Chọn Chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    while (true){
                        System.out.println("Vui lòng nhập loại sản phẩm:" +
                                "\n 1. Sản phẩm Nhập khẩu"                +
                                "\n 2. Sản phẩm Xuất khẩu"                +
                                "\n 3. Quay lại menu" );
                        System.out.println("Chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                spNhapKhau.themMoi();
                                break;
                            case 2:
                                spXuatKhau.themMoi();
                                break;
                            case 3:
                                menuQuanLySanPham();
                        }
                    }
                case 2:
                    while (true){
                        System.out.println("Vui lòng nhập loại sản phẩm:" +
                                "\n 1. Sản phẩm Nhập khẩu"                +
                                "\n 2. Sản phẩm Xuất khẩu"                +
                                "\n 3. Quay lại menu" );
                        System.out.println("Chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                spNhapKhau.xoa();
                                break;
                            case 2:
                                spXuatKhau.xoa();
                                break;
                            case 3:
                                menuQuanLySanPham();
                        }
                    }
                case 3:
                    while (true){
                        System.out.println("Vui lòng nhập loại sản phẩm:" +
                                "\n 1. Sản phẩm Nhập khẩu"                +
                                "\n 2. Sản phẩm Xuất khẩu"                +
                                "\n 3. Quay lại menu" );
                        System.out.println("Chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                spNhapKhau.xemDanhSach();
                                break;
                            case 2:
                                spXuatKhau.xemDanhSach();
                                break;
                            case 3:
                                menuQuanLySanPham();
                        }
                    }

                case 4:
                    while (true){
                        System.out.println("Vui lòng nhập loại sản phẩm:" +
                                "\n 1. Sản phẩm Nhập khẩu"                +
                                "\n 2. Sản phẩm Xuất khẩu"                +
                                "\n 3. Quay lại menu" );
                        System.out.println("Chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                spNhapKhau.timKiem();
                                break;
                            case 2:
                                spXuatKhau.timKiem();
                                break;
                            case 3:
                                menuQuanLySanPham();
                        }
                    }
                case 5:
                    System.exit(0);
            }
        }
    }

}
