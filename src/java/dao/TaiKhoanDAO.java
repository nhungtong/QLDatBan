/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.KetNoiCSDL;
import java.sql.*;

/**
 *
 * @author hi tcc
 */
public class TaiKhoanDAO {
    private Connection connection;

    public TaiKhoanDAO() {
        connection = KetNoiCSDL.getConnection();
        if (connection == null) {
            throw new RuntimeException("Không thể kết nối tới cơ sở dữ liệu!");
        }
    }
    public boolean kiemTraDangNhap(String maNhanVien, String matKhau) {
        String sql = "SELECT * FROM taikhoan WHERE MaNhanVien = ? AND MatKhau = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maNhanVien);
            preparedStatement.setString(2, matKhau);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next(); 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
