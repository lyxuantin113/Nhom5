package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	        stmt.setString(2, tk.getMaNV().getMaNV());
	        n = stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return n > 0;
	}
	
}
