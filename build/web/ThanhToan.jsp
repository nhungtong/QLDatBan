<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="dao.ThanhToanDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tính Tổng Tiền và Hóa Đơn</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f9f9f9;
                margin: 0;
                padding: 0;
            }
            .date-title {
                text-align: center;
                margin-bottom: 10px;
                font-size: 16px;
                color: #555;
                font-weight: bold;
            }
            h2 {
                text-align: center;
                color: #333;
                margin-bottom: 20px;
            }
            h1 {
                text-align: center;
                color: #333;
                margin-top: 30px;
            }
            form {
                max-width: 500px;
                margin: 20px auto;
                background: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            label {
                display: block;
                margin-bottom: 10px;
                font-weight: bold;
            }
            input[type="text"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 20px;
                border: 1px solid #ddd;
                border-radius: 4px;
            }
            button {
                background-color: #5cb85c;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
                font-size: 16px;
            }
            button:hover {
                background-color: #4cae4c;
            }
            .invoice-container {
                text-align: center;
                margin: 40px auto;
                background: #fff;
                padding: 20px;
                border-radius: 8px;
                width: 90%;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            table {
                margin: 20px auto;
                border-collapse: collapse;
                width: 80%;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            }
            table, th, td {
                border: 1px solid #ddd;
            }
            th, td {
                padding: 15px;
                text-align: center;
                font-size: 16px;
            }
            th {
                background-color: #5cb85c;
                color: white;
                font-weight: bold;
            }
            tr:nth-child(even) {
                background-color: #f2f2f2;
            }
            tr:hover {
                background-color: #e8f5e9;
            }
            .total-container {
                text-align: center;
                margin-top: 20px;
                font-size: 18px;
                color: #333;
                font-weight: bold;
            }

            /* Đánh giá */
            /* Đánh giá */
            .rating-container {
                text-align: center;
                margin-top: 30px;
            }
            .star-rating {
                display: flex;  /* Sử dụng flexbox để sắp xếp các ngôi sao theo chiều ngang */
                justify-content: center;  /* Căn giữa các ngôi sao */
                font-size: 30px;
                color: #ccc;
                cursor: pointer;
            }
            .star-rating input {
                display: none;  /* Ẩn các radio button */
            }
            .star-rating label {
                color: #ccc;
                cursor: pointer;
                padding: 0 5px;  /* Thêm khoảng cách giữa các ngôi sao */
            }
            .star-rating input:checked ~ label {
                color: gold;  /* Tô vàng các ngôi sao đã chọn */
            }
            .star-rating label:hover,
            .star-rating label:hover ~ label {
                color: gold;  /* Tô vàng các ngôi sao khi hover */
            }

        </style>
    </head>
    <body>
         <div class="chung">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <h1>Tính Tổng Tiền</h1>
        <form action="ThanhToan.jsp" method="post">
            <label for="maBan">Nhập Mã Bàn:</label>
            <input type="text" id="maBan" name="maBan" placeholder="Mã bàn" required>
            <button type="submit">Tính Tổng Tiền</button>
        </form>

        <%
            String maBan = request.getParameter("maBan");
            if (maBan != null && !maBan.isEmpty()) {
                ThanhToanDAO thanhToanDAO = new ThanhToanDAO();

                // Tính tổng tiền và lưu vào bảng thanhtoan
                double tongTien = thanhToanDAO.tinhTongTienVaLuu(maBan);

                // Lấy danh sách chi tiết hóa đơn
                List<Map<String, Object>> hoaDon = thanhToanDAO.getChiTietHoaDon(maBan);

                if (hoaDon != null && !hoaDon.isEmpty()) {
                    java.sql.Date ngayThanhToan = (java.sql.Date) hoaDon.get(0).get("NgayThanhToan");
        %>
        <%
            // Lấy thời gian hiện tại
            java.time.LocalDateTime now = java.time.LocalDateTime.now();
            java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate = now.format(formatter);
        %>
        <div class="invoice-container">
            <div class="date-title">
                Ngày Thanh Toán: <%= formattedDate%>
            </div>
            <h2>Hóa Đơn Cho Bàn: <%= maBan%></h2>
            <table>
                <tr>
                    <th>Tên Món Ăn</th>
                    <th>Giá Thành (VND)</th>
                    <th>Số Lượng</th>
                    <th>Thành Tiền (VND)</th>
                </tr>
                <%
                    // Duyệt danh sách để hiển thị thông tin món ăn
                    for (Map<String, Object> item : hoaDon) {
                        String tenMonAn = (String) item.get("TenMonAn");
                        double giaThanh = (double) item.get("GiaThanh");
                        int soLuong = (int) item.get("SoLuong");
                        double thanhTien = giaThanh * soLuong;
                %>
                <tr>
                    <td><%= tenMonAn%></td>
                    <td><%= giaThanh%></td>
                    <td><%= soLuong%></td>
                    <td><%= thanhTien%></td>
                </tr>
                <% }%>
            </table>
            <div class="total-container">
                Tổng Tiền: <%= tongTien%> VND
            </div>
        </div>
        <form action="ThanhToanServlet" method="post">

            <!-- Lấy maBan từ request attribute và truyền vào hidden input -->
            <input type="hidden" name="maBan" value="<%= maBan%>">

            <div class="star-rating">
                <input type="radio" id="star5" name="dichVu" value="5">
                <label for="star5">&#9733;</label>

                <input type="radio" id="star4" name="dichVu" value="4">
                <label for="star4">&#9733;</label>

                <input type="radio" id="star3" name="dichVu" value="3">
                <label for="star3">&#9733;</label>

                <input type="radio" id="star2" name="dichVu" value="2">
                <label for="star2">&#9733;</label>

                <input type="radio" id="star1" name="dichVu" value="1">
                <label for="star1">&#9733;</label>
            </div>

            <button type="submit" class="submit-btn">Gửi Đánh Giá</button>
        </form>
    </div>
    <%
    } else {
    %>
    <div class="invoice-container">
        <h3>Không có dữ liệu hóa đơn cho bàn <%= maBan%>.</h3>
    </div>
    <%
            }
        }
    %>
</body>
</html>
