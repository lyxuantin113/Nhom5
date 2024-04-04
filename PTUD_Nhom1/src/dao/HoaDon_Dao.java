package dao;

import java.sql.Connection;
import java.sql.Date;
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
				Date ngayXuat = rs.getDate(3);
				String sdtKH = rs.getString(4);
				KhachHang kh = new KhachHang(sdtKH);
				String maNV = rs.getString(5);
				NhanVien nv = new NhanVien(maNV);
				List<ChiTietHoaDon> list = (List<ChiTietHoaDon>) rs.getArray(6);
//				HoaDon gồm các field: String maHD, Date ngayLap, KhachHang khachHang, 
//				NhanVien maNV, List<ChiTietHoaDon>

				HoaDon hd = new HoaDon(maHD, ngayLap, ngayXuat, kh, nv, list);
				dshd.add(hd);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dshd;
	}

	public List<HoaDon> getDSHD() {
		return dshd;
	}
}
