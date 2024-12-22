<%-- 
    Document   : suanv
    Created on : Nov 22, 2024, 9:09:25 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Sửa Nhân Viên</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f9f9f9;
                padding: 20px;
            }
            .form-container {
                width: 500px;
                margin: auto;
                background: #fff;
                border-radius: 10px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                padding: 20px;
            }
            .form-container h1 {
                text-align: center;
                margin-bottom: 20px;
            }
            .form-group {
                margin-bottom: 15px;
            }
            .form-group label {
                display: block;
                font-weight: bold;
            }
            .form-group input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }
            .form-actions {
                text-align: center;
            }
            .form-actions button {
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            .form-actions button:hover {
                background-color: #45a049;
            }
            .error {
                color: red;
                text-align: center;
                margin-bottom: 15px;
            }
            .success {
                color: green;
                text-align: center;
                margin-bottom: 15px;
            }
        </style>
    </head>
    <body>
        <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <div class="form-container">
            <h1>Sửa Nhân Viên</h1>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>

            <form action="NhanVienServlet" method="post">
                <!-- Hidden input để chỉ định action -->
                <input type="hidden" name="action" value="update">

                <!-- Mã nhân viên (không cho chỉnh sửa) -->
                <div class="form-group">
                    <label for="maNhanVien">Mã Nhân Viên</label>
                    <input type="text" id="maNhanVien" name="maNhanVien" value="${nhanVien.maNhanVien}" readonly>
                </div>

                <div class="form-group">
                    <label for="hoTen">Họ Tên</label>
                    <input type="text" id="hoTen" name="hoTen" value="${nhanVien.hoTen}" required>
                </div>

                <div class="form-group">
                    <label for="chucVu">Chức Vụ</label>
                    <input type="text" id="chucVu" name="chucVu" value="${nhanVien.chucVu}" required>
                </div>

                <div class="form-group">
                    <label for="diaChi">Địa Chỉ</label>
                    <input type="text" id="diaChi" name="diaChi" value="${nhanVien.diaChi}" required>
                </div>

                <div class="form-group">
                    <label for="soDienThoai">Số Điện Thoại</label>
                    <input type="text" id="soDienThoai" name="soDienThoai" value="${nhanVien.soDienThoai}" required>
                </div>

                <div class="form-group">
                    <label for="ngaySinh">Ngày Sinh</label>
                    <input type="date" id="ngaySinh" name="ngaySinh" value="${nhanVien.ngaySinh}" required>
                </div>

                <!-- Nút hành động -->
                <div class="form-actions">
                    <button type="submit">Cập Nhật</button>
                    <button type="button" onclick="window.location.href = 'danhsachnv1.jsp'">Hủy</button>
                </div>
            </form>
        </div>
    </body>
</html>
