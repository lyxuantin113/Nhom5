package entity;

import java.sql.Date;
import java.time.LocalDate;

public class PhieuNhapThuoc {
	private String maPhieuNhap;
	private String maNCC;
	private String maNV;
	private LocalDate ngayNhap;
	public LocalDate getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	private Double tongTien;
	private Boolean trangThai;
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	
	public Double getTongTien() {
		return tongTien;
	}
	public void setTongTien(Double tongTien) {
		this.tongTien = tongTien;
	}
	public Boolean getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(Boolean trangThai) {
		this.trangThai = trangThai;
	}
	public PhieuNhapThuoc(String maPhieuNhap, String maNCC, String maNV, LocalDate ngayNhap, Double tongTien,
			Boolean trangThai) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}
	
	public PhieuNhapThuoc() {
		super();
	}
	
	
	

}
