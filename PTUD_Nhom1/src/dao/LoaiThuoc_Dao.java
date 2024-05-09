package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.LoaiThuoc;

public class LoaiThuoc_Dao {
	private List<LoaiThuoc> dsLoaiThuoc;
	Connection con = ConnectDB.getConnection();

	public LoaiThuoc_Dao() {
		dsLoaiThuoc = new ArrayList<LoaiThuoc>();
	}
	
	public List<LoaiThuoc> readFromTable() {
		try {
			dsLoaiThuoc.clear();
			String sql = "select * from LoaiThuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maLoai = rs.getString(1);
				String loaiThuoc = rs.getString(2);
				String moTa = rs.getString(3);
				LoaiThuoc lt = new LoaiThuoc(maLoai, loaiThuoc, moTa);
				dsLoaiThuoc.add(lt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLoaiThuoc;
	}

	public void addLoaiThuoc(LoaiThuoc lt) {
		try {
			String sql = "insert into LoaiThuoc values('" + lt.getMaLoai() + "','" + lt.getLoaiThuoc() + "','"
					+ lt.getMoTa() + "')";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void deleteLoaiThuoc(String maLoai) {
		try {
			String sql = "delete from LoaiThuoc where maLoaiThuoc = '" + maLoai + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateLoaiThuoc(LoaiThuoc lt) {
		try {
			String sql = "update LoaiThuoc set loaiThuoc = '" + lt.getLoaiThuoc() + "', moTa = '" + lt.getMoTa()
					+ "' where maLoaiThuoc = '" + lt.getMaLoai() + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
