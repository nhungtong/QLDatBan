-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 27, 2024 lúc 07:40 AM
-- Phiên bản máy phục vụ: 10.4.32-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldatban`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `danhgia`
--

CREATE TABLE `danhgia` (
  `MaBan` int(11) NOT NULL,
  `DichVu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `danhgia`
--

INSERT INTO `danhgia` (`MaBan`, `DichVu`) VALUES
(1, 5),
(2, 5),
(7, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `datban`
--

CREATE TABLE `datban` (
  `MaBan` int(11) NOT NULL,
  `TinhTrang` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `datban`
--

INSERT INTO `datban` (`MaBan`, `TinhTrang`) VALUES
(1, 'Đang sử dụng'),
(2, 'Đang sử dụng'),
(3, 'Trống'),
(4, 'Đặt Trước'),
(5, 'Đang Sử Dụng'),
(6, 'Đang sử dụng'),
(7, 'Đang sử dụng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `goimon`
--

CREATE TABLE `goimon` (
  `MaBan` int(11) NOT NULL,
  `MaMonAn` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL,
  `TinhTrangMonAn` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `goimon`
--

INSERT INTO `goimon` (`MaBan`, `MaMonAn`, `SoLuong`, `TinhTrangMonAn`) VALUES
(2, 1, 2, 'Chưa hoàn thành'),
(2, 3, 2, 'Chưa hoàn thành'),
(1, 6, 1, 'Chưa hoàn thành'),
(1, 7, 1, 'Chưa hoàn thành'),
(7, 1, 2, 'Chưa hoàn thành'),
(7, 6, 1, 'Chưa hoàn thành'),
(7, 7, 1, 'Chưa hoàn thành');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguyenlieu`
--

CREATE TABLE `nguyenlieu` (
  `MaHoaDon` int(11) NOT NULL,
  `TenNguyenLieu` varchar(100) DEFAULT NULL,
  `DonGia` decimal(10,2) DEFAULT NULL,
  `SoLuong` int(11) DEFAULT NULL,
  `ThanhTien` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguyenlieu`
--

INSERT INTO `nguyenlieu` (`MaHoaDon`, `TenNguyenLieu`, `DonGia`, `SoLuong`, `ThanhTien`) VALUES
(1, 'Thịt Bò', 150000.00, 2, 300000.00),
(2, 'Bún', 20000.00, 3, 60000.00),
(3, 'Nem', 10000.00, 5, 50000.00),
(4, 'Bánh Cuốn', 15000.00, 4, 60000.00),
(5, 'Chả Cá', 70000.00, 1, 70000.00);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhanvien`
--

CREATE TABLE `nhanvien` (
  `MaNhanVien` varchar(10) NOT NULL,
  `HoTen` varchar(50) NOT NULL,
  `NgaySinh` date NOT NULL,
  `DiaChi` varchar(100) NOT NULL,
  `SoDienThoai` varchar(10) NOT NULL,
  `ChucVu` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nhanvien`
--

INSERT INTO `nhanvien` (`MaNhanVien`, `HoTen`, `NgaySinh`, `DiaChi`, `SoDienThoai`, `ChucVu`) VALUES
('NV01', 'Nguyễn Văn An', '1990-01-15', '123 Đường Lê Duẩn, Quận Hoàn Kiếm, Hà Nội', '0987654321', 'Phục vụ'),
('NV02', 'Trần Thị Hoa', '1988-04-20', '45 Đường Kim Mã, Quận Ba Đình, Hà Nội', '0976543210', 'Kế toán'),
('NV03', 'Phạm Thị Lan', '1995-02-10', '101 Đường Cầu Giấy, Quận Cầu Giấy, Hà Nội', '0954321098', 'Lễ tân'),
('NV04', 'Ngô Quốc Bảo', '1987-03-15', '303 Đường Giải Phóng, Quận Hoàng Mai, Hà Nội', '0932109876', 'Đầu bếp'),
('NV05', 'Hoàng Văn Hùng', '1990-12-18', '707 Đường Tây Sơn, Quận Đống Đa, Hà Nội', '0898765432', 'Nhân sự');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaNhanVien` varchar(10) NOT NULL,
  `MatKhau` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaNhanVien`, `MatKhau`) VALUES
('NV01', 'nv01'),
('NV02', 'nv02'),
('NV03', 'nv03'),
('NV04', 'nv04'),
('NV05', 'nv05');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thanhtoan`
--

CREATE TABLE `thanhtoan` (
  `MaBan` int(11) NOT NULL,
  `TongTien` int(11) NOT NULL,
  `NgayThanhToan` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thanhtoan`
--

INSERT INTO `thanhtoan` (`MaBan`, `TongTien`, `NgayThanhToan`) VALUES
(1, 27000, '2024-11-26'),
(2, 220000, '2024-11-26'),
(7, 127000, '2024-11-27');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thucdon`
--

CREATE TABLE `thucdon` (
  `MaMonAn` int(11) NOT NULL,
  `TenMonAn` varchar(100) DEFAULT NULL,
  `ThucPham` varchar(20) NOT NULL,
  `GiaThanh` decimal(10,2) DEFAULT NULL,
  `HinhAnh` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `thucdon`
--

INSERT INTO `thucdon` (`MaMonAn`, `TenMonAn`, `ThucPham`, `GiaThanh`, `HinhAnh`) VALUES
(1, 'Phở Bò', 'Đồ Ăn', 50000.00, 'phobo.jpg'),
(2, 'Bún Chả', 'Đồ Ăn', 40000.00, 'buncha.jpg'),
(3, 'Nem Rán', 'Đồ Ăn', 60000.00, 'nemran.jpg'),
(4, 'Bánh Cuốn', 'Đồ Ăn', 30000.00, 'banhcuon.jpg'),
(5, 'Chả Cá', 'Đồ Ăn', 80000.00, 'chaca.jpg'),
(6, 'Trà Chanh', 'Đồ Uống', 12000.00, 'trachanh.jpg'),
(7, 'Trà Đào', 'Đồ Uống', 15000.00, 'tradao.jpg'),
(8, 'Pepsi', 'Đồ Uống', 10000.00, 'pepsi.jpg'),
(9, 'Bún bò Huế', 'Đồ Ăn', 40000.00, 'bunbohue.jpg'),
(10, 'Sữa đậu nành', 'Đồ Uống', 10000.00, 'suadaunanh.jpg'),
(11, 'Bún ốc', 'Đồ Ăn', 35000.00, 'bunoc.jpg');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `danhgia`
--
ALTER TABLE `danhgia`
  ADD PRIMARY KEY (`MaBan`,`DichVu`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Chỉ mục cho bảng `datban`
--
ALTER TABLE `datban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Chỉ mục cho bảng `goimon`
--
ALTER TABLE `goimon`
  ADD KEY `MaMonAn` (`MaMonAn`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Chỉ mục cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  ADD PRIMARY KEY (`MaHoaDon`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaNhanVien`);

--
-- Chỉ mục cho bảng `thanhtoan`
--
ALTER TABLE `thanhtoan`
  ADD PRIMARY KEY (`MaBan`),
  ADD KEY `MaBan` (`MaBan`);

--
-- Chỉ mục cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaMonAn`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `datban`
--
ALTER TABLE `datban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `nguyenlieu`
--
ALTER TABLE `nguyenlieu`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaMonAn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `danhgia`
--
ALTER TABLE `danhgia`
  ADD CONSTRAINT `danhgia_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `thanhtoan` (`MaBan`);

--
-- Các ràng buộc cho bảng `goimon`
--
ALTER TABLE `goimon`
  ADD CONSTRAINT `goimon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `datban` (`MaBan`),
  ADD CONSTRAINT `goimon_ibfk_2` FOREIGN KEY (`MaMonAn`) REFERENCES `thucdon` (`MaMonAn`);

--
-- Các ràng buộc cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD CONSTRAINT `taikhoan_ibfk_1` FOREIGN KEY (`MaNhanVien`) REFERENCES `nhanvien` (`MaNhanVien`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
