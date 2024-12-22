/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.KetNoiCSDL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.GoiMon;
/**
 *
 * @author hi tcc
 */
public class GoiMonDAO {
    private Connection connection;

    public GoiMonDAO() {
        
        connection = KetNoiCSDL.getConnection();
    }
    // Phương thức lấy danh sách tất cả đơn gọi món
    public List<GoiMon> layDanhSachGoiMon() throws SQLException {
        List<GoiMon> danhSachGoiMon = new ArrayList<>();
        String sql = "SELECT * FROM goimon";  

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int maBan = rs.getInt("MaBan");
                int maMonAn = rs.getInt("MaMonAn");
                int soLuong = rs.getInt("SoLuong");
                String tinhTrang = rs.getString("TinhTrang");
                GoiMon goiMon = new GoiMon(maBan, maMonAn, soLuong, tinhTrang);
                danhSachGoiMon.add(goiMon);
            }
        }
        return danhSachGoiMon;
    }
    // Phương thức thêm đơn gọi món mới
     public void themMonAn(int maBan, int maMonAn, int soLuong) throws SQLException {
    String sqlInsert = "INSERT INTO goimon (MaBan, MaMonAn, SoLuong, TinhTrangMonAn) VALUES (?, ?, ?, 'Chưa hoàn thành')";
    try (PreparedStatement stmtInsert = connection.prepareStatement(sqlInsert)) {
        stmtInsert.setInt(1, maBan);
        stmtInsert.setInt(2, maMonAn);
        stmtInsert.setInt(3, soLuong);
        stmtInsert.executeUpdate();
    }
}    
    
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
