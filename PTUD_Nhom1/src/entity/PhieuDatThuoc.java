package entity;

import java.sql.Date;

public class PhieuDatThuoc {
	private String maPD;
	private KhachHang khachHang;
	private NhanVien maNV;
	private Date ngayLap, ngayNhan;

	public PhieuDatThuoc() {
		// TODO Auto-generated constructor stub
	}

	public PhieuDatThuoc(String maPD, KhachHang khachHang, NhanVien maNV, Date ngayLap, Date ngayNhan) {
		super();
		this.maPD = maPD;
		this.khachHang = khachHang;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public String getMaPD() {
		return maPD;
	}

	public void setMaPD(String maPD) {
		this.maPD = maPD;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	@Override
	public String toString() {
		return "PhieuDatThuoc [maPD=" + maPD + ", khachHang=" + khachHang + ", maNV=" + maNV + ", ngayLap=" + ngayLap
				+ ", ngayNhan=" + ngayNhan + "]";
	}

}
