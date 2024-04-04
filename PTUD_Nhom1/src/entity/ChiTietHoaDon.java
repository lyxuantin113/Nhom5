package entity;

import java.util.List;

public class ChiTietHoaDon {
	private HoaDon maHoaDon;
	private Thuoc maThuoc;
	private int soLuong;

	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(HoaDon maHoaDon, Thuoc maThuoc, int soLuong) {
		super();
		this.maHoaDon = maHoaDon;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public HoaDon getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(HoaDon maHoaDon) {
		this.maHoaDon = maHoaDon;
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
		return "ChiTietHoaDon [maHoaDon=" + maHoaDon + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}

}
