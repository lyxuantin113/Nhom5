package entity;

public class ChiTietPhieuNhapThuoc {
	private PhieuNhapThuoc maPhieuNhap;
	private Thuoc maThuoc;
	private int soLuong;

	public ChiTietPhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietPhieuNhapThuoc(PhieuNhapThuoc maPhieuNhap, Thuoc maThuoc, int soLuong) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public PhieuNhapThuoc getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(PhieuNhapThuoc maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
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
		return "ChiTietPhieuNhapThuoc [maPhieuNhap=" + maPhieuNhap + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong
				+ "]";
	}

}
