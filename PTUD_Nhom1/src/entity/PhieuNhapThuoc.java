package entity;

import java.sql.Date;

public class PhieuNhapThuoc {
	private String maPhieuNhap;
	private String maNCC;
	private String maNV;
	private ChiTietPhieuNhapThuoc chiTietPhieuNhapThuoc;
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
	public ChiTietPhieuNhapThuoc getChiTietPhieuNhapThuoc() {
		return chiTietPhieuNhapThuoc;
	}
	public void setChiTietPhieuNhapThuoc(ChiTietPhieuNhapThuoc chiTietPhieuNhapThuoc) {
		this.chiTietPhieuNhapThuoc = chiTietPhieuNhapThuoc;
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
	public PhieuNhapThuoc(String maPhieuNhap, String maNCC, String maNV, ChiTietPhieuNhapThuoc chiTietPhieuNhapThuoc,
			Double tongTien, Boolean trangThai) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.chiTietPhieuNhapThuoc = chiTietPhieuNhapThuoc;
		this.tongTien = tongTien;
		this.trangThai = trangThai;
	}
	public PhieuNhapThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "PhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maNCC=" + maNCC + ", maNV=" + maNV
				+ ", chiTietPhieuNhapThuoc=" + chiTietPhieuNhapThuoc + ", tongTien=" + tongTien + ", trangThai="
				+ trangThai + "]";
	}
	
	
	

}
