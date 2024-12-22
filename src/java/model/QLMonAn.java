/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thaot
 */
public class QLMonAn {
    private int maBan;
    private int maMonAn;
    private int soLuong;
    private String tinhTrangMonAn;
   
    public QLMonAn() {}

    public QLMonAn(int maBan, int maMonAn, int soLuong, String tinhTrangMonAn) {
        this.maBan = maBan;
        this.maMonAn = maMonAn;
        this.soLuong = soLuong;
        this.tinhTrangMonAn = tinhTrangMonAn;
    }

    public int getMaBan() {
        return maBan;
    }

    public void setMaBan(int maBan) {
        this.maBan = maBan;
    }

    public int getMaMonAn() {
        return maMonAn;
    }

    public void setMaMonAn(int maMonAn) {
        this.maMonAn = maMonAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrangMonAn() {
        return tinhTrangMonAn;
    }

    public void setTinhTrangMonAn(String tinhTrangMonAn) {
        this.tinhTrangMonAn = tinhTrangMonAn;
    }
    
}
