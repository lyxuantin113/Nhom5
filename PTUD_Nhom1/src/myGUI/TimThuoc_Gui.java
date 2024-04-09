package myGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.Thuoc;

public class TimThuoc_Gui extends JPanel implements ActionListener {
	private JButton btnTim;
	private JTextField txtThongTin;
	private JTable table;
	private JComboBox<String> cbbCachTim;
	private JButton btnReset;

	public TimThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

		// HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Tìm thuốc");
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

		// Cách tìm kiếm
		JLabel lblCachTim = new JLabel("Tìm theo: ");
		lblCachTim.setPreferredSize(new Dimension(90, 25));
		cbbCachTim = new JComboBox<String>();
		cbbCachTim.addItem("Mã thuốc");
		cbbCachTim.addItem("Tên thuốc");
		cbbCachTim.addItem("Loại thuốc");
		cbbCachTim.addItem("Nhà cung cấp");
		b1.add(lblCachTim);
		b1.add(cbbCachTim);
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b1);

		// Thông tin tìm kiếm
		JLabel lblThongTin = new JLabel("Thông tin: ");
		lblThongTin.setPreferredSize(new Dimension(90, 25));
		txtThongTin = new JTextField(20);
		b2.add(lblThongTin);
		b2.add(txtThongTin);
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b2);
		pnCenterTop.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin tìm kiếm"));
		// Button
		JPanel pnButton = new JPanel();
		btnTim = new JButton("Tìm");
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTim.setBackground(new Color(0, 160, 255));
		btnReset = new JButton("Reset");
		btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnReset.setBackground(new Color(0, 160, 255));

		pnButton.add(btnTim);
		pnButton.add(btnReset);

		b3.add(pnButton);
		pnCenterTop.add(b3);
		// Table
		String[] headers = { "NCC", "Mã thuốc", "Tên thuốc", "Loại", "Đơn vị", "HSD", "Giá nhập", "Giá bán",
				"Số lượng tồn", "Xuất xứ" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		pnCenterBot.add(sp);
		pnCenter.add(Box.createVerticalStrut(10));

		pnCenter.add(pnCenterTop);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot);
		pnMain.add(pnCenter, BorderLayout.CENTER);

		add(pnMain);
		// Action
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		txtThongTin.addActionListener(this);

		ConnectDB.connect();
		hienTable();

	}

	private void hienTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy danh sách thuốc từ database
		Thuoc_Dao thuocDao = new Thuoc_Dao();

		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		for (Thuoc thuoc : dsThuoc) {
			Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getLoaiThuoc(),
					thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(), thuoc.getGiaBan(), thuoc.getSoLuongTon(),
					thuoc.getNuocSanXuat() };
			model.addRow(rowData);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			timThuoc();
		}
		if (o.equals(btnReset)) {
			txtThongTin.setText("");
			hienTable();
		}
	}

	private void timThuoc() {
		// Lấy thông tin tìm kiếm
		String thongTin = txtThongTin.getText();
		// Lấy cách tìm kiếm
		String cachTim = (String) cbbCachTim.getSelectedItem();
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		if (thongTin.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
			return;
		} else {
			if (cachTim.equals("Mã thuốc")) {
				List<Thuoc> listThuoc = thuocDao.timTheoMa(thongTin);
				if (listThuoc!=null) {
					for (Thuoc thuoc : listThuoc) {						
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
								thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(),
								thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
						model.addRow(rowData);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã thuốc.");
					hienTable();
				}

			}
			if (cachTim.equals("Tên thuốc")) {
				if (thuocDao.timTheoTen(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (Thuoc thuoc : dsThuoc) {
						if (thuoc.getTenThuoc().contains(thongTin)) {
							Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy tên thuốc.");
					hienTable();
				}
			}
			if (cachTim.equals("Loại thuốc")) {
				if (thuocDao.timTheoLoai(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (Thuoc thuoc : dsThuoc) {
						if (thuoc.getLoaiThuoc().contains(thongTin)) {
							Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy loại thuốc.");
					hienTable();
				}
			}
			if (cachTim.equals("Nhà cung cấp")) {
				if (thuocDao.timTheoNCC(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					for (Thuoc thuoc : dsThuoc) {
						if (thuoc.getMaNCC().contains(thongTin)) {
							Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy nhà cung cấp.");
					hienTable();
				}
			}

		}

	}
}
