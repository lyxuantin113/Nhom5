package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.PhieuDatThuoc;

public class PhieuDatThuoc_Dao {
	private List<PhieuDatThuoc> dspdt;
	
	public PhieuDatThuoc_Dao() {
		dspdt = new ArrayList<PhieuDatThuoc>();
	}
	
	public List<PhieuDatThuoc> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from PhieuDatThuoc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maPDT = rs.getString(1);
				String maKH = rs.getString(2);
				KhachHang kh = new KhachHang(maKH, "");
				String maNV = rs.getString(3);
				NhanVien nv = new NhanVien(maNV, "", "", "", "");
				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);
				
//				String maPD, KhachHang khachHang, NhanVien maNV, Date ngayLap, Date ngayNhan
				PhieuDatThuoc pdt = new PhieuDatThuoc(maPDT, kh, nv, ngayLap, ngayNhan);
				
				dspdt.add(pdt);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return dspdt;
	}
	
	public List<PhieuDatThuoc> getDSPDT() {
		return dspdt;
	}
}
