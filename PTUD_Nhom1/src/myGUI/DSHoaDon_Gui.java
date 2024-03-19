package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSHoaDon_Gui extends JPanel {
	
	public DSHoaDon_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Hóa Đơn");
		Font fo = new Font("Times New Roman", Font.BOLD, 24);
		headLb.setFont(fo);
		headLb.setForeground(Color.blue);
		pnHead.add(headLb);
		
//		CENTER	
		JPanel pnCenter = new JPanel();
		
		Box box = Box.createVerticalBox();
		String[] headerTable = "Mã hóa đơn;Mã nhân viên;Tên khách hàng; Số điện thoại KH;Ngày xuất đơn;Tổng thành tiền".split(";");
		DefaultTableModel model = new DefaultTableModel(headerTable, 0);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(model));
		table.setRowHeight(20);

		box.add(Box.createVerticalStrut(10));
		box.add(scroll);
		box.add(Box.createVerticalStrut(10));
		box.setPreferredSize(new Dimension(1000, 550));
		
		pnCenter.add(box);
		
//		End
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		add(pnMain);
	}

}
