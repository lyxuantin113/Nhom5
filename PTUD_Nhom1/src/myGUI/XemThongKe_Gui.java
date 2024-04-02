package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
	

public class XemThongKe_Gui extends JPanel {
	private JPanel pnlMain;
	private JPanel pnlHead;
	private JLabel lbHead;
	private JPanel pnlCenter;
	private Box boxContainer;
	private Box boxBoLoc;
	private Box boxBoLoc1;
	private Box boxThang;
	private JButton btnThang;
	private JComboBox cbbThang;
	private Box boxQuy;
	private JButton btnQuy;
	private JComboBox cbbQuy;
	private JTextField textQuy;
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

//		Xem theo tháng
		boxThang = Box.createHorizontalBox();
		btnThang = new JButton("Xem theo tháng");
		// Tạo mảng chứa tên các tháng
		String[] months = { "Tháng 1", "Tháng 2", "Tháng 3", "Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7", "Tháng 8",
				"Tháng 9", "Tháng 10", "Tháng 11", "Tháng 12" };
		cbbThang = new JComboBox<>(months);
		btnThang.setMaximumSize(new Dimension(100, 30));
		boxThang.add(btnThang);
		boxThang.add(Box.createHorizontalStrut(5));
		boxThang.add(cbbThang);

//      Xem theo quý
		boxQuy = Box.createHorizontalBox();
		btnQuy = new JButton("Xem theo quý");
		 // Tạo mảng chứa tên các quý
        String[] quys = {"Qúy 1", "Qúy 2", "Qúy 3", "Qúy 4"};
		cbbQuy = new JComboBox<>(quys);
		btnQuy.setMaximumSize(new Dimension(100, 30));
		boxQuy.add(btnQuy);
		boxQuy.add(Box.createHorizontalStrut(5));
		boxQuy.add(cbbQuy);

// 		Xem theo ngày (nhập ngày tháng năm)
		boxNgay = Box.createHorizontalBox();
		lbNgay = new JLabel("Xem theo ngày: ");
		textNgay = new JTextField();
		textNgay.setMaximumSize(new Dimension(500, 30));
		boxNgay.add(lbNgay);
		boxNgay.add(Box.createHorizontalStrut(5));
		boxNgay.add(textNgay);
		
		boxBoLoc1.add(boxThang);
		boxBoLoc1.add(Box.createVerticalStrut(10));
		boxBoLoc1.add(boxQuy);
		boxBoLoc1.add(Box.createVerticalStrut(10));
		boxBoLoc1.add(boxNgay);
		boxBoLoc1.add(Box.createVerticalStrut(10));
		
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
				String[] doiTuongSapXep = { "Nhân viên", "Khách hàng", "Doanh thu", "Lợi thuận", "Số lượng", "Đơn hàng", "Thời gian" };
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
		String[] header = "Khách Hàng ;Nhân viên ;Hóa đơn ;Số lượng; Doanh thu; Lợi thuận; Thời gian".split(";");
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(model));
		scroll.setPreferredSize(new Dimension(700, 450)); // SET CHIỀU CAO TABLE
		table.setRowHeight(20);
		boxTable.add(scroll);
		
		boxContainer.add(boxBoLoc);
		boxContainer.add(boxTable);
		boxBoLoc.setBorder(BorderFactory.createTitledBorder("Bộ lọc"));;
		pnlCenter.add(boxContainer);
		
		pnlMain.add(pnlHead, BorderLayout.NORTH);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		
		add(pnlMain);
	}
}
