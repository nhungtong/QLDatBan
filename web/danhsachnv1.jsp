<%-- 
    Document   : danhsachnv1
    Created on : Nov 22, 2024, 10:45:02 AM
    Author     : Admin
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="dao.NhanVienDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- JSTL forEac<!-- h -->
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Danh sách nhân viên</title>
        <style>
            /* Tổng quan */
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f8f9fa;
                color: #333;
                line-height: 1.6;
            }

            h1 {
                text-align: center;
                margin: 20px 0;
                color: #4CAF50;
            }

            h3 {
                text-align: center;
                color: #333;
                margin: 20px 0;
            }
            
            .b {
                display: inline-block;
                margin: 20px;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                text-decoration: none;
                border-radius: 5px;
                transition: background-color 0.3s ease;
            }

            .b:hover {
                background-color: #45a049;
            }

            .search-bar {
                text-align: center;
                margin-bottom: 20px;
            }

            .search-bar form {
                display: inline-block;
            }

            .search-bar input[type="text"] {
                width: 300px;
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .search-bar button {
                padding: 10px 20px;
                font-size: 16px;
                background-color: #007BFF;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            .search-bar button:hover {
                background-color: #0056b3;
            }

            /* Bảng danh sách */
            table {
                width: 90%;
                margin: 0 auto;
                border-collapse: collapse;
                background-color: white;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: center;
            }

            th {
                background-color: #f4f4f4;
                font-weight: bold;
            }

            tbody tr:nth-child(even) {
                background-color: #f9f9f9;
            }

            tbody tr:hover {
                background-color: #f1f1f1;
            }

            /* Nút hành động */
            .action-buttons form {
                display: inline-block;
                margin: 0 5px;
            }

            .action-buttons button {
                padding: 5px 10px;
                font-size: 14px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: transform 0.2s ease;
            }

            .action-buttons button:hover {
                transform: scale(1.1);
            }

            .action-buttons button[type="submit"] {
                background-color: #007BFF;
                color: white;
            }

            .action-buttons button[type="submit"]:hover {
                background-color: #0056b3;
            }

            .action-buttons button[style*="color: red;"] {
                background-color: #FF5A5A;
                color: white;
            }

            .action-buttons button[style*="color: red;"]:hover {
                background-color: #D90000;
            }

            form div {
                margin: 20px 0;
                text-align: center;
            }

            form div button {
                padding: 10px 20px;
                font-size: 16px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease, transform 0.2s ease;
            }

            form div button:hover {
                background-color: #45a049;
                transform: scale(1.05);
            }

            form div button:active {
                background-color: #3e8e41;
                transform: scale(1);
            }

            @media (max-width: 768px) {
                table {
                    font-size: 14px;
                }

                .search-bar input[type="text"] {
                    width: 80%;
                }

                form div button {
                    width: 90%;
                }
            }

        </style>
    </head>
    <body>
        <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <h1>Danh sách nhân viên</h1>
        <a class="b" href="themnv1.jsp">Thêm nhân viên mới</a>
        <br><br>

        <!-- Thanh tìm kiếm -->
        <div class="search-bar">
            <form action="NhanVienServlet" method="post">
                <input type="hidden" name="action" value="search">
                <input type="text" name="maNhanVien" placeholder="Nhập mã nhân viên cần tìm..." required>
                <button type="submit">Tìm kiếm</button>
            </form>
        </div>

        <!-- Hiển thị thông báo -->
        <c:if test="${not empty thongBao}">
            <p style="color: green;">${thongBao}</p>
        </c:if>

        <!-- Hiển thị kết quả tìm kiếm -->
        <c:if test="${not empty nhanVienTimDuoc}">
            <h3>Kết Quả Tìm Kiếm:</h3>
            <table>
                <thead>
                    <tr>
                        <th>Mã nhân viên</th>
                        <th>Họ tên</th>
                        <th>Ngày sinh</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Chức vụ</th>
                        <th>Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${nhanVienTimDuoc.maNhanVien}</td>
                        <td>${nhanVienTimDuoc.hoTen}</td>
                        <td>${nhanVienTimDuoc.ngaySinh}</td>
                        <td>${nhanVienTimDuoc.diaChi}</td>
                        <td>${nhanVienTimDuoc.soDienThoai}</td>
                        <td>${nhanVienTimDuoc.chucVu}</td>
                        <td class="action-buttons">
                            <!-- Nút Xóa -->
                            <form action="NhanVienServlet" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="maNhanVien" value="${nhanVienTimDuoc.maNhanVien}">
                                <button type="submit" style="color: red;">Xóa</button>
                            </form>
                        </td>
                    </tr>
                </tbody>
            </table>
        </c:if>

        <!-- Danh sách nhân viên -->
        <h3>Danh Sách Nhân Viên</h3>
        <table>
            <!-- <thead>
                 <tr>
                     <th>Mã nhân viên</th>
                     <th>Họ tên</th>
                     <th>Ngày sinh</th>
                     <th>Địa chỉ</th>
                     <th>Số điện thoại</th>
                     <th>Chức vụ</th>
                     <th>Hành động</th>
                 </tr>
             </thead>-->
            <tbody>
                <c:forEach var="nhanVien" items="${danhSachNhanVien}">
                    <tr>
                        <td>${nhanVien.maNhanVien}</td>
                        <td>${nhanVien.hoTen}</td>
                        <td>${nhanVien.ngaySinh}</td>
                        <td>${nhanVien.diaChi}</td>
                        <td>${nhanVien.soDienThoai}</td>
                        <td>${nhanVien.chucVu}</td>
                        <td class="action-buttons">
                            <!-- Nút Sửa -->
                            <form action="NhanVienServlet" method="post">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="maNhanVien" value="${nhanVien.maNhanVien}">
                                <button type="submit">Sửa</button>
                            </form>

                            <!-- Nút Xóa -->
                            <form action="NhanVienServlet" method="post">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="maNhanVien" value="${nhanVien.maNhanVien}">
                                <button type="submit" style="color: red;">Xóa</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="NhanVienServlet" method="GET">
            <div style="text-align: center;">
                <button type="submit">Hiển thị danh sách nhân viên</button>
            </div>
        </form>
    </body>
</html>
