package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import db.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Thuoc;

public class ChiTietHoaDon_Dao {
	List<ChiTietHoaDon> dscthd = null;
	Map<Thuoc, Integer> danhSachDon = new LinkedHashMap<>();
	Connection con = null;
	private PreparedStatement pstmt;
	
	public ChiTietHoaDon_Dao() {
		dscthd = new ArrayList<ChiTietHoaDon>();
		con = ConnectDB.getInstance().getConnection();
	}
	
	public void addDanhSachDon(Thuoc thuoc, int soLuong) {
		danhSachDon.put(thuoc, soLuong);
	}
	
	public void deleteDanhSachDon(Thuoc thuoc) {
		danhSachDon.remove(thuoc);
	}
	
	public void resetDanhSachDon() {
		danhSachDon = null;
	}
	
	public Map<Thuoc, Integer> getDanhSachDon() {
		return danhSachDon;
	}
	
	public List<ChiTietHoaDon> findByID(HoaDon maHoaDon) {
		String query = "Select * from ChiTietHoaDon Where maHoaDon = ?";
		Statement stmt;
		try {
			pstmt.setObject(1, maHoaDon);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				HoaDon hoaDon = (HoaDon) rs.getObject(1); 
				Thuoc thuoc = (Thuoc) rs.getObject(2);
				int soLuong = rs.getInt(3);
				ChiTietHoaDon cthd = new ChiTietHoaDon(hoaDon, thuoc, soLuong);
				dscthd.add(cthd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dscthd;
	}
	
	public boolean addOne(ChiTietHoaDon chiTietHoaDon) {
		String query = "Insert into ChiTietHoaDon Values (?,?,?)";
		int n = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setObject(1, chiTietHoaDon.getMaHoaDon());
			pstmt.setObject(2, chiTietHoaDon.getMaThuoc());
			pstmt.setInt(3, chiTietHoaDon.getSoLuong());
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}
	
	public boolean deleteById(Thuoc maThuoc) {
		String query = "Delete from ChiTietHoaDon Where maThuoc = ?";
		int n = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setObject(1, maThuoc);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}
	
	public boolean updateSoLuong(ChiTietHoaDon chiTietHoaDon) {
		String query = "Update ChiTietHoaDon "
				+ "Set soLuong = soLuong + ? "
				+ "Where maHoaDon = ?, maThuoc = ?";
		int n = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, chiTietHoaDon.getSoLuong());
			pstmt.setObject(2, chiTietHoaDon.getMaHoaDon());
			pstmt.setObject(3, chiTietHoaDon.getMaThuoc());
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}
	
	public List<ChiTietHoaDon> getList() {
		return dscthd;
	}
	
//	public void resetList() {
//		dscthd = null;
//	}

}
