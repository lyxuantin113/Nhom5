package dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import db.ConnectDB;
import entity.DonVi;
import entity.LoaiThuoc;
import entity.Thuoc;

public class Thuoc_Dao {
	private List<Thuoc> dsThuoc;
	Connection con = ConnectDB.getInstance().getConnection();

	public Thuoc_Dao() {
		dsThuoc = new ArrayList<Thuoc>();
	}

	public List<Thuoc> readFromTable() {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
				//
				DonVi_Dao dvDao = new DonVi_Dao();
				DonVi donViC = dvDao.getDonViClass(donVi);
				LoaiThuoc_Dao ltDao = new LoaiThuoc_Dao();
				LoaiThuoc loaiThuocC = ltDao.getLoaiThuocClass(loaiThuoc);
				
				
				Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuocC, donViC, hsd, giaGoc, giaBan, slTon, nuocSX, tenNCC);
				
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}

			// Tạo mã QR từ thông tin của thuốc
			String qrCodeContent = thuoc.getMaThuoc();
			BitMatrix bitMatrix = generateQRCode(qrCodeContent);

			// Lưu mã QR vào một tệp PNG
			String qrCodeFilename = thuoc.getMaThuoc() + "_" + UUID.randomUUID().toString() + ".png";
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", new File(qrCodeFilename).toPath());
			// Chuyển loại thuốc thành mã
			String query1 = "select maLoaiThuoc from LoaiThuoc where loaiThuoc = '" + thuoc.getMaLoai().getLoaiThuoc() + "'";
			Statement stm1 = con.createStatement();
			ResultSet rs1 = stm1.executeQuery(query1);
			String maLoai = "";
			if (rs1.next()) {
				maLoai = rs1.getString(1);
			}
			// Chuyển đơn vị thành mã đơn vị
			String query2 = "select maDonVi from DonVi where donVi = '" + thuoc.getMaDonVi().getDonVi() + "'";
			Statement stm2 = con.createStatement();
			ResultSet rs2 = stm2.executeQuery(query2);
			String maDonVi = "";
			if (rs2.next()) {
				maDonVi = rs2.getString(1);
			}
			// Chuyển nhà cung cấp thành mã nhà cung cấp
			String query3 = "select maNCC from NhaCungCap where tenNCC = '" + thuoc.getMaNCC() + "'";
			Statement stm3 = con.createStatement();
			ResultSet rs3 = stm3.executeQuery(query3);
			String maNCC = "";
			if (rs3.next()) {
				maNCC = rs3.getString(1);
			}
			
			// Thêm thuốc vào database
			String query = "insert into Thuoc values(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, thuoc.getMaThuoc());
			pstmt.setString(2, thuoc.getTenThuoc());
			pstmt.setString(3, maLoai);
			pstmt.setString(4, maDonVi);
			pstmt.setDate(5, java.sql.Date.valueOf(thuoc.getHSD()));
			pstmt.setDouble(6, thuoc.getGiaNhap());
			pstmt.setDouble(7, thuoc.getGiaBan());
			pstmt.setInt(8, thuoc.getSoLuongTon());
			pstmt.setString(9, thuoc.getNuocSanXuat());
			pstmt.setString(10, maNCC);
			
			pstmt.executeUpdate();
			pstmt.close();
			
			dsThuoc.add(thuoc);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Xóa thuốc trong database
	public boolean deleteThuoc(String maThuoc) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}

			String query = "update Thuoc set tenThuoc = '" + thuoc.getTenThuoc() + "', maLoaiThuoc = '"
					+ thuoc.getMaLoai().getMaLoai() + "', maDonVi = '" + thuoc.getMaDonVi().getMaDonVi() + "', HSD = '" + thuoc.getHSD()
					+ "', giaNhap = " + thuoc.getGiaNhap() + ", giaBan = " + thuoc.getGiaBan() + ", soLuongTon = "
					+ thuoc.getSoLuongTon() + ", nuocSanXuat = '" + thuoc.getNuocSanXuat() + "' where maThuoc = '"
					+ thuoc.getMaThuoc() + "'";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			for (Thuoc t : dsThuoc) {
				if (t.getMaThuoc().equals(thuoc.getMaThuoc())) {
					t.setTenThuoc(thuoc.getTenThuoc());
					t.setMaLoai(thuoc.getMaLoai());
					t.setMaDonVi(thuoc.getMaDonVi());
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
	public Thuoc timTheoMa(String ma) {
		Thuoc t = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "select * from Thuoc where maThuoc = '" + ma + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String ten = rs.getString(2);
				String loai = rs.getString(3);
				String donVi = rs.getString(4);
				LocalDate hsd = rs.getDate(5).toLocalDate();
				double giaNhap = rs.getDouble(6);
				double giaBan = rs.getDouble(7);
				int tonKho = rs.getInt(8);
				String nuocSx = rs.getString(9);
				String tenNCC = rs.getString(10);
				
				DonVi_Dao dvDao = new DonVi_Dao();
				DonVi donViC = dvDao.getDonViClass(donVi);
				LoaiThuoc_Dao ltDao = new LoaiThuoc_Dao();
				LoaiThuoc loaiThuocC = ltDao.getLoaiThuocClass(loai);
				
				t = new Thuoc(ma, ten, loaiThuocC, donViC, hsd, giaNhap, giaBan, tonKho, nuocSx, tenNCC);
			}
			return t;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// Tìm thuốc theo tên
	public Boolean timTheoTen(String ten) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
				
				DonVi_Dao dvDao = new DonVi_Dao();
				DonVi donViC = dvDao.getDonViClass(donVi);
				LoaiThuoc_Dao ltDao = new LoaiThuoc_Dao();
				LoaiThuoc loaiThuocC = ltDao.getLoaiThuocClass(loai);
				
				t = new Thuoc(ma, ten, loaiThuocC, donViC, hsd, giaNhap, giaBan, tonKho, nuocSx, tenNCC);
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where maLoaiThuoc = '" + loai + "'";
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where maNCC = '" + ncc + "'";
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
				
				DonVi_Dao dvDao = new DonVi_Dao();
				DonVi donViC = dvDao.getDonViClass(donVi);
				LoaiThuoc_Dao ltDao = new LoaiThuoc_Dao();
				LoaiThuoc loaiThuocC = ltDao.getLoaiThuocClass(loaiThuoc);
				Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuocC, donViC, hsd, giaGoc, giaBan, slTon, nuocSX,
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			// Update số lượng tồn, hsd
			String query = "update Thuoc set soLuongTon = '" + thuoc.getSoLuongTon() 
					+ "', HSD = '" + thuoc.getHSD()
					+ "' where maThuoc = '" + thuoc.getMaThuoc() + "'";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean checkThuoc(String maThuoc) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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
				
				DonVi_Dao dvDao = new DonVi_Dao();
				DonVi donViC = dvDao.getDonViClass(donVi);
				LoaiThuoc_Dao ltDao = new LoaiThuoc_Dao();
				LoaiThuoc loaiThuocC = ltDao.getLoaiThuocClass(loaiThuoc);
				
				thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuocC, donViC, hsd, giaGoc, giaBan, slTon, nuocSX, tenNCC);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return thuoc;

	}

	public boolean searchNCC(String maNCC) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "select * from Thuoc where maNCC = '" + maNCC + "'";
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

	public Boolean timTheoMaTuyetDoi(String ma) {

		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from Thuoc where maThuoc = '" + ma + "'";
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

	// Phương thức tạo mã QR từ nội dung cho trước
	private BitMatrix generateQRCode(String qrCodeContent) throws WriterException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		return qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, 200, 200);
	}

	public String taoMa() {
		// Lấy phần tử cuối cùng + 1
		String ma = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String query = "select top 1 maThuoc from Thuoc order by maThuoc desc";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				ma = rs.getString(1);
				String so = ma.substring(2);
				int soMoi = Integer.parseInt(so) + 1;
				if (soMoi < 10) {
					ma = "TH00000" + soMoi;
				} else if (soMoi < 100) {
					ma = "TH0000" + soMoi;
				} else if (soMoi < 1000) {
					ma = "TH000" +soMoi;
				} else if (soMoi < 10000) {
					ma = "TH00" + soMoi;
				} else if (soMoi < 100000) {
					ma = "TH0" + soMoi;
				} else {
					ma = "TH" + soMoi;
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ma;
		
	}
}
