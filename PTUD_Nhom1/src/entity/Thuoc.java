package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Thuoc {
	private String maThuoc, tenThuoc, loaiThuoc, donVi;
	private LocalDate HSD;
	private double giaNhap;
	private double giaBan;
	private int soLuongTon;
	private String nuocSanXuat;
	private String maNCC;

	

	public Thuoc(String maThuoc, String tenThuoc, String loaiThuoc, String donVi, LocalDate hSD, double giaNhap,
			double giaBan, int soLuongTon, String nuocSanXuat, String maNCC) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.loaiThuoc = loaiThuoc;
		this.donVi = donVi;
		HSD = hSD;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.nuocSanXuat = nuocSanXuat;
		this.maNCC = maNCC;
	}

	public Thuoc(String maThuoc) {
		super();
		this.maThuoc = maThuoc;
	}

	public String getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public String getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	

	public LocalDate getHSD() {
		return HSD;
	}

	public void setHSD(LocalDate hSD) {
		HSD = hSD;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public String getNuocSanXuat() {
		return nuocSanXuat;
	}

	public void setNuocSanXuat(String nuocSanXuat) {
		this.nuocSanXuat = nuocSanXuat;
	}

	

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", loaiThuoc=" + loaiThuoc + ", donVi=" + donVi
				+ ", HSD=" + HSD + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon
				+ ", nuocSanXuat=" + nuocSanXuat + ", maNCC=" + maNCC + "]";
	}

}
