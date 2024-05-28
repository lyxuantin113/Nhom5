package entity;

public class DonVi {
	private String maDonVi;
	private String donVi;
	
	public DonVi(String maDonVi, String donVi) {
		super();
		this.maDonVi = maDonVi;
		this.donVi = donVi;
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


	@Override
	public String toString() {
		return "DonVi [maDonVi=" + maDonVi + ", donVi=" + donVi +"]";
	}
	
	
}
