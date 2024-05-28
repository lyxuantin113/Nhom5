package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.NhaCungCap;
import entity.NhanVien;

public class ThemNCC_Gui extends JPanel implements ActionListener {
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JTable table;
	private JButton btnTim;
	private JButton btnXoa;
	private JTextField txtTimKiem;
	
	private NhaCungCap_Dao nccDao = new NhaCungCap_Dao();
	private Thuoc_Dao thuocDao = new Thuoc_Dao();
	private JButton btnSua;
	public ThemNCC_Gui(NhanVien nhanVienDN) {
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
		lblMa.setPreferredSize(new Dimension(90, 25));
		txtMa = new JTextField(20);
		txtMa.setEditable(false);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMa);
		b1.add(txtMa);
		// Tên NCC
		JLabel lblTen = new JLabel("Tên NCC: ");
		lblTen.setPreferredSize(new Dimension(90, 25));
		txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);

		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Địa chỉ
		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setPreferredSize(new Dimension(90, 25));
		txtDiaChi = new JTextField(20);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblDiaChi);
		b2.add(txtDiaChi);
		// SĐT
		JLabel lblSDT = new JLabel("SĐT: ");
		lblSDT.setPreferredSize(new Dimension(90, 25));
		txtSDT = new JTextField(20);
		b2.add(Box.createHorizontalStrut(10));

		b2.add(lblSDT);
		b2.add(txtSDT);
		pnCenterTop.add(b2);
		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Thông tin nhà cung cấp"));
		// Button
		JPanel pnButton = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnThem.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnThem.setBackground(new Color(0, 160, 255));
		btnXoaTrang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setBackground(new Color(0, 160, 255));
		pnButton.add(btnThem);
		pnButton.add(btnXoaTrang);
		b3.add(pnButton);
		pnCenterTop.add(b3);
		// Table
		String[] headers = { "Mã NCC", "Tên NCC", "Địa chỉ", "SĐT" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
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
		txtTimKiem = new JTextField(20);
		btnTim = new JButton("Tìm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTim.setBackground(new Color(0, 160, 255));
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSua.setBackground(new Color(0, 160, 255));
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoa.setBackground(new Color(0, 160, 255));
		pnFoot.add(lblTimKiem);
		pnFoot.add(txtTimKiem);
		pnFoot.add(btnTim);
		pnFoot.add(btnSua);
		pnFoot.add(btnXoa);
		pnMain.add(pnFoot, BorderLayout.SOUTH);

		add(pnMain);
		// Action
		btnThem.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				txtMa.setText(table.getValueAt(row, 0).toString());
				txtTen.setText(table.getValueAt(row, 1).toString());
				txtDiaChi.setText(table.getValueAt(row, 2).toString());
				txtSDT.setText(table.getValueAt(row, 3).toString());
			}
		});
		ConnectDB.connect();
		hienThiDanhSachNCC();

	}

	private void hienThiDanhSachNCC() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		List<NhaCungCap> dsNCC = new NhaCungCap_Dao().readFromTable();
		for (NhaCungCap ncc : dsNCC) {
			model.addRow(new Object[] { ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChiNCC(), ncc.getSdtNCC() });
		}
		// tạo mã tự động
		taoMa();
		

	}

	private void taoMa() {
		txtMa.setText(NhaCungCap_Dao.taoMaNCC());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			themNCC();
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if (o.equals(btnTim)) {
			tim();
		}
		if (o.equals(btnSua)) {
			sua();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}

	}

	private void sua() {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần sửa");
			return;
		}
		if (!xuLyDuLieu())
			return;
		
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		NhaCungCap ncc = new NhaCungCap(ma, ten, diaChi, sdt);
		if (ma.equals("") || ten.equals("") || diaChi.equals("") || sdt.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
			return;
		}
		int hoiNhac = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (hoiNhac != JOptionPane.YES_OPTION) {
			return;
		}
		if (nccDao.searchNCC(ma)) {
			JOptionPane.showMessageDialog(null, "Sửa nhà cung cấp thành công");
			nccDao.updateNCC(ncc);
			hienThiDanhSachNCC();
			xoaTrang();
		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp cần sửa");
		}
		
	}

	private void xoa() {
		
		
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nhà cung cấp cần xóa");
			return;
		}
		String maNCC = (String) table.getValueAt(row, 0);
		if (nccDao.searchNCC(maNCC)) {
			int chon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa", "Xác nhận",
					JOptionPane.YES_NO_OPTION);
			if (chon == JOptionPane.YES_OPTION) {
				if (thuocDao.searchNCC(maNCC)) {
					JOptionPane.showMessageDialog(null, "Không thể xóa nhà cung cấp này vì có thuốc liên quan");
					return;
				}
				nccDao.deleteNCC(maNCC);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
				hienThiDanhSachNCC();
				xoaTrang();

			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp cần xóa");
		}

	}

	private void tim() {
		String maNCC = txtTimKiem.getText();
		if (maNCC.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập mã nhà cung cấp cần tìm");
			return;
		}
		int rowCount = table.getRowCount();
		for (int row = 0; row < rowCount; row++) {
			String rowData = table.getValueAt(row, 0).toString();
			if (rowData.equals(maNCC)) {
				JOptionPane.showMessageDialog(null, "Đã tìm thấy nhà cung cấp " + maNCC + " tại dòng " + (row + 1) + "");
				table.setRowSelectionInterval(row, row);
				return;
			}

		}
		table.clearSelection();
		JOptionPane.showMessageDialog(null, "Không tìm thấy nhà cung cấp " + maNCC + "");

	}

	private void xoaTrang() {
		txtMa.setText(NhaCungCap_Dao.taoMaNCC());
		txtTen.setText("");
		txtDiaChi.setText("");
		txtSDT.setText("");

	}

	private void themNCC() {
		if (!xuLyDuLieu())
			return;

		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		NhaCungCap ncc = new NhaCungCap(ma, ten, diaChi, sdt);
		
		if (ma.equals("") || ten.equals("") || diaChi.equals("") || sdt.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
			return;
		}
		if (!nccDao.searchNCC(ma)) {
			JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công");
			nccDao.addNCC(ncc);
			xoaTrang();
			hienThiDanhSachNCC();

		} else {
			JOptionPane.showMessageDialog(null, "Mã nhà cung cấp đã tồn tại");
		}

	}

	private boolean xuLyDuLieu() {
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String diaChi = txtDiaChi.getText();
		String sdt = txtSDT.getText();
		if (ma.equals("") || ten.equals("") || diaChi.equals("") || sdt.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin");
			return false;
		}
		if (ma.length() > 10) {
			JOptionPane.showMessageDialog(null, "Mã nhà cung cấp không được quá 10 ký tự");
			txtMa.requestFocus();
			return false;
		}
		if (ten.length() > 50) {
			JOptionPane.showMessageDialog(null, "Tên nhà cung cấp không được quá 50 ký tự");
			txtTen.requestFocus();
			return false;
		}
		if (diaChi.length() > 100) {
			JOptionPane.showMessageDialog(null, "Địa chỉ không được quá 100 ký tự");
			txtDiaChi.requestFocus();
			return false;
		}
		if (sdt.length() > 10) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được quá 10 ký tự");
			txtSDT.requestFocus();
			return false;
		}
		if (!sdt.matches("0[0-9]{9}")) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			txtSDT.requestFocus();
			return false;
		}

		return true;
	}

}
