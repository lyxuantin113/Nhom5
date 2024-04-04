package entity;

public class NhanVien {
	private String maNV;
	private String tenNV, sdtNV, chucVu, email;

	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String maNV, String tenNV, String sdtNV, String chucVu, String email) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.sdtNV = sdtNV;
		this.chucVu = chucVu;
		this.email = email;
	}

	public NhanVien(String maNV2) {
		this.maNV = maNV2;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getSdtNV() {
		return sdtNV;
	}

	public void setSdtNV(String sdtNV) {
		this.sdtNV = sdtNV;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", sdtNV=" + sdtNV + ", chucVu=" + chucVu + ", email="
				+ email + "]";
	}

}
