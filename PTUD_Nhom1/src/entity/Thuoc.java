package entity;

import java.time.LocalDate;

public class Thuoc {
	private String maThuoc, tenThuoc;
	private LoaiThuoc maLoai;
	private DonVi maDonVi;
	private LocalDate HSD;
	private double giaNhap;
	private double giaBan;
	private int soLuongTon;
	private String nuocSanXuat;
	private String maNCC;
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
	public LoaiThuoc getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(LoaiThuoc maLoai) {
		this.maLoai = maLoai;
	}
	public DonVi getMaDonVi() {
		return maDonVi;
	}
	public void setMaDonVi(DonVi maDonVi) {
		this.maDonVi = maDonVi;
	}
	public LocalDate getHSD() {
		return HSD;
	}
	public void setHSD(LocalDate hSD) {
		HSD = hSD;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
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
	public Thuoc(String maThuoc, String tenThuoc, LoaiThuoc maLoai, DonVi maDonVi, LocalDate hSD, double giaNhap,
			double giaBan, int soLuongTon, String nuocSanXuat, String maNCC) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.maLoai = maLoai;
		this.maDonVi = maDonVi;
		HSD = hSD;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.nuocSanXuat = nuocSanXuat;
		this.maNCC = maNCC;
	}
	public Thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", maLoai=" + maLoai + ", maDonVi=" + maDonVi
				+ ", HSD=" + HSD + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon
				+ ", nuocSanXuat=" + nuocSanXuat + ", maNCC=" + maNCC + "]";
	}

	

}
