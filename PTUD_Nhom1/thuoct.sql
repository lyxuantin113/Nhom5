USE [master]
GO
/****** Object:  Database [QuanLyThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
CREATE DATABASE [QuanLyThuoc]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyThuoc', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLyThuoc.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyThuoc_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLyThuoc_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyThuoc] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyThuoc].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyThuoc] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyThuoc] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyThuoc] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyThuoc] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyThuoc] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyThuoc] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyThuoc] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyThuoc] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyThuoc] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyThuoc] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyThuoc] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyThuoc] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyThuoc] SET QUERY_STORE = OFF
GO
USE [QuanLyThuoc]
GO
/****** Object:  Table [dbo].[ChiTietDonDatThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonDatThuoc](
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
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 3/9/2024 11:51:16 PM ******/
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
/****** Object:  Table [dbo].[ChiTietPhieuNhapThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhapThuoc](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maThuoc] [nvarchar](50) NOT NULL,
	[soLuong] [int] NULL,
	[giaGoc] [float] NULL,
 CONSTRAINT [PK_ChiTietPhieuNhapThuoc] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC,
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonDatThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonDatThuoc](
	[maDonDat] [nvarchar](50) NOT NULL,
	[sdtKH] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NULL,
	[ngayNhan] [date] NULL,
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
	[sdtKH] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayLap] [date] NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[soDienThoai] [nvarchar](50) NOT NULL,
	[hoTen] [nvarchar](50) NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[soDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 3/9/2024 11:51:16 PM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 3/9/2024 11:51:16 PM ******/
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
/****** Object:  Table [dbo].[PhieuNhapThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapThuoc](
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maNCC] [nvarchar](50) NOT NULL,
	[ngayNhap] [date] NULL,
 CONSTRAINT [PK_PhieuNhapThuoc] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[maThuoc] [nvarchar](50) NOT NULL,
	[tenThuoc] [nvarchar](50) NULL,
	[loaiThuoc] [nvarchar](50) NULL,
	[hsd] [date] NULL,
	[giaBan] [float] NULL,
	[soLuongTon] [int] NULL,
	[donVi] [nvarchar](50) NULL,
 CONSTRAINT [PK_Thuoc] PRIMARY KEY CLUSTERED 
(
	[maThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChiTietDonDatThuoc] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD12336394', N'TH39400532', 1)
INSERT [dbo].[ChiTietDonDatThuoc] ([maDonDat], [maThuoc], [soLuong]) VALUES (N'DD14428593', N'TH29939402', 2)
GO
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD01256553', N'TH29939402', 2)
INSERT [dbo].[ChiTietHoaDon] ([maHoaDon], [maThuoc], [soLuong]) VALUES (N'HD01323464', N'TH58328395', 1)
GO
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maPhieuNhap], [maThuoc], [soLuong], [giaGoc]) VALUES (N'PN29231290', N'TH58328395', 90, 120000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maPhieuNhap], [maThuoc], [soLuong], [giaGoc]) VALUES (N'PN29482942', N'TH39400532', 56, 80000)
INSERT [dbo].[ChiTietPhieuNhapThuoc] ([maPhieuNhap], [maThuoc], [soLuong], [giaGoc]) VALUES (N'PN29948592', N'TH29939402', 50, 34000)
GO
INSERT [dbo].[DonDatThuoc] ([maDonDat], [sdtKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD12336394', N'0929404304', N'NV21120381', CAST(N'2024-02-28' AS Date), CAST(N'2024-03-01' AS Date))
INSERT [dbo].[DonDatThuoc] ([maDonDat], [sdtKH], [maNV], [ngayLap], [ngayNhan]) VALUES (N'DD14428593', N'0343350117', N'NV21120481', CAST(N'2024-03-06' AS Date), CAST(N'2024-03-09' AS Date))
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [sdtKH], [maNV], [ngayLap]) VALUES (N'HD01256553', N'0964405259', N'NV21120381', CAST(N'2024-02-28' AS Date))
INSERT [dbo].[HoaDon] ([maHoaDon], [sdtKH], [maNV], [ngayLap]) VALUES (N'HD01323464', N'0912644361', N'NV21120481', CAST(N'2024-03-09' AS Date))
GO
INSERT [dbo].[KhachHang] ([soDienThoai], [hoTen]) VALUES (N'0343350117', N'Nguyễn Quốc Khôi')
INSERT [dbo].[KhachHang] ([soDienThoai], [hoTen]) VALUES (N'0912644361', N'Hạo Văn Vĩ')
INSERT [dbo].[KhachHang] ([soDienThoai], [hoTen]) VALUES (N'0929404304', N'Lê Thế Quân')
INSERT [dbo].[KhachHang] ([soDienThoai], [hoTen]) VALUES (N'0964405259', N'Dương Xuân Tín')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC028931', N'Getz Pharma', N'Korangi, Karachi 74900, Pakistan', N'9221 111 111 511')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC920402', N'Farmalabor-Produtos Farmacêuticos, S.A.', N'Sebal, Belide 3150-194 Condeixa-a-Nova Bồ Đào Nha', N'351 21 499 74 00')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [diaChiNCC], [sdtNCC]) VALUES (N'NCC929423', N'Khapharco', N' 74 Thống Nhất, Vạn Thắng, Nha Trang, Khánh Hoà', N'0258 382 2946')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV21120381', N'Lý Xuân Sang', N'090522421', N'Nhân viên quản lí', N'xuanxuansang@gmail.com')
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [sdtNV], [chucVu], [email]) VALUES (N'NV21120481', N'Nguyễn Văn Tuấn', N'0905209982', N'Nhân viên bán hàng', N'v2ntu2n@gmail.com')
GO
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [ngayNhap]) VALUES (N'PN29231290', N'NCC929423', CAST(N'2024-01-13' AS Date))
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [ngayNhap]) VALUES (N'PN29482942', N'NCC920402', CAST(N'2024-02-23' AS Date))
INSERT [dbo].[PhieuNhapThuoc] ([maPhieuNhap], [maNCC], [ngayNhap]) VALUES (N'PN29948592', N'NCC028931', CAST(N'2024-02-09' AS Date))
GO
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [hsd], [giaBan], [soLuongTon], [donVi]) VALUES (N'TH29939402', N'Paracetamol (acetaminophen) 500mg (Panactol)', N'Paracetamol', CAST(N'2025-11-15' AS Date), 40000, 95, N'hộp')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [hsd], [giaBan], [soLuongTon], [donVi]) VALUES (N'TH39400532', N'Cetirizin 10mg (Taparen)', N'Cetirizine', CAST(N'2025-05-23' AS Date), 91400, 145, N'viên')
INSERT [dbo].[Thuoc] ([maThuoc], [tenThuoc], [loaiThuoc], [hsd], [giaBan], [soLuongTon], [donVi]) VALUES (N'TH58328395', N'Candesartan + hydrochlorothiazid 16mg + 12.5mg', N'Thuốc lợi tiểu', CAST(N'2025-03-09' AS Date), 145600, 56, N'viên')
GO
ALTER TABLE [dbo].[ChiTietDonDatThuoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonDatThuoc_DonDatThuoc] FOREIGN KEY([maDonDat])
REFERENCES [dbo].[DonDatThuoc] ([maDonDat])
GO
ALTER TABLE [dbo].[ChiTietDonDatThuoc] CHECK CONSTRAINT [FK_ChiTietDonDatThuoc_DonDatThuoc]
GO
ALTER TABLE [dbo].[ChiTietDonDatThuoc]  WITH CHECK ADD  CONSTRAINT [FK_ChiTietDonDatThuoc_Thuoc] FOREIGN KEY([maThuoc])
REFERENCES [dbo].[Thuoc] ([maThuoc])
GO
ALTER TABLE [dbo].[ChiTietDonDatThuoc] CHECK CONSTRAINT [FK_ChiTietDonDatThuoc_Thuoc]
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
ALTER TABLE [dbo].[DonDatThuoc]  WITH CHECK ADD  CONSTRAINT [FK_DonDatThuoc_KhachHang] FOREIGN KEY([sdtKH])
REFERENCES [dbo].[KhachHang] ([soDienThoai])
GO
ALTER TABLE [dbo].[DonDatThuoc] CHECK CONSTRAINT [FK_DonDatThuoc_KhachHang]
GO
ALTER TABLE [dbo].[DonDatThuoc]  WITH CHECK ADD  CONSTRAINT [FK_DonDatThuoc_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[DonDatThuoc] CHECK CONSTRAINT [FK_DonDatThuoc_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([sdtKH])
REFERENCES [dbo].[KhachHang] ([soDienThoai])
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
USE [master]
GO
ALTER DATABASE [QuanLyThuoc] SET  READ_WRITE 
GO
