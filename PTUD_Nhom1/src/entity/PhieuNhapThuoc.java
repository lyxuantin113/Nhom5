package entity;

import java.sql.Date;
import java.time.LocalDate;

public class PhieuNhapThuoc {
	private String maPhieuNhap;
	private NhaCungCap nhaCungCap;
	private NhanVien nhanVien;
	private LocalDate ngayNhap;
	private Double tongTien;
	private Boolean trangThai;
	
	public LocalDate getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}
	
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
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
	
	public PhieuNhapThuoc(String maPhieuNhap, NhaCungCap nhaCungCap, NhanVien nhanVien, LocalDate ngayNhap,
			Double tongTien, Boolean trangThai) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.nhaCungCap = nhaCungCap;
		this.nhanVien = nhanVien;
		this.ngayNhap = ngayNhap;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}
	public PhieuNhapThuoc() {
		super();
	}
	
	
	

}
