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
	private List<DonDat> dsdd;
	Connection con = null;
	private PreparedStatement pstmt;

	public DonDat_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dsdd = new ArrayList<DonDat>();
	}

	@SuppressWarnings("unchecked")
	public List<DonDat> readFromTable() {
		try {
			String query = "select * from DonDat";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maPDT = rs.getString(1);
				KhachHang kh = (KhachHang) rs.getObject(2);
				NhanVien nv = (NhanVien) rs.getObject(3);
				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);
				List<ChiTietDonDat> list = (List<ChiTietDonDat>) rs.getArray(6);

//				String maPD, KhachHang khachHang, NhanVien maNV, Date ngayLap, Date ngayNhan, List<ChiTietDonDat>
				DonDat pdt = new DonDat(maPDT, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate(), list);

				dsdd.add(pdt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsdd;
	}
	
	public boolean addOne(DonDat donDat) {
		String query = "Insert into DonDat Values (?,?,?,?,?,?)";
		int n = 0;
		try {
			pstmt.executeQuery(query);
			pstmt.setString(1, donDat.getMaDonDat());
			pstmt.setObject(2, donDat.getMaKH());
			pstmt.setObject(3, donDat.getMaNV());
			pstmt.setDate(4, Date.valueOf(donDat.getNgayLap()));
			pstmt.setDate(5, Date.valueOf(donDat.getNgayNhan()));
			pstmt.setArray(6, (Array) donDat.getCtdd());
			
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return n > 0;
	}

	public List<DonDat> findByID(String maDonDat) {
		List<DonDat> dsdd = null;
		String query = "select * from DonDat where maDonDat = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maDonDat);

			ResultSet rs = pstmt.executeQuery();

			String maDD = rs.getString(1);
			KhachHang kh = (KhachHang) rs.getObject(2);
			NhanVien nv = (NhanVien) rs.getObject(3);
			Date ngayLap = rs.getDate(4);
			Date ngayNhan = rs.getDate(5);
			List<ChiTietDonDat> ctdd = (List<ChiTietDonDat>) rs.getArray(6);

			dsdd.add(new DonDat(maDD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate(), ctdd));
			return dsdd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsdd;
	}

	public List<DonDat> findByNgayLap(Date ngayLap) {
		List<DonDat> dsdd = null;
		String query = "select * from DonDat where ngayLap = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ngayLap);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maDD = rs.getString(1);
				KhachHang kh = (KhachHang) rs.getObject(2);
				NhanVien nv = (NhanVien) rs.getObject(3);
				Date ngayLapDD = rs.getDate(4);
				Date ngayNhanDD = rs.getDate(5);
				List<ChiTietDonDat> ctdd = (List<ChiTietDonDat>) rs.getArray(6);
				dsdd.add(new DonDat(maDD, kh, nv, ngayLapDD.toLocalDate(), ngayNhanDD.toLocalDate(), ctdd));
			}

			return dsdd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsdd;
	}

	public List<DonDat> findByNgayNhan(Date ngayNhan) {
		List<DonDat> dsdd = null;
		String query = "select * from DonDat where ngayNhan = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, ngayNhan);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maDD = rs.getString(1);
				KhachHang kh = (KhachHang) rs.getObject(2);
				NhanVien nv = (NhanVien) rs.getObject(3);
				Date ngayLapDD = rs.getDate(4);
				Date ngayNhanDD = rs.getDate(5);
				List<ChiTietDonDat> ctdd = (List<ChiTietDonDat>) rs.getArray(6);
				dsdd.add(new DonDat(maDD, kh, nv, ngayLapDD.toLocalDate(), ngayNhanDD.toLocalDate(), ctdd));
			}

			return dsdd;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dsdd;
	}

	public List<DonDat> getDSPDT() {
		return dsdd;
	}
}
