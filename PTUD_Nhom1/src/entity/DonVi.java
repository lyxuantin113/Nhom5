package entity;

public class DonVi {
	private String maDonVi;
	private String donVi;
	private String quyDoi;
	
	public DonVi(String maDonVi, String donVi, String quyDoi) {
		super();
		this.maDonVi = maDonVi;
		this.donVi = donVi;
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

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public String getQuyDoi() {
		return quyDoi;
	}

	public void setQuyDoi(String quyDoi) {
		this.quyDoi = quyDoi;
	}

	@Override
	public String toString() {
		return "DonVi [maDonVi=" + maDonVi + ", donVi=" + donVi + ", quyDoi=" + quyDoi + "]";
	}
	
	
}
