package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_Dao;
//import dao.ThongKe_Dao;
import db.ConnectDB;
import entity.HoaDon;

public class XemThongKe_Gui extends JPanel implements ActionListener, MouseListener {
	private JPanel pnlMain;
	private JPanel pnlHead;
	private JLabel lbHead;
	private JPanel pnlCenter;
	private Box boxContainer;
	private Box boxBoLoc;
	private Box boxBoLoc1;
	private Box boxThang;
	private JComboBox cbbThang;
	private Box boxNgay;
	private JTextField textNgay;
	private JLabel lbNgay;
	private Box boxBoLoc2;
	private Box boxKhachHang;
	private JButton btnKhachHang;
	private JComboBox cbbKhachHang;
	private Box boxNhanVien;
	private JButton btnNhanVien;
	private JComboBox cbbNhanVien;
	private Box boxSapXep;
	private JButton btnSapXep;
	private JComboBox cbbSapXep;
	private Box boxTable;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane scroll;
	private Box boxNam;
	private JButton btnNam;
	private JComboBox cbbNam;
	private JLabel lbThang;
	private JLabel lbNam;
	private JComboBox cbbNgay;
	private JButton btnXoaRong;
	private Box boxBtn;
	private JButton btnXemThongKe;

//	private ThongKe_Dao dsTK = new ThongKe_Dao();
	private HoaDon_Dao dsHD = new HoaDon_Dao();

	public XemThongKe_Gui() {

//		JPANEL
		pnlMain = new JPanel();
		pnlMain.setLayout(new BorderLayout());

//		HEADER
		pnlHead = new JPanel();
		lbHead = new JLabel("Xem Thống Kê");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		lbHead.setFont(fo24);
		lbHead.setForeground(Color.blue);
		pnlHead.add(lbHead);

//		CENTER
		pnlCenter = new JPanel();

		boxContainer = Box.createVerticalBox();
		boxBoLoc = Box.createHorizontalBox();

//		Bộ lọc 1 (theo thời gian)		
		boxBoLoc1 = Box.createVerticalBox();

//      Xem theo năm
		boxNam = Box.createHorizontalBox();
		lbNam = new JLabel("Xem theo năm: ");
		// Tạo mảng chứa
		cbbNam = new JComboBox<>();
		lbNam.setMaximumSize(new Dimension(100, 30));
		boxNam.add(lbNam);
		boxNam.add(Box.createHorizontalStrut(5));
		boxNam.add(cbbNam);

//		Xem theo tháng
		boxThang = Box.createHorizontalBox();
		lbThang = new JLabel("Xem theo tháng: ");
		// Tạo mảng chứa tên các tháng
		String[] months = { "", "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cbbThang = new JComboBox<>(months);
		lbThang.setMaximumSize(new Dimension(100, 30));
		boxThang.add(lbThang);
		boxThang.add(Box.createHorizontalStrut(5));
		boxThang.add(cbbThang);

// 		Xem theo ngày (nhập ngày tháng năm)
		boxNgay = Box.createHorizontalBox();
		lbNgay = new JLabel("Xem theo ngày: ");
		cbbNgay = new JComboBox<>();
		lbNgay.setMaximumSize(new Dimension(500, 30));
		boxNgay.add(lbNgay);
		boxNgay.add(Box.createHorizontalStrut(5));
		boxNgay.add(cbbNgay);

		boxBtn = Box.createHorizontalBox();
		btnXemThongKe = new JButton("Xem Thống Kê");
		btnXoaRong = new JButton("Xóa Rỗng");
		boxBtn.add(btnXemThongKe);
		boxBtn.add(Box.createHorizontalStrut(5));
		boxBtn.add(btnXoaRong);

		boxBoLoc1.add(boxNam);
		boxBoLoc1.add(Box.createVerticalStrut(10));
		boxBoLoc1.add(boxThang);
		boxBoLoc1.add(Box.createVerticalStrut(10));
		boxBoLoc1.add(boxNgay);
		boxBoLoc1.add(Box.createVerticalStrut(10));
		boxBoLoc1.add(boxBtn);
		boxBoLoc1.setBorder(BorderFactory.createTitledBorder("Thời gian"));

//		Bộ lọc 2 (theo đối tượng)		
		boxBoLoc2 = Box.createVerticalBox();

//		Xem theo Khách hàng
		boxKhachHang = Box.createHorizontalBox();
		btnKhachHang = new JButton("Xem Khách hàng");
		cbbKhachHang = new JComboBox<>();
//		cbbKhachHang.setMaximumSize(new Dimension(200, 30));
		boxKhachHang.add(btnKhachHang);
		boxKhachHang.add(boxBoLoc1.add(Box.createVerticalStrut(5)));
		boxKhachHang.add(cbbKhachHang);

//      Xem theo Nhân viên
		boxNhanVien = Box.createHorizontalBox();
		btnNhanVien = new JButton("Xem Nhân viên");
		cbbNhanVien = new JComboBox<>();
//		btnNhanVien.setMaximumSize(new Dimension(50, 30));
		boxNhanVien.add(btnNhanVien);
		boxNhanVien.add(boxBoLoc1.add(Box.createVerticalStrut(5)));
		boxNhanVien.add(cbbNhanVien);

// 		Sắp xếp theo đối tượng đã chọn
		boxSapXep = Box.createHorizontalBox();
		btnSapXep = new JButton("Sắp xếp theo: ");
		// Tạo mảng chứa tên các đối tượng
		String[] doiTuongSapXep = { "Đơn hàng", "Nhân viên", "Khách hàng", "Số lượng", "Thời gian", "Doanh thu",
				"Lợi nhuận", };
		cbbSapXep = new JComboBox<>(doiTuongSapXep);
//		btnSapXep.setMaximumSize(new Dimension(50, 30));
		boxSapXep.add(btnSapXep);
		boxSapXep.add(boxBoLoc1.add(Box.createVerticalStrut(5)));
		boxSapXep.add(cbbSapXep);

		boxBoLoc2.add(boxKhachHang);
		boxBoLoc2.add(Box.createVerticalStrut(10));
		boxBoLoc2.add(boxNhanVien);
		boxBoLoc2.add(Box.createVerticalStrut(10));
		boxBoLoc2.add(boxSapXep);
		boxBoLoc2.add(Box.createVerticalStrut(10));

		boxBoLoc.add(boxBoLoc1);
		boxBoLoc.add(Box.createHorizontalStrut(250));
		boxBoLoc.add(boxBoLoc2);

		boxTable = Box.createVerticalBox();
		String[] header = "Hóa đơn ;Khách Hàng ;Nhân viên ;Số lượng; Thời gian; Doanh thu; Lợi thuận".split(";");
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(model));
		scroll.setPreferredSize(new Dimension(700, 450)); // SET CHIỀU CAO TABLE
		table.setRowHeight(20);
		boxTable.add(scroll);

		boxContainer.add(boxBoLoc);
		boxContainer.add(boxTable);
		boxBoLoc.setBorder(BorderFactory.createTitledBorder("Bộ lọc"));
		pnlCenter.add(boxContainer);

		pnlMain.add(pnlHead, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);

		add(pnlMain);
		// Action
		btnXoaRong.addActionListener(this);
		btnXemThongKe.addActionListener(this);
		table.addMouseListener(this);
		ConnectDB.connect();
//		hienTable();
		cbbThang.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lấy chỉ số của tháng được chọn
				int selectedMonthIndex = cbbThang.getSelectedIndex();

				// Xác định số ngày tương ứng với tháng được chọn
				int daysInMonth = getDaysInMonth(selectedMonthIndex);

				// Xóa các mục cũ trong Combobox của ngày
				cbbNgay.removeAllItems();
				cbbNgay.addItem("");
				// Thêm các mục mới vào Combobox của ngày
				for (int i = 1; i <= daysInMonth; i++) {

					cbbNgay.addItem(String.valueOf(i));
				}
			}
		});
	}

//
//	 Phương thức thực hiện thống kê và cập nhật dữ liệu lên bảng
//	public void thucHienThongKe(int nam, int thang, int ngay) {
//		// Gọi các phương thức từ DAO để thực hiện thống kê
//
//		// Thống kê doanh thu và lợi nhuận tương ứng
//		double doanhThu, loiNhuan;
//		if (ngay == -1 && thang == -1) { // Thống kê theo năm
//			doanhThu = dsTK.thongKeDoanhThuTheoNam(nam);
//			loiNhuan = dsTK.thongKeLoiNhuanTheoNam(nam);
//		} else if (ngay == -1) { // Thống kê theo tháng
//			doanhThu = dsTK.thongKeDoanhThuTheoThang(thang, nam);
//			loiNhuan = dsTK.thongKeLoiNhuanTheoThang(thang, nam);
//		} else { // Thống kê theo ngày
//			doanhThu = dsTK.thongKeDoanhThuTheoNgay(ngay, thang, nam);
//			loiNhuan = dsTK.thongKeLoiNhuanTheoNgay(ngay, thang, nam);
//		}
//
//		// Hiển thị kết quả lên bảng
//		Object[] rowData = { "", "", "", "", doanhThu, loiNhuan, "" };
//		DefaultTableModel model = (DefaultTableModel) table.getModel();
//		model.addRow(rowData);
//	}
//	 Trong phương thức hienTable()
	public void hienTable() {
		List<HoaDon> danhSachHoaDon = dsHD.readFromTable();

		// Xóa các dòng hiện tại trên bảng trước khi cập nhật dữ liệu mới
		model.setRowCount(0);
		// Khởi tạo danh sách để lưu trữ các mã khách hàng và mã nhân viên
		Set<String> maKhachHangSet = new HashSet<>();
		Set<String> maNhanVienSet = new HashSet<>();
		// Khởi tạo một Set để lưu trữ các năm đã xuất hiện
		Set<Integer> namSet = new HashSet<>();

		// Duyệt qua từng hóa đơn trong danh sách
		for (HoaDon hoaDon : danhSachHoaDon) {
			// Lấy năm từ ngày lập hóa đơn
			int nam = hoaDon.getNgayLap().getYear();
			// Lấy mã khách hàng và mã nhân viên từ hóa đơn
			String maKhachHang = hoaDon.getMaKH().getMaKH();
			String maNhanVien = hoaDon.getMaNV().getMaNV();

			// Thêm năm vào Set
			namSet.add(nam);
			// Thêm mã khách hàng và mã nhân viên vào danh sách (nếu chưa có)
			maKhachHangSet.add(maKhachHang);
			maNhanVienSet.add(maNhanVien);

			// Tính doanh thu và lợi nhuận cho hóa đơn hiện tại
			double doanhThu = dsHD.tinhDoanhThuChoHoaDon(hoaDon);
			double loiNhuan = dsHD.tinhLoiNhuanChoHoaDon(hoaDon);

			// Tạo một mảng chứa các giá trị của hàng
			Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaKH().getMaKH(), hoaDon.getMaNV().getMaNV(),
					hoaDon.getNgayLap().toString(), hoaDon.getNgayNhan().toString(), doanhThu, loiNhuan };

			// Thêm hàng vào bảng
			model.addRow(rowData);
		}
		// Xóa các mục cũ trong Combobox của năm
		cbbNam.removeAllItems();
		// Xóa các lựa chọn cũ trong Combobox của Khách hàng và Nhân viên
		cbbKhachHang.removeAllItems();
		cbbNhanVien.removeAllItems();

		// Thêm các năm từ Set vào Combobox của năm
		for (int nam : namSet) {
			cbbNam.addItem(String.valueOf(nam));
		}
		// Thêm các mã khách hàng vào Combobox của Khách hàng
		for (String maKH : maKhachHangSet) {
			cbbKhachHang.addItem(maKH);
		}

		// Thêm các mã nhân viên vào Combobox của Nhân viên
		for (String maNV : maNhanVienSet) {
			cbbNhanVien.addItem(maNV);
		}
	}

	private int getDaysInMonth(int monthIndex) {
		// Tháng 2 (index = 2) có 28 hoặc 29 ngày tùy theo năm nhuận
		if (monthIndex == 2) {
			int selectedYear = Integer.parseInt(cbbNam.getSelectedItem().toString());
			if (isLeapYear(selectedYear)) {
				return 29;
			} else {
				return 28;
			}
		}
		// Các tháng khác có số ngày như sau:
		else if (monthIndex == 4 || monthIndex == 6 || monthIndex == 9 || monthIndex == 11) {
			return 30;
		} else {
			return 31;
		}
	}

	// Phương thức để kiểm tra năm nhuận
	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnXemThongKe) {

		}
		if (e.getSource() == btnXoaRong) {
			// Xóa rỗng Combobox của năm
			cbbNam.setSelectedIndex(-1);

			// Xóa rỗng Combobox của tháng
			cbbThang.setSelectedIndex(0);

			// Xóa rỗng Combobox của ngày
			cbbNgay.setSelectedIndex(-1);

			// Xóa rỗng Combobox của Khách hàng
			cbbKhachHang.setSelectedIndex(-1);

			// Xóa rỗng Combobox của Nhân viên
			cbbNhanVien.setSelectedIndex(-1);

			// Xóa rỗng Combobox của Sắp xếp
			cbbSapXep.setSelectedIndex(0);
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
