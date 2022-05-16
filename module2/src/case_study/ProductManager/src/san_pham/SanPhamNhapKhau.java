package san_pham;

public class SanPhamNhapKhau extends SanPham {
    private int giaNhapKhau;
    private String tinhThanhNhap;
    private int thueNhapKhau;

    public SanPhamNhapKhau() {
    }

    public SanPhamNhapKhau(int id, String maSanPham, String tenSanPham, int giaBan, int soLuong, String nhaSanXuat, int giaNhapKhau, String tinhThanhNhap, int thueNhapKhau) {
        super(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanhNhap = tinhThanhNhap;
        this.thueNhapKhau = thueNhapKhau;
    }

    public int getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(int giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanhNhap() {
        return tinhThanhNhap;
    }

    public void setTinhThanhNhap(String tinhThanhNhap) {
        this.tinhThanhNhap = tinhThanhNhap;
    }

    public int getThueNhapKhau() {
        return thueNhapKhau;
    }

    public void setThueNhapKhau(int thueNhapKhau) {
        this.thueNhapKhau = thueNhapKhau;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\n giaNhapKhau     : " + giaNhapKhau +
                "\n tinhThanhNhap   : " + tinhThanhNhap+
                "\n thueNhapKhau    : " + thueNhapKhau ;
    }
}
