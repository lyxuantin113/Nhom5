package entity;

import java.time.LocalDate;

public class Thuoc {
	private String maThuoc, tenThuoc;
	private String maLoai;
	private String maDonVi;
	private LocalDate HSD;
	private double giaNhap;
	private double giaBan;
	private int soLuongTon;
	private String nuocSanXuat;
	private String maNCC;

	

	public Thuoc(String maThuoc, String tenThuoc, String maLoai, String maDonVi, LocalDate hSD, double giaNhap,
			double giaBan, int soLuongTon, String nuocSanXuat, String maNCC) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.maLoai = maLoai;
		this.maDonVi = maDonVi;
		this.HSD = hSD;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.nuocSanXuat = nuocSanXuat;
		this.maNCC = maNCC;
	}

	public Thuoc() {
		super();
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
		return maLoai;
	}

	public void setLoaiThuoc(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getDonVi() {
		return maDonVi;
	}

	public void setDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
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
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", loaiThuoc=" + maLoai + ", donVi=" + maDonVi
				+ ", HSD=" + HSD + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon
				+ ", nuocSanXuat=" + nuocSanXuat + ", maNCC=" + maNCC + "]";
	}

}
