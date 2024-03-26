package entity;

import java.util.List;

public class ChiTietHoaDon {
	private HoaDon maHD;
	private List<DanhSachThuoc> dsThuoc;

	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon maHD, List<DanhSachThuoc> dsThuoc) {
		super();
		this.maHD = maHD;
		this.dsThuoc = dsThuoc;
	}

	public HoaDon getMaHD() {
		return maHD;
	}

	public void setMaHD(HoaDon maHD) {
		this.maHD = maHD;
	}

	public List<DanhSachThuoc> getDsThuoc() {
		return dsThuoc;
	}

	public void setDsThuoc(List<DanhSachThuoc> dsThuoc) {
		this.dsThuoc = dsThuoc;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maHD=" + maHD + ", dsThuoc=" + dsThuoc + "]";
	}

}
