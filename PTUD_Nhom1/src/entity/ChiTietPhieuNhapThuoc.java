package entity;

import java.time.LocalDate;

public class ChiTietPhieuNhapThuoc {
	private PhieuNhapThuoc maPhieuNhap;
	private Thuoc thuoc;
	private int soLuong;
	private double giaNhap;
	private LocalDate hsd;
	private String donVi;
	private double thanhTien;
	
	
	
	
	public PhieuNhapThuoc getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(PhieuNhapThuoc maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	
	public Thuoc getThuoc() {
		return thuoc;
	}
	public void setThuoc(Thuoc thuoc) {
		this.thuoc = thuoc;
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
	public ChiTietPhieuNhapThuoc(PhieuNhapThuoc maPhieuNhap, Thuoc thuoc, int soLuong, double giaNhap, LocalDate hsd,
			String donVi, double thanhTien) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.thuoc = thuoc;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.hsd = hsd;
		this.donVi = donVi;
		this.thanhTien = thanhTien;
	}
	public ChiTietPhieuNhapThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ChiTietPhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", thuoc=" + thuoc + ", soLuong=" + soLuong
				+ ", giaNhap=" + giaNhap + ", hsd=" + hsd + ", donVi=" + donVi + ", thanhTien=" + thanhTien + "]";
	}
	
	
	

	

}
