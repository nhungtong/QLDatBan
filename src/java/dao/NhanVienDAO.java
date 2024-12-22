/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbconnection.KetNoiCSDL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author hi tcc
 */
public class NhanVienDAO {

    private Connection connection;

    public NhanVienDAO() {
        connection = KetNoiCSDL.getConnection();
    }

    // Thêm nhân viên mới
    public boolean themNhanVien(NhanVien nhanVien) throws SQLException {
        
        String sql = "INSERT INTO NhanVien (MaNhanVien, HoTen, NgaySinh, DiaChi, SoDienThoai, ChucVu) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nhanVien.getMaNhanVien());
            preparedStatement.setString(2, nhanVien.getHoTen());
             preparedStatement.setDate(3, java.sql.Date.valueOf(nhanVien.getNgaySinh()));
             preparedStatement.setString(4, nhanVien.getDiaChi());
             preparedStatement.setString(5, nhanVien.getSoDienThoai());
            preparedStatement.setString(6, nhanVien.getChucVu());
            
            
           
            int rowsAffected = preparedStatement.executeUpdate();
        
        return rowsAffected > 0;
        }
        }

    // Lấy danh sách nhân viên
    public List<NhanVien> layDanhSachNhanVien() {
        List<NhanVien> danhSachNhanVien = new ArrayList<>();
        String sql = "SELECT * FROM nhanvien";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql); ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                String maNhanVien = rs.getString("MaNhanVien");
                String hoTen = rs.getString("HoTen");
                String chucVu = rs.getString("ChucVu");
                String diaChi = rs.getString("DiaChi");
                String soDienThoai = rs.getString("SoDienThoai");
                LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();

                NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, chucVu, diaChi, soDienThoai, ngaySinh);
                danhSachNhanVien.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachNhanVien;
    }

    // Tìm nhân viên theo mã
    public NhanVien timNhanVienTheoMa(String maNhanVien) {
        String sql = "SELECT * FROM nhanvien WHERE MaNhanVien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maNhanVien);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    String hoTen = rs.getString("HoTen");
                    String chucVu = rs.getString("ChucVu");
                    String diaChi = rs.getString("DiaChi");
                    String soDienThoai = rs.getString("SoDienThoai");
                    LocalDate ngaySinh = rs.getDate("NgaySinh").toLocalDate();
                    return new NhanVien(maNhanVien, hoTen, chucVu, diaChi, soDienThoai, ngaySinh);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Cập nhật nhân viên
    public boolean capNhatNhanVien(NhanVien nhanVien) {
        boolean hangCN = false;
        String sql = "UPDATE nhanvien SET HoTen = ?, ChucVu = ?, DiaChi = ?, SoDienThoai = ?, NgaySinh = ? WHERE MaNhanVien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nhanVien.getHoTen());
            preparedStatement.setString(2, nhanVien.getChucVu());
            preparedStatement.setString(3, nhanVien.getDiaChi());
            preparedStatement.setString(4, nhanVien.getSoDienThoai());
            preparedStatement.setDate(5, java.sql.Date.valueOf(nhanVien.getNgaySinh()));
            preparedStatement.setString(6, nhanVien.getMaNhanVien());
            preparedStatement.executeUpdate();
            hangCN = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hangCN;
    }

    // Xóa nhân viên
    public boolean xoaNhanVien(String maNhanVien) {
        boolean hangDX = false;
        String sql = "DELETE FROM nhanvien WHERE MaNhanVien = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, maNhanVien);
            hangDX = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hangDX;
    }

    // Đóng kết nối cơ sở dữ liệu
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
