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
import entity.ChiTietDonDat;
import entity.DonDat;

public class DonDat_Dao {
	private List<DonDat> dspdt;
	Connection con = null;

	public DonDat_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dspdt = new ArrayList<DonDat>();
	}

	public List<DonDat> readFromTable() {
		try {
			String query = "select * from PhieuDatThuoc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maPDT = rs.getString(1);
				String sdtKH = rs.getString(2);
				KhachHang kh = new KhachHang(sdtKH);
				String maNV = rs.getString(3);
				NhanVien nv = new NhanVien(maNV);
				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);
				List<ChiTietDonDat> list = (List<ChiTietDonDat>) rs.getArray(6);

//				String maPD, KhachHang khachHang, NhanVien maNV, Date ngayLap, Date ngayNhan, List<ChiTietDonDat>
				DonDat pdt = new DonDat(maPDT, kh, nv, ngayLap, ngayNhan, list);

				dspdt.add(pdt);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dspdt;
	}

	public List<DonDat> getDSPDT() {
		return dspdt;
	}
}
