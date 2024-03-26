package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LapHoaDon_Gui extends JPanel {

	public LapHoaDon_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Lập Hóa Đơn");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		headLb.setFont(fo24);
		headLb.setForeground(Color.blue);
		headPn.add(headLb);

//		CENTER

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();
//		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

		Box boxNhap = Box.createHorizontalBox();

//		Mã Thuốc
		JLabel lbMaThuoc = new JLabel("Mã Thuốc: ");
		lbMaThuoc.setPreferredSize(new Dimension(90, 0));
		JTextField tfMaThuoc = new JTextField(15);

		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbMaThuoc);
		boxNhap.add(Box.createHorizontalStrut(10));
		boxNhap.add(tfMaThuoc);
		boxNhap.add(Box.createHorizontalStrut(30));

//		Số lượng
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setPreferredSize(lbMaThuoc.getPreferredSize());
		JTextField tfSoLuong = new JTextField(15);
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbSoLuong);
		boxNhap.add(Box.createHorizontalStrut(10));
		boxNhap.add(tfSoLuong);
		boxNhap.add(Box.createHorizontalStrut(30));

//		BUTTON Thêm thuốc vào danh sách
		JButton btnThem = new JButton("Thêm");
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(btnThem);
		btnThem.setBackground(new Color(0, 160, 255));
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boxNhap.add(Box.createHorizontalStrut(30));

		pnCenterTop.add(boxNhap);

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableHoaDon = new JPanel();
		JPanel pnTableThuoc = new JPanel();

//		Panel Left (Table Hóa Đơn)
		JLabel lbTableHoaDon = new JLabel("Đơn Thuốc:");
		lbTableHoaDon.setFont(fo16);
		Box boxTableHoaDon = Box.createVerticalBox();
		String[] headerHoaDon = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		JTable tableHoaDon = new JTable(modelHoaDon);
		JScrollPane scrollHoaDon = new JScrollPane();
		scrollHoaDon.setViewportView(tableHoaDon = new JTable(modelHoaDon));
		tableHoaDon.setRowHeight(20);

		boxTableHoaDon.add(lbTableHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));
		boxTableHoaDon.add(scrollHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));

		pnTableHoaDon.add(boxTableHoaDon);

//		Panel Right (Table Thuốc)
		JLabel lbTableThuoc = new JLabel("Danh Sách Thuốc:");
		lbTableThuoc.setFont(fo16);
		Box boxTableThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Đơn giá;HSD".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		JTable tableThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tableThuoc = new JTable(modelThuoc));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableThuoc.setRowHeight(20);

		boxTableThuoc.add(lbTableThuoc);
		boxTableThuoc.add(Box.createVerticalStrut(10));
		boxTableThuoc.add(scrollThuoc);
		boxTableThuoc.add(Box.createVerticalStrut(10));

		pnTableThuoc.add(boxTableThuoc);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setLeftComponent(pnTableHoaDon);
		jsplit.setRightComponent(pnTableThuoc);
		jsplit.setPreferredSize(new Dimension(1000, 330)); // SET CHIỀU CAO TABLE

		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));

//		TOTAL AND CREATE
		JPanel pnEndHD = new JPanel();
		pnEndHD.setLayout(new BoxLayout(pnEndHD, BoxLayout.X_AXIS));

		JPanel pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		pnBox.setBorder(BorderFactory.createTitledBorder("Thông Tin Hóa Đơn"));
		Box boxTong = Box.createHorizontalBox();
		Box boxMa = Box.createHorizontalBox();
		Box boxKH = Box.createHorizontalBox();
		
//		BOX1 Tổng - Ngày Lập
//		Tổng thành tiền
		JLabel lbTong = new JLabel("Tổng thành tiền:");
		lbTong.setPreferredSize(new Dimension(100, 30));
		JTextField tfTong = new JTextField(20);
		tfTong.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(lbTong);
		boxTong.add(tfTong);
		
//		Ngày Lập
		JLabel lbNgayLap = new JLabel("Ngày Lập HD: ");
		lbNgayLap.setPreferredSize(new Dimension(100, 30));
		JTextField tfNgayLap = new JTextField(20);
		tfNgayLap.setText(LocalDate.now().toString());
		tfNgayLap.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(30));
		boxTong.add(lbNgayLap);
		boxTong.add(tfNgayLap);

		pnBox.add(boxTong);
		pnBox.add(Box.createVerticalStrut(10));

//		BOX2 Tên KH - SDT Khách Hàng
//		Tên Khách Hàng
		JLabel lbKH = new JLabel("Tên Khách: ");
		lbKH.setPreferredSize(new Dimension(100, 30));
		JTextField tfKH = new JTextField(20);
		boxKH.add(Box.createHorizontalStrut(10));
		boxKH.add(lbKH);
		boxKH.add(tfKH);

//		Số Điện thoại Khách
		JLabel lbSDT = new JLabel("Số ĐT Khách:");
		lbSDT.setPreferredSize(new Dimension(100, 30));
		JTextField tfSDT = new JTextField(20);
		boxKH.add(Box.createHorizontalStrut(30));
		boxKH.add(lbSDT);
		boxKH.add(tfSDT);
		pnBox.add(boxKH);
		pnBox.add(Box.createVerticalStrut(10));

//		BOX3 Mã Hóa Đơn - Mã NV
//		Mã Hóa Đơn
		JLabel lbMaHD = new JLabel("Mã Hóa Đơn:");
		lbMaHD.setPreferredSize(new Dimension(100, 30));
		JTextField tfMaHD = new JTextField(20);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(lbMaHD);
		boxMa.add(tfMaHD);
		
//		Mã NV
		JLabel lbNV = new JLabel("Mã Nhân Viên:");
		lbNV.setPreferredSize(new Dimension(100, 30));
		JTextField tfNV = new JTextField(20);
		boxMa.add(Box.createHorizontalStrut(30));
		boxMa.add(lbNV);
		boxMa.add(tfNV);
		pnBox.add(boxMa);
		pnBox.add(Box.createHorizontalStrut(10));
		pnBox.add(Box.createVerticalStrut(10));


//		BUTTON LẬP HÓA ĐƠN
		JPanel pnSouth = new JPanel();
		JButton btnLap = new JButton("Lập hóa đơn");
		btnLap.setBackground(new Color(0, 160, 255));
		btnLap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLap.setPreferredSize(new Dimension(110, 35));
		pnSouth.add(btnLap);

//		ADD Center Panel
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);
		pnCenter.add(pnBox, BorderLayout.SOUTH);
		pnCenter.add(Box.createVerticalStrut(15));

//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);
//		END
		add(pnMain);
	}
}
