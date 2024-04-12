package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import db.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.Thuoc;

public class ChiTietHoaDon_Dao {
	List<ChiTietHoaDon> dscthd = null;
	Connection con = null;
	private PreparedStatement pstmt;
	
	public ChiTietHoaDon_Dao() {
		dscthd = new ArrayList<ChiTietHoaDon>();
		con = ConnectDB.getInstance().getConnection();
	}

	public List<ChiTietHoaDon> findByID(String maHoaDon) {
		String query = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";
		List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maHoaDon);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				// Lấy ID của thuốc từ ResultSet
				String maThuoc = rs.getString("maThuoc");
				int soLuong = rs.getInt("soLuong");

				// Tạo mới một đối tượng Thuoc với ID tương ứng
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				Thuoc thuoc = thuocDao.timTheoMa(maThuoc).get(0);

				ChiTietHoaDon cthd = new ChiTietHoaDon(thuoc, soLuong);
				listChiTietHoaDon.add(cthd);
			}
			return listChiTietHoaDon;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void add(HoaDon hoaDon) {
		try {
			String query = "Insert into ChiTietHoaDon Values (?,?,?)";
			pstmt = con.prepareStatement(query);
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
				pstmt.setString(1, hoaDon.getMaHoaDon());
				pstmt.setString(2, chiTietHoaDon.getMaThuoc().getMaThuoc());
				pstmt.setInt(3, chiTietHoaDon.getSoLuong());
				pstmt.executeUpdate();
				dscthd.add(chiTietHoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean deleteOne(ChiTietHoaDon chiTietHoaDon) {
		String query = "Delete from ChiTietHoaDon Where maThuoc = ?";
		int n = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, chiTietHoaDon.getMaThuoc().getMaThuoc());
			dscthd.remove(chiTietHoaDon);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public List<ChiTietHoaDon> getList() {
		return dscthd;
	}

}
