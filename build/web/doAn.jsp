<%-- 
    Document   : doAn
    Created on : Nov 25, 2024, 9:43:32 AM
    Author     : hi tcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đồ Ăn</title>
        <link rel="stylesheet" type="text/css" href="style/doan.css">
    </head>
    <body>
        <div class="chung">
            <jsp:include page="danhsachmonan.jsp" />
        </div>
        <div class="container">
            <p>Mã bàn đã chọn: ${maBan}</p>
            <table>
                <tbody>
                    <c:if test="${not empty danhSachDoAn}">
                        <c:forEach var="monAn" items="${danhSachDoAn}">
                            <tr>
                                <td class="monAnItem">
                                    <div class="monAnInfo">
                                        <p class="tenMonAn">${monAn.tenMonAn}</p>
                                        <p class="giaThanh">${monAn.giaThanh} VNĐ</p>
                                        <img class="monAnImage" src="images/${monAn.hinhAnh}" alt="${monAn.tenMonAn}" />
                                    </div>
                                    <div class="soLuong">
                                        <button type="button" class="btnTru">-</button>
                                        <input type="number" name="soLuong" class="inputSoLuong" value="1" min="1" />
                                        <button type="button" class="btnCong">+</button>
                                    </div>
                                    <form action="MonAnServlet" method="POST">
                                        <input type="hidden" name="maBan" value="${maBan}" />
                                        <input type="hidden" name="maMonAn" value="${monAn.maMonAn}" />
                                        <input type="hidden" name="action" value="addDA" />
                                        <input type="hidden" class="hiddenSoLuong" name="soLuong" value="1" />
                                        <button type="submit" class="btnChon">Chọn</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </tbody>
            </table>
        </div>

        <script>
            // Xử lý tăng số lượng
            document.querySelectorAll('.btnCong').forEach(function (button) {
                button.addEventListener('click', function () {
                    const input = this.previousElementSibling; // Lấy input trước nút cộng
                    const currentValue = parseInt(input.value, 10) || 1; // Giá trị hiện tại
                    input.value = currentValue + 1; // Tăng lên 1
                });
            });

            // Xử lý giảm số lượng
            document.querySelectorAll('.btnTru').forEach(function (button) {
                button.addEventListener('click', function () {
                    const input = this.nextElementSibling; // Lấy input sau nút trừ
                    const currentValue = parseInt(input.value, 10) || 1; // Giá trị hiện tại
                    if (currentValue > 1) {
                        input.value = currentValue - 1; // Giảm xuống 1 nếu lớn hơn 1
                    }
                });
            });

            // Cập nhật giá trị số lượng vào trường hidden trong form trước khi submit
            document.querySelectorAll('.btnChon').forEach(function (button) {
                button.addEventListener('click', function (event) {
                    const form = this.closest('form'); // Lấy form gần nhất
                    const inputSoLuong = form.previousElementSibling.querySelector('.inputSoLuong'); // Lấy input số lượng
                    const hiddenSoLuong = form.querySelector('.hiddenSoLuong'); // Lấy input hidden trong form
                    hiddenSoLuong.value = inputSoLuong.value; // Gán giá trị từ input số lượng vào input hidden
                });
            });
        </script>
        <%-- Hiển thị thông báo thành công nếu có --%>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success">
                ${successMessage}
            </div>
        </c:if>
    </body>
</html>
