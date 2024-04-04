package entity;

import java.sql.Date;
import java.util.List;

public class DonDat {
	private String maPD;
	private KhachHang khachHang;
	private NhanVien maNV;
	private Date ngayLap, ngayNhan;
	private List<ChiTietDonDat> ctdd;

	public DonDat() {
		// TODO Auto-generated constructor stub
	}

	public DonDat(String maPD, KhachHang khachHang, NhanVien maNV, Date ngayLap, Date ngayNhan, List<ChiTietDonDat> ctdd) {
		super();
		this.maPD = maPD;
		this.khachHang = khachHang;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.ctdd = ctdd;
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

	public List<ChiTietDonDat> getCtdd() {
		return ctdd;
	}

	public void setCtdd(List<ChiTietDonDat> ctdd) {
		this.ctdd = ctdd;
	}

	@Override
	public String toString() {
		return "DonDat [maPD=" + maPD + ", khachHang=" + khachHang + ", maNV=" + maNV + ", ngayLap=" + ngayLap
				+ ", ngayNhan=" + ngayNhan + ", ctdd=" + ctdd + "]";
	}

}
