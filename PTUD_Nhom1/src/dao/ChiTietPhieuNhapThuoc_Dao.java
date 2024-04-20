package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.ChiTietPhieuNhapThuoc;

public class ChiTietPhieuNhapThuoc_Dao {
	private List<ChiTietPhieuNhapThuoc> dsCTPNT;
	
	public ChiTietPhieuNhapThuoc_Dao() {
		dsCTPNT = new ArrayList<ChiTietPhieuNhapThuoc>();
	}
	
	public List<ChiTietPhieuNhapThuoc> readFromTable(String maPhieuNhap) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from ChiTietPhieuNhapThuoc where maPhieuNhap = '"+maPhieuNhap+"'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				
				String maThuoc = rs.getString(1);
				String maChiTiet = rs.getString(2);
				int soLuong = rs.getInt(3);
				
				double giaNhap = rs.getDouble(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				String donVi = rs.getString(6);
				double thanhTien = rs.getDouble(7);
				
				ChiTietPhieuNhapThuoc ctPNT = new ChiTietPhieuNhapThuoc(maChiTiet,maThuoc, soLuong, giaNhap, hsd, donVi, thanhTien);
				
				dsCTPNT.add(ctPNT);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsCTPNT;
	}
	
	public List<ChiTietPhieuNhapThuoc> getDSPNT() {
		return dsCTPNT;
	}
	
	
	// Tạo chi tiết phiếu nhập mới trong database
	public boolean create(ChiTietPhieuNhapThuoc ctPNT) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "INSERT INTO ChiTietPhieuNhapThuoc VALUES ('" + ctPNT.getMaThuoc() + "','" + ctPNT.getMaPhieuNhap() + "','" + ctPNT.getSoLuong() + "','" + ctPNT.getGiaNhap() + "','" + ctPNT.getHsd() + "','" + ctPNT.getDonVi() + "','" + ctPNT.getThanhTien() + "')";

			Statement stm = con.createStatement();
			int result = stm.executeUpdate(query);
			if (result > 0) {
				dsCTPNT.add(ctPNT);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// Sửa chi tiết phiếu nhập trong database
	public boolean update(ChiTietPhieuNhapThuoc ctPNT) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "update ChiTietPhieuNhapThuoc set soLuong = '" + ctPNT.getSoLuong() + "', giaNhap = '"
					+ ctPNT.getGiaNhap() + "', hsd = '" + ctPNT.getHsd() + "', donVi = '" + ctPNT.getDonVi()
					+ "', thanhTien = '" + ctPNT.getThanhTien() + "' where maPhieuNhap = '" + ctPNT.getMaPhieuNhap()
					+ "' and maThuoc = '" + ctPNT.getMaThuoc() + "'";
			Statement stm = con.createStatement();
			int result = stm.executeUpdate(query);
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	// Xóa  chi tiết phiếu nhập trong database
	public boolean delete(String maCTPNT) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "delete from ChiTietPhieuNhapThuoc where maPhieuNhap = '" + maCTPNT + "'";
			Statement stm = con.createStatement();
			int result = stm.executeUpdate(query);
			if (result > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean findMaPhieuNhap(String maCTPNT ,String maThuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from ChiTietPhieuNhapThuoc where maPhieuNhap = '" + maCTPNT + "' and maThuoc = '" + maThuoc + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
