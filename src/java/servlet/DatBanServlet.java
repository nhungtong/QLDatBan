/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.DatBanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DatBan;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hi tcc
 */
@WebServlet(name = "DatBanServlet", urlPatterns = {"/DatBanServlet"})
public class DatBanServlet extends HttpServlet {

    // Đảm bảo tương thích phiên bản
    private static final long serialVersionUID = 1L;

    // Khởi tạo đối tượng DatBanDAO
    private DatBanDAO datBanDAO = new DatBanDAO();

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
            out.println("<title>Servlet DatBanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DatBanServlet at " + request.getContextPath() + "</h1>");
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
    // Dùng để lấy hoặc truy vấn dữ liệu
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DatBan> danhSachBan = datBanDAO.layDanhSachBan();
        request.setAttribute("danhSachBan", danhSachBan);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/danhsachban.jsp");
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

    // Dùng để gửi dữ liệu từ client đến server
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                int maBan = Integer.parseInt(request.getParameter("maBan"));
                String tinhTrang = request.getParameter("tinhTrang");

                DatBan banMoi = new DatBan(maBan, tinhTrang);

                boolean isSuccess = datBanDAO.themBan(banMoi);
                if (isSuccess) {
                    request.setAttribute("message", "Thêm bàn thành công.");
                } else {
                    request.setAttribute("message", "Thêm bàn thất bại.");
                }

                RequestDispatcher dispatcher = request.getRequestDispatcher("/themban.jsp");
                dispatcher.forward(request, response);

            } else if ("edit".equals(action)) {
                int maBan = Integer.parseInt(request.getParameter("maBan"));
                DatBan datBan = datBanDAO.layTinhTrangTheoMa(maBan);

                if (datBan != null) {
                    request.setAttribute("datBan", datBan);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("suaban.jsp");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("thongBao", "Bàn không tồn tại!");
                    request.getRequestDispatcher("/danhsachban.jsp").forward(request, response);
                }

            }else if("update".equals(action)){
                int maBan = Integer.parseInt(request.getParameter("maBan"));
                String tinhTrang = request.getParameter("tinhTrang");

                DatBan datBan = new DatBan(maBan, tinhTrang);
                 boolean isUpdated = datBanDAO.capnhatTinhTrang(maBan, tinhTrang);

            if (isUpdated) {
                response.sendRedirect("danhsachban.jsp");
            } else {
                request.setAttribute("error", "Cập nhật không thành công!");
                request.setAttribute("datBan", datBan);
                RequestDispatcher dispatcher = request.getRequestDispatcher("suaban.jsp");
                dispatcher.forward(request, response);
            }
            }else if ("delete".equals(action)) {
                int maBan = Integer.parseInt(request.getParameter("maBan"));
                boolean isDeleted = datBanDAO.xoaBan(maBan);
            if (isDeleted) {
                request.setAttribute("thongBao", "Xóa thành công!");
            } else {
                request.setAttribute("thongBao", "Không thể xóa.");
            }
            List<DatBan> danhSachBan = datBanDAO.layDanhSachBan();
            request.setAttribute("danhSachBan", danhSachBan);
            request.getRequestDispatcher("danhsachban.jsp").forward(request, response);

            } else if ("search".equals(action)) {
                int maBan = Integer.parseInt(request.getParameter("maBan"));
                DatBan banTimDuoc = datBanDAO.layTinhTrangTheoMa(maBan);
                if (banTimDuoc != null) {
                    request.setAttribute("ketQuaTimKiem", banTimDuoc);
                } else {
                    request.setAttribute("ketQuaTimKiem", null);
                    request.setAttribute("thongBao", "Không tìm thấy bàn với mã " + maBan);
                }
                List<DatBan> danhSachBan = datBanDAO.layDanhSachBan();
                request.setAttribute("danhSachBan", danhSachBan);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/danhsachban.jsp");
                dispatcher.forward(request, response);
            } 
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Lỗi khi xử lý yêu cầu.");
        }
    }

    @Override
    public void destroy() {
        if (datBanDAO != null) {
            try {
                datBanDAO.closeConnection();
            } catch (SQLException ex) {
                Logger.getLogger(DatBanServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
