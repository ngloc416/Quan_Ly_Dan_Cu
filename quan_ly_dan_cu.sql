-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 11, 2021 lúc 08:38 AM
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
(57, 22, 74, 'chủ hộ'),
(58, 22, 75, 'vợ'),
(59, 22, 76, 'con trai'),
(60, 23, 77, 'chủ hộ'),
(61, 23, 78, 'vợ'),
(62, 23, 79, 'con gái'),
(63, 22, 82, 'con trai'),
(64, 23, 83, 'con gái'),
(65, 23, 84, 'con trai'),
(66, 23, 91, 'con trai'),
(67, 22, 92, 'con gái'),
(68, 23, 93, 'con trai'),
(69, 22, 94, 'con gái');

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
(22, 'HK1', '789456123011', 'HN', '2021-12-06', NULL, 'sinh sống'),
(23, 'HK23', '789456123006', 'HN', '2021-12-06', NULL, 'sinh sống');

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
(74, 'Nguyễn Văn Â', '', '1969-12-08', 'Nam', 'HN', 'HN', 'HN', 'Kinh', 'Phật giáo', 'VN', 'Giám đốc', 'HN', '789456123011', '2017-12-27', 'HN', '1969-12-08', 'HN', '3000-01-01', NULL, 'sinh sống', NULL, NULL, '2021-12-06'),
(75, 'Trần Thị B', '', '1971-07-06', 'Nữ', 'HN', 'HN', 'HN', 'Kinh', 'không', 'VN', 'Nội trợ', 'HN', '789456123002', '2017-12-06', 'HN', '1988-06-18', 'HN', '2021-12-06', 'đã qua đời', 'đã mất', NULL, NULL, '2021-12-06'),
(76, 'Nguyễn Văn C', '', '1990-03-06', 'Nam', 'HN', 'HN', 'HCM', 'Kinh', 'không', 'VN', 'Kỹ sư', 'HN', '789456123003', '2017-05-06', 'HN', '1990-03-06', 'HN', '3000-01-01', NULL, 'tạm vắng', '2021-07-01', '2021-08-12', '2021-12-06'),
(77, 'Bùi Văn D', '', '1971-10-06', 'Nam', 'HP', 'HP', 'HN', 'Kinh', 'không', 'VN', 'Phó giám đốc', 'HN', '789456123006', '2018-12-06', 'HP', '2007-07-06', 'HP', '3000-01-01', NULL, 'sinh sống', NULL, NULL, '2021-12-06'),
(78, 'Hoàng Thị E', '', '1975-01-06', 'Nữ', 'HP', 'HP', 'HN', 'Kinh', 'không', 'VN', 'Công nhân', 'HN', '789456123456', '2018-12-06', 'HP', '2007-12-06', 'HP', '3000-01-01', NULL, 'sinh sống', NULL, NULL, '2021-12-06'),
(79, 'Bùi Thị F', '', '1996-12-02', 'Nữ', 'HN', 'HP', 'HCM', 'Kinh', 'không', 'VN', 'Kế toán', 'HN', '789456123008', '2018-12-06', 'HN', '1996-12-02', 'HN', '3000-01-01', NULL, 'tạm vắng', '2021-12-01', '2021-12-16', '2021-12-06'),
(80, 'Cao Văn G', NULL, '1994-05-07', 'Nam', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '789456132789', NULL, NULL, NULL, 'TB', '3000-01-01', NULL, 'tạm trú', '2021-08-11', '2021-09-15', '2021-12-06'),
(81, 'Nguyễn Thị H', '', '1992-08-06', 'Nữ', NULL, NULL, 'HN', NULL, '', 'VN', '', '', '789456123369', '2017-05-25', '', NULL, 'HD', '3000-01-01', NULL, 'tạm trú', '2021-12-01', '2021-12-17', '2021-12-06'),
(82, 'Nguyễn Văn C', '', '1990-03-06', 'Nam', 'HN', 'HN', 'HN', 'Kinh', 'không', 'VN', 'Kỹ sư', 'HN', '789456123003', '2017-05-06', 'HN', '1990-03-06', 'HN', '2021-11-04', 'HCM', 'chuyển đi', '2021-07-01', NULL, '2021-12-06'),
(83, 'Bùi Thị F', '', '1996-12-02', 'Nữ', 'HN', 'HP', 'HN', 'Kinh', 'không', 'VN', 'Kế toán', 'HN', '789456123008', '2018-12-06', 'HN', '1996-12-02', 'HN', '3000-01-01', NULL, 'cập nhật', '2021-12-01', NULL, '2021-12-06'),
(84, 'Bùi Văn O', '', '1998-12-07', 'Nam', 'HN', 'HN', 'Hn', 'Kinh', 'không', 'VN', 'Kinh doanh', 'HN', '789456123789', '2018-12-07', 'HN', '1998-12-07', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-07'),
(85, 'Trịnh Văn K', '', '2000-12-07', 'Nam', NULL, NULL, 'HN', NULL, '', 'VN', '', '', '123456789799', '2018-09-09', '', NULL, 'ĐN', NULL, NULL, 'tạm trú', '2021-12-02', '2021-12-24', '2021-12-07'),
(86, 'Đỗ Văn L', '', '1989-12-09', 'Nam', NULL, NULL, 'HN', NULL, '', 'VN', '', '', '456789132456', '2017-08-09', '', NULL, 'HY', NULL, NULL, 'tạm trú', '2021-12-03', '2021-12-18', '2021-12-09'),
(87, 'Nguyễn Đình Lộc', NULL, '2001-12-10', 'Nam', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '456789123456', NULL, NULL, NULL, 'HD', NULL, NULL, 'tạm trú', '2021-12-03', '2021-12-18', '2021-12-10'),
(88, 'Trần Thị U', NULL, '1980-12-10', 'Nữ', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '123789456002', NULL, NULL, NULL, 'BG', NULL, NULL, 'tạm trú', '2021-12-03', '2021-12-18', '2021-12-10'),
(89, 'Trần Thị R', NULL, '1992-12-10', 'Nữ', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '741852963258', NULL, NULL, NULL, 'VT', NULL, NULL, 'tạm trú', '2021-12-02', '2021-12-18', '2021-12-10'),
(90, 'Hoàng Văn V', NULL, '1995-12-10', 'Nam', NULL, NULL, 'HN', NULL, NULL, 'VN', NULL, NULL, '963258741114', NULL, NULL, NULL, 'HCM', NULL, NULL, 'tạm trú', '2021-12-04', '2021-12-18', '2021-12-10'),
(91, 'Bùi Văn P', '', '2006-12-10', 'Nam', 'HN', 'HN', 'HN', 'Kinh', 'không', 'VN', 'Học sinh', 'HN', '789852963123', '2021-12-10', '', '2006-12-10', 'HN', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-10'),
(92, 'Nguyễn Thị M', '', '2012-12-10', 'Nữ', 'hn', 'hn', 'hn', 'kinh', 'không', 'VN', 'học sinh', 'hn', '789489624852', '2021-12-10', '', '2012-12-10', 'hn', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-10'),
(93, 'Bùi Văn Q', '', '2020-12-10', 'Nam', 'hn', 'hn', 'hn', 'kinh', 'không', 'vn', 'mới sinh', 'mới sinh', '789485236954', '2021-12-10', '', '2020-12-10', 'hn', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-10'),
(94, 'Nguyễn Thị Y', '', '2019-12-11', 'Nữ', 'HN', 'HN', 'HN', 'kinh', 'không', 'VN', 'mới sinh', 'mới sinh', '753951852456', NULL, '', '2019-12-11', 'mới sinh', '4900-02-01', NULL, 'sinh sống', NULL, NULL, '2021-12-11');

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
(4, '2021-12-10 00:00:00', 'Tết Nguyên Đán', 20000, 5, 100000, 'true', 'kết thúc'),
(5, '2021-12-10 00:00:00', 'Tết thiếu nhi 1/6', 50000, 4, 200000, 'true', 'kết thúc'),
(6, '2021-12-10 00:00:00', 'Thưởng học tập', 50000, 17, 850000, 'true', 'kết thúc'),
(11, '2021-12-11 14:26:56', 'Tết thiếu nhi 1/6', NULL, NULL, NULL, 'false', 'kết thúc'),
(12, '2021-12-11 14:27:16', 'Thưởng học tập', NULL, NULL, NULL, 'false', 'kết thúc'),
(13, '2021-12-11 14:28:42', 'Thưởng học tập', 40000, 10, 400000, 'true', 'kết thúc'),
(14, '2021-12-11 14:28:46', 'Trung thu', 60000, 4, 240000, 'true', 'kết thúc'),
(15, '2021-12-11 14:34:10', 'Tết thiếu nhi 1/6', 20000, 4, 80000, 'true', 'kết thúc');

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
(44, '2021-12-10 15:16:00', 10000000, 'thêm 10000000 vào quỹ'),
(45, '2021-12-10 15:18:21', 10500000, 'thêm 500000'),
(46, '2021-12-10 15:20:15', 12500000, '+ 2000000 VNĐ vào quỹ'),
(47, '2021-12-10 15:45:55', 12510000, '+ 10000 VNĐ vào quỹ'),
(48, '2021-12-10 16:08:21', 15510000, '+ 3000000 VNĐ vào quỹ'),
(49, '2021-12-10 19:09:37', 16010000, '+ 500000 VNĐ vào quỹ'),
(50, '2021-12-10 22:24:11', 15160000, '- 850000 VNĐ do tặng phần thưởng \'Thưởng học tập\' ngày 2021-12-10'),
(51, '2021-12-10 22:25:31', 15360000, '+ 200000 VNĐ vào quỹ'),
(52, '2021-12-10 22:38:14', 15410000, '+ 50000 VNĐ vào quỹ'),
(53, '2021-12-11 13:35:51', 15460000, '+ 50.000 ₫ VNĐ vào quỹ'),
(54, '2021-12-11 13:36:16', 14460000, '+ -1.000.000 ₫ VNĐ vào quỹ'),
(69, '2021-12-11 14:24:20', 14260000, '- 200.000 ₫ VNĐ do tặng phần thưởng \'Tết thiếu nhi 1/6\' ngày 2021-12-10'),
(70, '2021-12-11 14:27:02', 14260000, '- 0 ₫ VNĐ do tặng phần thưởng \'Tết thiếu nhi 1/6\' ngày 2021-12-11'),
(71, '2021-12-11 14:27:19', 14260000, '- 0 ₫ VNĐ do tặng phần thưởng \'Thưởng học tập\' ngày 2021-12-11'),
(72, '2021-12-11 14:29:57', 14020000, '- 240.000 ₫ VNĐ do tặng phần thưởng \'Trung thu\' ngày 2021-12-11'),
(73, '2021-12-11 14:29:59', 13620000, '- 400.000 ₫ VNĐ do tặng phần thưởng \'Thưởng học tập\' ngày 2021-12-11'),
(74, '2021-12-11 14:36:59', 13540000, '- 80.000 ₫ VNĐ do tặng phần thưởng \'Tết thiếu nhi 1/6\' ngày 2021-12-11');

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
(19, 6, 'HK1', 'Nguyễn Thị M', 'Nữ', '2012-12-10', 10, NULL),
(20, 6, 'HK23', 'Bùi Văn P', 'Nam', '2006-12-10', 7, NULL),
(21, 4, 'HK1', 'Nguyễn Thị M', 'Nữ', '2012-12-10', 1, NULL),
(22, 4, 'HK23', 'Bùi Văn P', 'Nam', '2006-12-10', 3, NULL),
(23, 4, 'HK23', 'Bùi Văn Q', 'Nam', '2020-12-10', 1, NULL),
(24, 5, 'HK1', 'Nguyễn Thị M', 'Nữ', '2012-12-10', 1, NULL),
(25, 5, 'HK1', 'Nguyễn Thị Y', 'Nữ', '2019-12-11', 1, NULL),
(26, 5, 'HK23', 'Bùi Văn P', 'Nam', '2006-12-10', 1, NULL),
(27, 5, 'HK23', 'Bùi Văn Q', 'Nam', '2020-12-10', 1, NULL),
(28, 14, 'HK1', 'Nguyễn Thị M', 'Nữ', '2012-12-10', 1, NULL),
(29, 14, 'HK1', 'Nguyễn Thị Y', 'Nữ', '2019-12-11', 1, NULL),
(30, 14, 'HK23', 'Bùi Văn P', 'Nam', '2006-12-10', 1, NULL),
(31, 14, 'HK23', 'Bùi Văn Q', 'Nam', '2020-12-10', 1, NULL),
(32, 13, 'HK1', 'Nguyễn Thị M', 'Nữ', '2012-12-10', 5, NULL),
(33, 13, 'HK23', 'Bùi Văn P', 'Nam', '2006-12-10', 5, NULL),
(34, 15, 'HK1', 'Nguyễn Thị M', 'Nữ', '2012-12-10', 1, NULL),
(35, 15, 'HK1', 'Nguyễn Thị Y', 'Nữ', '2019-12-11', 1, NULL),
(36, 15, 'HK23', 'Bùi Văn P', 'Nam', '2006-12-10', 1, NULL),
(37, 15, 'HK23', 'Bùi Văn Q', 'Nam', '2020-12-10', 1, NULL);

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
  `ngaytdoi` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=95;

--
-- AUTO_INCREMENT cho bảng `phanqua`
--
ALTER TABLE `phanqua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT cho bảng `quyphanthuong`
--
ALTER TABLE `quyphanthuong`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT cho bảng `tangqua`
--
ALTER TABLE `tangqua`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

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
