/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.KetNoiCSDL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hi tcc
 */
public class ThanhToanDAO {

    private Connection connection;

    public ThanhToanDAO() {
        connection = KetNoiCSDL.getConnection();
        if (connection == null) {
            throw new RuntimeException("Không thể kết nối tới cơ sở dữ liệu!");
        }
    }

    // Lấy thông tin từ goimon và thucdon, tính tổng tiền
    public double tinhTongTienVaLuu(String maBan) {
        String selectSql = "SELECT gm.MaBan, gm.MaMonAn, gm.SoLuong, td.GiaThanh "
                + "FROM goimon gm "
                + "JOIN thucdon td ON gm.MaMonAn = td.MaMonAn "
                + "WHERE gm.MaBan = ?";
        String insertSql = "INSERT INTO thanhtoan (MaBan, TongTien, NgayThanhToan) VALUES (?, ?, CURRENT_DATE) "
                + "ON DUPLICATE KEY UPDATE TongTien = ?, NgayThanhToan = CURRENT_DATE";

        double tongTien = 0;

        try (PreparedStatement selectStmt = connection.prepareStatement(selectSql); PreparedStatement insertStmt = connection.prepareStatement(insertSql)) {

            // Tính tổng tiền từ bảng goimon và thucdon
            selectStmt.setString(1, maBan);
            try (ResultSet rs = selectStmt.executeQuery()) {
                while (rs.next()) {
                    double giaThanh = rs.getDouble("GiaThanh");
                    int soLuong = rs.getInt("SoLuong");
                    tongTien += giaThanh * soLuong;
                }
            }

            insertStmt.setString(1, maBan);
            insertStmt.setDouble(2, tongTien);
            insertStmt.setDouble(3, tongTien);
            insertStmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tongTien;
    }

    // Lấy chi tiết hóa đơn để hiển thị
    public List<Map<String, Object>> getChiTietHoaDon(String maBan) {
        String sql = "SELECT gm.MaMonAn, td.TenMonAn, td.GiaThanh, gm.SoLuong, (td.GiaThanh * gm.SoLuong) AS ThanhTien "
                + "FROM goimon gm "
                + "JOIN thucdon td ON gm.MaMonAn = td.MaMonAn "
                + "WHERE gm.MaBan = ?";
        List<Map<String, Object>> hoaDon = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, maBan);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Map<String, Object> item = new HashMap<>();
                    item.put("MaMonAn", rs.getString("MaMonAn"));
                    item.put("TenMonAn", rs.getString("TenMonAn"));
                    item.put("GiaThanh", rs.getDouble("GiaThanh"));
                    item.put("SoLuong", rs.getInt("SoLuong"));
                    item.put("ThanhTien", rs.getDouble("ThanhTien"));
                    hoaDon.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hoaDon;
    }

    public void luuDanhGia(String maBan, int rating) throws SQLException {
        String sql = "INSERT INTO danhgia (DichVu, MaBan) VALUES (?, ?)"; // Sửa SQL nếu cần

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, rating);  
            ps.setString(2, maBan); 

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Đánh giá đã được lưu thành công.");
            } else {
                System.out.println("Không tìm thấy bàn với mã " + maBan);
            }
        } catch (SQLException e) {
            
            System.err.println("Có lỗi xảy ra khi lưu đánh giá: " + e.getMessage());
            throw e;
        }
    }

}
