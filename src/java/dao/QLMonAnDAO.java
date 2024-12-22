/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import dbconnection.KetNoiCSDL;
import static dbconnection.KetNoiCSDL.getConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.QLMonAn;

/**
 *
 * @author thaot
 */
public class QLMonAnDAO {
     public List<QLMonAn> layTatCaMonAn() {
        List<QLMonAn> danhSachMonAn = new ArrayList<>();
        Connection conn = KetNoiCSDL.getConnection();
        String query = "SELECT * FROM goimon";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                danhSachMonAn.add(new QLMonAn(
                    rs.getInt("MaBan"),
                    rs.getInt("MaMonAn"),
                    rs.getInt("SoLuong"),
                    rs.getString("TinhTrangMonAn")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMonAn;
    }

    public List<QLMonAn> timKiem(String tinhTrang, int maBan) {
        List<QLMonAn> danhSachMonAn = new ArrayList<>();
        Connection conn = KetNoiCSDL.getConnection();
        StringBuilder query = new StringBuilder("SELECT * FROM goimon WHERE 1=1");

        if (tinhTrang != null && !tinhTrang.isEmpty()) {
            query.append(" AND TinhTrangMonAn = ?");
        }
        if (maBan > 0) {
            query.append(" AND MaBan = ?");
        }

        try (PreparedStatement pstmt = conn.prepareStatement(query.toString())) {
            int index = 1;
            if (tinhTrang != null && !tinhTrang.isEmpty()) {
                pstmt.setString(index++, tinhTrang);
            }
            if (maBan > 0) {
                pstmt.setInt(index, maBan);
            }
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                danhSachMonAn.add(new QLMonAn(
                    rs.getInt("MaBan"),
                    rs.getInt("MaMonAn"),
                    rs.getInt("SoLuong"),
                    rs.getString("TinhTrangMonAn")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhSachMonAn;
    }
    
    public void xoaMonAn(int maBan, int maMonAn) {
    Connection conn = KetNoiCSDL.getConnection();
    String query = "DELETE FROM goimon WHERE MaBan = ? AND MaMonAn = ?";
    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
        pstmt.setInt(1, maBan);
        pstmt.setInt(2, maMonAn);
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    

    public void capNhatTinhTrangMonAn(int maBan, int maMonAn, String tinhTrangMoi) {
        Connection conn = KetNoiCSDL.getConnection();
        String query = "UPDATE goimon SET TinhTrangMonAn = ? WHERE MaBan = ? AND MaMonAn = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, tinhTrangMoi);
            pstmt.setInt(2, maBan);
            pstmt.setInt(3, maMonAn);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
