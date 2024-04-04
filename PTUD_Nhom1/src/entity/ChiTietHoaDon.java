package entity;

import java.util.List;

public class ChiTietHoaDon {
	private Thuoc maThuoc;
	private int soLuong;

	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(Thuoc maThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public Thuoc getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}

}
