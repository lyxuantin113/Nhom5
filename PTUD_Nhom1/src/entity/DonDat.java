package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DonDat {
	private static final String PREFIX = "DD";
    private static final AtomicInteger counter = new AtomicInteger(0);
    
	private String maDonDat;
	private KhachHang maKH;
	private NhanVien maNV;
	private LocalDate ngayLap, ngayNhan;
	private List<ChiTietDonDat> ctdd;

	public DonDat() {
		// TODO Auto-generated constructor stub
	}

	public DonDat(KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan, List<ChiTietDonDat> ctdd) {
		super();
		this.maDonDat = PREFIX + counter.incrementAndGet();
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.ctdd = ctdd;
	}

	public DonDat(String maPD, KhachHang khachHang, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
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

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) {
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
