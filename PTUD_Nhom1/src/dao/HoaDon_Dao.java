package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDon_Dao {
	List<HoaDon> dshd = new ArrayList<HoaDon>();
	Connection con = null;
	PreparedStatement pstmt = null;

	public HoaDon_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dshd = new ArrayList<HoaDon>();
	}

	public List<HoaDon> readFromTable() {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		try {
			String query = "select * from HoaDon";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maHD = rs.getString(1);

				KhachHang_Dao khDao = new KhachHang_Dao();
				String maKH = rs.getString(2);
				KhachHang kh = khDao.findById(maKH);

				NhanVien_Dao nvDao = new NhanVien_Dao();
				String maNV = rs.getString(3);
				NhanVien nv = nvDao.getNhanVien(maNV).get(0);
				Date ngayLap = rs.getDate(4);
				Date ngayNhan = rs.getDate(5);

				HoaDon hd = new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate());
				
				ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();
				List<ChiTietHoaDon> listCTHD = cthdDao.findByID(maHD);
				
				hd.setListChiTietHoaDon(listCTHD);
				
				listHD.add(hd);
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return listHD;
		}
	}

	public void addOne(HoaDon hoaDon) {
		try {
			String query = "INSERT INTO HoaDon VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, hoaDon.getMaHoaDon());
			pstmt.setString(2, hoaDon.getMaKH().getMaKH());
			pstmt.setString(3, hoaDon.getMaNV().getMaNV());
			pstmt.setDate(4, Date.valueOf(hoaDon.getNgayLap()));
			pstmt.setDate(5, Date.valueOf(hoaDon.getNgayNhan()));
			pstmt.executeUpdate();
			pstmt.close();

			ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();
			cthdDao.add(hoaDon);

			dshd.add(hoaDon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	ID
	public HoaDon findByID(String maHoaDon) {
	    HoaDon hoaDon = null;
	    String query = "select * from HoaDon where maHoaDon = ?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, maHoaDon);

	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) { // Di chuyển con trỏ đến dòng đầu tiên của kết quả
	            String maHD = rs.getString(1);

	            // Khách Hàng
	            String maKH = rs.getString(2);
	            KhachHang_Dao khachDao = new KhachHang_Dao();
	            KhachHang kh = khachDao.findById(maKH);

	            // Nhân Viên
	            String maNV = rs.getString(3);
	            NhanVien_Dao nhanVienDao = new NhanVien_Dao();
	            NhanVien nv = nhanVienDao.getNhanVien(maNV).get(0);

	            Date ngayLap = rs.getDate(4);
	            Date ngayNhan = rs.getDate(5);
	            hoaDon = new HoaDon(maHD, kh, nv, ngayLap.toLocalDate(), ngayNhan.toLocalDate());

	            ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();
	            List<ChiTietHoaDon> listCTHD = cthdDao.findByID(maHoaDon);

	            hoaDon.setListChiTietHoaDon(listCTHD);
	        }

	        rs.close();
	        pstmt.close();

	        return hoaDon;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}


//	NHÂN VIÊN
	public List<HoaDon> findByNhanVien(String maNV) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where maNV = ?";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, maNV);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	NGÀY LẬP
	public List<HoaDon> findByNgayLap(LocalDate ngayLap) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

//	NGÀY NHẬN
	public List<HoaDon> findByNgayNhan(LocalDate ngayNhan) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayNhan = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayNhan));

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	THỐNG KÊ FULL FIELD
	public List<HoaDon> findTKFullField(LocalDate ngayLap, String maNV, String maKH) {
		List<HoaDon> listHD = new ArrayList<HoaDon>();
		String query = "select * from HoaDon where ngayLap = ? AND maNV = ? AND maKH = ?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDate(1, Date.valueOf(ngayLap));
			pstmt.setString(2, maNV);
			pstmt.setString(3, maKH);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String maHD = rs.getString(1);
				listHD.add(findByID(maHD));
			}
			return listHD;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	Thống kê đơn của KH X được lập bởi NV Y theo tháng
	public List<HoaDon> findXYinMonth(LocalDate ngayLap, String maNV, String maKH) {
	    List<HoaDon> listHD = new ArrayList<HoaDon>();
	    String query = "SELECT * FROM HoaDon WHERE MONTH(ngayLap) = ? AND YEAR(ngayLap) = ? AND maNV = ? AND maKH = ?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, ngayLap.getMonthValue());
	        pstmt.setInt(2, ngayLap.getYear());
	        pstmt.setString(3, maNV);
	        pstmt.setString(4, maKH);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String maHD = rs.getString(1);
	            listHD.add(findByID(maHD));
	        }
	        return listHD;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
//	Thống kê đơn của KH X được lập bởi NV Y theo năm
	public List<HoaDon> findXYinYear(LocalDate ngayLap, String maNV, String maKH) {
	    List<HoaDon> listHD = new ArrayList<HoaDon>();
	    String query = "SELECT * FROM HoaDon WHERE YEAR(ngayLap) = ? AND maNV = ? AND maKH = ?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, ngayLap.getYear());
	        pstmt.setString(2, maNV);
	        pstmt.setString(3, maKH);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String maHD = rs.getString(1);
	            listHD.add(findByID(maHD));
	        }
	        return listHD;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
//	Thống kê đơn của KH X được lập bởi NV Y 
	public List<HoaDon> findXByY(String maNV, String maKH) {
	    List<HoaDon> listHD = new ArrayList<HoaDon>();
	    String query = "SELECT * FROM HoaDon WHERE maNV = ? AND maKH = ?";
	    try {
	        pstmt = con.prepareStatement(query);
	        pstmt.setString(1, maNV);
	        pstmt.setString(2, maKH);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            String maHD = rs.getString(1);
	            listHD.add(findByID(maHD));
	        }
	        return listHD;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	
//	DANH SÁCH
	public List<HoaDon> getDSHD() {
		return dshd;
	}

	public double tinhTongTien(HoaDon hoaDon) {
		double doanhThu = 0.0;
		if (hoaDon.getListChiTietHoaDon() != null) {
			for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
				double giaBan = chiTietHoaDon.getMaThuoc().getGiaBan();
				int soLuong = chiTietHoaDon.getSoLuong();
				doanhThu += giaBan * soLuong;
			}
		} else
			return 0;
		return doanhThu;
	}

	public double tinhLoiNhuanChoHoaDon(HoaDon hoaDon) {
		double loiNhuan = 0.0;
		if (hoaDon.getListChiTietHoaDon() != null) {
			for (ChiTietHoaDon chiTiet : hoaDon.getListChiTietHoaDon()) {
				double giaNhap = chiTiet.getMaThuoc().getGiaNhap();
				double giaBan = chiTiet.getMaThuoc().getGiaBan();
				int soLuong = chiTiet.getSoLuong();
				loiNhuan += (giaBan - giaNhap) * soLuong;
			}
		} else
			return 0;
		return loiNhuan;
	}
}
