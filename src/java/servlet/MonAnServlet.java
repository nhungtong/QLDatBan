/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.GoiMonDAO;
import dao.MonAnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.ThucDon;

/**
 *
 * @author hi tcc
 */
@WebServlet(name = "MonAnServlet", urlPatterns = {"/MonAnServlet"})
public class MonAnServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // Khởi tạo đối tượng DatBanDAO
    private MonAnDAO monAnDAO = new MonAnDAO();
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
            out.println("<title>Servlet MonAnServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MonAnServlet at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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

    if ("addDA".equals(action)) {
        try {
            int maBan = Integer.parseInt(request.getParameter("maBan"));
            int maMonAn = Integer.parseInt(request.getParameter("maMonAn"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));

            GoiMonDAO goiMonDAO = new GoiMonDAO();
            goiMonDAO.themMonAn(maBan, maMonAn, soLuong);

            request.setAttribute("successMessage", "Chọn món thành công!");

            HttpSession session = request.getSession();
            session.setAttribute("maBan", maBan);

            List<ThucDon> danhSachMonAn = monAnDAO.layDanhSachMonAn();
            request.setAttribute("danhSachDoAn", danhSachMonAn);
            request.setAttribute("maBan", maBan);

            request.getRequestDispatcher("doAn.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Lỗi xảy ra khi thêm món vào cơ sở dữ liệu.");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu đầu vào không hợp lệ. Vui lòng kiểm tra lại.");
        }
    } else if ("addDU".equals(action)) {
        try {
            int maBan = Integer.parseInt(request.getParameter("maBan"));
            int maMonAn = Integer.parseInt(request.getParameter("maMonAn"));
            int soLuong = Integer.parseInt(request.getParameter("soLuong"));

            GoiMonDAO goiMonDAO = new GoiMonDAO();
            goiMonDAO.themMonAn(maBan, maMonAn, soLuong);

            request.setAttribute("successMessage", "Chọn món thành công!");

            HttpSession session = request.getSession();
            session.setAttribute("maBan", maBan);

            List<ThucDon> danhSachMonAn = monAnDAO.timKiemMonAnTheoLoai("Đồ Uống");
            request.setAttribute("danhSachDoUong", danhSachMonAn);
            request.setAttribute("maBan", maBan);
            request.getRequestDispatcher("doUong.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Lỗi xảy ra khi thêm món vào cơ sở dữ liệu.");
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Dữ liệu đầu vào không hợp lệ. Vui lòng kiểm tra lại.");
        }
    } else {
        String maBan = request.getParameter("maBan");
        if (maBan != null && !maBan.isEmpty()) {
            List<ThucDon> danhSachMonAn = null;
            try {
                danhSachMonAn = monAnDAO.layDanhSachMonAn(); 
                request.setAttribute("danhSachDoAn", danhSachMonAn);
                request.setAttribute("maBan", maBan); 
                request.getRequestDispatcher("doAn.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(MonAnServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("errorMessage", "Có lỗi xảy ra khi truy vấn dữ liệu.");
            }
        } else {
            response.sendRedirect("nhapMaBan.jsp");
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
