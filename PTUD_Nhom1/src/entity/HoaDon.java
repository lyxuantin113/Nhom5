package entity;

import java.sql.Date;
import java.util.List;

public class HoaDon {
	private String maHD;
	private Date ngayLap;
	private Date ngayNhan;
	private KhachHang khachHang;
	private NhanVien maNV;
	private List<ChiTietHoaDon> cthd;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHD, Date ngayLap, Date ngayNhan, KhachHang khachHang, NhanVien maNV, List<ChiTietHoaDon> cthd) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.khachHang = khachHang;
		this.maNV = maNV;
		this.cthd = cthd;
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

	public Date getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(Date ngayNhan) {
		this.ngayNhan = ngayNhan;
	}

	public List<ChiTietHoaDon> getCthd() {
		return cthd;
	}

	public void setCthd(List<ChiTietHoaDon> cthd) {
		this.cthd = cthd;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", ngayNhan=" + ngayNhan + ", khachHang=" + khachHang
				+ ", maNV=" + maNV + ", cthd=" + cthd + "]";
	}

}
