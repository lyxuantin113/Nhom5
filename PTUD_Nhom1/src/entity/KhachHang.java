package entity;

public class KhachHang {
	private String soDienThoai;
	private String hoTen;

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String soDienThoai, String hoTen) {
		super();
		this.soDienThoai = soDienThoai;
		this.hoTen = hoTen;
	}

	public KhachHang(String sdtKH) {
		this.soDienThoai = sdtKH;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	@Override
	public String toString() {
		return "KhachHang [soDienThoai=" + soDienThoai + ", hoTen=" + hoTen + "]";
	}

}
