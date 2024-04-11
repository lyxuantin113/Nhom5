package entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class DonDat {
	private static final String PREFIX = "DD";

	private String maDonDat;
	private KhachHang maKH;
	private NhanVien maNV;
	private LocalDate ngayLap, ngayNhan;
	private List<ChiTietDonDat> listChiTietDonDat;

	public DonDat() {
		// TODO Auto-generated constructor stub
	}

	public DonDat(String maDonDat, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan) {
		super();
		this.maDonDat = maDonDat;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public DonDat(String maDonDat, KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietDonDat> listChiTietDonDat) {
		super();
		this.maDonDat = maDonDat;
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTietDonDat = listChiTietDonDat;
	}

	public DonDat(KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan,
			List<ChiTietDonDat> listChiTietDonDat) {
		super();
		this.maDonDat = PREFIX + generateRandomCode(5);
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
		this.listChiTietDonDat = listChiTietDonDat;
	}

	public DonDat(KhachHang maKH, NhanVien maNV, LocalDate ngayLap, LocalDate ngayNhan) {
		super();
		this.maDonDat = PREFIX + generateRandomCode(5);
		this.maKH = maKH;
		this.maNV = maNV;
		this.ngayLap = ngayLap;
		this.ngayNhan = ngayNhan;
	}

	public String getMaDonDat() {
		return maDonDat;
	}

	public void setMaDonDat(String maDonDat) {
		this.maDonDat = PREFIX + generateRandomCode(5);
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

	public List<ChiTietDonDat> getListChiTietDonDat() {
		return listChiTietDonDat;
	}

	public void setListChiTietDonDat(List<ChiTietDonDat> listChiTietDonDat) {
		this.listChiTietDonDat = listChiTietDonDat;
	}

	public static String generateRandomCode(int length) {
		String characters = "0123456789"; // Các ký tự được chấp nhận
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "DonDat [maDonDat=" + maDonDat + ", maKH=" + maKH + ", maNV=" + maNV + ", ngayLap=" + ngayLap
				+ ", ngayNhan=" + ngayNhan + ", listChiTietDonDat=" + listChiTietDonDat + "]";
	}

}
