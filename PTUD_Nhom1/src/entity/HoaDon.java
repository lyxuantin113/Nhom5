package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class HoaDon {
	private static final String PREFIX = "HD";
	private static final AtomicInteger counter = new AtomicInteger(0);

	private String maHoaDon;
	private KhachHang maKH;
	private NhanVien maNV;
	private LocalDate ngayLap;
	private LocalDate ngayNhan;
	private List<ChiTietHoaDon> cthd;

	public HoaDon() {
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietHoaDon> cthd) {
		super();
		this.maHoaDon = maHoaDon;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.cthd = cthd;
	}

	public HoaDon(KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan, List<ChiTietHoaDon> cthd) {
		super();
		this.maHoaDon = PREFIX + counter.incrementAndGet();
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.cthd = cthd;
	}

	public LocalDate getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(LocalDate ngayLap) {
		this.ngayLap = ngayLap;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	public LocalDate getNgayNhan() {
		return ngayNhan;
	}

	public void setNgayNhan(LocalDate ngayNhan) {
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

	public KhachHang getMaKH() {
		return maKH;
	}

	public void setMaKH(KhachHang maKH) {
		this.maKH = maKH;
	}

	@Override
	public String toString() {
		String hoaDonString = "HoaDon [maHoaDon=" + maHoaDon + ", maKH=" + maKH + ", maNV=" + maNV + ", ngayLap=" + ngayLap
				+ ", ngayNhan=" + ngayNhan + ", cthd=" ;
		
		for (ChiTietHoaDon chiTietHoaDon : cthd) {
			hoaDonString+=chiTietHoaDon.toString();
		}
		
		return hoaDonString+ "] ";
	}

}
