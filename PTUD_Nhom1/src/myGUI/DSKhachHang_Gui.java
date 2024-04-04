package myGUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSKhachHang_Gui extends JPanel implements ActionListener {
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JTextField txtSDT;
	private JTextField txtTen;
	private JTable table;
	private JButton btnXoa;

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
		txtSDT = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblSDT);
		b1.add(txtSDT);

		// Tên khách hàng
		JLabel lblTen = new JLabel("Tên khách hàng: ");
		lblTen.setPreferredSize(new Dimension(120, 20));
		txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));
		pnCenterTop.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin khách hàng"));

		// Button
		JPanel pnButton = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		pnCenterBot.add(pnButton);
		// Table
		String[] headers = { "Số điện thoại", "Tên khách hàng" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
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
		txtTimKiem.setPreferredSize(new Dimension(getWidth(), 30));
		JButton btnTim = new JButton("Tìm");
		btnXoa = new JButton("Xóa");

		pnFooter.add(lblTimKiem);
		pnFooter.add(txtTimKiem);
		pnFooter.add(btnTim);
		pnFooter.add(btnXoa);
		pnMain.add(pnFooter);

		add(pnMain);

		// Event
		txtSDT.addActionListener(this);
		txtTen.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnXoa.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXoaTrang)) {
			txtSDT.setText("");
			txtTen.setText("");
			txtTen.requestFocus();
		}
		if (o.equals(btnThem)) {
			themKhachHang();
		}
		if (o.equals(btnXoa)) {
			xoaKhachHang();
		}

	}

	private void themKhachHang() {
		String sdt = txtSDT.getText();
		String ten = txtTen.getText();
		if (sdt.equals("") || ten.equals("")) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đủ thông tin");
		} else {
			// thêm vào table
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] { sdt, ten });
			txtSDT.setText("");
			txtTen.setText("");
			txtSDT.requestFocus();
			JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");

		}

	}
	private void xoaKhachHang() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần xóa");
		} else {
			int choice = JOptionPane.showConfirmDialog(DSKhachHang_Gui.this, "Bạn có chắc chắn muốn xóa dòng này?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			if (choice == JOptionPane.YES_OPTION) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.removeRow(row);
				JOptionPane.showMessageDialog(this, "Xóa khách hàng thành công");
			} 
		}
	}
}
