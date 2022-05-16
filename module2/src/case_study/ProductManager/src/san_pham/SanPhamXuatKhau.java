package san_pham;

public class SanPhamXuatKhau extends SanPham {
    private int giaXuatKhau;
    private String quocGiaNhapSP;

    public SanPhamXuatKhau() {
    }

    public SanPhamXuatKhau(int id, String maSanPham, String tenSanPham, int giaBan, int soLuong, String nhaSanXuat, int giaXuatKhau, String quocGiaNhapSP) {
        super(id, maSanPham, tenSanPham, giaBan, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGiaNhapSP = quocGiaNhapSP;
    }

    public int getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(int giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGiaNhapSP() {
        return quocGiaNhapSP;
    }

    public void setQuocGiaNhapSP(String quocGiaNhapSP) {
        this.quocGiaNhapSP = quocGiaNhapSP;
    }

    @Override
    public String toString() {
        return  super.toString()+
                "\n giaXuatKhau     : " + giaXuatKhau +
                "\n quocGiaNhapSP   : " + quocGiaNhapSP;
    }
}
