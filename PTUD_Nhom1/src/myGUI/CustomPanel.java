package myGUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomPanel extends JPanel {
    public CustomPanel() {
    	JPanel pnBorder_NV = new JPanel();
		pnBorder_NV.setLayout(new BorderLayout());
		// North
		JPanel pnNorth_NV = new JPanel();
		pnNorth_NV.setLayout(new BoxLayout(pnNorth_NV, BoxLayout.Y_AXIS));
		Box box_NV = Box.createHorizontalBox();

		JLabel title_NV = new JLabel("Quản lý nhân viên");
		title_NV.setForeground(Color.BLUE);
		title_NV.setFont(new Font("Aria", Font.BOLD, 20));
		box_NV.add(title_NV);
		pnNorth_NV.add(box_NV);
		pnNorth_NV.add(Box.createVerticalStrut(20));

		pnBorder_NV.add(pnNorth_NV, BorderLayout.NORTH);
		// Center
		JPanel pnCenter_NV = new JPanel();
		pnCenter_NV.setLayout(new BoxLayout(pnCenter_NV, BoxLayout.Y_AXIS));
		JPanel pnCenterTop_NV = new JPanel();
		pnCenterTop_NV.setLayout(new BoxLayout(pnCenterTop_NV, BoxLayout.Y_AXIS));
		JPanel pnCenterBot_NV = new JPanel();
		pnCenterBot_NV.setLayout(new BoxLayout(pnCenterBot_NV, BoxLayout.Y_AXIS));

		Box b1_NV = Box.createHorizontalBox();
		Box b2_NV = Box.createHorizontalBox();
		Box b3_NV = Box.createHorizontalBox();
		Box b4_NV = Box.createHorizontalBox();

		JLabel lblMa = new JLabel("Mã nhân viên: ");
		lblMa.setPreferredSize(new Dimension(100, 25));
		b1_NV.add(Box.createHorizontalStrut(10));
		b1_NV.add(lblMa);
		JTextField txtMaNV_NV = new JTextField(20);
		b1_NV.add(txtMaNV_NV);
		pnCenterTop_NV.add(b1_NV);
		JLabel lblTen_NV = new JLabel("Tên nhân viên: ");
		lblTen_NV.setPreferredSize(new Dimension(100, 25));
		b1_NV.add(Box.createHorizontalStrut(10));
		b1_NV.add(lblTen_NV);
		JTextField txtTenNV_NV = new JTextField(30);
		b1_NV.add(txtTenNV_NV);
		pnCenterTop_NV.add(b1_NV);
		pnCenterTop_NV.add(Box.createVerticalStrut(10));

		JLabel lblSDT_NV = new JLabel("SDT: ");
		lblSDT_NV.setPreferredSize(new Dimension(105, 25));
		b2_NV.add(Box.createHorizontalStrut(10));
		b2_NV.add(lblSDT_NV);
		JTextField txtSDT_NV = new JTextField(20);
		b2_NV.add(txtSDT_NV);
		JLabel lblEmail_NV = new JLabel("Email: ");
		lblEmail_NV.setPreferredSize(new Dimension(100, 25));
		b2_NV.add(Box.createHorizontalStrut(10));
		b2_NV.add(lblEmail_NV);
		JTextField txtEmail_NV = new JTextField(30);
		b2_NV.add(txtEmail_NV);
		pnCenterTop_NV.add(b2_NV);
		pnCenterTop_NV.add(Box.createVerticalStrut(10));

		JLabel lblLuong_NV = new JLabel("Lương: ");
		lblLuong_NV.setPreferredSize(new Dimension(105, 25));
		b4_NV.add(Box.createHorizontalStrut(10));
		b4_NV.add(lblLuong_NV);
		JTextField txtLuong_NV = new JTextField(20);
		b4_NV.add(txtLuong_NV);
		JLabel lblChucVu_NV = new JLabel("Chức vụ: ");
		lblChucVu_NV.setPreferredSize(new Dimension(100, 25));
		b4_NV.add(Box.createHorizontalStrut(10));
		b4_NV.add(lblChucVu_NV);
		JTextField txtChucVu_NV = new JTextField(30);
		b4_NV.add(txtChucVu_NV);
		pnCenterTop_NV.add(b4_NV);
		pnCenterTop_NV.add(Box.createVerticalStrut(10));

		pnCenter_NV.add(pnCenterTop_NV);

		String[] headers_NV = "Ma;Ten;SDT;Email;Luong;Chuc vu".split(";");
		DefaultTableModel model_NV = new DefaultTableModel(headers_NV, 0);
		JTable table_NV = new JTable(model_NV);
		JScrollPane scroll_NV = new JScrollPane();
		scroll_NV.setViewportView(table_NV = new JTable(model_NV));
		table_NV.setRowHeight(20);
		b3_NV.add(Box.createHorizontalStrut(10));
		b3_NV.add(scroll_NV);
		b3_NV.add(Box.createHorizontalStrut(10));
		pnCenterBot_NV.add(b3_NV);
		pnCenterBot_NV.add(Box.createVerticalStrut(10));
		pnCenter_NV.add(pnCenterBot_NV);

		pnBorder_NV.add(pnCenter_NV, BorderLayout.CENTER);
		
		
		add(pnBorder_NV);
    }
}

