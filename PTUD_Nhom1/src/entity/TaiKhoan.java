package entity;

public class TaiKhoan {
	private String tenTaiKhoan;
	private String matKhau;
	private NhanVien maNV;

	public TaiKhoan(String tenTaiKhoan, String matKhau, NhanVien maNV) {
		super();
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
		this.maNV = maNV;
	}

	public TaiKhoan() {
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(NhanVien maNV) {
		super();
		this.maNV = maNV;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public NhanVien getMaNV() {
		return maNV;
	}

	public void setMaNV(NhanVien maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return "TaiKhoan [tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + ", maNV=" + maNV + "]";
	}
}
