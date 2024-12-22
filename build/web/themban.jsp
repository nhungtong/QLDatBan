<%-- 
    Document   : themban
    Created on : Nov 24, 2024, 4:28:42 PM
    Author     : hi tcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Bàn</title>
        <link rel="stylesheet" type="text/css" href="style/themban.css">
    </head>
    <body>
        <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <div class="themban">
            <h1>Thêm Bàn Mới</h1>
        <form action="DatBanServlet" method="POST">
            <input type="hidden" name="action" value="add"> 

            <label for="maBan">Mã Bàn: </label>
            <input type="text" id="maBan" name="maBan" required>

            <label for="tinhTrang">Tình Trạng: </label>
            <input type="text" id="tinhTrang" name="tinhTrang" required>
            
            <button type="submit">Thêm Bàn</button>
        </form>
        </div>
        <div >
             <a href="danhsachban.jsp" class="nut-link">Quay lại danh sách bàn</a>
        </div>
    </body>
</html>
