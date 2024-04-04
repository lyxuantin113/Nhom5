package entity;

import java.sql.Date;
import java.util.List;

public class HoaDon {
	private String maHoaDon;
	private KhachHang maKH;
	private NhanVien maNV;
	private Date ngayLap;
	private Date ngayNhan;
	private List<ChiTietHoaDon> cthd;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public HoaDon(String maHoaDon, KhachHang maKH, NhanVien maNV, Date ngayLap, Date ngayNhan,
			List<ChiTietHoaDon> cthd) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.cthd = cthd;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
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

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", maKH=" + maKH + ", maNV=" + maNV + ", ngayLap=" + ngayLap
				+ ", ngayNhan=" + ngayNhan + ", cthd=" + cthd + "]";
	}

}
