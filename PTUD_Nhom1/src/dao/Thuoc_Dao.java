package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.NhaCungCap;
import entity.Thuoc;

public class Thuoc_Dao {
	private List<Thuoc> dst;
	
	public Thuoc_Dao() {
		dst = new ArrayList<Thuoc>();
	}
	
	public List<Thuoc> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from Thuoc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				String tenThuoc = rs.getString(2);
				String loaiThuoc = rs.getString(3);
				String donVi = rs.getString(4);
				Date hsd = rs.getDate(5);
				double giaBan = rs.getDouble(6);
				int slTon = rs.getInt(7);
				String maNCC = rs.getString(8);
				NhaCungCap ncc = new NhaCungCap(maNCC, "", "", "");
				
//				String maThuoc, String tenThuoc, String loaiThuoc, String donVi
//				, Date hSD, double giaBan, int soLuongTon, NhaCungCap ncc
				Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuoc, donVi, hsd, giaBan, slTon, ncc);
				dst.add(thuoc);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dst;
	}
	
	public List<Thuoc> getDST() {
		return dst;
	}
}
