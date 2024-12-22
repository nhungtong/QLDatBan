/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hi tcc
 */
public class ThanhToan {
    private int MaBan;
    private int MaMonAn;
    private String TenMonAn;
    private float GiaThanh;

    public ThanhToan() {
    }

    public ThanhToan(int MaBan, int MaMonAn, String TenMonAn, float GiaThanh) {
        this.MaBan = MaBan;
        this.MaMonAn = MaMonAn;
        this.TenMonAn = TenMonAn;
        this.GiaThanh = GiaThanh;
    }

    public int getMaBan() {
        return MaBan;
    }

    public void setMaBan(int MaBan) {
        this.MaBan = MaBan;
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

    public float getGiaThanh() {
        return GiaThanh;
    }

    public void setGiaThanh(float GiaThanh) {
        this.GiaThanh = GiaThanh;
    }
    
}
