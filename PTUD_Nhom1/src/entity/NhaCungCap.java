package entity;

public class NhaCungCap {
	private String maNCC;
	private String tenNCC, diaChiNCC, sdtNCC;

	public NhaCungCap() {
		// TODO Auto-generated constructor stub
	}

	public NhaCungCap(String maNCC, String tenNCC, String diaChiNCC, String sdtNCC) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChiNCC = diaChiNCC;
		this.sdtNCC = sdtNCC;
	}

	public NhaCungCap(String maNCC2) {
		this.maNCC = maNCC2;
	}

	public String getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChiNCC() {
		return diaChiNCC;
	}

	public void setDiaChiNCC(String diaChiNCC) {
		this.diaChiNCC = diaChiNCC;
	}

	public String getSdtNCC() {
		return sdtNCC;
	}

	public void setSdtNCC(String sdtNCC) {
		this.sdtNCC = sdtNCC;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNCC=" + maNCC + ", tenNCC=" + tenNCC + ", diaChiNCC=" + diaChiNCC + ", sdtNCC=" + sdtNCC
				+ "]";
	}

}
