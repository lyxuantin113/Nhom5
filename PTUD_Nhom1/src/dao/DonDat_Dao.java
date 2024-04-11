package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.ChiTietDonDat;
import entity.ChiTietHoaDon;
import entity.DonDat;
import entity.HoaDon;

public class DonDat_Dao {
	private List<DonDat> dsdd = new ArrayList<DonDat>();
	Connection con = null;
	private PreparedStatement pstmt = null;

	public DonDat_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dsdd = new ArrayList<DonDat>();
	}

	public List<DonDat> readFromTable() {
		List<DonDat> listDD = new ArrayList<DonDat>();
		try {
			String query = "select * from DonDat";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maDD = rs.getString(1);
				KhachHang_Dao khDao = new KhachHang_Dao();
				String maKH = rs.getString(2);
				KhachHang kh = khDao.findById(maKH);

				NhanVien_Dao nvDao = new NhanVien_Dao();
				String maNV = rs.getString(3);
				NhanVien nv = nvDao.getNhanVien(maNV).get(0);
				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);

				DonDat dd = new DonDat(maDD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate());

				ChiTietDonDat_Dao ctddDao = new ChiTietDonDat_Dao();
				List<ChiTietDonDat> listCTDD = ctddDao.findByID(maDD);
				
				dd.setListChiTietDonDat(listCTDD);
				
				listDD.add(dd);
			}
			return listDD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void addOne(DonDat donDat) {
		String query = "Insert into DonDat Values (?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, donDat.getMaDonDat());
			pstmt.setString(2, donDat.getMaKH().getMaKH());
			pstmt.setString(3, donDat.getMaNV().getMaNV());
			pstmt.setDate(4, Date.valueOf(donDat.getNgayLap()));
			pstmt.setDate(5, Date.valueOf(donDat.getNgayNhan()));
			pstmt.executeUpdate();
			pstmt.close();

			ChiTietDonDat_Dao ctddDao = new ChiTietDonDat_Dao();
			ctddDao.add(donDat);

			dsdd.add(donDat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DonDat findByID(String maDonDat) {
		DonDat donDat = null;
		String query = "select * from DonDat where maDonDat = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maDonDat);

			ResultSet rs = pstmt.executeQuery();

			String maDD = rs.getString(1);

//			Khách Hàng
			String maKH = rs.getString(2);
			KhachHang_Dao khachDao = new KhachHang_Dao();
			KhachHang kh = khachDao.findById(maKH);

//			Nhân Viên
			String maNV = rs.getString(3);
			NhanVien_Dao nhanVienDao = new NhanVien_Dao();
			NhanVien nv = nhanVienDao.getNhanVien(maNV).get(0);

			Date ngayLap = rs.getDate(4);
			Date ngayNhan = rs.getDate(5);

			donDat = new DonDat(maDD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate());

			rs.close();

			ChiTietDonDat_Dao ctddDao = new ChiTietDonDat_Dao();
			List<ChiTietDonDat> listCTDD = ctddDao.findByID(maDonDat);

			donDat.setListChiTietDonDat(listCTDD);

			return donDat;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	NHÂN VIÊN
	public List<DonDat> findByNhanVien(String maNV) {
		List<DonDat> listDD = new ArrayList<DonDat>();
		String query = "select * from DonDat where maNV = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maDD = rs.getString(1);
				listDD.add(findByID(maDD));
			}
			return listDD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DonDat> findByNgayLap(Date ngayLap) {
		List<DonDat> listDD = new ArrayList<DonDat>();
		String query = "select * from DonDat where ngayLap = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ngayLap);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maDD = rs.getString(1);
				listDD.add(findByID(maDD));
			}
			return listDD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DonDat> findByNgayNhan(Date ngayNhan) {
		List<DonDat> listDD = new ArrayList<DonDat>();
		String query = "select * from DonDat where ngayNhan = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ngayNhan);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maDD = rs.getString(1);
				listDD.add(findByID(maDD));
			}

			return listDD;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<DonDat> getDSDD() {
		return dsdd;
	}
	
	public double tinhTongTien(DonDat donDat) {
		double doanhThu = 0.0;
		for (ChiTietDonDat chiTietDonDat : donDat.getListChiTietDonDat()) {
			double giaBan = chiTietDonDat.getMaThuoc().getGiaBan();
			int soLuong = chiTietDonDat.getSoLuong();
			doanhThu += giaBan * soLuong;
		}
		return doanhThu;
	}

	public double tinhLoiNhuanChoDonDat(DonDat donDat) {
		double loiNhuan = 0.0;
		for (ChiTietDonDat chiTietDonDat : donDat.getListChiTietDonDat()) {
			double giaNhap = chiTietDonDat.getMaThuoc().getGiaNhap();
			double giaBan = chiTietDonDat.getMaThuoc().getGiaBan();
			int soLuong = chiTietDonDat.getSoLuong();
			loiNhuan += (giaBan - giaNhap) * soLuong;
		}
		return loiNhuan;
	}
}
