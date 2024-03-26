package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.HoaDon_Dao;
import entity.HoaDon;

public class DSHoaDon_Gui extends JPanel implements ActionListener {
	DefaultTableModel model;
	private HoaDon_Dao dshd = new HoaDon_Dao();
	
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
		model = new DefaultTableModel(headerTable, 0);
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
		
//		Show All HoaDon in Table
//		dshd.readFromTable();
//		showTable();
	}
	
//	Show Table
	private void showTable() {
		for (HoaDon hd : dshd.getDSHD()) {
			String[] dataRow = {hd.getMaHD(), hd.getNgayLap()+"", hd.getKhachHang()+"", hd.getMaNV()+""};
			model.addRow(dataRow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
