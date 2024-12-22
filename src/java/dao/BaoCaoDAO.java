package dao;

import dbconnection.KetNoiCSDL;
import model.BaoCao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaoCaoDAO {

    private Connection connection;

    public BaoCaoDAO() {
        connection = KetNoiCSDL.getConnection();
    }

    // Phương thức lấy toàn bộ báo cáo doanh thu
    public List<BaoCao> layBaoCaoDoanhThu() {
        List<BaoCao> danhSachBaoCao = new ArrayList<>();
        String sql = "SELECT * FROM thanhtoan"; 

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                
                Date ngayThanhToan = rs.getDate("NgayThanhToan");
                String maBan = rs.getString("MaBan");
                double tongTien = rs.getDouble("TongTien");

                
                BaoCao baoCao = new BaoCao(ngayThanhToan, maBan, tongTien);

                
                danhSachBaoCao.add(baoCao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachBaoCao; 
    }

    // Phương thức lấy báo cáo doanh thu theo ngày
    public List<BaoCao> layBaoCaoDoanhThuTheoNgay(Date ngay) {
        List<BaoCao> danhSachBaoCao = new ArrayList<>();
        String sql = "SELECT * FROM thanhtoan WHERE DATE(NgayThanhToan) = ?"; 

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setDate(1, ngay);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    
                    Date ngayThanhToan = rs.getDate("NgayThanhToan");
                    String maBan = rs.getString("MaBan");
                    double tongTien = rs.getDouble("TongTien");

                    
                    BaoCao baoCao = new BaoCao(ngayThanhToan, maBan, tongTien);

                   
                    danhSachBaoCao.add(baoCao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachBaoCao; 
    }

    // Phương thức lấy báo cáo doanh thu theo tháng
    public List<BaoCao> layBaoCaoDoanhThuTheoThang(int thang, int nam) {
        List<BaoCao> danhSachBaoCao = new ArrayList<>();
        String sql = "SELECT * FROM thanhtoan WHERE MONTH(NgayThanhToan) = ? AND YEAR(NgayThanhToan) = ?"; 

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setInt(1, thang);
            statement.setInt(2, nam);

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                   
                    Date ngayThanhToan = rs.getDate("NgayThanhToan");
                    String maBan = rs.getString("MaBan");
                    double tongTien = rs.getDouble("TongTien");

                    
                    BaoCao baoCao = new BaoCao(ngayThanhToan, maBan, tongTien);

                    
                    danhSachBaoCao.add(baoCao);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return danhSachBaoCao; 
    }
    public double tinhTongDoanhThuTheoNgay(Date ngay) {
    String sql = "SELECT SUM(TongTien) AS TongDoanhThu FROM thanhtoan WHERE DATE(NgayThanhToan) = ?";
    double tongDoanhThu = 0;

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setDate(1, ngay);

        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                tongDoanhThu = rs.getDouble("TongDoanhThu");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tongDoanhThu;
}
    public double tinhTongDoanhThuTheoThang(int thang, int nam) {
    String sql = "SELECT SUM(TongTien) AS TongDoanhThu "
               + "FROM thanhtoan "
               + "WHERE MONTH(NgayThanhToan) = ? AND YEAR(NgayThanhToan) = ?";
    double tongDoanhThu = 0;

    try (PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setInt(1, thang);
        statement.setInt(2, nam);

        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                tongDoanhThu = rs.getDouble("TongDoanhThu");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return tongDoanhThu;
}

}
