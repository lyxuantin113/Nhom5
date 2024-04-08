package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSDonDat_Gui extends JPanel {
	
private JComboBox<String> cbbTim;

//	Nút Chuyển Qua DS Hóa Đơn ????????????????
	
	public DSDonDat_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Đơn Đặt");
		Font fo = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		headLb.setFont(fo);
		headLb.setForeground(Color.blue);
		pnHead.add(headLb);
		
//		CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();
//		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableDonDat = new JPanel();
		JPanel pnTableThuoc = new JPanel();

//		Panel Right (Table Các Loại Thuốc Trong Đơn Đang Chọn)
		JLabel lblTableDSThuoc = new JLabel("Danh Sách Thuốc Trong Đơn:");
		lblTableDSThuoc.setFont(fo16);
		Box boxTableDSThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		JTable tblThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tblThuoc = new JTable(modelThuoc));
		tblThuoc.setRowHeight(20);

		boxTableDSThuoc.add(lblTableDSThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));
		boxTableDSThuoc.add(scrollThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));

		pnTableDonDat.add(boxTableDSThuoc);

//		Panel Left (Table Danh Sách Hóa Đơn Tìm Được)
		JLabel lblTableDonDat = new JLabel("Danh Sách Đơn Đặt:");
		lblTableDonDat.setFont(fo16);
		Box boxTableDonDat = Box.createVerticalBox();
		String[] headerDonDat = "Mã đơn;Mã NV;Tên khách;SĐT Khách;Ngày lập;Ngày nhận;Tổng tiền".split(";");
		DefaultTableModel modelDonDat = new DefaultTableModel(headerDonDat, 0);
		JTable tableDonDat = new JTable(modelDonDat);
		JScrollPane scrollDonDat = new JScrollPane();
		scrollDonDat.setViewportView(tableDonDat = new JTable(modelDonDat));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableDonDat.setRowHeight(20);

		boxTableDonDat.add(lblTableDonDat);
		boxTableDonDat.add(Box.createVerticalStrut(10));
		boxTableDonDat.add(scrollDonDat);
		boxTableDonDat.add(Box.createVerticalStrut(10));

		pnTableThuoc.add(boxTableDonDat);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setRightComponent(pnTableDonDat);
		jsplit.setLeftComponent(pnTableThuoc);
		jsplit.setSize(1500,470);
		jsplit.setPreferredSize(new Dimension(950, 470)); // SET CHIỀU CAO TABLE

		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));
		
//		SOUTH
		JPanel pnSouth = new JPanel();
		
		cbbTim = new JComboBox<String>();
		cbbTim.addItem("Mã đơn");
		cbbTim.addItem("Mã Nhân viên");
		cbbTim.addItem("Ngày lập");
		cbbTim.addItem("Ngày nhận");
		cbbTim.setPreferredSize(new Dimension(110, 35));
		
		JTextField tfTim = new JTextField(17);
		tfTim.setPreferredSize(new Dimension(0,35));
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setBackground(new Color(0,160,255));
		btnTim.setPreferredSize(new Dimension(100, 35));
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		JButton btnHoanThanh = new JButton("Hoàn Thành Đơn");
		btnHoanThanh.setBackground(new Color(0,160,255));
		btnHoanThanh.setPreferredSize(new Dimension(150, 35));
		btnHoanThanh.setCursor(new Cursor(Cursor.HAND_CURSOR)); 
		
		pnSouth.add(cbbTim);
		pnSouth.add(tfTim);
		pnSouth.add(btnTim);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnHoanThanh);
		
//		End
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);
		
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnSouth, BorderLayout.SOUTH);
		add(pnMain);
	}

}
