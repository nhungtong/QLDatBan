<%-- 
    Document   : suaban
    Created on : Nov 24, 2024, 11:23:06 PM
    Author     : hi tcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style/suaban.css">
    </head>
    <body>
           <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <div class="form-container">
            <h1>Sửa Tình Trạng Đặt Bàn</h1>
            
            <form action="DatBanServlet" method="POST">
                <input type="hidden" name="action" value="update">

                <div class="form-group">
                    <label for="maBan">Mã Bàn: </label>
                    <input type="text" id="maBan" name="maBan" value="${datBan.maBan}" readonly>
                </div>

                <div class="form-group">
                    <label for="tinhTrang">Tình Trạng: </label>
                    <input type="text" id="tinhTrang" name="tinhTrang" value="${datBan.tinhTrang}" required>
                </div>
                <!-- Nút hành động -->
                <div class="form-actions">
                    <button type="submit" >Cập Nhật</button>
                    <button type="button" onclick="window.location.href = 'danhsachban.jsp'">Hủy</button>
                </div>
            </form>
        </div>
    </body>
</html>
