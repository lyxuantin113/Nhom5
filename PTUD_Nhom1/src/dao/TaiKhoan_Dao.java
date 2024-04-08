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

}
