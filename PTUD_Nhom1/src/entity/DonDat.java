package entity;

import java.sql.Date;
import java.util.List;

public class DonDat {
	private String maDonDat;
	private KhachHang maKH;
	private NhanVien maNV;
	private Date ngayLap, ngayNhan;
	private List<ChiTietDonDat> ctdd;

	public DonDat() {
		// TODO Auto-generated constructor stub
	}

	public DonDat(String maPD, KhachHang khachHang, NhanVien maNV, Date ngayLap, Date ngayNhan,
			List<ChiTietDonDat> ctdd) {
		super();
		this.maDonDat = maPD;
		this.maKH = khachHang;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.ctdd = ctdd;
	}

	public String getMaDonDat() {
		return maDonDat;
	}

	public void setMaDonDat(String maDonDat) {
		this.maDonDat = maDonDat;
	}

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
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

	public List<ChiTietDonDat> getCtdd() {
		return ctdd;
	}

	public void setCtdd(List<ChiTietDonDat> ctdd) {
		this.ctdd = ctdd;
	}

	@Override
	public String toString() {
		return "DonDat [maPD=" + maDonDat + ", khachHang=" + maKH + ", maNV=" + maNV + ", ngayLap=" + ngayLap
				+ ", ngayNhan=" + ngayNhan + ", ctdd=" + ctdd + "]";
	}

}
