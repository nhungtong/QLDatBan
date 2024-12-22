/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.KetNoiCSDL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ThucDon;

/**
 *
 * @author hi tcc
 */
public class MonAnDAO {

    private Connection connection;

    public MonAnDAO() {
        connection = KetNoiCSDL.getConnection();
    }

    // Phương thức lấy danh sách tất cả đơn gọi món
    public List<ThucDon> layDanhSachMonAn() throws SQLException {
        List<ThucDon> danhSachMon = new ArrayList<>();
        String sql = "SELECT * FROM thucdon";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int maMonAn = rs.getInt("MaMonAn");
                String tenMonAn = rs.getString("TenMonAn");
                String thucPham = rs.getString("ThucPham");
                int giaThanh = rs.getInt("GiaThanh");
                String hinhAnh = rs.getString("HinhAnh");
                ThucDon monAn = new ThucDon(maMonAn, tenMonAn, thucPham, giaThanh, hinhAnh);
                danhSachMon.add(monAn);
            }
        }
        return danhSachMon;
    }
    // Phương thức tìm kiếm món ăn theo loại thực phẩm

    public List<ThucDon> timKiemMonAnTheoLoai(String loaiThucPham) throws SQLException {
        List<ThucDon> danhSachMon = new ArrayList<>();
        String sql = "SELECT * FROM thucdon WHERE ThucPham = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, loaiThucPham);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    int maMonAn = rs.getInt("MaMonAn");
                    String tenMonAn = rs.getString("TenMonAn");
                    String thucPham = rs.getString("ThucPham");
                    int giaThanh = rs.getInt("GiaThanh");
                    String hinhAnh = rs.getString("HinhAnh");
                    ThucDon monAn = new ThucDon(maMonAn, tenMonAn, thucPham, giaThanh, hinhAnh);
                    danhSachMon.add(monAn);
                }
            }
        }
        return danhSachMon;
    }

    public List<ThucDon> timKiemMonAn() throws SQLException {
    List<ThucDon> danhSachMonAn = new ArrayList<>();
    String loaiMon = "Đồ Ăn";  

    danhSachMonAn = timKiemMonAnTheoLoai(loaiMon);

    return danhSachMonAn;
}

    public List<ThucDon> timKiemDoUong() throws SQLException {
    List<ThucDon> danhSachDoUong = new ArrayList<>();
    String loaiMon = "Đồ Uống";  

    danhSachDoUong = timKiemMonAnTheoLoai(loaiMon);

    return danhSachDoUong;
}

}
