package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameDanhSach extends JFrame {
	
	public static void main(String[] args) {
		new FrameDanhSach();
	}
	
	public FrameDanhSach() {
		
//		JFRAME
		super("Quản lý hóa đơn");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(1070, 600);
		setVisible(true);
		
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
		box.setPreferredSize(new Dimension(getWidth()-100, getHeight()-100));
		
		pnCenter.add(box);
		
//		End
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		add(pnMain);
	}
}
