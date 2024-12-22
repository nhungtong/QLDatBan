package model;

import java.util.Date;

/**
 * Lớp đại diện cho báo cáo doanh thu của một bàn.
 */
public class BaoCao {
    private Date ngayThanhToan; // Ngày thanh toán
    private String maBan;      // Mã bàn
    private double tongTien; // Tổng tiền của bàn

    /**
     * Constructor đầy đủ.
     *
     * @param ngayThanhToan Ngày thanh toán
     * @param maBan Mã bàn
     * @param tongTien Tổng tiền
     */
    public BaoCao(Date ngayThanhToan, String maBan, double tongTien) {
        this.ngayThanhToan = ngayThanhToan;
        this.maBan = maBan;
        this.tongTien = tongTien;
    }

    // Getter và Setter
    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getMaBan() {
        return maBan;
    }

    public void setMaBan(String maBan) {
        this.maBan = maBan;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    /**
     * Trả về chuỗi mô tả đối tượng.
     *
     * @return Chuỗi mô tả
     */
    @Override
    public String toString() {
        return "BaoCao{" +
               "ngayThanhToan=" + ngayThanhToan +
               ", maBan='" + maBan + '\'' +
               ", tongTien=" + tongTien +
               '}';
    }
}
