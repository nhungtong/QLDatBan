<%-- 
    Document   : danhsachmonan
    Created on : Nov 25, 2024, 8:31:18 AM
    Author     : hi tcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh Sách Món Ăn</title>
        <link rel="stylesheet" type="text/css" href="style/danhsachmon.css">
    </head>
    <body>
        <div class="hienthi">
            <jsp:include page="GiaoDien.jsp" />
        </div>
        <div class="container">
            <div class="tieude">
                <form action="MonAnServlet" method="POST">
                    <input type="hidden" name="action" value="doAn">
                    <button type="submit" class="nut">Thực Đơn</button>
                </form>
            </div>
        </div>
    </body>
</html>
