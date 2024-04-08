package entity;

import java.time.LocalDate;

public class ChiTietPhieuNhapThuoc {
	private String maCTPNT;
	private String maThuoc;
	private int soLuong;
	private String tenThuoc;
	private double giaNhap;
	private LocalDate hsd;
	private String donVi;
	private double thanhTien;
	
	
	public String getMaCTPNT() {
		return maCTPNT;
	}

	public void setMaCTPNT(String maCTPNT) {
		this.maCTPNT = maCTPNT;
	}
	public String getMaThuoc() {
		return maThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getTenThuoc() {
		return tenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public LocalDate getHsd() {
		return hsd;
	}
	public void setHsd(LocalDate hsd) {
		this.hsd = hsd;
	}
	public String getDonVi() {
		return donVi;
	}
	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	

	public ChiTietPhieuNhapThuoc(String maCTPNT,String maThuoc, int soLuong, String tenThuoc, double giaNhap, LocalDate hsd,
			String donVi, double thanhTien) {
		super();
		this.maCTPNT = maCTPNT;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
		this.tenThuoc = tenThuoc;
		this.giaNhap = giaNhap;
		this.hsd = hsd;
		this.donVi = donVi;
		this.thanhTien = thanhTien;
		
	}
	public ChiTietPhieuNhapThuoc() {
		super();
		
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhapThuoc [maCTPNT=" + maCTPNT + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong
				+ ", tenThuoc=" + tenThuoc + ", giaNhap=" + giaNhap + ", hsd=" + hsd + ", donVi=" + donVi
				+ ", thanhTien=" + thanhTien + "]";
	}

	
	
	
	
	

}
