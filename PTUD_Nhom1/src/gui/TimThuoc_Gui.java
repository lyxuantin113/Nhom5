package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.DonVi_Dao;
import dao.LoaiThuoc_Dao;
import dao.NhaCungCap_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.LoaiThuoc;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.Thuoc;

public class TimThuoc_Gui extends JPanel implements ActionListener {
	private JButton btnTim;
	private JTextField txtThongTin;
	private JTable table;
	private JComboBox<String> cbbCachTim;
	private JButton btnReset;
	private Thuoc_Dao thuocDao ;
	private NhaCungCap_Dao nccDao ;
	private LoaiThuoc_Dao loaiThuocDao;
	private DonVi_Dao donViDao;
	private JComboBox<String> cbbThongTin;

	public TimThuoc_Gui(NhanVien nhanVienDN) {
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
		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin tìm kiếm"));
		
		// Thông tin tìm kiếm combobox
		JLabel lblThongTinCBB = new JLabel("Thông tin: ");
		lblThongTinCBB.setPreferredSize(new Dimension(90, 25));
		cbbThongTin = new JComboBox<String>();
		cbbThongTin.setPreferredSize(new Dimension(400, 25));
		cbbThongTin.setEditable(false);
		b2.add(Box.createHorizontalStrut(20));
		b2.add(lblThongTinCBB);
		b2.add(cbbThongTin);
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b2);
		
		
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
		cbbCachTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cachTim = (String) cbbCachTim.getSelectedItem();
				if (cachTim.equals("Mã thuốc")) {
					txtThongTin.setText("");
					txtThongTin.setEditable(true);
					cbbThongTin.setEnabled(false);
				}
				if (cachTim.equals("Tên thuốc")) {
					txtThongTin.setText("");
					txtThongTin.setEditable(true);
					cbbThongTin.setEnabled(false);
				}
				if (cachTim.equals("Loại thuốc")) {
					txtThongTin.setText("");
					txtThongTin.setEditable(false);
					cbbThongTin.setEnabled(true);
					cbbThongTin.removeAllItems();
					// Đổ dữ liệu cho combobox
					loaiThuocDao = new LoaiThuoc_Dao();
					List<LoaiThuoc> dsLoai = loaiThuocDao.readFromTable();
					for (LoaiThuoc loai : dsLoai) {
						cbbThongTin.addItem(loai.getLoaiThuoc());
					}
				}
				if (cachTim.equals("Nhà cung cấp")) {
					txtThongTin.setText("");
					txtThongTin.setEditable(false);
					cbbThongTin.setEnabled(true);
					cbbThongTin.removeAllItems();
					// Đổ dữ liệu cho combobox
					nccDao = new NhaCungCap_Dao();
					List<NhaCungCap> dsNCC = nccDao.readFromTable();
					for (NhaCungCap ncc : dsNCC) {
						cbbThongTin.addItem(ncc.getTenNCC());
					}
					
				}
			}
		});

	}

	private void hienTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy danh sách thuốc từ database
		thuocDao = new Thuoc_Dao();
		nccDao = new NhaCungCap_Dao();
		loaiThuocDao = new LoaiThuoc_Dao();
		donViDao = new DonVi_Dao();

		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		for (Thuoc thuoc : dsThuoc) {
			String ncc = nccDao.getNCC(thuoc.getMaNCC());
			String loai = loaiThuocDao.getLoaiThuoc(thuoc.getMaLoai().getMaLoai());
			String donVi = donViDao.getDonVi(thuoc.getMaDonVi().getMaDonVi());
			Object[] rowData = { ncc, thuoc.getMaThuoc(), thuoc.getTenThuoc(), loai,
					donVi, thuoc.getHSD(), thuoc.getGiaNhap(), thuoc.getGiaBan(), thuoc.getSoLuongTon(),
					thuoc.getNuocSanXuat() };
			model.addRow(rowData);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			String cachTim = (String) cbbCachTim.getSelectedItem();
			if (cachTim.equals("Mã thuốc") || cachTim.equals("Tên thuốc")) {
				timThuocTheoTenVaMa();
			} else {
				timThuocTheoLoaiVaNCC();
			}
		}
		if (o.equals(btnReset)) {
			txtThongTin.setText("");
			cbbCachTim.setSelectedIndex(0);
			hienTable();
		}
	}

	private void timThuocTheoTenVaMa() {
		thuocDao = new Thuoc_Dao();
		String thongTin = txtThongTin.getText();
		donViDao = new DonVi_Dao();
		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		// Lấy cách tìm kiếm
		String cachTim = (String) cbbCachTim.getSelectedItem();
		if (thongTin.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
			return;
		} else {
			if (cachTim.equals("Mã thuốc")) {
				if (thuocDao.timTheoMaTuyetDoi(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					JOptionPane.showMessageDialog(this, "Tìm thấy mã thuốc.");
					for (Thuoc thuoc : dsThuoc) {						
						if (thuoc.getMaThuoc().contains(thongTin)) {
							Object[] rowData = { nccDao.getNCC(thuoc.getMaNCC()), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									loaiThuocDao.getLoaiThuoc(thuoc.getMaLoai().getMaLoai()), donViDao.getDonVi(thuoc.getMaDonVi().getMaDonVi()), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
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
					JOptionPane.showMessageDialog(this, "Tìm thấy tên thuốc.");
					for (Thuoc thuoc : dsThuoc) {
						if (thuoc.getTenThuoc().contains(thongTin)) {
							Object[] rowData = { nccDao.getNCC(thuoc.getMaNCC()), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									loaiThuocDao.getLoaiThuoc(thuoc.getMaLoai().getMaLoai()), donViDao.getDonVi(thuoc.getMaDonVi().getMaDonVi()), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy tên thuốc.");
					hienTable();
				}
			}
		}
	}

	private void timThuocTheoLoaiVaNCC() {
		thuocDao = new Thuoc_Dao();
		nccDao = new NhaCungCap_Dao();
		loaiThuocDao = new LoaiThuoc_Dao();
		donViDao = new DonVi_Dao();
		// Lấy thông tin tìm kiếm
		String thongTin = cbbThongTin.getSelectedItem().toString();
		// Lấy cách tìm kiếm
		String cachTim = (String) cbbCachTim.getSelectedItem();
		
		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		if (thongTin.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
			return;
		} else {
			if (cachTim.equals("Loại thuốc")) {
				String loai = loaiThuocDao.getMaLoaiThuoc(thongTin);
				if (thuocDao.timTheoLoai(loai)) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					JOptionPane.showMessageDialog(this, "Tìm thấy loại thuốc " + thongTin);
					for (Thuoc thuoc : dsThuoc) {
						if (thuoc.getMaLoai().getMaLoai().contains(loai)) {
							Object[] rowData = { nccDao.getNCC(thuoc.getMaNCC()), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									loaiThuocDao.getLoaiThuoc(thuoc.getMaLoai().getMaLoai()), donViDao.getDonVi(thuoc.getMaDonVi().getMaDonVi()), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
					}
				} else {
					cbbThongTin.setSelectedIndex(0);
					JOptionPane.showMessageDialog(this, "Không tìm thấy các thuốc có loại thuốc này.");
					hienTable();
				}
			}
			if (cachTim.equals("Nhà cung cấp")) {
				String ncc = nccDao.getMaNCC(thongTin);
				if (thuocDao.timTheoNCC(ncc)) {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					JOptionPane.showMessageDialog(this, "Tìm thấy nhà cung cấp "+ thongTin);
					for (Thuoc thuoc : dsThuoc) {
						if (thuoc.getMaNCC().contains(ncc)) {
							Object[] rowData = { nccDao.getNCC(thuoc.getMaNCC()), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
									loaiThuocDao.getLoaiThuoc(thuoc.getMaLoai().getMaLoai()), donViDao.getDonVi(thuoc.getMaDonVi().getMaDonVi()), thuoc.getHSD(), thuoc.getGiaNhap(),
									thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
							model.addRow(rowData);
						}
					}
				} else {
					cbbThongTin.setSelectedIndex(0);
					JOptionPane.showMessageDialog(this, "Không tìm thấy các thuốc của nhà cung cấp này.");
					hienTable();
				}
			}

		}

	}
}
