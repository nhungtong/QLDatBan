/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hi tcc
 */
public class GoiMon {
    private int MaBan;
    private int MaMonAn;
    private int SoLuong;
    private String TinhTrang;

    public GoiMon() {
    }

    public GoiMon(int MaBan, int MaMonAn, int SoLuong, String TinhTrang) {
        this.MaBan = MaBan;
        this.MaMonAn = MaMonAn;
        this.SoLuong = SoLuong;
        this.TinhTrang = TinhTrang;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
  
    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
    
}
