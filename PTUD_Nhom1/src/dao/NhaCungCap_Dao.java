package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.ConnectDB;
import entity.NhaCungCap;

public class NhaCungCap_Dao {
	private List<NhaCungCap> dsNCC;
	
	public NhaCungCap_Dao() {
		dsNCC = new ArrayList<NhaCungCap>();
	}
	
	public List<NhaCungCap> readFromTable() {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			String query = "select * from NhaCungCap";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);

				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
				dsNCC.add(ncc);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsNCC;
	}
	
	public List<NhaCungCap> getDSNCC() {
		return dsNCC;
	}
	
	// Thêm nhà cung cấp vào database
	public void addNCC(NhaCungCap ncc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			String query = "insert into NhaCungCap values('" + ncc.getMaNCC() + "', N'" + ncc.getTenNCC() + "', N'"
					+ ncc.getDiaChiNCC() + "', '" + ncc.getSdtNCC() + "')";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			dsNCC.add(ncc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Xóa nhà cung cấp khỏi database
	public void deleteNCC(String maNCC) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			String query = "delete from NhaCungCap where MaNCC = '" + maNCC + "'";
			
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			for (NhaCungCap ncc : dsNCC) {
				if (ncc.getMaNCC().equals(maNCC)) {
					dsNCC.remove(ncc);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Cập nhật thông tin nhà cung cấp
	public void updateNCC(NhaCungCap ncc) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			String query = "update NhaCungCap set TenNCC = N'" + ncc.getTenNCC() + "', DiaChi = N'" + ncc.getDiaChiNCC()
					+ "', SDT = '" + ncc.getSdtNCC() + "' where MaNCC = '" + ncc.getMaNCC() + "'";
			Statement stm = con.createStatement();
			stm.executeUpdate(query);
			for (NhaCungCap n : dsNCC) {
				if (n.getMaNCC().equals(ncc.getMaNCC())) {
					n.setTenNCC(ncc.getTenNCC());
					n.setDiaChiNCC(ncc.getDiaChiNCC());
					n.setSdtNCC(ncc.getSdtNCC());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Tìm kiếm nhà cung cấp
	public boolean searchNCC(String maNCC) {
		try {
			Connection con = ConnectDB.getInstance().getConnection();
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return false;
			}
			String query = "select * from NhaCungCap where MaNCC = '" + maNCC + "'";
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

	public static String taoMaNCC() {
		String maNCC = "NCC";
        try {
            Connection con = ConnectDB.getInstance().getConnection();
            String query = "select top 1 MaNCC from NhaCungCap order by MaNCC desc";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            if (rs.next()) {
                String ma = rs.getString(1);
                int so = Integer.parseInt(ma.substring(3)) + 1;
                if (so < 10) {
                    maNCC += "0" + so;
                } else if (so < 100) {
                    maNCC += + so;
                } else {
                    maNCC += so;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return maNCC;
		
	
	}
}
