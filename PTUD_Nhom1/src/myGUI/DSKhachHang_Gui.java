package myGUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSKhachHang_Gui extends JPanel{
	public DSKhachHang_Gui() {
		setSize(1070, 600);
		setVisible(true);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		// HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Quản lý khách hàng");
		pnHead.add(lblHead);
		pnMain.add(pnHead);
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(java.awt.Color.BLUE);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b1 = Box.createHorizontalBox();
		
		// Số điện thoại khách hàng
		JLabel lblSDT = new JLabel("Số điện thoại: ");
		lblSDT.setPreferredSize(new Dimension(120, 20));
		JTextField txtSDT = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblSDT);
		b1.add(txtSDT);
		
		// Tên khách hàng
		JLabel lblTen = new JLabel("Tên khách hàng: ");
		lblTen.setPreferredSize(new Dimension(120, 20));
		JTextField txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));
		
		// Button
		JPanel pnButton = new JPanel();
		JButton btnThem = new JButton("Thêm");
		JButton btnXoaTrang = new JButton("Xóa trắng");
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		pnCenterBot.add(pnButton);
		// Table
		String[] headers = {"Số điện thoại", "Tên khách hàng"};
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 350));
		pnCenterBot.add(sp);
		
		pnCenter.add(pnCenterTop);
		pnCenter.add(pnCenterBot);
		
		pnMain.add(pnCenter);
		// Footer
		JPanel pnFooter = new JPanel();
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		JTextField txtTimKiem = new JTextField(20);
		JButton btnTim = new JButton("Tìm");
		JButton btnXoa = new JButton("Xóa");
		
		pnFooter.add(lblTimKiem);
		pnFooter.add(txtTimKiem);
		pnFooter.add(btnTim);
		pnFooter.add(btnXoa);
		pnMain.add(pnFooter);
		
		
		add(pnMain);
	}
}
