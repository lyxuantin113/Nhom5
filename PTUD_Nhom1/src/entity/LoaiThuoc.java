package entity;

public class LoaiThuoc {
	private String maLoai;
	private String loaiThuoc;
	private String moTa;
	
	public LoaiThuoc(String maLoai, String loaiThuoc, String moTa) {
		super();
		this.maLoai = maLoai;
		this.loaiThuoc = loaiThuoc;
		this.moTa = moTa;
	}
	
	public LoaiThuoc() {
		super();
	}

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}

	public String getLoaiThuoc() {
		return loaiThuoc;
	}

	public void setLoaiThuoc(String loaiThuoc) {
		this.loaiThuoc = loaiThuoc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public String toString() {
		return "LoaiThuoc [maLoai=" + maLoai + ", loaiThuoc=" + loaiThuoc + ", moTa=" + moTa + "]";
	}
	
	

	
}
