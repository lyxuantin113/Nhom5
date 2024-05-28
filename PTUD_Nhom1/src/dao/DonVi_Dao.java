package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.DonVi;

public class DonVi_Dao {
	private List<DonVi> dsDonVi;
	Connection con = ConnectDB.getConnection();
	
	public DonVi_Dao() {
		dsDonVi = new ArrayList<DonVi>();
	}
	
	public List<DonVi> readFromTable() {
		try {
			dsDonVi.clear();
			String sql = "select * from DonVi";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maDonVi = rs.getString(1);
				String tenDonVi = rs.getString(2);
				DonVi dv = new DonVi(maDonVi, tenDonVi);
				dsDonVi.add(dv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDonVi;
	}

	public void addDonVi(DonVi dv) {
		try {
            String sql = "insert into DonVi values('"+dv.getMaDonVi()+"')";
            Statement statement = con.createStatement();
            statement.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    
	}
	
	public void deleteDonVi(String maDonVi) {
		try {
			String sql = "delete from DonVi where maDonVi = '" + maDonVi + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateDonVi(DonVi dv) {
		try {
			String sql = "update DonVi set tenDonVi = '" + dv.getDonVi() + "' where maDonVi = '" + dv.getMaDonVi() + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkMaDonVi(String maDonVi) {
		try {
			String sql = "select * from DonVi where maDonVi = '" + maDonVi + "'";
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

	public String taoMaDonVi() {
		try {
			String sql = "select max(maDonVi) from DonVi";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maDonVi = rs.getString(1);
				String number = maDonVi.substring(2);
				int num = Integer.parseInt(number);
				num++;
				if (num < 10) {
					return "DV00" + num;
				} else if (num < 100) {
					return "DV0" + num;
				} else {
					return "DV" + num;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DV001";
	}

	public String getDonVi(String maDonVi) {
		try {
			String sql = "select * from DonVi where maDonVi = '" + maDonVi + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String tenDonVi = rs.getString(2);
				return tenDonVi;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maDonVi;
	}

	public String getMaDonVi(String donVi) {
		try {
			String sql = "select * from DonVi where donVi = '" + donVi + "'";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				String maDonVi = rs.getString(1);
				return maDonVi;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return donVi;
	}

	public boolean checkTonTaiThuoc(String maDonVi) {
		try {
			String sql = "select * from Thuoc where maDonVi = '" + maDonVi + "'";
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
	
}
