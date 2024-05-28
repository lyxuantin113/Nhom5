package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.ChiTietDonDat;
import entity.DonDat;
import entity.Thuoc;

public class ChiTietDonDat_Dao {
	List<ChiTietDonDat> dsctdd = null;
	Connection con = null;
	private PreparedStatement pstmt;

	public ChiTietDonDat_Dao() {
		dsctdd = new ArrayList<ChiTietDonDat>();
		con = ConnectDB.getInstance().getConnection();
	}

	public List<ChiTietDonDat> findByID(String maDonDat) {
		String query = "Select * from ChiTietDonDat Where maDonDat = ?";
		List<ChiTietDonDat> listChiTietDonDat = new ArrayList<ChiTietDonDat>();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maDonDat);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				// Lấy ID của thuốc từ ResultSet
				String maThuoc = rs.getString("maThuoc");
				int soLuong = rs.getInt("soLuong");

				// Tạo mới một đối tượng Thuoc với ID tương ứng
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				Thuoc thuoc = thuocDao.timTheoMa(maThuoc);

				ChiTietDonDat ctdd = new ChiTietDonDat(thuoc, soLuong);
				listChiTietDonDat.add(ctdd);
			}

			return listChiTietDonDat;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void add(DonDat donDat) {
		String query = "Insert into ChiTietDonDat Values (?,?,?)";
		try {
			pstmt = con.prepareStatement(query);
			for (ChiTietDonDat chiTietDonDat : donDat.getListChiTietDonDat()) {
				pstmt.setString(1, donDat.getMaDonDat());
				pstmt.setString(2, chiTietDonDat.getMaThuoc().getMaThuoc());
				pstmt.setInt(3, chiTietDonDat.getSoLuong());
				pstmt.executeUpdate();
				dsctdd.add(chiTietDonDat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteByID(String maDonDat) {
		String query = "Delete from ChiTietDonDat Where maDonDat = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maDonDat);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ChiTietDonDat> getList() {
		return dsctdd;
	}
}
