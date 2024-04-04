package entity;

import java.sql.Date;

public class PhieuNhapThuoc {
	private String maPhieuNhap;
	private NhaCungCap maNCC;
	private NhanVien maNV;
	private Date ngayGui;
	private Date ngayNhan;

	public PhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}

	public PhieuNhapThuoc(String maPhieuNhap, NhaCungCap maNCC, NhanVien maNV, Date ngayGui, Date ngayNhan) {
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

	public Date getNgayGui() {
		return ngayGui;
	}

	public void setNgayGui(Date ngayGui) {
		this.ngayGui = ngayGui;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	@Override
	public String toString() {
		return "PhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maNCC=" + maNCC + ", maNV=" + maNV + ", ngayGui="
				+ ngayGui + ", ngayNhan=" + ngayNhan + "]";
	}

}
