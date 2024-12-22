package model;

import java.time.LocalDate;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private String chucVu;
    private String diaChi;
    private String soDienThoai;
    private LocalDate ngaySinh; // Thêm thuộc tính ngày sinh

    // Constructor đầy đủ
    public NhanVien(String maNhanVien, String hoTen, String chucVu, String diaChi, String soDienThoai, LocalDate ngaySinh) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.chucVu = chucVu;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
    }

    // Getters và Setters
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    // Phương thức toString để hiển thị thông tin nhân viên
    @Override
    public String toString() {
        return "NhanVien{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", chucVu='" + chucVu + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", ngaySinh=" + ngaySinh +
                '}';
    }
}
