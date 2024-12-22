<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="dao.QLMonAnDAO, model.QLMonAn"%>
<%
    QLMonAnDAO monAnDAO = new QLMonAnDAO();
    List<QLMonAn> danhSachMonAn;

    String tinhTrang = request.getParameter("tinhTrang");
    String maBanParam = request.getParameter("maBan");

    if ((tinhTrang == null || tinhTrang.isEmpty()) && (maBanParam == null || maBanParam.isEmpty())) {
        danhSachMonAn = monAnDAO.layTatCaMonAn();
    } else {
        int maBan = maBanParam != null && !maBanParam.isEmpty() ? Integer.parseInt(maBanParam) : -1;
        danhSachMonAn = monAnDAO.timKiem(tinhTrang, maBan);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tình Trạng Món</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f7f9fc;
            margin: 0;
            padding: 0;
        }
        h1 {
            text-align: center;
            margin-top: 20px;
            color: #2c3e50;
        }
        table {
            margin: 30px auto;
            border-collapse: collapse;
            width: 90%;
            background-color: #ffffff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        table th, table td {
            border: 1px solid #dddddd;
            text-align: center;
            padding: 12px;
        }
        table th {
            background-color: #2c3e50;
            color: #ffffff;
            text-transform: uppercase;
        }
        table tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        table tr:hover {
            background-color: #f1c40f;
            color: #fff;
        }
        select, button, input[type="number"] {
            font-size: 14px;
            padding: 6px 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        select, input[type="number"] {
            background-color: #ecf0f1;
            color: #2c3e50;
        }
        button {
            background-color: #3498db;
            color: #ffffff;
            cursor: pointer;
        }
        button:hover {
            background-color: #2980b9;
        }
        form {
            margin: 0;
        }
    </style>
</head>
<body>
    <div class="chung">
            <jsp:include page="GiaoDien.jsp" />
    </div>
    <h1>Tìm Kiếm Món Ăn</h1>
    <form action="TinhTrangMon.jsp" method="GET" style="text-align: center; margin-bottom: 20px;">
        <label for="tinhTrang">Tình Trạng:</label>
        <select name="tinhTrang" id="tinhTrang">
            <option value="">-- Chọn Tình Trạng --</option>
            <option value="Chưa hoàn thành">Chưa hoàn thành</option>
            <option value="Đang chuẩn bị">Đang chuẩn bị</option>
            <option value="Chờ phục vụ">Chờ phục vụ</option>
            <option value="Đã phục vụ">Đã phục vụ</option>
        </select>
        <label for="maBan">Mã Bàn:</label>
        <input type="number" name="maBan" id="maBan" placeholder="Nhập mã bàn">
        <button type="submit">Tìm Kiếm</button>
    </form>

    <h1>Tình Trạng Các Món Ăn</h1>
    <table>
        <tr>
            <th>Mã Bàn</th>
            <th>Mã Món Ăn</th>
            <th>Số Lượng</th>
            <th>Tình Trạng</th>
            <th>Hành Động</th>
        </tr>
        <%
            for (QLMonAn monAn : danhSachMonAn) {
        %>
        <tr>
            <td><%= monAn.getMaBan() %></td>
            <td><%= monAn.getMaMonAn() %></td>
            <td><%= monAn.getSoLuong() %></td>
            <td><%= monAn.getTinhTrangMonAn() %></td>
            <td>
    <form action="CapNhatTinhTrangServlet" method="POST" style="display: inline-block;">
        <input type="hidden" name="maBan" value="<%= monAn.getMaBan() %>">
        <input type="hidden" name="maMonAn" value="<%= monAn.getMaMonAn() %>">
        <select name="tinhTrangMoi">
            <option value="Chưa hoàn thành" <%= "Chưa hoàn thành".equals(monAn.getTinhTrangMonAn()) ? "selected" : "" %>>Chưa hoàn thành</option>
            <option value="Đang chuẩn bị" <%= "Đang chuẩn bị".equals(monAn.getTinhTrangMonAn()) ? "selected" : "" %>>Đang chuẩn bị</option>
            <option value="Chờ phục vụ" <%= "Chờ phục vụ".equals(monAn.getTinhTrangMonAn()) ? "selected" : "" %>>Chờ phục vụ</option>
            <option value="Đã phục vụ" <%= "Đã phục vụ".equals(monAn.getTinhTrangMonAn()) ? "selected" : "" %>>Đã phục vụ</option>
        </select>
        <button type="submit">Cập Nhật</button>
    </form>
    <form action="XoaMonAnServlet" method="POST" style="display: inline-block;" 
          onsubmit="return confirm('Bạn có chắc muốn xóa món ăn này?')">
        <input type="hidden" name="maBan" value="<%= monAn.getMaBan() %>">
        <input type="hidden" name="maMonAn" value="<%= monAn.getMaMonAn() %>">
        <button type="submit" style="background-color: #e74c3c; color: white;">Xóa</button>
    </form>
</td>

        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
