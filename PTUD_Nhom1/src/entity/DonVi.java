package entity;

public class DonVi {
	private String maDonVi;
	private String tenDonVi;
	private String quyDoi;
	
	public DonVi(String maDonVi, String tenDonVi, String quyDoi) {
		super();
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
		this.quyDoi = quyDoi;
	}
	
	public DonVi() {
		super();
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	public String getQuyDoi() {
		return quyDoi;
	}

	public void setQuyDoi(String quyDoi) {
		this.quyDoi = quyDoi;
	}

	@Override
	public String toString() {
		return "DonVi [maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + ", quyDoi=" + quyDoi + "]";
	}
	
	
}
