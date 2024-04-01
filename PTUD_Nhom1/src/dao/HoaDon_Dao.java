package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_Dao {
	List<HoaDon> dshd;
	public HoaDon_Dao() {
//		db.ConnectDB.getInstance().connect();
		dshd = new ArrayList<HoaDon>();
	}
	
	public List<HoaDon> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from HoaDon";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maHD = rs.getString(1);
				Date ngayLap = rs.getDate(2);
				String maKH = rs.getString(3);
				KhachHang kh = new KhachHang(maKH, "");
				String maNV = rs.getString(4);
				NhanVien nv = new NhanVien(maNV, "", "", "", "");
//				String maHD, Date ngayLap, KhachHang khachHang, NhanVien maNV
				
				HoaDon hd = new HoaDon(maHD, ngayLap, kh, nv);
				dshd.add(hd);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dshd;
	}
	
	public List<HoaDon> getDSHD() {
		return dshd;
	}
}
