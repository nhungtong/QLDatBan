/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.NhanVienDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NhanVien;

/**
 *
 * @author Admin
 */
@WebServlet(name = "NhanVienServlet", urlPatterns = {"/NhanVienServlet"})
public class NhanVienServlet extends HttpServlet {

    private NhanVienDAO nhanVienDAO;

    @Override
    public void init() {
        nhanVienDAO = new NhanVienDAO(); // Kết nối DAO
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NhanVien</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NhanVien at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<NhanVien> danhSachNhanVien = nhanVienDAO.layDanhSachNhanVien();

        
        request.setAttribute("danhSachNhanVien", danhSachNhanVien);

       
        RequestDispatcher dispatcher = request.getRequestDispatcher("danhsachnv1.jsp");
        dispatcher.forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");
        if ("add".equals(action)) {
            
            String maNhanVien = request.getParameter("maNhanVien");
            String hoTen = request.getParameter("hoTen");
            String chucVu = request.getParameter("chucVu");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String ngaySinhString = request.getParameter("ngaySinh");

            LocalDate ngaySinh = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                ngaySinh = LocalDate.parse(ngaySinhString, formatter);
            } catch (Exception e) {
                request.setAttribute("error", "Ngày sinh không hợp lệ.");
                request.getRequestDispatcher("themnv1.jsp").forward(request, response); 
                return;
            }

            NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, chucVu, diaChi, soDienThoai, ngaySinh);

            boolean isAdded = false;
            try {
                isAdded = nhanVienDAO.themNhanVien(nhanVien);
            } catch (SQLException ex) {
                Logger.getLogger(NhanVienServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (isAdded) {
                request.setAttribute("thongBao", "Thêm nhân viên thành công!");
                
                response.sendRedirect("danhsachnv1.jsp"); 
            } else {
                request.setAttribute("error", "Không thể thêm nhân viên. Vui lòng thử lại.");
                request.getRequestDispatcher("themnv1.jsp").forward(request, response); 
            }
        } else if ("edit".equals(action)) {
            
            String maNhanVien = request.getParameter("maNhanVien");

           
            NhanVien nhanVien = nhanVienDAO.timNhanVienTheoMa(maNhanVien);

            if (nhanVien != null) {
                
                request.setAttribute("nhanVien", nhanVien);
               
                RequestDispatcher dispatcher = request.getRequestDispatcher("suanv.jsp");
                dispatcher.forward(request, response);
            } else {
                
                request.setAttribute("error", "Không tìm thấy nhân viên.");
                response.sendRedirect("danhsachnv1.jsp");
            }
        } else if ("update".equals(action)) {
            
            String maNhanVien = request.getParameter("maNhanVien");
            String hoTen = request.getParameter("hoTen");
            String chucVu = request.getParameter("chucVu");
            String diaChi = request.getParameter("diaChi");
            String soDienThoai = request.getParameter("soDienThoai");
            String ngaySinhString = request.getParameter("ngaySinh");
            LocalDate ngaySinh = null;
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
                ngaySinh = LocalDate.parse(ngaySinhString, formatter);
            } catch (Exception e) {
                request.setAttribute("error", "Ngày sinh không hợp lệ.");
                request.getRequestDispatcher("themnv1.jsp").forward(request, response); 
                return;
            }
            
            NhanVien nhanVien = new NhanVien(maNhanVien, hoTen, chucVu, diaChi, soDienThoai, ngaySinh);

           
            boolean isUpdated = nhanVienDAO.capNhatNhanVien(nhanVien);

            if (isUpdated) {
                
                response.sendRedirect("danhsachnv1.jsp");
            } else {
               
                request.setAttribute("error", "Cập nhật không thành công!");
                request.setAttribute("nhanVien", nhanVien);
                RequestDispatcher dispatcher = request.getRequestDispatcher("suanv.jsp");
                dispatcher.forward(request, response);
            }
        } else if ("delete".equals(action)) {
            String maNhanVien = request.getParameter("maNhanVien");
            boolean isDeleted = nhanVienDAO.xoaNhanVien(maNhanVien);

            if (isDeleted) {
                request.setAttribute("thongBao", "Xóa nhân viên thành công!");
            } else {
                request.setAttribute("thongBao", "Không thể xóa nhân viên.");
            }

           
            List<NhanVien> danhSachNhanVien = nhanVienDAO.layDanhSachNhanVien();
            request.setAttribute("danhSachNhanVien", danhSachNhanVien);
            request.getRequestDispatcher("danhsachnv1.jsp").forward(request, response);
        } else if ("search".equals(action)) {
           
            String maNhanVien = request.getParameter("maNhanVien");
            NhanVien nhanVienTimDuoc = nhanVienDAO.timNhanVienTheoMa(maNhanVien);

            if (nhanVienTimDuoc != null) {
                request.setAttribute("nhanVienTimDuoc", nhanVienTimDuoc);
                request.setAttribute("thongBao", "Tìm thấy nhân viên với mã " + maNhanVien);
            } else {
                request.setAttribute("nhanVienTimDuoc", null);
                request.setAttribute("thongBao", "Không tìm thấy nhân viên với mã " + maNhanVien);
            }

            
            RequestDispatcher dispatcher = request.getRequestDispatcher("danhsachnv1.jsp");
            dispatcher.forward(request, response);
            return; 
        }

        // Sau khi xử lý xong, trả về danh sách nhân viên
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet quản lý nhân viên";
    }// </editor-fold>

}
