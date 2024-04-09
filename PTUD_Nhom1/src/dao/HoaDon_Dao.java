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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_Dao {
	List<HoaDon> dshd;
	Connection con = null;
	PreparedStatement pstmt = null;

	public HoaDon_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dshd = new ArrayList<HoaDon>();
	}

	public List<HoaDon> readFromTable() {
		try {
			String query = "select * from HoaDon";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maHD = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				Date ngayNhan = rs.getDate(3);
				String sdtKH = rs.getString(4);
				KhachHang kh = new KhachHang(sdtKH);
				String maNV = rs.getString(5);
				NhanVien nv = new NhanVien(maNV);
				List<ChiTietHoaDon> list = (List<ChiTietHoaDon>) rs.getArray(6);
//				HoaDon gồm các field: String maHD, Date ngayLap, KhachHang khachHang, 
//				NhanVien maNV, List<ChiTietHoaDon>

				HoaDon hd = new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate(), list);
				dshd.add(hd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshd;
	}

	public void addOne(HoaDon hoaDon) {
		try {
			String query = "Insert into HoaDon Values (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, hoaDon.getMaHoaDon());
			pstmt.setObject(2, hoaDon.getMaKH());
			pstmt.setObject(3, hoaDon.getMaNV());
			pstmt.setDate(4, Date.valueOf(hoaDon.getNgayLap()));
			pstmt.setDate(5, Date.valueOf(hoaDon.getNgayNhan()));
			pstmt.setArray(6, (Array) hoaDon.getCthd());
			dshd.add(hoaDon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	ID
	public List<HoaDon> findByID(String maHoaDon) {
		List<HoaDon> dshd = null;
		String query = "select * from HoaDon where maHoaDon = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maHoaDon);

			ResultSet rs = pstmt.executeQuery();

			String maHD = rs.getString(1);
			KhachHang kh = (KhachHang) rs.getObject(2);
			NhanVien nv = (NhanVien) rs.getObject(3);
			Date ngayLap = rs.getDate(4);
			Date ngayNhan = rs.getDate(5);
			List<ChiTietHoaDon> cthd = (List<ChiTietHoaDon>) rs.getArray(6);

			dshd.add(new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate(), cthd));
			return dshd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dshd;
	}
	
//	NHÂN VIÊN
	public List<HoaDon> findByNhanVien(String maNV) {
		List<HoaDon> dshd = null;
		String query = "select * from HoaDon where maNV = ?";
		NhanVien_Dao nvDao = new NhanVien_Dao();
		NhanVien nv = (NhanVien) nvDao.getNhanVien(maNV);
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setObject(1, nv);

			ResultSet rs = pstmt.executeQuery();

			String maHD = rs.getString(1);
			KhachHang kh = (KhachHang) rs.getObject(2);
			Date ngayLap = rs.getDate(4);
			Date ngayNhan = rs.getDate(5);
			List<ChiTietHoaDon> cthd = (List<ChiTietHoaDon>) rs.getArray(6);

			dshd.add(new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate(), cthd));
			return dshd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dshd;
	}
	
//	NGÀY LẬP
	public List<HoaDon> findByNgayLap(Date ngayLap) {
		List<HoaDon> dshd = null;
		String query = "select * from HoaDon where ngayLap = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ngayLap);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String maHD = rs.getString(1);
				KhachHang kh = (KhachHang) rs.getObject(2);
				NhanVien nv = (NhanVien) rs.getObject(3);
				Date ngayLapHD = rs.getDate(4);
				Date ngayNhanHD = rs.getDate(5);
				List<ChiTietHoaDon> cthd = (List<ChiTietHoaDon>) rs.getArray(6);
				dshd.add(new HoaDon(maHD, kh, nv, ngayLapHD.toLocalDate(), ngayNhanHD.toLocalDate(), cthd));
			}

			return dshd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dshd;
	}
	
//	NGÀY NHẬN
	public List<HoaDon> findByNgayNhan(Date ngayNhan) {
		List<HoaDon> dshd = null;
		String query = "select * from HoaDon where ngayNhan = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ngayNhan);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				String maHD = rs.getString(1);
				KhachHang kh = (KhachHang) rs.getObject(2);
				NhanVien nv = (NhanVien) rs.getObject(3);
				Date ngayLapHD = rs.getDate(4);
				Date ngayNhanHD = rs.getDate(5);
				List<ChiTietHoaDon> cthd = (List<ChiTietHoaDon>) rs.getArray(6);
				dshd.add(new HoaDon(maHD, kh, nv, ngayLapHD.toLocalDate(), ngayNhanHD.toLocalDate(), cthd));
			}

			return dshd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dshd;
	}

//	DANH SÁCH
	public List<HoaDon> getDSHD() {
		return dshd;
	}
}
