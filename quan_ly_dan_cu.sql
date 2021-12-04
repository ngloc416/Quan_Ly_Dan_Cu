-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 04, 2021 lúc 02:44 PM
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
(24, 12, 41, 'chủ hộ');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hokhau`
--

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
(12, 'HK1', '012345678912', 'HD', '2021-12-04', NULL, 'sinh sống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nhankhau`
--

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
(41, 'Nguyễn Đình Lộc', '', '2021-12-04', 'Nam', 'HD', 'HD', 'HD', 'Kinh', 'không', 'VN', 'SV', 'BK', '012345678912', '2021-12-04', 'HD', '2021-12-04', 'HD', NULL, NULL, 'sinh sống', NULL, NULL, '2021-12-04');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thaydoihokhau`
--

CREATE TABLE `thaydoihokhau` (
  `id` int(11) NOT NULL,
  `mahokhau` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ttintdoi` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ndtdoi` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ghichu` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaytdoi` date DEFAULT NULL,
  `nguoitdoi` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thaydoinhankhau`
--

CREATE TABLE `thaydoinhankhau` (
  `id` int(11) NOT NULL,
  `cmnd` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ttintdoi` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `tungay` date DEFAULT NULL,
  `denngay` date DEFAULT NULL,
  `ghichu` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ngaytdoi` date DEFAULT NULL,
  `nguoitdoi` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `users`
--

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
-- Chỉ mục cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  ADD PRIMARY KEY (`id`),
  ADD KEY `mahokhau` (`mahokhau`),
  ADD KEY `nguoitdoi` (`nguoitdoi`);

--
-- Chỉ mục cho bảng `thaydoinhankhau`
--
ALTER TABLE `thaydoinhankhau`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cmnd` (`cmnd`),
  ADD KEY `nguoitdoi` (`nguoitdoi`);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT cho bảng `hokhau`
--
ALTER TABLE `hokhau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `nhankhau`
--
ALTER TABLE `nhankhau`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;

--
-- AUTO_INCREMENT cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `thaydoinhankhau`
--
ALTER TABLE `thaydoinhankhau`
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
-- Các ràng buộc cho bảng `thaydoihokhau`
--
ALTER TABLE `thaydoihokhau`
  ADD CONSTRAINT `thaydoihokhau_ibfk_1` FOREIGN KEY (`mahokhau`) REFERENCES `hokhau` (`mahokhau`),
  ADD CONSTRAINT `thaydoihokhau_ibfk_2` FOREIGN KEY (`nguoitdoi`) REFERENCES `users` (`ID`);

--
-- Các ràng buộc cho bảng `thaydoinhankhau`
--
ALTER TABLE `thaydoinhankhau`
  ADD CONSTRAINT `thaydoinhankhau_ibfk_1` FOREIGN KEY (`cmnd`) REFERENCES `nhankhau` (`cmnd`),
  ADD CONSTRAINT `thaydoinhankhau_ibfk_2` FOREIGN KEY (`nguoitdoi`) REFERENCES `users` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
