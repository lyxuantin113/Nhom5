package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.ChiTietPhieuNhapThuoc;

public class PhieuNhapThuoc_Dao {
	private List<ChiTietPhieuNhapThuoc> dsPNT;
	
	public PhieuNhapThuoc_Dao() {
		dsPNT = new ArrayList<ChiTietPhieuNhapThuoc>();
	}
	
	public List<ChiTietPhieuNhapThuoc> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from ChiTietPhieuNhapThuoc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				
				String maThuoc = rs.getString(1);
				int soLuong = rs.getInt(2);
				String tenThuoc = rs.getString(3);
				double giaNhap = rs.getDouble(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				String donVi = rs.getString(6);
				double thanhTien = rs.getDouble(7);
				String maChiTiet = rs.getString(9);
				ChiTietPhieuNhapThuoc ctPNT = new ChiTietPhieuNhapThuoc(maChiTiet,maThuoc, soLuong, tenThuoc, giaNhap, hsd, donVi, thanhTien);
				
				dsPNT.add(ctPNT);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPNT;
	}
	
	public List<ChiTietPhieuNhapThuoc> getDSPNT() {
		return dsPNT;
	}
	
	
}
