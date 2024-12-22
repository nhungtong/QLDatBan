<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Giao Diện</title>
        <link rel="stylesheet" type="text/css" href="style/giaodien.css">
    </head>
    <body>
        <div class="top-bar">
            <div class="left">
                <i>📞</i> Hotline: 19001009
                <span style="margin-left: 20px;">📍 Địa chỉ: Hoàng Mai, Hà Nội</span>
            </div>
            <div class="center"></div>
            <div class="right">
                <button onclick="logout()">🔓 Đăng xuất</button>
            </div>
        </div>
        <script>
            function logout() {
                window.location.href = 'DangNhap.jsp';
            }
        </script>
        <div class="name">
            <div>
                <img src="images/logo.jpg" alt="Logo nhà hàng">
            </div>
            <div>
                <h1>LamBert</h1>
                <h4>Nâng niu từng bữa ăn của bạn</h4>
            </div>
        </div>
        <div class="center-bar">
            <div class="left">
                <ul class="menu">
                    <li>
                        <a href="#">Quản Lý</a>
                        <ul class="submenu">
                            <li>
                                <a href="#">Quản Lý Đặt Bàn</a>
                                <ul>
                                    <li><a href="danhsachban.jsp">Danh Sách Bàn</a></li>
                                    <li><a href="themban.jsp">Thêm Bàn</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">Quản Lý Đặt Món</a>
                                <ul>
                                    <li><a href="danhsachmonan.jsp">Danh Sách Món Ăn</a></li>
                                </ul>
                            </li>
                            <li>
                                <a href="TinhTrangMon.jsp">Quản Lý Trạng Thái Món</a>
                            </li>
                            <li>
                                <a href="ThanhToan.jsp">Quản Lý Thanh Toán</a>
                            </li>
                            <li>
                                <a href="tpbaocao.jsp">Quản Lý Doanh Thu</a>
                            </li>
                            <li>
                                <a href="baocaonguyenlieu.jsp">Quản Lý Nguyên Liệu</a>
                            </li>
                            <li>
                                <a href="#">Quản Lý Nhân Sự</a>
                                <ul>
                                    <li><a href="danhsachnv1.jsp">Danh Sách Nhân Sự</a></li>
                                    <li><a href="themnv1.jsp">Thêm Nhân Sự</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <div class="right">
                <div class="search-box">
                    <input type="text" placeholder="Tìm sản phẩm">
                    <button type="submit">
                        🔍
                    </button>
                </div>
            </div>
        </div>
    </body>
</html>
