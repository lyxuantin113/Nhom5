package entity;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class KhachHang {
	private static final String PREFIX = "KH";

	private String maKH;
	private String soDienThoai;
	private String hoTen;

	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(String soDienThoai, String hoTen) {
		super();
		this.maKH = PREFIX + generateRandomCode(5);
		this.soDienThoai = soDienThoai;
		this.hoTen = hoTen;
	}

	public KhachHang(String maKH, String soDienThoai, String hoTen) {
		super();
		this.maKH = maKH;
		this.soDienThoai = soDienThoai;
		this.hoTen = hoTen;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH() {
		this.maKH = PREFIX + generateRandomCode(5);
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

	public static String generateRandomCode(int length) {
		String characters = "0123456789"; // Các ký tự được chấp nhận
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(characters.length());
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", soDienThoai=" + soDienThoai + ", hoTen=" + hoTen + "]";
	}

}
