package entity;

public class ChiTietDonDat {
	private DonDat maDonDat;
	private Thuoc maThuoc;
	private int soLuong;

	public ChiTietDonDat() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietDonDat(DonDat maDonDat, Thuoc maThuoc, int soLuong) {
		super();
		this.maDonDat = maDonDat;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public DonDat getMaDonDat() {
		return maDonDat;
	}

	public void setMaDonDat(DonDat maDonDat) {
		this.maDonDat = maDonDat;
	}

	public Thuoc getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(Thuoc maThuoc) {
		this.maThuoc = maThuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietDonDat [maDonDat=" + maDonDat + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}

}
