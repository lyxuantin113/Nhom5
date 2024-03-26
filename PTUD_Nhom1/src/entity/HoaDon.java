package entity;

import java.sql.Date;

public class HoaDon {
	private String maHD;
	private Date ngayLap;
	private KhachHang khachHang;
	private NhanVien maNV;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHD, Date ngayLap, KhachHang khachHang, NhanVien maNV) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.khachHang = khachHang;
		this.maNV = maNV;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
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

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", khachHang=" + khachHang + ", maNV=" + maNV + "]";
	}

}
