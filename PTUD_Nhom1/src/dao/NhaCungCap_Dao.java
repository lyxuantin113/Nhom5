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
	Connection con = null;
	
	public NhaCungCap_Dao() {
		con = ConnectDB.getInstance().getConnection();
		dsNCC = new ArrayList<NhaCungCap>();
	}
	
	public List<NhaCungCap> readFromTable() {
		try {
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
			if (con == null) {
				System.err.println("Không thể thiết lập kết nối cơ sở dữ liệu.");
				return;
			}
			String query = "update NhaCungCap set tenNCC = N'" + ncc.getTenNCC() + "', diaChiNCC = N'" + ncc.getDiaChiNCC()
					+ "', sdtNCC = '" + ncc.getSdtNCC() + "' where maNCC = '" + ncc.getMaNCC() + "'";
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
        	ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
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

	public String getNCC(String maNCC) {
		try {
			String query = "select * from NhaCungCap where MaNCC = '" + maNCC + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String tenNCC = rs.getString(2);
				return tenNCC;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return maNCC;
	}

	public String getMaNCC(String tenNCC) {
		try {
			String query = "select * from NhaCungCap where tenNCC = '" + tenNCC + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String maNCC = rs.getString(1);
				return maNCC;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tenNCC;
		
	}

	public NhaCungCap getNhaCungCap(String maNCC) {
		try {
			String query = "select * from NhaCungCap where MaNCC = '" + maNCC + "'";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(query);
			if (rs.next()) {
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, sdt);
				return ncc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
