/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.TaiKhoanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hi tcc
 */
@WebServlet(name = "DangNhapServlet", urlPatterns = {"/DangNhapServlet"})
public class DangNhapServlet extends HttpServlet {

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
    String maNhanVien = request.getParameter("username"); 
    String matKhau = request.getParameter("password"); 

    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();

    try (PrintWriter out = response.getWriter()) {
       
        if (taiKhoanDAO.kiemTraDangNhap(maNhanVien, matKhau)) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Đăng nhập thành công</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Xin chào, " + maNhanVien + "! Đăng nhập thành công!</h1>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Đăng nhập thất bại</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sai tài khoản hoặc mật khẩu. Vui lòng thử lại.</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
            response.sendRedirect("DangNhap.jsp");
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
    
    String username = request.getParameter("username");
    String password = request.getParameter("password");

   
    TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
    boolean isValid = taiKhoanDAO.kiemTraDangNhap(username, password);

    
    if (isValid) {
        
        request.getSession().setAttribute("username", username); 
        response.sendRedirect("GiaoDienChung.jsp"); 
    } else {
        request.setAttribute("errorMessage", "Sai tài khoản hoặc mật khẩu. Vui lòng thử lại.");
        request.getRequestDispatcher("DangNhap.jsp").forward(request, response); 
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
