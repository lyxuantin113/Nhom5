package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.ChiTietDonDat;
import entity.DonDat;
import entity.Thuoc;

public class ChiTietDonDat_Dao {
	List<ChiTietDonDat> dsctdd = null;
	Connection con = null;
	private PreparedStatement pstmt;
	
	public ChiTietDonDat_Dao() {
		dsctdd = new ArrayList<ChiTietDonDat>();
		con = ConnectDB.getInstance().getConnection();
	}
	
	public List<ChiTietDonDat> findByID(DonDat maDonDat) {
		String query = "Select * from ChiTietDonDat Where maDonDat = ?";
		Statement stmt;
		try {
			pstmt.setObject(1, maDonDat);

			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				DonDat donDat = (DonDat) rs.getObject(1); 
				Thuoc thuoc = (Thuoc) rs.getObject(2);
				int soLuong = rs.getInt(3);
				ChiTietDonDat cthd = new ChiTietDonDat(donDat, thuoc, soLuong);
				dsctdd.add(cthd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dsctdd;
	}
	
	public boolean addOne(ChiTietDonDat chiTietDonDat) {
		String query = "Insert into ChiTietDonDat Values (?,?,?)";
		int n = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setObject(1, chiTietDonDat.getMaDonDat());
			pstmt.setObject(2, chiTietDonDat.getMaThuoc());
			pstmt.setInt(3, chiTietDonDat.getSoLuong());
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}
	
	public boolean deleteById(Thuoc maThuoc) {
		String query = "Delete from ChiTietDonDat Where maThuoc = ?";
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
	
	public boolean updateSoLuong(ChiTietDonDat chiTietDonDat) {
		String query = "Update ChiTietDonDat "
				+ "Set soLuong = soLuong + ? "
				+ "Where maDonDat = ?, maThuoc = ?";
		int n = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, chiTietDonDat.getSoLuong());
			pstmt.setObject(2, chiTietDonDat.getMaDonDat());
			pstmt.setObject(3, chiTietDonDat.getMaThuoc());
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return n > 0;
	}
	
	public List<ChiTietDonDat> getList() {
		return dsctdd;
	}
}
