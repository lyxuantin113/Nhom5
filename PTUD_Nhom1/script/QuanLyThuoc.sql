CREATE DATABASE [QuanLyThuoc]
GO
ALTER DATABASE [QuanLyThuoc] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyThuoc].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

USE [QuanLyThuoc]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhapThuoc]    Script Date: 4/9/2024 2:16:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhapThuoc](
	[maThuoc] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[giaNhap] [float] NULL,
	[hsd] [date] NULL,
	[donVi] [nchar](50) NULL,
	[thanhTien] [float] NULL,
	[maCTPNT] [nchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 4/9/2024 2:16:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [nvarchar](50) NOT NULL,
	[tenNCC] [nvarchar](50) NULL,
	[diaChiNCC] [nvarchar](50) NULL,
	[sdtNCC] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhaCungCap] PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 4/9/2024 2:16:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [nvarchar](50) NOT NULL,
	[tenNV] [nvarchar](50) NULL,
	[sdtNV] [nvarchar](50) NULL,
	[chucVu] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhapThuoc]    Script Date: 4/9/2024 2:16:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapThuoc](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maNCC] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayNhap] [date] NULL,
	[tongTien] [float] NULL,
	[trangThai] [nchar](10) NULL,
 CONSTRAINT [PK_PhieuNhapThuoc] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 4/9/2024 2:16:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[maThuoc] [nvarchar](50) NOT NULL,
	[tenThuoc] [nvarchar](50) NOT NULL,
	[loaiThuoc] [nvarchar](50) NOT NULL,
	[donVi] [nvarchar](50) NOT NULL,
	[hsd] [date] NOT NULL,
	[giaNhap] [float] NOT NULL,
	[giaBan] [float] NOT NULL,
	[soLuongTon] [int] NOT NULL,
	[nuocSanXuat] [nvarchar](50) NOT NULL,
	[maNCC] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Thuoc] PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [nvarchar](50) NOT NULL,
	[soDienThoai] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonDat](
	[maDonDat] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[ngayNhan] [date] NOT NULL
 CONSTRAINT [PK_DonDatThuoc] PRIMARY KEY CLUSTERED 
(
	[maDonDat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[ngayNhan] [date] NOT NULL
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/* */
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonDat](
	[maDonDat] [nvarchar](50) NOT NULL,
	[maThuoc] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL
 CONSTRAINT [PK_ChiTietDonDatThuoc] PRIMARY KEY CLUSTERED 
(
	[maDonDat] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[maThuoc] [nvarchar](50) NOT NULL,
	[soLuong] [int] NOT NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nvarchar](50) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

/* Lien Ket */
/* ChiTietDonDat */
ALTER TABLE [dbo].[ChiTietDonDat]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonDat_DonDat] FOREIGN KEY([maDonDat])
REFERENCES [dbo].[DonDat] ([maDonDat])
GO
ALTER TABLE [dbo].[ChiTietDonDat] CHECK CONSTRAINT [FK_ChiTietDonDat_DonDat]
GO
ALTER TABLE [dbo].[ChiTietDonDat]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonDat_Thuoc] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[ChiTietDonDat] CHECK CONSTRAINT [FK_ChiTietDonDat_Thuoc]
GO

/* ChiTietHoaDon */
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_HoaDon]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietHoaDon_Thuoc] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[ChiTietHoaDon] CHECK CONSTRAINT [FK_ChiTietHoaDon_Thuoc]
GO

/* DonDat */
ALTER TABLE [dbo].[DonDat]  WITH CHECK ADD  CONSTRAINT [FK_DonDat_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[DonDat] CHECK CONSTRAINT [FK_DonDat_KhachHang]
GO
ALTER TABLE [dbo].[DonDat]  WITH CHECK ADD  CONSTRAINT [FK_DonDat_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[DonDat] CHECK CONSTRAINT [FK_DonDat_NhanVien]
GO

/* HoaDon */
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO

/* TaiKhoan */
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO

ALTER TABLE [dbo].[ChiTietPhieuNhapThuoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhapThuoc_Thuoc] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhapThuoc] CHECK CONSTRAINT [FK_ChiTietPhieuNhapThuoc_Thuoc]
GO
ALTER TABLE [dbo].[PhieuNhapThuoc]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapThuoc_NhaCungCap] FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[PhieuNhapThuoc] CHECK CONSTRAINT [FK_PhieuNhapThuoc_NhaCungCap]
GO
ALTER TABLE [dbo].[PhieuNhapThuoc]  WITH CHECK ADD  CONSTRAINT [FK_PhieuNhapThuoc_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[PhieuNhapThuoc] CHECK CONSTRAINT [FK_PhieuNhapThuoc_NhanVien]
GO

INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [donVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH001', N'Vitamin C', N'Th?c ph?m ch?c nang', N'Viên', CAST(N'2024-04-09' AS Date), 100, 120, 24, N'My', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [donVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH002', N'Vitamin B', N'Thu?c c?m', N'Viên', CAST(N'2024-04-09' AS Date), 120, 140, 102, N'VN', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [donVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH003', N'Vita C', N'Thu?c c?m', N'Viên', CAST(N'2024-04-09' AS Date), 140, 150, 100, N'VN', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [donVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH004', N'Cam A', N'Thu?c c?m', N'Viên', CAST(N'2024-04-09' AS Date), 111, 130, 0, N'VN', N'NCC02')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [donVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH005', N'Sot A', N'Thu?c h? s?t', N'Viên', CAST(N'2024-04-09' AS Date), 123, 150, 0, N'VN', N'NCC03')
GO
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH003', 100, 140, CAST(N'2025-04-04' AS Date), N'Viên                                              ', 14000, N'PN111                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH004', 10, 120, CAST(N'2024-12-12' AS Date), N'Viên                                              ', 1200, N'PN003                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH001', 12, 120, CAST(N'2012-12-12' AS Date), N'Viên                                              ', 1440, N'PN101                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH002', 51, 120, CAST(N'2012-12-12' AS Date), N'Viên                                              ', 6120, N'PN101                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH001', 10, 1200, CAST(N'2024-11-11' AS Date), N'Viên                                              ', 12000, N'PN005                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH002', 10, 1200, CAST(N'2024-11-11' AS Date), N'Viên                                              ', 12000, N'PN005                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH003', 10, 1500, CAST(N'2024-11-11' AS Date), N'Viên                                              ', 15000, N'PN005                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH001', 10, 211, CAST(N'2022-12-12' AS Date), N'Viên                                              ', 2110, N'PN102                                             ')
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien], [maCTPNT]) VALUES (N'TH002', 20, 150, CAST(N'2022-12-12' AS Date), N'Viên                                              ', 3000, N'PN102                                             ')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC01', N'Nha cung cap A', N'Duong 27', N'0123456789')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC02', N'Nha cung cap B', N'Duong 29', N'0123456788')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC03', N'Nha cung cap C', N'Duong 28', N'0123456799')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV001', N'Le Van Long', N'0907938820', N'Nhan vien quan ly', N'longql1@gmai.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV002', N'Nguyen Thanh', N'0704462112', N'Nhan vien ban hang', N'thanhnguyen@gmai.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV003', N'Le Thi Hieu', N'0912747858', N'Nhan vien ban hang', N'hieu03@gmai.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV004', N'Nguyen Thi Thi', N'0362446577', N'Nhan vien ban hang', N'thithi@gmai.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV005', N'Tran Van Dung', N'0793888444', N'Nhan vien ban hang', N'dung444@gmai.com')
GO
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN001', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN002', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN003', N'NCC02', N'NV001', CAST(N'2024-04-09' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN005', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 39000, N'1         ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN010', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 1200, N'1         ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN101', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 2880, N'1         ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN102', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 2700, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN103', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 14806, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN104', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN105', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 3600, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN111', N'NCC01', N'NV001', CAST(N'2024-04-09' AS Date), 14000, N'1         ')
GO
