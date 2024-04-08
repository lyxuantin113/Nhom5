package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.PhieuNhapThuoc;

public class PhieuNhapThuoc_Dao {
	private List<PhieuNhapThuoc> dsPNT;
	
	public PhieuNhapThuoc_Dao() {
		dsPNT = new ArrayList<PhieuNhapThuoc>();
	}
	
	public List<PhieuNhapThuoc> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from PhieuNhapThuoc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
                String maPhieuNhap = rs.getString(1);
                String maNCC = rs.getString(2);
                String maNV = rs.getString(3);
                LocalDate ngayNhap = rs.getDate(4).toLocalDate();
                Double tongTien = rs.getDouble(5);
                Boolean trangThai = rs.getBoolean(6);
                
                PhieuNhapThuoc pnt = new PhieuNhapThuoc(maPhieuNhap, maNCC, maNV, ngayNhap, tongTien, trangThai);
                dsPNT.add(pnt);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dsPNT;
	}
	
	
	public List<PhieuNhapThuoc> getDSPNT() {
		return dsPNT;
	}
	// Tạo phiếu nhập mới trong database
	public boolean create(PhieuNhapThuoc pnt) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "insert into PhieuNhapThuoc values('" + pnt.getMaPhieuNhap() + "','" + pnt.getMaNCC() + "','"
					+ pnt.getMaNV() + "','" + pnt.getNgayNhap() + "','" + pnt.getTongTien() + "','" + pnt.getTrangThai()
					+ "')";
			Statement stm = con.createStatement();
			int result = stm.executeUpdate(query);
			if (result > 0) {
				dsPNT.add(pnt);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateTongTien(PhieuNhapThuoc pnt) {
		try {
            Connection con = ConnectDB.getInstance().getConnection();
            String query = "update PhieuNhapThuoc set tongTien = '"+pnt.getTongTien()+"' where maPhieuNhap = '"+pnt.getMaPhieuNhap()+"'";
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
		
	}
	// Update trạng thái
	public void updateTrangThai(String  pnt) {
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String query = "update PhieuNhapThuoc set trangThai = 1 where maPhieuNhap = '"+pnt+"'";
            Statement stm = con.createStatement();
            stm.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
