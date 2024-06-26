USE [QuanLyThuoc]
GO
/****** Object:  Table [dbo].[ChiTietDonDat]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonDat](
	[maDonDat] [nvarchar](50) NOT NULL,
	[maThuoc] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_ChiTietDonDatThuoc] PRIMARY KEY CLUSTERED 
(
	[maDonDat] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[maThuoc] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
 CONSTRAINT [PK_ChiTietHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhapThuoc]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhapThuoc](
	[maThuoc] [nvarchar](50) NOT NULL,
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[giaNhap] [float] NULL,
	[hsd] [date] NULL,
	[donVi] [nvarchar](50) NULL,
	[thanhTien] [float] NULL,
 CONSTRAINT [PK_ChiTietPhieuNhapThuoc] PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC,
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonDat]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonDat](
	[maDonDat] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[ngayNhan] [date] NOT NULL,
 CONSTRAINT [PK_DonDatThuoc] PRIMARY KEY CLUSTERED 
(
	[maDonDat] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonVi]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonVi](
	[maDonVi] [nvarchar](50) NOT NULL,
	[donVi] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_DonVi] PRIMARY KEY CLUSTERED 
(
	[maDonVi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nvarchar](50) NOT NULL,
	[maKH] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NOT NULL,
	[ngayNhan] [date] NOT NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 5/30/2024 12:01:04 AM ******/
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
/****** Object:  Table [dbo].[LoaiThuoc]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiThuoc](
	[maLoaiThuoc] [nvarchar](50) NOT NULL,
	[loaiThuoc] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiThuoc] PRIMARY KEY CLUSTERED 
(
	[maLoaiThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 5/30/2024 12:01:04 AM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 5/30/2024 12:01:04 AM ******/
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
/****** Object:  Table [dbo].[PhieuNhapThuoc]    Script Date: 5/30/2024 12:01:04 AM ******/
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
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/30/2024 12:01:04 AM ******/
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
/****** Object:  Table [dbo].[Thuoc]    Script Date: 5/30/2024 12:01:04 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[maThuoc] [nvarchar](50) NOT NULL,
	[tenThuoc] [nvarchar](50) NOT NULL,
	[maLoaiThuoc] [nvarchar](50) NOT NULL,
	[maDonVi] [nvarchar](50) NOT NULL,
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
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD02011', N'TH000011', 1)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD35306', N'TH000017', 5)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD35306', N'TH000018', 5)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD49328', N'TH000014', 10)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD49328', N'TH000016', 10)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD49328', N'TH000017', 10)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD58513', N'TH000011', 2)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD58513', N'TH000012', 3)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD58513', N'TH000013', 2)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD65050', N'TH000005', 10)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD65050', N'TH000008', 10)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD65050', N'TH000020', 1)
INSERT [dbo].[ChiTietDonDat] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD90424', N'TH000010', 11)
GO
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD07425', N'TH000008', 4)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD07425', N'TH000016', 20)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD07425', N'TH000017', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD09553', N'TH000020', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD12076', N'TH000008', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD12227', N'TH000005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD16083', N'TH000008', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD21254', N'TH000005', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD26329', N'TH000001', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD26329', N'TH000002', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD26329', N'TH000004', 6)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD26329', N'TH000010', 7)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD26329', N'TH000011', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD38414', N'TH000003', 4)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD38414', N'TH000004', 8)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD38414', N'TH000012', 4)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD38816', N'TH000002', 12)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD38816', N'TH000004', 12)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD43111', N'TH000002', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD43111', N'TH000010', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD43111', N'TH000011', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD43111', N'TH000013', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51428', N'TH000008', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51428', N'TH000010', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000001', 7)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000002', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000004', 4)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000010', 14)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000015', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000016', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD51816', N'TH000017', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD53718', N'TH000014', 20)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD53718', N'TH000015', 20)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD57584', N'TH000002', 8)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD57584', N'TH000003', 6)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD61467', N'TH000001', 3)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD61467', N'TH000003', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD61467', N'TH000008', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD64399', N'TH000001', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD64399', N'TH000002', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD64399', N'TH000008', 3)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD64399', N'TH000010', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD64399', N'TH000013', 3)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD85118', N'TH000001', 3)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD85118', N'TH000002', 10)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD85118', N'TH000004', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD85118', N'TH000012', 5)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD85118', N'TH000020', 1)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD91462', N'TH000008', 8)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD91462', N'TH000013', 5)
GO
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'Th000001', N'PN000001', 10, 100, CAST(N'2025-12-12' AS Date), N'Vien', 1000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000001', N'PN000002', 10, 100, CAST(N'2025-05-12' AS Date), N'Vien', 1000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000001', N'PN000005', 10, 100, CAST(N'2025-05-12' AS Date), N'Vien', 1000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000002', N'PN000005', 20, 120, CAST(N'2025-05-29' AS Date), N'Vien', 2400)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000007', N'PN000005', 10, 100, CAST(N'2026-11-11' AS Date), N'Vien', 1000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000011', N'PN000002', 100, 200, CAST(N'2027-05-28' AS Date), N'Vien', 20000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000011', N'PN000006', 100, 200, CAST(N'2027-05-28' AS Date), N'Vien', 20000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000012', N'PN000002', 200, 500, CAST(N'2026-05-28' AS Date), N'Vien', 100000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000012', N'PN000006', 100, 500, CAST(N'2026-05-28' AS Date), N'Vien', 50000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000013', N'PN000006', 100, 180, CAST(N'2027-05-28' AS Date), N'Vien', 18000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000014', N'PN000007', 200, 340, CAST(N'2027-05-28' AS Date), N'Vien', 68000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000015', N'PN000007', 200, 400, CAST(N'2027-05-28' AS Date), N'Vien', 80000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000016', N'PN000007', 200, 250, CAST(N'2026-05-28' AS Date), N'Vien', 50000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000017', N'PN000007', 200, 500, CAST(N'2027-05-28' AS Date), N'Vien', 100000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maThuoc], [maPhieuNhap], [soLuong], [giaNhap], [hsd], [donVi], [thanhTien]) VALUES (N'TH000018', N'PN000007', 20, 340, CAST(N'2027-05-28' AS Date), N'Vien', 6800)
GO
INSERT [dbo].[DonDat] ([maDonDat], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD02011', N'KH00005', N'NV004', CAST(N'2024-03-29' AS Date), CAST(N'2024-04-10' AS Date))
INSERT [dbo].[DonDat] ([maDonDat], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD35306', N'KH00005', N'NV001', CAST(N'2024-04-29' AS Date), CAST(N'2024-05-02' AS Date))
INSERT [dbo].[DonDat] ([maDonDat], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD49328', N'KH00002', N'NV001', CAST(N'2024-01-25' AS Date), CAST(N'2024-01-29' AS Date))
INSERT [dbo].[DonDat] ([maDonDat], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD58513', N'KH00004', N'NV001', CAST(N'2024-01-29' AS Date), CAST(N'2024-01-31' AS Date))
INSERT [dbo].[DonDat] ([maDonDat], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD65050', N'KH00011', N'NV004', CAST(N'2024-05-29' AS Date), CAST(N'2025-06-02' AS Date))
INSERT [dbo].[DonDat] ([maDonDat], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD90424', N'KH00012', N'NV004', CAST(N'2024-05-29' AS Date), CAST(N'2024-05-30' AS Date))
GO
INSERT [dbo].[DonVi] ([maDonVi], [donVi]) VALUES (N'DV001', N'Vien')
INSERT [dbo].[DonVi] ([maDonVi], [donVi]) VALUES (N'DV002', N'Hop')
INSERT [dbo].[DonVi] ([maDonVi], [donVi]) VALUES (N'DV003', N'Vi')
INSERT [dbo].[DonVi] ([maDonVi], [donVi]) VALUES (N'DV004', N'ml')
INSERT [dbo].[DonVi] ([maDonVi], [donVi]) VALUES (N'DV005', N'Thung')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD07425', N'KH00002', N'NV001', CAST(N'2024-05-10' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD09553', N'KH00010', N'NV001', CAST(N'2024-04-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD12076', N'KH00000', N'NV004', CAST(N'2024-03-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD12227', N'KH00000', N'NV004', CAST(N'2024-05-11' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD16083', N'KH00000', N'NV004', CAST(N'2024-06-06' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD21254', N'KH00000', N'NV004', CAST(N'2023-12-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD26329', N'KH00007', N'NV001', CAST(N'2023-12-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD36094', N'KH00010', N'NV001', CAST(N'2023-12-31' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD38414', N'KH00004', N'NV001', CAST(N'2024-01-01' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD38816', N'KH00003', N'NV001', CAST(N'2024-01-03' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD43111', N'KH00004', N'NV001', CAST(N'2024-01-09' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD51428', N'KH00011', N'NV004', CAST(N'2024-03-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD51816', N'KH00002', N'NV001', CAST(N'2024-03-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD53718', N'KH00002', N'NV001', CAST(N'2024-02-24' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD57584', N'KH00002', N'NV001', CAST(N'2024-02-24' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD61467', N'KH00005', N'NV001', CAST(N'2024-02-03' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD64399', N'KH00005', N'NV001', CAST(N'2024-03-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD85118', N'KH00005', N'NV001', CAST(N'2024-05-29' AS Date), CAST(N'2024-05-29' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [maKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'HD91462', N'KH00009', N'NV001', CAST(N'2024-05-29' AS Date), CAST(N'2024-05-29' AS Date))
GO
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00000', N'', N'')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00001', N'0912345678', N'Nguyen Van An')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00002', N'0987654321', N'Tran Thi Bich')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00003', N'0934567890', N'Pham Minh Duc')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00004', N'0971234567', N'Do Thi Hong')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00005', N'0945678901', N'Vu Van Long')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00006', N'0916789012', N'Nguyen Thi Thanh')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00007', N'0902345678', N'Hoang Quoc Bao')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00008', N'0936789012', N'Tran Van Khoa')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00009', N'0982345678', N'Le Thi Thu')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00010', N'0982345677', N'Tran Anh Thu')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00011', N'0964405259', N'Ngo Van Vi')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00012', N'0708883138', N'Quang Tuan')
INSERT [dbo].[KhachHang] ([maKH], [soDienThoai], [hoTen]) VALUES (N'KH00013', N'0708883137', N'Ly Xuan Tin')
GO
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT001', N'Thuc pham chuc nang', NULL)
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT002', N'Thuoc giam dau', N'')
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT003', N'Thuoc khang sinh', NULL)
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT004', N'Thuoc cam', NULL)
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT005', N'Thuoc ha sot', N'')
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT006', N'Thuoc an than', N'dieu tri kho ngu, khong dung nhieu')
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT007', N'Thuoc tim mach', NULL)
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT008', N'Thuoc chong viem', NULL)
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT009', N'Dieu tri tieu duong', N'')
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT010', N'Thuoc da day', N'')
INSERT [dbo].[LoaiThuoc] ([maLoaiThuoc], [loaiThuoc], [moTa]) VALUES (N'LT011', N'Thuoc dieu tri di ung', N'')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC01', N'Nha cung cap ABCD', N'28/2 duong 28 go vap', N'0987654321')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC02', N'Nha cung cap OneTwo', N'12 duong 27 go vap', N'0987123456')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC03', N'Nha cung cap 991', N'991 duong 2 go vap', N'0991991991')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC04', N'Nha cung cap so 1', N'10 duong 1 go vapy', N'0111222111')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC07', N'Nha cung cap 22', N'21 duong so 3', N'0912312312')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC08', N'Nha cung cap thuoc', N'10 duong 21', N'0666333994')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV000', N'', N'', N'', N'')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV001', N'Nguyen Hoang Anh', N'0903123123', N'Nhan vien quan ly', N'hoanganh@gmail.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV002', N'Tran Nhat Ky', N'0703123456', N'Nhan vien ban hang', N'nhatkyy@gmail.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV003', N'To Hoang Thien', N'0363456123', N'Nhan vien ban hang', N'thien@gmail.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV004', N'Tran Ky', N'0903456789', N'Nhan vien quan ly', N'kyy@gmail.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV005', N'Nguyen Hanh', N'0366266771', N'Nhan vien ban hang', N'hanh771@gmail.com')
GO
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000001', N'NCC01', N'NV001', CAST(N'2024-05-28' AS Date), 1000, N'1         ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000002', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 121000, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000003', N'NCC02', N'NV001', CAST(N'2024-05-29' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000004', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000005', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 4400, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000006', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 88000, N'1         ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000007', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 304800, N'1         ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000008', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 0, N'false     ')
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [maNV], [ngayNhap], [tongTien], [trangThai]) VALUES (N'PN000009', N'NCC01', N'NV001', CAST(N'2024-05-29' AS Date), 0, N'false     ')
GO
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [maNV]) VALUES (N'NV001', N'001', N'NV001')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [maNV]) VALUES (N'NV004', N'004', N'NV004')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [maNV]) VALUES (N'hanh771@gmail.com', N'0366266771', N'NV005')
GO
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000001', N'Vitamin A', N'LT001', N'DV004', CAST(N'2025-05-12' AS Date), 100, 130, 150, N'Viet Nam', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000002', N'Vitamin B', N'LT001', N'DV001', CAST(N'2025-05-29' AS Date), 120, 140, 165, N'VN', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000003', N'Vitamin C', N'LT001', N'DV001', CAST(N'2024-11-29' AS Date), 140, 155, 70, N'VN', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000004', N'Vitamin D', N'LT001', N'DV001', CAST(N'2024-05-28' AS Date), 111, 130, 96, N'VN', N'NCC02')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000005', N'Vitamin E', N'LT001', N'DV001', CAST(N'2024-05-29' AS Date), 123, 150, 9, N'VN', N'NCC03')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000006', N'Vitamin F', N'LT001', N'DV001', CAST(N'2025-12-12' AS Date), 100, 1200, 15, N'My', N'NCC02')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000007', N'Vitamin G', N'LT001', N'DV001', CAST(N'2026-11-11' AS Date), 100, 120, 10, N'VN', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000008', N'Paracetamol', N'LT001', N'DV001', CAST(N'2025-12-12' AS Date), 10000, 12000, 11, N'VN', N'NCC02')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000009', N'Para extral', N'LT001', N'DV001', CAST(N'2024-05-10' AS Date), 180, 234, 40, N'My', N'NCC02')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000010', N'Vitamin H', N'LT002', N'DV001', CAST(N'2024-12-29' AS Date), 190, 240, 106, N'My', N'NCC03')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000011', N'Ibuprofen', N'LT002', N'DV001', CAST(N'2027-05-28' AS Date), 200, 250, 90, N'My', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000012', N'Amoxicillin', N'LT003', N'DV001', CAST(N'2026-05-28' AS Date), 500, 600, 91, N'Anh', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000013', N'Aspirin', N'LT005', N'DV001', CAST(N'2027-05-28' AS Date), 180, 200, 90, N'Duc', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000014', N'Lisinopril', N'LT007', N'DV001', CAST(N'2027-05-28' AS Date), 340, 380, 180, N'Anh', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000015', N'Metformin', N'LT009', N'DV001', CAST(N'2027-05-28' AS Date), 400, 450, 170, N'My', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000016', N'Omeprazole', N'LT010', N'DV001', CAST(N'2026-05-28' AS Date), 250, 300, 170, N'Anh', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000017', N'Simvastatin', N'LT007', N'DV001', CAST(N'2027-05-28' AS Date), 500, 600, 180, N'My', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000018', N'Metoprolol', N'LT001', N'DV001', CAST(N'2027-05-28' AS Date), 340, 390, 20, N'Anh', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000019', N'Cetirizine', N'LT011', N'DV001', CAST(N'2026-05-28' AS Date), 250, 300, 0, N'Bi', N'NCC01')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [maLoaiThuoc], [maDonVi], [hsd], [giaNhap], [giaBan], [soLuongTon], [nuocSanXuat], [maNCC]) VALUES (N'TH000020', N'Serum tri mun', N'LT001', N'DV001', CAST(N'2025-12-30' AS Date), 1000, 2000, 1, N'VN', N'NCC01')
GO
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
ALTER TABLE [dbo].[ChiTietPhieuNhapThuoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhapThuoc_PhieuNhapThuoc] FOREIGN KEY([maPhieuNhap])
REFERENCES [dbo].[PhieuNhapThuoc] ([maPhieuNhap])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhapThuoc] CHECK CONSTRAINT [FK_ChiTietPhieuNhapThuoc_PhieuNhapThuoc]
GO
ALTER TABLE [dbo].[ChiTietPhieuNhapThuoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietPhieuNhapThuoc_Thuoc] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[ChiTietPhieuNhapThuoc] CHECK CONSTRAINT [FK_ChiTietPhieuNhapThuoc_Thuoc]
GO
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
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK_Thuoc_DonVi] FOREIGN KEY([maDonVi])
REFERENCES [dbo].[DonVi] ([maDonVi])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK_Thuoc_DonVi]
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK_Thuoc_LoaiThuoc] FOREIGN KEY([maLoaiThuoc])
REFERENCES [dbo].[LoaiThuoc] ([maLoaiThuoc])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK_Thuoc_LoaiThuoc]
GO
