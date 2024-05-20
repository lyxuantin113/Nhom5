package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.ChiTietHoaDon;
import entity.NhanVien;
import entity.TaiKhoan;

public class TaiKhoan_Dao {
	List<TaiKhoan> dstk;
	Connection con = null;

	public TaiKhoan_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dstk = new ArrayList<TaiKhoan>();
	}

	public boolean createTaiKhoan(TaiKhoan tk) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			// Nếu Mã nhân viên chưa tồn tại, tiến hành thêm mới
			stmt = con.prepareStatement("insert into TaiKhoan values(?, ?, ?)");
			stmt.setString(1, tk.getTenTaiKhoan());
			stmt.setString(2, tk.getMatKhau());
			stmt.setString(3, tk.getMaNV().getMaNV());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	// Phương thức kiểm tra đăng nhập
	public boolean kiemTraDangNhap(String taiKhoan, String matKhau) {
		Connection con = ConnectDB.getInstance().getConnection();

		PreparedStatement stmt = null;
		try {
			// Kết nối đến cơ sở dữ liệu
			String sql = "SELECT COUNT(*) FROM TaiKhoan WHERE tenTaiKhoan = ? AND matKhau = ?";
			stmt = con.prepareStatement(sql);
			// Thiết lập tham số cho câu lệnh SQL
			stmt.setString(1, taiKhoan);
			stmt.setString(2, matKhau);
			// Thực thi truy vấn
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0; // Trả về true nếu có ít nhất một bản ghi trả về
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false; // Trả về false nếu có lỗi xảy ra hoặc không có bản ghi nào trả về
	}

	public NhanVien getNVByAccount(String taiKhoan, String matKhau) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		NhanVien_Dao nvDao = new NhanVien_Dao();
		NhanVien nv = null;
		try {
			// Kết nối đến cơ sở dữ liệu
			String sql = "SELECT * FROM TaiKhoan WHERE tenTaiKhoan = ? AND matKhau = ?";
			stmt = con.prepareStatement(sql);
			// Thiết lập tham số cho câu lệnh SQL
			stmt.setString(1, taiKhoan);
			stmt.setString(2, matKhau);
			// Thực thi truy vấn
			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				nv = nvDao.getNhanVien(resultSet.getString("maNV")).get(0);
			}
			return nv;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return nv;
	}

	public TaiKhoan getTKById(String maNV) {
		TaiKhoan tk = null;
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "SELECT * FROM TaiKhoan WHERE maNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maNV);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				NhanVien_Dao nvDao = new NhanVien_Dao();
				NhanVien nv = nvDao.getNhanVien(maNV).get(0);
				tk = new TaiKhoan(rs.getString("tenTaiKhoan"), rs.getString("matKhau"), nv);
			}
			return tk;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tk;
	}
	
	public boolean doiMatKhau(TaiKhoan tk, String mkMoi) {
		Connection con = ConnectDB.getInstance().getConnection();
		PreparedStatement stmt = null;
		String query = "Update TaiKhoan Set matKhau = ? Where maNV = ? AND tenTaiKhoan = ?";
		int n = 0;
		try {
			stmt = con.prepareStatement(query);
			stmt.setString(1, mkMoi);
			stmt.setString(2, tk.getMaNV().getMaNV());
			stmt.setString(3, tk.getTenTaiKhoan());
			n = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n > 0;
	}
}
