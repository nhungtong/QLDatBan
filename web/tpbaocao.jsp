<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="dao.ThanhToanDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Báo cáo doanh thu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            color: #333;
        }
        h2 {
            text-align: center;
            color: #2c3e50;
            padding: 20px;
            background-color: #3498db;
            color: white;
            margin: 0;
        }
        .message {
            color: #e74c3c;
            text-align: center;
            font-weight: bold;
            margin-top: 20px;
        }
        form {
            background-color: #ffffff;
            padding: 20px;
            margin: 20px auto;
            width: 80%;
            max-width: 600px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        form div {
            margin-bottom: 15px;
        }
        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }
        input[type="date"], input[type="month"], button {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            margin-top: 5px;
        }
        button {
            background-color: #3498db;
            color: white;
            cursor: pointer;
            border: none;
            margin-top: 10px;
            font-size: 16px;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        button:hover {
            background-color: #2980b9;
            transform: scale(1.05);
        }
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            text-align: center;
        }
        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
        }
        th {
            background-color: #3498db;
            color: white;
        }
        td {
            background-color: #ffffff;
        }
        @media (max-width: 768px) {
            table {
                width: 100%;
                overflow-x: auto;
                display: block;
            }
            table th, table td {
                white-space: nowrap;
            }
            form {
                width: 90%;
            }
        }
    </style>
</head>
<body>
    <div class="chung">
        <jsp:include page="GiaoDien.jsp" />
    </div>
    <h2>Báo cáo Doanh Thu</h2>

    <!-- Hiển thị thông báo lỗi hoặc thông điệp -->
    <c:if test="${not empty message}">
        <p class="message">${message}</p>
    </c:if>

    <!-- Hiển thị tổng doanh thu -->
    <c:if test="${not empty tongDoanhThu}">
        <p class="message" style="color: green;">Tổng doanh thu: <strong>${tongDoanhThu}</strong> VND</p>
    </c:if>

    <!-- Form chọn ngày hoặc tháng để xem báo cáo -->
    <form action="BaoCaoServlet" method="GET">
        <div>
            <label for="ngay">Chọn ngày:</label>
            <input type="date" id="ngay" name="ngay" />
        </div>
        <div>
            <label for="thang">Chọn tháng:</label>
            <input type="month" id="thang" name="thang" />
        </div>
        <div>
            <button type="submit">Xem báo cáo</button>
        </div>
    </form>

    <!-- Hiển thị bảng báo cáo doanh thu -->
    <c:if test="${not empty danhSachBaoCao}">
        <table>
            <thead>
                <tr>
                    <th>Ngày</th>
                    <th>Bàn</th>
                    <th>Tổng Doanh Thu</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="bc" items="${danhSachBaoCao}">
                    <tr>
                        <td>${bc.ngayThanhToan}</td>
                        <td>${bc.maBan}</td>
                        <td>${bc.tongTien}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>

    <!-- Thông báo nếu không có dữ liệu -->
    <c:if test="${empty danhSachBaoCao}">
        <p class="message" style="color: gray;">Không có dữ liệu báo cáo để hiển thị.</p>
    </c:if>
</body>
</html>
