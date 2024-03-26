package test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.ChiTietHoaDon;
import entity.DanhSachThuoc;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Thuoc;

public class TestMain {
	public static void main(String[] args) {
		List<DanhSachThuoc> dst = new ArrayList<DanhSachThuoc>();
		NhaCungCap ncc = new NhaCungCap("ncc1", "TenNCC1", "DiaChi1", "0912233445");
		Thuoc thuoc1 = new Thuoc("t1", "TenThuoc1", "LoaiA", "Vien", Date.valueOf(LocalDate.of(2024, 5, 26)), 12000, 12, ncc);
		Thuoc thuoc2 = new Thuoc("t2", "TenThuoc2", "LoaiB", "Hop", Date.valueOf(LocalDate.of(2025, 1, 12)), 17000, 23, ncc);
		Thuoc thuoc3 = new Thuoc("t3", "TenThuoc3", "LoaiC", "Vi", Date.valueOf(LocalDate.of(2024, 8, 05)), 15000, 54, ncc);
		DanhSachThuoc dst1 = new DanhSachThuoc(thuoc1, 3);
		DanhSachThuoc dst2 = new DanhSachThuoc(thuoc2, 7);
		DanhSachThuoc dst3 = new DanhSachThuoc(thuoc3, 5);
		dst.add(dst1);
		dst.add(dst2);
		dst.add(dst3);
//		System.out.println(dst);
//		Kiểm tra sdt Khach Hàng [findCustomerByID(String sdtKH) trả về KH] 
//		nếu khác null thì cho nó vào khởi tạo HoaDon ở dưới
//		nếu null thì tạo KH (lấy sdt và tên KH trên textField để khởi tạo)
//		TƯƠNG TỰ VỚI NHÂN VIÊN (HOẶC ĐỂ COMBOBOX thì không cần kiểm tra, chỉ cần trả về bằng mã NV)
		KhachHang kh = new KhachHang("0912644366", "Ly Xuan Tin");
		NhanVien nv = new NhanVien("NV1", "TenNV1", "0909090909", "Nhan Vien", "nv1@gmail.com");
		HoaDon hd = new HoaDon("hd1", Date.valueOf(LocalDate.of(2024, 3, 26)), kh, nv);
		ChiTietHoaDon cthd = new ChiTietHoaDon(hd, dst);
		System.out.println(cthd);
	}
}
