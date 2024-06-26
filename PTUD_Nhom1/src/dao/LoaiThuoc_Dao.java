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

	public boolean checkMaLoaiThuoc(String maLoai) {
		
		for (LoaiThuoc lt : dsLoaiThuoc) {
			if (lt.getMaLoai().equals(maLoai)) {
				return true;
			}
		}
		return false;
	}

	public String taoMaLoaiThuoc() {
		
		try {
			String sql = "select max(maLoaiThuoc) from LoaiThuoc";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maLoaiThuoc = rs.getString(1);
				String number = maLoaiThuoc.substring(2);
				int num = Integer.parseInt(number);
				num++;
				if (num < 10) {
					return "LT00" + num;
				} else if (num < 100) {
					return "LT0" + num;
				} else {
					return "LT" + num;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    
	}

	public String getLoaiThuoc(String maLoaiThuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from LoaiThuoc where maLoaiThuoc = '" + maLoaiThuoc + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String loaiThuoc = rs.getString(2);
				return loaiThuoc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maLoaiThuoc;
	}

	public String getMaLoaiThuoc(String loaiThuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from LoaiThuoc where loaiThuoc = '" + loaiThuoc + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String maLoaiThuoc = rs.getString(1);
				return maLoaiThuoc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loaiThuoc;
	}

	public boolean checkTonTaiThuoc(String maLoai) {
		try {
			String sql = "select * from Thuoc where maLoaiThuoc = '" + maLoai + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
		
		
	}

	public LoaiThuoc getLoaiThuocClass(String loaiThuoc) {
		try {
			String sql = "select * from LoaiThuoc where maLoaiThuoc = '" + loaiThuoc + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String loaiThuocT = rs.getString(2);
				String moTa = rs.getString(3);
				LoaiThuoc lt = new LoaiThuoc(loaiThuoc, loaiThuocT, moTa);
				return lt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
