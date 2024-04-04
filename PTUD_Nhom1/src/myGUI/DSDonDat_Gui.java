package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSDonDat_Gui extends JPanel {
	
//	Nút Chuyển Qua DS Hóa Đơn ????????????????
	
	public DSDonDat_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Đơn Đặt");
		Font fo = new Font("Times New Roman", Font.BOLD, 24);
		headLb.setFont(fo);
		headLb.setForeground(Color.blue);
		pnHead.add(headLb);
		
//		CENTER	
		JPanel pnCenter = new JPanel();
		
		Box box = Box.createVerticalBox();
		String[] headerTable = "Mã phiếu đặt;Mã nhân viên;Tên khách hàng; Số điện thoại KH;Ngày lập đơn;Ngày nhận hàng;Tổng thành tiền".split(";");
		DefaultTableModel model = new DefaultTableModel(headerTable, 0);
		JTable table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		table.setRowHeight(20);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(model));
		table.setRowHeight(20);

		box.add(Box.createVerticalStrut(10));
		box.add(scroll);
		box.add(Box.createVerticalStrut(10));
		box.setPreferredSize(new Dimension(1000, 520));
		
		pnCenter.add(box);
		
//		SOUTH
		JPanel pnSouth = new JPanel();
		
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
		
		pnSouth.add(tfTim);
		pnSouth.add(btnTim);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnHoanThanh);
		
//		End
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnSouth, BorderLayout.SOUTH);
		add(pnMain);
	}

}
