/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author hi tcc
 */
import dbconnection.KetNoiCSDL;
import model.BaoCao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NguyenLieu;

public class NguyenLieuDAO {

    private Connection connection;

    public NguyenLieuDAO() {
        connection = KetNoiCSDL.getConnection();
    }

    public List<NguyenLieu> layDanhSachNguyenLieu() {
        List<NguyenLieu> danhSachNguyenLieu = new ArrayList<>();
        String sql = "SELECT * FROM nguyenlieu"; 

        try (PreparedStatement statement = connection.prepareStatement(sql); 
                ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                
                int maHoaDon = rs.getInt("MaHoaDon");
                String tenNguyenLieu = rs.getString("TenNguyenLieu");
                double donGia = rs.getDouble("DonGia");
                int soLuong = rs.getInt("SoLuong");
                double thanhTien = rs.getDouble("ThanhTien");

                
                NguyenLieu nguyenLieu = new NguyenLieu(maHoaDon, tenNguyenLieu, donGia, soLuong, thanhTien);

               
                danhSachNguyenLieu.add(nguyenLieu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachNguyenLieu; 
    }
}
