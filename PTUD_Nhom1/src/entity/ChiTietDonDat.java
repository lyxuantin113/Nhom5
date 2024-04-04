package entity;

public class ChiTietDonDat {
	private Thuoc maThuoc;
	private int soLuong;

	public ChiTietDonDat() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietDonDat(Thuoc maThuoc, int soLuong) {
		super();
		this.maThuoc = maThuoc;
		this.soLuong = soLuong;
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
		return "ChiTietPhieuDatThuoc [maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}

}
