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

/* */
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

/****** Object:  Table [dbo].[Thuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
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

/****** Object:  Table [dbo].[DonDatThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
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
	[dsChiTietDonDat] NVARCHAR(MAX)
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
	[ngayNhan] [date] NOT NULL,
	[dsChiTietHoaDon] NVARCHAR(MAX)
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

/****** Object:  Table [dbo].[PhieuNhapThuoc]    Script Date: 3/9/2024 11:51:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhapThuoc](
	
	[maPhieuNhap] [nvarchar](50) NOT NULL,
	[maNCC] [nvarchar](50) NOT NULL,
	[maNV] [nvarchar](50) NOT NULL,
	[ngayGui] [date] NOT NULL,
	[ngayNhan] [date] NOT NULL,
	[dsChiTietPhieuNhap] NVARCHAR(MAX)

 CONSTRAINT [PK_PhieuNhapThuoc] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC
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
 CONSTRAINT [PK_ChiTietPhieuNhapThuoc] PRIMARY KEY CLUSTERED 
(
	[maPhieuNhap] ASC,
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

/* ChiTietPhieuNhapThuoc */
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

/* PhieuNhapThuoc */
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

/* TaiKhoan */
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
