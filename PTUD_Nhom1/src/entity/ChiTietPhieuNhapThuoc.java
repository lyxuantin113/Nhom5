package entity;

import java.time.LocalDate;

public class ChiTietPhieuNhapThuoc {
	private String maPhieuNhap;
	private String maThuoc;
	private int soLuong;
	private double giaNhap;
	private LocalDate hsd;
	private String donVi;
	private double thanhTien;
	
	
	
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
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
	

	public ChiTietPhieuNhapThuoc(String maPhieuNhap,String maThuoc, int soLuong, double giaNhap, LocalDate hsd,
			String donVi, double thanhTien) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
		
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
		return "ChiTietPhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong
				 +  ", giaNhap=" + giaNhap + ", hsd=" + hsd + ", donVi=" + donVi
				+ ", thanhTien=" + thanhTien + "]";
	}

	
	
	
	
	

}
