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
				String quyDoi = rs.getString(3);
				DonVi dv = new DonVi(maDonVi, tenDonVi, quyDoi);
				dsDonVi.add(dv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsDonVi;
	}

	public void addDonVi(DonVi dv) {
		try {
            String sql = "insert into DonVi values('"+dv.getMaDonVi()+"','"+dv.getTenDonVi()+"','"+dv.getQuyDoi()+"')";
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
			String sql = "update DonVi set tenDonVi = '" + dv.getTenDonVi() + "', quyDoi = '" + dv.getQuyDoi()
					+ "' where maDonVi = '" + dv.getMaDonVi() + "'";
			Statement statement = con.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
