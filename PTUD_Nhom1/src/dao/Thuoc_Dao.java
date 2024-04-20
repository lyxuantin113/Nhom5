package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.NhaCungCap;
import entity.Thuoc;

public class Thuoc_Dao {
	private List<Thuoc> dsThuoc;

	public Thuoc_Dao() {
		dsThuoc = new ArrayList<Thuoc>();
	}

	public List<Thuoc> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from Thuoc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				String tenThuoc = rs.getString(2);
				String loaiThuoc = rs.getString(3);
				String donVi = rs.getString(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				double giaGoc = rs.getDouble(6);
				double giaBan = rs.getDouble(7);
				int slTon = rs.getInt(8);
				String nuocSX = rs.getString(9);

				String tenNCC = rs.getString(10);

				Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuoc, donVi, hsd, giaGoc, giaBan, slTon, nuocSX,
						tenNCC);
				;
				dsThuoc.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsThuoc;
	}

	public List<Thuoc> getDST() {
		return dsThuoc;
	}

	// Thêm thuốc vào database
	public void addThuoc(Thuoc thuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			String query = "insert into Thuoc values ('" + thuoc.getMaThuoc() + "', '" + thuoc.getTenThuoc() + "', '"
					+ thuoc.getLoaiThuoc() + "', '" + thuoc.getDonVi() + "', '" + thuoc.getHSD() + "', "
					+ thuoc.getGiaNhap() + ", " + thuoc.getGiaBan() + ", " + thuoc.getSoLuongTon() + ", '"
					+ thuoc.getNuocSanXuat() + "', '" + thuoc.getMaNCC() + "')";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			dsThuoc.add(thuoc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xóa thuốc trong database
	public boolean deleteThuoc(String maThuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "delete from Thuoc where maThuoc = '" + maThuoc + "'";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			for (Thuoc t : dsThuoc) {
				if (t.getMaThuoc().equals(maThuoc)) {
					dsThuoc.remove(t);
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateThuoc(Thuoc thuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}

			String query = "update Thuoc set tenThuoc = '" + thuoc.getTenThuoc() + "', loaiThuoc = '"
					+ thuoc.getLoaiThuoc() + "', donVi = '" + thuoc.getDonVi() + "', HSD = '" + thuoc.getHSD()
					+ "', giaNhap = " + thuoc.getGiaNhap() + ", giaBan = " + thuoc.getGiaBan() + ", soLuongTon = "
					+ thuoc.getSoLuongTon() + ", nuocSanXuat = '" + thuoc.getNuocSanXuat() + "' where maThuoc = '"
					+ thuoc.getMaThuoc() + "'";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			for (Thuoc t : dsThuoc) {
				if (t.getMaThuoc().equals(thuoc.getMaThuoc())) {
					t.setTenThuoc(thuoc.getTenThuoc());
					t.setLoaiThuoc(thuoc.getLoaiThuoc());
					t.setDonVi(thuoc.getDonVi());
					t.setHSD(thuoc.getHSD());
					t.setGiaNhap(thuoc.getGiaNhap());
					t.setGiaBan(thuoc.getGiaBan());
					t.setSoLuongTon(thuoc.getSoLuongTon());
					t.setNuocSanXuat(thuoc.getNuocSanXuat());
					t.setMaNCC(thuoc.getMaNCC());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateThuocQuatity(String maThuoc, int soLuongGiam) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}

			String query = "Update Thuoc SET soLuongTon = soLuongTon - ? WHERE maThuoc = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, soLuongGiam);
			pstmt.setString(2, maThuoc);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Tìm thuốc theo mã
	public List<Thuoc> timTheoMa(String ma) {
		List<Thuoc> listThuoc = new ArrayList<>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
//				return false;
			}
			String query = "select * from Thuoc where maThuoc = '" + ma + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
//				return true;
				String ten = rs.getString(2);
				String loai = rs.getString(3);
				String donVi = rs.getString(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				double giaNhap = rs.getDouble(6);
				double giaBan = rs.getDouble(7);
				int tonKho = rs.getInt(8);
				String nuocSx = rs.getString(9);
				String tenNCC = rs.getString(10);
				Thuoc thuoc = new Thuoc(ma, ten, loai, donVi, hsd, giaNhap, giaBan, tonKho, nuocSx, tenNCC);
				listThuoc.add(thuoc);
			}
			return listThuoc;
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return false;
		return listThuoc;
	}

	// Tìm thuốc theo tên
	public Boolean timTheoTen(String ten) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where tenThuoc = '" + ten + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// Tìm thuốc theo tên trả về Thuoc
		public Thuoc findByName(String ten) {
			Thuoc t = null;
			try {
				Connection con = ConnectDB.getInstance().getConnection();
				if (con == null) {
					System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
					return null;
				}
				String query = "select * from Thuoc where tenThuoc = '" + ten + "'";
				Statement stm = con.createStatement();
				ResultSet rs = stm.executeQuery(query);
				if (rs.next()) {
					String ma = rs.getString(1);
					String loai = rs.getString(3);
					String donVi = rs.getString(4);
					LocalDate hsd = rs.getDate(5).toLocalDate();
					double giaNhap = rs.getDouble(6);
					double giaBan = rs.getDouble(7);
					int tonKho = rs.getInt(8);
					String nuocSx = rs.getString(9);
					String tenNCC = rs.getString(10);
					t = new Thuoc(ma, ten, loai, donVi, hsd, giaNhap, giaBan, tonKho, nuocSx, tenNCC);
				}
				return t;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

	// Tìm thuốc theo loại
	public Boolean timTheoLoai(String loai) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where loaiThuoc = '" + loai + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Tìm thuốc theo ncc
	public Boolean timTheoNCC(String ncc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where tenNCC = '" + ncc + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// Lấy danh sách theo nhà cung cấp
	public List<Thuoc> getDSTByNCC(String ncc) {
		List<Thuoc> ds = new ArrayList<Thuoc>();
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return null;
			}
			String query = "select * from Thuoc where maNCC = '" + ncc + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				String tenThuoc = rs.getString(2);
				String loaiThuoc = rs.getString(3);
				String donVi = rs.getString(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				double giaGoc = rs.getDouble(6);
				double giaBan = rs.getDouble(7);
				int slTon = rs.getInt(8);
				String nuocSX = rs.getString(9);
				String tenNCC = rs.getString(10);

				Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuoc, donVi, hsd, giaGoc, giaBan, slTon, nuocSX,
						tenNCC);
				ds.add(thuoc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public void updateTTThuoc(Thuoc thuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			// Update số lượng tồn, giá nhận, hsd, đơn vị
			String query = "update Thuoc set soLuongTon = '" + thuoc.getSoLuongTon() + "', giaNhap = '"
					+ thuoc.getGiaNhap() + "', HSD = '" + thuoc.getHSD() + "', donVi = '" + thuoc.getDonVi()
					+ "' where maThuoc = '" + thuoc.getMaThuoc() + "'";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkThuoc(String maThuoc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where maThuoc = '" + maThuoc + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Thuoc readFromTable(String string) {
		Thuoc thuoc = null;
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from Thuoc where maThuoc = '" + string + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maThuoc = rs.getString(1);
				String tenThuoc = rs.getString(2);
				String loaiThuoc = rs.getString(3);
				String donVi = rs.getString(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				double giaGoc = rs.getDouble(6);
				double giaBan = rs.getDouble(7);
				int slTon = rs.getInt(8);
				String nuocSX = rs.getString(9);

				String tenNCC = rs.getString(10);

				thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuoc, donVi, hsd, giaGoc, giaBan, slTon, nuocSX, tenNCC);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thuoc;

	}

}
