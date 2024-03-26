package entity;

public class ChiTietPhieuDatThuoc {
	private PhieuDatThuoc maPD;
	private Thuoc maThuoc;
	private int soLuong;

	public ChiTietPhieuDatThuoc() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietPhieuDatThuoc(PhieuDatThuoc maPD, Thuoc maThuoc, int soLuong) {
		super();
		this.maPD = maPD;
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
	}

	public PhieuDatThuoc getMaPD() {
		return maPD;
	}

	public void setMaPD(PhieuDatThuoc maPD) {
		this.maPD = maPD;
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
		return "ChiTietPhieuDatThuoc [maPD=" + maPD + ", maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}

}
