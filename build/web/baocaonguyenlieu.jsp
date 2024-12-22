<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Danh Sách Nguyên Liệu</title>
    <link rel="stylesheet" href="styles.css"> <!-- Đường dẫn đến file CSS -->
</head>
<style>
    /* styles.css */

body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f9f9f9;
    color: #333;
}

h1 {
    text-align: center;
    margin-top: 20px;
    color: #4CAF50;
}

table {
    margin: 20px auto;
    border-collapse: collapse;
    width: 80%;
    background-color: #fff;
}

table th, table td {
    padding: 10px;
    text-align: center;
    border: 1px solid #ddd;
}

table th {
    background-color: #4CAF50;
    color: white;
}

table tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

table tbody tr:hover {
    background-color: #e0f7fa;
}

/* Style for the form */
form {
    margin: 20px auto;
    text-align: center;
}

form button {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
    transition: background-color 0.3s ease, transform 0.2s ease;
}

form button:hover {
    background-color: #45a049;
    transform: scale(1.05);
}

form button:active {
    background-color: #3d8b3d;
    transform: scale(1);
}

form div {
    margin: 20px 0;
}

/* Responsive design for smaller screens */
@media (max-width: 768px) {
    table {
        width: 100%;
        font-size: 14px;
    }

    form button {
        width: 90%;
        font-size: 18px;
    }
}

</style>
<body>
    <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
    <h1>Danh Sách Nguyên Liệu</h1>

    <c:if test="${not empty danhSachNguyenLieu}">
        <table border="1" cellspacing="0" cellpadding="5">
            <thead>
                <tr>
                    <th>Mã Hóa Đơn</th>
                    <th>Tên Nguyên Liệu</th>
                    <th>Đơn Giá</th>
                    <th>Số Lượng</th>
                    <th>Thành Tiền</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="nguyenLieu" items="${danhSachNguyenLieu}">
                    <tr>
                        <td>${nguyenLieu.maHoaDon}</td>
                        <td>${nguyenLieu.tenNguyenLieu}</td>
                        <td>${nguyenLieu.donGia}</td>
                        <td>${nguyenLieu.soLuong}</td>
                        <td>${nguyenLieu.thanhTien}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
     <form action="BaoCaoServlet" method="Post">
        <div style="text-align: center;">
            <button type="submit">Hiển thị danh sách nguyên liệu</button>
        </div>
    </form>  
</body>
</html>
