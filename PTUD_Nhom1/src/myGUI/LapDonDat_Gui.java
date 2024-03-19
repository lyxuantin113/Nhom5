package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class LapDonDat_Gui extends JPanel{
	public LapDonDat_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Lập Phiếu Đặt Thuốc");
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

//		Panel Left (Table Đơn Đặt)
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
		jsplit.setPreferredSize(new Dimension(1000, 350)); // SET CHIỀU CAO TABLE

		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));

//		TOTAL AND CREATE
		JPanel pnEndHD = new JPanel();
		pnEndHD.setLayout(new BoxLayout(pnEndHD, BoxLayout.X_AXIS));

		Box containerBox = Box.createVerticalBox();
		
		Box boxTong = Box.createHorizontalBox();
		Box boxMa = Box.createHorizontalBox();

//		BOX1 Tổng - Ngày Lập - Ngày Nhận - Mã Đơn
//		Tổng thành tiền
		JLabel lbTong = new JLabel("Tổng thành tiền:");
		lbTong.setPreferredSize(new Dimension(100, 0));
		JTextField tfTong = new JTextField();
		tfTong.setPreferredSize(new Dimension(getWidth(), 25)); // SET ĐỘ RỘNG JTEXTFIELD
		tfTong.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(15));
		boxTong.add(lbTong);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(tfTong);
		boxTong.add(Box.createHorizontalStrut(15));
		
//		Ngày Lập
		JLabel lbNgayLap = new JLabel("Ngày Lập HD: ");
		lbNgayLap.setPreferredSize(new Dimension(90, 0));
		JTextField tfNgayLap = new JTextField();
		tfNgayLap.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(15));
		boxTong.add(lbNgayLap);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(tfNgayLap);
		boxTong.add(Box.createHorizontalStrut(15));
		
//		Ngày Nhận
		JLabel lbNgayNhan = new JLabel("Ngày Nhận: ");
		lbNgayNhan.setPreferredSize(new Dimension(80, 0));
		JTextField tfNgayNhan = new JTextField();
		boxTong.add(Box.createHorizontalStrut(15));
		boxTong.add(lbNgayNhan);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(tfNgayNhan);
		boxTong.add(Box.createHorizontalStrut(15));

//		Mã Đơn Đặt
		JLabel lbMaHD = new JLabel("Mã Phiếu:");
		lbTong.setPreferredSize(new Dimension(100, 0));
		JTextField tfMaHD = new JTextField();
		boxTong.add(Box.createHorizontalStrut(15));
		boxTong.add(lbMaHD);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(tfMaHD);
		boxTong.add(Box.createHorizontalStrut(15));

//		BOX2 Mã NV - Tên KH - SDT Khách Hàng
//		Tên Khách Hàng
		JLabel lbTenKH = new JLabel("Tên KH: ");
		lbTenKH.setPreferredSize(new Dimension(55, 0));
		JTextField tfTenKH = new JTextField();
		tfTenKH.setPreferredSize(new Dimension(0, 25));
		boxMa.add(Box.createHorizontalStrut(25));
		boxMa.add(lbTenKH);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfTenKH);
		boxMa.add(Box.createHorizontalStrut(20));

//		Số Điện Thoại KH
		JLabel lbSDT = new JLabel("Số ĐT Khách:");
		lbSDT.setPreferredSize(new Dimension(80, 0));
		JTextField tfSDT = new JTextField();
		boxMa.add(Box.createHorizontalStrut(20));
		boxMa.add(lbSDT);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfSDT);
		boxMa.add(Box.createHorizontalStrut(25));
		
//		Mã NV
		JLabel lbMaNV = new JLabel("Mã NV: ");
		lbMaNV.setPreferredSize(new Dimension(55, 0));
		JTextField tfMaNV = new JTextField();
		boxMa.add(Box.createHorizontalStrut(20));
		boxMa.add(lbMaNV);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfMaNV);
		boxMa.add(Box.createHorizontalStrut(20));

//		add Box1 Box2
		containerBox.add(boxTong);
		containerBox.add(Box.createVerticalStrut(15));
		containerBox.add(boxMa);
		
		pnEndHD.add(containerBox);
		
//		BUTTON LẬP HÓA ĐƠN
		JPanel pnSouth = new JPanel();
		JButton btnLap = new JButton("Lập Phiếu Đặt");
		btnLap.setBackground(new Color(0, 160, 255));
		btnLap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLap.setPreferredSize(new Dimension(150, 35));
		pnSouth.add(btnLap);

//		Add Center
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);
		pnCenter.add(pnEndHD, BorderLayout.SOUTH);
		pnCenter.add(Box.createVerticalStrut(20));

//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);

//		END
		add(pnMain);
	}
}
