package servlet;

import dao.ThanhToanDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ThanhToanServlet", urlPatterns = {"/ThanhToanServlet"})
public class ThanhToanServlet extends HttpServlet {

    // Phương thức xử lý cho cả GET và POST
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ThanhToanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ThanhToanServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // Phương thức xử lý GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    // Phương thức xử lý POST
    @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String maBan = request.getParameter("maBan"); 
    String dichVu = request.getParameter("dichVu"); 
    ThanhToanDAO thanhToanDAO = new ThanhToanDAO();

    try (PrintWriter out = response.getWriter()) {
       
        if (maBan == null || maBan.isEmpty()) {
            out.println("<p style='color:red;'>Lỗi: Mã bàn không hợp lệ!</p>");
            out.println("</body></html>");
            return; 
        }

        double tongTien = thanhToanDAO.tinhTongTienVaLuu(maBan);

        List<Map<String, Object>> hoaDon = thanhToanDAO.getChiTietHoaDon(maBan);

        if (dichVu != null && !dichVu.isEmpty()) {
            try {
                int rating = Integer.parseInt(dichVu); 
                if (rating >= 1 && rating <= 5) { 
                    thanhToanDAO.luuDanhGia(maBan, rating);
                    out.println("<p style='color:green;'>Đánh giá của bạn đã được ghi nhận! Cảm ơn bạn.</p>");
                } else {
                    out.println("<p style='color:red;'>Đánh giá không hợp lệ. Vui lòng chọn từ 1 đến 5 sao.</p>");
                }
            }catch (NumberFormatException e) {
                out.println("<p style='color:red;'>Đánh giá phải là một số hợp lệ (1 đến 5).</p>");
            }
           
            
        } else {
            out.println("<p style='color:red;'>Không có đánh giá nào được gửi!</p>");
        }

        out.println("</body>");
        out.println("</html>");
    } catch (Exception e) {
        e.printStackTrace();
        response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Có lỗi xảy ra trên máy chủ.");
    }

    // Truyền maBan sang trang JSP
    request.setAttribute("maBan", maBan);

    // Chuyển tiếp đến trang DanhGia.jsp
    request.getRequestDispatcher("DanhGia.jsp").forward(request, response);
}

}
