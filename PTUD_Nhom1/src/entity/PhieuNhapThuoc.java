package entity;

import java.sql.Date;
import java.time.LocalDate;

public class PhieuNhapThuoc {
	private String maPhieuNhap;
	private NhaCungCap maNCC;
	private NhanVien maNV;
	private LocalDate ngayGui;
	private LocalDate ngayNhan;

	public PhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}

	public PhieuNhapThuoc(String maPhieuNhap, NhaCungCap maNCC, NhanVien maNV, LocalDate ngayGui, LocalDate ngayNhan) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngayGui = ngayGui;
		this.ngayNhan = ngayNhan;
	}

	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public NhaCungCap getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(NhaCungCap maNCC) {
		this.maNCC = maNCC;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public LocalDate getNgayGui() {
		return ngayGui;
	}

	public void setNgayGui(LocalDate ngayGui) {
		this.ngayGui = ngayGui;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	@Override
	public String toString() {
		return "PhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maNCC=" + maNCC + ", maNV=" + maNV + ", ngayGui="
				+ ngayGui + ", ngayNhan=" + ngayNhan + "]";
	}

}
