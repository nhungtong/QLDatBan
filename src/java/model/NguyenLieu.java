/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hi tcc
 */
public class NguyenLieu {
     private int maHoaDon;
    private String tenNguyenLieu;
    private double donGia;
    private int soLuong;
    private double thanhTien;

    public NguyenLieu(int maHoaDon, String tenNguyenLieu, double donGia, int soLuong, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.tenNguyenLieu = tenNguyenLieu;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
