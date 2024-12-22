<%-- 
    Document   : themnv1
    Created on : Nov 22, 2024, 3:45:31 PM
    Author     : Admin
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thêm Nhân Viên</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
                background-color: #f4f4f9;
            }
            form {
                max-width: 500px;
                margin: auto;
                background: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            label {
                font-weight: bold;
                margin-top: 10px;
                display: block;
            }
            input, select, button {
                width: 100%;
                margin: 5px 0 20px;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
            }
            button {
                background-color: #28a745;
                color: white;
                font-size: 16px;
                border: none;
                cursor: pointer;
            }
            button:hover {
                background-color: #218838;
            }
        </style>
    </head>
    <body>
        <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <h1 style="text-align: center;">Thêm Nhân Viên</h1>
        <form action="NhanVienServlet" method="POST">
            <input type="hidde<inputn" name="action" value="add"> 

            <label for="maNhanVien">Mã Nhân Viên</label>
            <input type="text" id="maNhanVien" name="maNhanVien" required>

            <label for="hoTen">Họ Tên</label>
            <input type="text" id="hoTen" name="hoTen" required>

            <label for="chucVu">Chức Vụ</label>
            <input type="text" id="chucVu" name="chucVu" required>

            <label for="diaChi">Địa Chỉ</label>
            <input type="text" id="diaChi" name="diaChi" required>

            <label for="soDienThoai">Số Điện Thoại</label>
            <input type="tel" id="soDienThoai" name="soDienThoai" pattern="[0-9]{10}" required>

            <label for="ngaySinh">Ngày Sinh</label>
            <input type="date" id="ngaySinh" name="ngaySinh" required>

            <button type="submit">Thêm Nhân Viên</button>
        </form>
    </body>
</html>
