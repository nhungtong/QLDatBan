<%-- 
    Document   : nhapMaBan
    Created on : Nov 25, 2024, 11:13:15 AM
    Author     : hi tcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nhập Mã Bàn</title>
        <link rel="stylesheet" type="text/css" href="style/nhapmaban.css">

    </head>
    <body>
        <div class="chung">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <div class="nhap">
            <h2>Vui lòng nhập mã bàn để tiếp tục</h2>
            <form action="MonAnServlet" method="POST">
                <input type="text" id="maBan" name="maBan" required />
                <button type="submit">Tiếp tục</button>
            </form>
        </div>
    </body>
</html>
