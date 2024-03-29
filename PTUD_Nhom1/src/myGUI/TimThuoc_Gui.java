package myGUI;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TimThuoc_Gui extends JPanel{
	public TimThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		// HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Thêm nhà cung cấp");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
//		pnHead.add(Box.createVerticalStrut(30));
		
		pnMain.add(pnHead, BorderLayout.NORTH);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		
		// Mã NCC
		JLabel lblMa = new JLabel("Mã NCC: ");
		lblMa.setPreferredSize(new Dimension(90, 20));
		JTextField txtMa = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMa);
		b1.add(txtMa);
		// Tên NCC
		JLabel lblTen = new JLabel("Tên NCC: ");
		lblTen.setPreferredSize(new Dimension(90, 20));
		JTextField txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);
		
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Địa chỉ
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setPreferredSize(new Dimension(90, 20));
		JTextField txtDiaChi = new JTextField(20);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblDiaChi);
		b2.add(txtDiaChi);
		// SĐT
		JLabel lblSDT = new JLabel("SĐT: ");
		lblSDT.setPreferredSize(new Dimension(90, 20));
		JTextField txtSDT = new JTextField(20);
		b2.add(Box.createHorizontalStrut(10));
			
		b2.add(lblSDT);
		b2.add(txtSDT);
		pnCenterTop.add(b2);
		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin nhà cung cấp"));
		// Button
		JPanel pnButton = new JPanel();
		JButton btnThem = new JButton("Thêm");
		JButton btnXoaTrang = new JButton("Xóa trắng");
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		b3.add(pnButton);
		pnCenterTop.add(b3);
		// Table
		String[] headers = {"Mã NCC", "Tên NCC", "Địa chỉ", "SĐT"};
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		pnCenterBot.add(sp);
		pnCenter.add(Box.createVerticalStrut(10));
		
		pnCenter.add(pnCenterTop);
		pnCenter.add(pnCenterBot);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		// FOOTER
		JPanel pnFoot = new JPanel();
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		JTextField txtTimKiem = new JTextField(20);
		JButton btnTim = new JButton("Tìm");
		JButton btnXoa = new JButton("Xóa");
		pnFoot.add(lblTimKiem);
		pnFoot.add(txtTimKiem);
		pnFoot.add(btnTim);
		pnFoot.add(btnXoa);
		pnMain.add(pnFoot, BorderLayout.SOUTH);
		
		add(pnMain);
	}
}
