package entity;

public class DanhSachThuoc {
	private Thuoc maThuoc;
	private int soLuong;

	public DanhSachThuoc() {
		// TODO Auto-generated constructor stub
	}

	public DanhSachThuoc(Thuoc maThuoc, int soLuong) {
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
		return "DanhSachThuoc [maThuoc=" + maThuoc + ", soLuong=" + soLuong + "]";
	}

}
