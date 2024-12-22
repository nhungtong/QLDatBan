package servlet;

import dao.NguyenLieuDAO;
import dao.BaoCaoDAO;
import model.BaoCao;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.NguyenLieu;

/**
 * Servlet để xử lý yêu cầu báo cáo doanh thu.
 */
@WebServlet(name = "BaoCaoServlet", urlPatterns = {"/BaoCaoServlet"})
public class BaoCaoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BaoCaoDAO baocaoDAO;
    private NguyenLieuDAO nguyenLieuDAO;

    @Override
    public void init() throws ServletException {
        // Khởi tạo DAO
        baocaoDAO = new BaoCaoDAO();
        nguyenLieuDAO = new NguyenLieuDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ngayStr = request.getParameter("ngay"); 
        String thangStr = request.getParameter("thang"); 
        List<BaoCao> danhSachBaoCao = new ArrayList<>();
        double tongDoanhThu = 0;

        try {
            if (ngayStr != null && !ngayStr.isEmpty()) {
                danhSachBaoCao = layBaoCaoTheoNgay(ngayStr, request);
                tongDoanhThu = baocaoDAO.tinhTongDoanhThuTheoNgay(java.sql.Date.valueOf(ngayStr)); 
            }
            
            else if (thangStr != null && !thangStr.isEmpty()) {
                danhSachBaoCao = layBaoCaoTheoThang(thangStr, request);
                tongDoanhThu = baocaoDAO.tinhTongDoanhThuTheoThang(Integer.parseInt(thangStr.split("-")[1]), Integer.parseInt(thangStr.split("-")[0])); // Tính tổng doanh thu theo tháng
            }
            
            else {
                danhSachBaoCao = baocaoDAO.layBaoCaoDoanhThu();
                request.setAttribute("message", "Hiển thị toàn bộ báo cáo doanh thu.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Đã xảy ra lỗi khi lấy báo cáo doanh thu: " + e.getMessage());
        }

        
        request.setAttribute("danhSachBaoCao", danhSachBaoCao);
        request.setAttribute("tongDoanhThu", tongDoanhThu);

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("tpbaocao.jsp");
        dispatcher.forward(request, response);
    }

   
    private List<BaoCao> layBaoCaoTheoNgay(String ngayStr, HttpServletRequest request) {
        List<BaoCao> danhSachBaoCao = new ArrayList<>();
        try {
            
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = sdf.parse(ngayStr);
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            danhSachBaoCao = baocaoDAO.layBaoCaoDoanhThuTheoNgay(sqlDate);
            request.setAttribute("message", "Báo cáo doanh thu theo ngày: " + ngayStr);
        } catch (ParseException e) {
            request.setAttribute("message", "Định dạng ngày không hợp lệ. Vui lòng nhập ngày theo định dạng yyyy-MM-dd.");
        }
        return danhSachBaoCao;
    }

    // Phương thức xử lý báo cáo theo tháng
    private List<BaoCao> layBaoCaoTheoThang(String thangStr, HttpServletRequest request) {
        List<BaoCao> danhSachBaoCao = new ArrayList<>();
        try {
            
            String[] parts = thangStr.split("-");
            int nam = Integer.parseInt(parts[0]);
            int thang = Integer.parseInt(parts[1]);
            
            danhSachBaoCao = baocaoDAO.layBaoCaoDoanhThuTheoThang(thang, nam);
            request.setAttribute("message", "Báo cáo doanh thu theo tháng: " + thangStr);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            request.setAttribute("message", "Định dạng tháng không hợp lệ. Vui lòng nhập tháng theo định dạng yyyy-MM.");
        }
        return danhSachBaoCao;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<NguyenLieu> danhSachNguyenLieu = nguyenLieuDAO.layDanhSachNguyenLieu();

        
        request.setAttribute("danhSachNguyenLieu", danhSachNguyenLieu);

        
        RequestDispatcher dispatcher = request.getRequestDispatcher("baocaonguyenlieu.jsp");
        dispatcher.forward(request, response);
    }
}
