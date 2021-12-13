-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 13, 2021 lúc 09:12 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quan_ly_dan_cu`
--
CREATE DATABASE IF NOT EXISTS `quan_ly_dan_cu` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `quan_ly_dan_cu`;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `giadinh`
--

DROP TABLE IF EXISTS `giadinh`;
CREATE TABLE `giadinh` (
  `id` int(11) NOT NULL,
  `idhokhau` int(11) NOT NULL,
  `idnhankhau` int(11) NOT NULL,
  `quanhechuho` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `giadinh`
--

INSERT INTO `giadinh` (`id`, `idhokhau`, `idnhankhau`, `quanhechuho`) VALUES
(74, 26, 101, 'chủ hộ'),
(75, 26, 102, 'vợ'),
(76, 26, 103, 'con trai'),
(77, 26, 104, 'con gái'),
(78, 26, 105, 'con  dâu'),
(79, 26, 106, 'cháu trai'),
(80, 27, 107, 'chủ hộ'),
(81, 27, 108, 'vợ'),
(82, 27, 109, 'con trai'),
(83, 27, 110, 'con gái'),
(84, 26, 112, 'con gái');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hokhau`
--

DROP TABLE IF EXISTS `hokhau`;
CREATE TABLE `hokhau` (
  `id` int(11) NOT NULL,
  `mahokhau` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cmndchuho` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `diachi` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaylap` date DEFAULT NULL,
  `ngaychuyendi` date DEFAULT NULL,
  `tinhtrang` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hokhau`
--

INSERT INTO `hokhau` (`id`, `mahokhau`, `cmndchuho`, `diachi`, `ngaylap`, `ngaychuyendi`, `tinhtrang`) VALUES
(26, 'HK1', '123123123123', 'HN', '2021-12-13', NULL, 'sinh sống'),
(27, 'HK27', '789456123123', 'HN', '2021-12-13', NULL, 'sinh sống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhankhau`
--

DROP TABLE IF EXISTS `nhankhau`;
CREATE TABLE `nhankhau` (
  `id` int(10) NOT NULL,
  `hoten` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `bidanh` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaysinh` date NOT NULL,
  `gioitinh` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `noisinh` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nguyenquan` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dchiennay` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `dantoc` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tongiao` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `quoctich` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `nghenghiep` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `noilamviec` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cmnd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ngaycap` date DEFAULT NULL,
  `noicap` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaychuyenden` date DEFAULT NULL,
  `noitruocchuyenden` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaychuyendi` date DEFAULT NULL,
  `noiden` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tinhtrang` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `tungay` date DEFAULT NULL,
  `denngay` date DEFAULT NULL,
  `ngaylap` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `nhankhau`
--

INSERT INTO `nhankhau` (`id`, `hoten`, `bidanh`, `ngaysinh`, `gioitinh`, `noisinh`, `nguyenquan`, `dchiennay`, `dantoc`, `tongiao`, `quoctich`, `nghenghiep`, `noilamviec`, `cmnd`, `ngaycap`, `noicap`, `ngaychuyenden`, `noitruocchuyenden`, `ngaychuyendi`, `noiden`, `tinhtrang`, `tungay`, `denngay`, `ngaylap`) VALUES
(101, 'Nguyễn Văn A', '', '1967-03-20', 'Nam', 'HN', 'HN', 'HN', 'Kinh', 'không', 'VN', 'chủ tịch', 'HN', '123123123123', '2017-12-13', 'HN', '1967-03-20', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(102, 'Đỗ Thị B', '', '1969-07-13', 'Nữ', 'HP', 'HP', 'HN', 'Kinh', 'không', 'VN', 'nội trợ', 'HN', '456456456456', '2017-12-13', 'HN', '1987-12-30', 'HP', '2021-12-13', 'đã qua đời', 'đã mất', NULL, NULL, '2021-12-13'),
(103, 'Nguyễn Văn C', '', '1989-05-13', 'Nam', 'HN', 'HN', 'HN', 'kinh', 'không', 'VN', 'giám đốc', 'HN', '789789789789', '2017-12-13', 'HN', '1989-05-13', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(104, 'Nguyễn Thị D', '', '1993-02-04', 'Nữ', 'HN', 'Hn', 'HCM', 'Kinh', 'không', 'VN', 'giám đốc', 'HN', '123456789123', '2017-12-13', 'HN', '1993-02-04', 'HN', '4900-02-01', NULL, 'tạm vắng', '2021-12-03', '2021-12-25', '2021-12-13'),
(105, 'Hoàng Thị E', '', '1991-06-06', 'Nữ', 'HCM', 'HCM', 'HN', 'Kinh', 'không', 'VN', 'thư ký', 'HN', '123456789456', '2017-12-13', 'HCM', '2012-12-13', 'HCM', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(106, 'Nguyễn Văn F', '', '2018-12-13', 'Nam', 'HN', 'HN', 'HN', 'kinh', 'không', 'VN', 'mới sinh', 'mới sinh', '123456789789', NULL, '', '2018-12-13', 'mới sinh', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(107, 'Bùi Văn G', '', '1985-06-09', 'Nam', 'HD', 'HD', 'HN', 'kinh', 'không', 'VN', 'kỹ sư', 'HN', '789456123123', '2018-12-13', 'HD', '2008-12-13', 'HD', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(108, 'Trần Thị H', '', '1985-12-13', 'Nữ', 'HD', 'HD', 'HN', 'kinh', 'không', 'VN', 'kế toán', 'HN', '123456789777', '2017-12-13', 'HD', '2008-12-13', 'HD', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(109, 'Bùi Văn K', '', '2006-12-13', 'Nam', 'HN', 'HD', 'HN', 'kinh', 'không', 'VN', 'học sinh', 'HN', '123456789888', NULL, '', '2006-12-13', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(110, 'Bùi Thị I', '', '2008-12-13', 'Nữ', 'HN', 'HD', 'HN', 'kinh', 'không', 'VN', 'học sinh', 'HN', '123456789999', NULL, '', '2008-12-13', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-13'),
(111, 'Trần Đức J', NULL, '1995-12-13', 'Nam', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '123456789666', NULL, NULL, NULL, 'BG', NULL, NULL, 'tạm trú', '2021-12-03', '2021-12-18', '2021-12-13'),
(112, 'Nguyễn Thị D', '', '1993-02-04', 'Nữ', 'HN', 'Hn', 'HN', 'Kinh', 'không', 'VN', 'giám đốc', 'HN', '123456789123', '2017-12-13', 'HN', '1993-02-04', 'HN', '4900-02-01', NULL, 'cập nhật', '2021-12-03', NULL, '2021-12-13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phanqua`
--

DROP TABLE IF EXISTS `phanqua`;
CREATE TABLE `phanqua` (
  `id` int(11) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp(),
  `dip` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `giatri` int(11) DEFAULT NULL,
  `tongqua` int(11) DEFAULT NULL,
  `tonggiatri` int(11) DEFAULT NULL,
  `taods` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tinhtrang` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `phanqua`
--

INSERT INTO `phanqua` (`id`, `thoigian`, `dip`, `giatri`, `tongqua`, `tonggiatri`, `taods`, `tinhtrang`) VALUES
(20, '2021-12-13 15:10:02', 'Tết thiếu nhi 1/6', 100000, 3, 300000, 'true', 'kết thúc'),
(21, '2021-12-13 15:10:07', 'Thưởng học tập', 50000, 17, 850000, 'true', 'kết thúc');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `quyphanthuong`
--

DROP TABLE IF EXISTS `quyphanthuong`;
CREATE TABLE `quyphanthuong` (
  `id` int(11) NOT NULL,
  `thoigian` datetime NOT NULL DEFAULT current_timestamp(),
  `sodu` int(11) NOT NULL,
  `mota` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

--
-- Đang đổ dữ liệu cho bảng `quyphanthuong`
--

INSERT INTO `quyphanthuong` (`id`, `thoigian`, `sodu`, `mota`) VALUES
(80, '2021-12-13 15:09:45', 10000000, '+ 10.000.000 ₫ VNĐ vào quỹ'),
(81, '2021-12-13 15:09:57', 15000000, '+ 5.000.000 ₫ VNĐ vào quỹ'),
(82, '2021-12-13 15:11:01', 14700000, '- 300.000 ₫ VNĐ do tặng phần thưởng \'Tết thiếu nhi 1/6\' ngày 2021-12-13'),
(83, '2021-12-13 15:11:03', 13850000, '- 850.000 ₫ VNĐ do tặng phần thưởng \'Thưởng học tập\' ngày 2021-12-13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tangqua`
--

DROP TABLE IF EXISTS `tangqua`;
CREATE TABLE `tangqua` (
  `id` int(11) NOT NULL,
  `idphanqua` int(11) NOT NULL,
  `mahokhau` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `hoten` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gioitinh` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaysinh` date DEFAULT NULL,
  `soluong` int(11) DEFAULT NULL,
  `giatri` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tangqua`
--

INSERT INTO `tangqua` (`id`, `idphanqua`, `mahokhau`, `hoten`, `gioitinh`, `ngaysinh`, `soluong`, `giatri`) VALUES
(41, 20, 'HK1', 'Nguyễn Văn F', 'Nam', '2018-12-13', 1, NULL),
(42, 20, 'HK27', 'Bùi Thị I', 'Nữ', '2008-12-13', 1, NULL),
(43, 20, 'HK27', 'Bùi Văn K', 'Nam', '2006-12-13', 1, NULL),
(44, 21, 'HK27', 'Bùi Thị I', 'Nữ', '2008-12-13', 10, NULL),
(45, 21, 'HK27', 'Bùi Văn K', 'Nam', '2006-12-13', 7, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thaydoihokhau`
--

DROP TABLE IF EXISTS `thaydoihokhau`;
CREATE TABLE `thaydoihokhau` (
  `id` int(11) NOT NULL,
  `mahokhau` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ttintdoi` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ndtdoi` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ghichu` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaytdoi` date DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thaydoihokhau`
--

INSERT INTO `thaydoihokhau` (`id`, `mahokhau`, `ttintdoi`, `ndtdoi`, `ghichu`, `ngaytdoi`) VALUES
(10, 'HK1', 'Chuyển đến', NULL, NULL, '2021-12-13'),
(11, 'HK1', 'Thêm thành viên', 'Nguyễn Văn A - 123123123123', NULL, '2021-12-13'),
(12, 'HK1', 'Thêm thành viên', 'Đỗ Thị B - 456456456456', NULL, '2021-12-13'),
(13, 'HK1', 'Thêm thành viên', 'Nguyễn Văn C - 789789789789', NULL, '2021-12-13'),
(14, 'HK1', 'Thêm thành viên', 'Nguyễn Thị D - 123456789123', NULL, '2021-12-13'),
(15, 'HK1', 'Thêm thành viên', 'Hoàng Thị E - 123456789456', NULL, '2021-12-13'),
(16, 'HK1', 'Thêm thành viên', 'Nguyễn Văn F - 123456789789', NULL, '2021-12-13'),
(17, 'HK27', 'Chuyển đến', NULL, NULL, '2021-12-13'),
(18, 'HK27', 'Thêm thành viên', 'Bùi Văn G - 789456123123', NULL, '2021-12-13'),
(19, 'HK27', 'Thêm thành viên', 'Trần Thị H - 123456789777', NULL, '2021-12-13'),
(20, 'HK27', 'Thêm thành viên', 'Bùi Văn K - 123456789888', NULL, '2021-12-13'),
(21, 'HK27', 'Thêm thành viên', 'Bùi Thị I - 123456789999', NULL, '2021-12-13'),
(22, 'HK1', 'Xóa thành viên', 'Đỗ Thị B - 456456456456', 'Qua đời. Khai tử bởi: Nguyễn Văn A - 123123123123 - ', '2021-12-13');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) NOT NULL,
  `username` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `pass` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `users`
--

INSERT INTO `users` (`id`, `username`, `pass`) VALUES
(1, 'admin1', 'admin'),
(2, 'admin2', 'admin');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `giadinh`
--
ALTER TABLE `giadinh`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idhokhau` (`idhokhau`),
  ADD KEY `idnhankhau` (`idnhankhau`);

--
-- Chỉ mục cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cmndchuho` (`cmndchuho`),
  ADD KEY `mahokhau` (`mahokhau`);

--
-- Chỉ mục cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cmnd` (`cmnd`);

--
-- Chỉ mục cho bảng `phanqua`
--
ALTER TABLE `phanqua`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `quyphanthuong`
--
ALTER TABLE `quyphanthuong`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Chỉ mục cho bảng `tangqua`
--
ALTER TABLE `tangqua`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mahokhau` (`mahokhau`),
  ADD KEY `idphanqua` (`idphanqua`);

--
-- Chỉ mục cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mahokhau` (`mahokhau`);

--
-- Chỉ mục cho bảng `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `giadinh`
--
ALTER TABLE `giadinh`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=85;

--
-- AUTO_INCREMENT cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;

--
-- AUTO_INCREMENT cho bảng `phanqua`
--
ALTER TABLE `phanqua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `quyphanthuong`
--
ALTER TABLE `quyphanthuong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `tangqua`
--
ALTER TABLE `tangqua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `giadinh`
--
ALTER TABLE `giadinh`
  ADD CONSTRAINT `giadinh_ibfk_1` FOREIGN KEY (`idhokhau`) REFERENCES `hokhau` (`id`),
  ADD CONSTRAINT `giadinh_ibfk_2` FOREIGN KEY (`idnhankhau`) REFERENCES `nhankhau` (`id`);

--
-- Các ràng buộc cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  ADD CONSTRAINT `hokhau_ibfk_1` FOREIGN KEY (`cmndchuho`) REFERENCES `nhankhau` (`cmnd`);

--
-- Các ràng buộc cho bảng `tangqua`
--
ALTER TABLE `tangqua`
  ADD CONSTRAINT `tangqua_ibfk_1` FOREIGN KEY (`mahokhau`) REFERENCES `hokhau` (`mahokhau`),
  ADD CONSTRAINT `tangqua_ibfk_2` FOREIGN KEY (`idphanqua`) REFERENCES `phanqua` (`id`);

--
-- Các ràng buộc cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  ADD CONSTRAINT `thaydoihokhau_ibfk_1` FOREIGN KEY (`mahokhau`) REFERENCES `hokhau` (`mahokhau`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
