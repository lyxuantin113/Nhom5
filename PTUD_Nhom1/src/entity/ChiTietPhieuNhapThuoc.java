package entity;

public class ChiTietPhieuNhapThuoc {
	private PhieuNhapThuoc maPN;
	private Thuoc maThuoc;
	private int soLuong;
	private double giaGoc;

	public ChiTietPhieuNhapThuoc() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietPhieuNhapThuoc(PhieuNhapThuoc maPN, Thuoc maThuoc, int soLuong, double giaGoc) {
		super();
		this.maPN = maPN;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
		this.giaGoc = giaGoc;
	}

	public PhieuNhapThuoc getMaPN() {
		return maPN;
	}

	public void setMaPN(PhieuNhapThuoc maPN) {
		this.maPN = maPN;
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

	public double getGiaGoc() {
		return giaGoc;
	}

	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhapThuoc [maPN=" + maPN + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong + ", giaGoc="
				+ giaGoc + "]";
	}

}
