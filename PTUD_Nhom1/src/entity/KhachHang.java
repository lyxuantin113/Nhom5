package entity;

public class KhachHang {
	private String maKH;
	private String soDienThoai;
	private String hoTen;

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String maKH, String soDienThoai, String hoTen) {
		super();
		this.maKH = maKH;
		this.soDienThoai = soDienThoai;
		this.hoTen = hoTen;
	}

	public KhachHang(String maKH, String hoTen) {
		super();
		this.maKH = maKH;
		this.hoTen = hoTen;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
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
		return "KhachHang [maKH=" + maKH + ", soDienThoai=" + soDienThoai + ", hoTen=" + hoTen + "]";
	}

}
