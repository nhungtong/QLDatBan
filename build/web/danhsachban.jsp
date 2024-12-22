<%-- 
    Document   : danhsachban
    Created on : Nov 24, 2024, 3:36:48 PM
    Author     : hi tcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Sách Bàn </title>
        <link rel="stylesheet" type="text/css" href="style/danhsachban.css">
    </head>
    <body>
        <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <div class="container">
            <div>
                <a href="themban.jsp" class="nut-link">Thêm Bàn</a>
            </div>
            <div>
                <form action="DatBanServlet" method="GET">
                    <div class="nut" style="text-align: center; margin-bottom: 20px;">
                        <button type="submit">Hiển Thị Danh Sách Bàn</button>
                    </div>
                </form>
            </div>
            <div class="timkiem">
                <form action="DatBanServlet" method="POST">
                    <input type="hidden" name="action" value="search">
                    <input type="number" id="maBan" name="maBan" placeholder="Nhập mã bàn" required>
                    <button type="submit">Tìm Kiếm</button>
                </form>
            </div>
        </div>
        <c:if test="${not empty thongBao}">
            <p class="thong-bao">${thongBao}</p>
        </c:if>
        <div class="danhsachban">
            <c:if test="${not empty ketQuaTimKiem}">
                <h3>Danh Sách Bàn:</h3>
                <table>
                    <thead>
                        <tr>
                            <th>Mã Bàn</th>
                            <th>Tình Trạng</th>
                            <th colspan="2">Hành Động</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${ketQuaTimKiem.maBan}</td>
                            <td>${ketQuaTimKiem.tinhTrang}</td>
                            <td class="sua">
                                <form action="DatBanServlet" method="post">
                                    <input type="hidden" name="action" value="edit">
                                    <input type="hidden" name="maBan" value="${ketQuaTimKiem.maBan}">
                                    <button type="submit">Sửa</button>
                                </form>
                            </td>
                            <td class="xoa">
                                <form action="DatBanServlet" method="POST">
                                    <input type="hidden" name="action" value="delete">
                                    <input type="hidden" name="maBan" value="${ketQuaTimKiem.maBan}">
                                    <button type="submit">Xóa</button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </c:if>
            <h3>Danh Sách Bàn:</h3>
            <c:if test="${not empty danhSachBan}">
                <table id="ban-table">
                    <thead>
                        <tr>
                            <th>Mã Bàn</th>
                            <th>Tình Trạng</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="ban" items="${danhSachBan}">
                            <tr>
                                <td>${ban.maBan}</td>
                                <td>${ban.tinhTrang}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</body>
</html>
