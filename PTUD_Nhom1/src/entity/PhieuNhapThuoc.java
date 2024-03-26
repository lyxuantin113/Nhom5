package entity;

import java.sql.Date;

public class PhieuNhapThuoc {
	private String maPhieuNhap;
	private NhaCungCap maNCC;
	private NhanVien maNV;
	private Date ngayNhap;

	public PhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}

	public PhieuNhapThuoc(String maPhieuNhap, NhaCungCap maNCC, NhanVien maNV, Date ngayNhap) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maNCC = maNCC;
		this.maNV = maNV;
		this.ngayNhap = ngayNhap;
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

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Override
	public String toString() {
		return "PhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maNCC=" + maNCC + ", maNV=" + maNV + ", ngayNhap="
				+ ngayNhap + "]";
	}

}
