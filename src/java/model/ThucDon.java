/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hi tcc
 */
public class ThucDon {
    private int MaMonAn;
    private String TenMonAn;
    private String ThucPham;
    private int GiaThanh;
    private String HinhAnh;

    public ThucDon() {
    }

    public ThucDon(int MaMonAn, String TenMonAn, String ThucPham, int GiaThanh, String HinhAnh) {
        this.MaMonAn = MaMonAn;
        this.TenMonAn = TenMonAn;
        this.ThucPham = ThucPham;
        this.GiaThanh = GiaThanh;
        this.HinhAnh = HinhAnh;
    }

    public int getMaMonAn() {
        return MaMonAn;
    }

    public void setMaMonAn(int MaMonAn) {
        this.MaMonAn = MaMonAn;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public void setTenMonAn(String TenMonAn) {
        this.TenMonAn = TenMonAn;
    }

    public String getThucPham() {
        return ThucPham;
    }

    public void setThucPham(String ThucPham) {
        this.ThucPham = ThucPham;
    }

    public int getGiaThanh() {
        return GiaThanh;
    }

    public void setGiaThanh(int GiaThanh) {
        this.GiaThanh = GiaThanh;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }
    
}
