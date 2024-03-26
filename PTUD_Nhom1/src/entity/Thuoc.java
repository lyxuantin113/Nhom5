package entity;

import java.sql.Date;

public class Thuoc {
	private String maThuoc, tenThuoc, loaiThuoc, donVi;
	private Date HSD;
	private double giaBan;
	private int soLuongTon;
	private NhaCungCap ncc;

	public Thuoc() {
		// TODO Auto-generated constructor stub
	}

	public Thuoc(String maThuoc, String tenThuoc, String loaiThuoc, String donVi, Date hSD, double giaBan,
			int soLuongTon, NhaCungCap ncc) {
		super();
		this.maThuoc = maThuoc;
		this.tenThuoc = tenThuoc;
		this.loaiThuoc = loaiThuoc;
		this.donVi = donVi;
		HSD = hSD;
		this.giaBan = giaBan;
		this.soLuongTon = soLuongTon;
		this.ncc = ncc;
	}

	public String getMaThuoc() {
		return maThuoc;
	}

	public void setMaThuoc(String maThuoc) {
		this.maThuoc = maThuoc;
	}

	public String getTenThuoc() {
		return tenThuoc;
	}

	public void setTenThuoc(String tenThuoc) {
		this.tenThuoc = tenThuoc;
	}

	public String getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	public Date getHSD() {
		return HSD;
	}

	public void setHSD(Date hSD) {
		HSD = hSD;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSoLuongTon() {
		return soLuongTon;
	}

	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}

	public NhaCungCap getNcc() {
		return ncc;
	}

	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}

	@Override
	public String toString() {
		return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", loaiThuoc=" + loaiThuoc + ", donVi=" + donVi
				+ ", HSD=" + HSD + ", giaBan=" + giaBan + ", soLuongTon=" + soLuongTon + ", ncc=" + ncc + "]";
	}

}
