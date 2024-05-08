package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.DonDat_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.NhaCungCap_Dao;
import dao.PhieuNhapThuoc_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.Thuoc;

public class DSThuoc_Gui extends JPanel implements ActionListener {
	private JButton btnAdd;
	private JButton btnXoaTrang;
	private JButton btnTim;
	private JButton btnXoa;
	private JTable table;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtHSD;
	private JTextField txtGiaNhap;
	private JTextField txtGiaBan;
	private JTextField txtSoLuong;
	private JTextField txtXuatXu;
	private JComboBox<String> cbbDonVi;
	private JComboBox<String> cbbLoai;
	private JComboBox<String> cbbNCC;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnAddDonVi;
	private JButton btnAddLoai;

	public DSThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Quản lý thuốc");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));

		pnCenterTop.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin thuốc"));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		// Nhà cung cấp
		JLabel lblNCC = new JLabel("Nhà cung cấp: ");
		lblNCC.setPreferredSize(new Dimension(90, 25));
		cbbNCC = new JComboBox<String>();
		
		b0.add(Box.createHorizontalStrut(10));
		b0.add(lblNCC);
		b0.add(cbbNCC);
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b0);
		pnCenterTop.add(Box.createVerticalStrut(5));

		// Mã thuốc
		JLabel lblMa = new JLabel("Mã thuốc: ");
		lblMa.setPreferredSize(new Dimension(90, 25));
		txtMa = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMa);
		b1.add(txtMa);
		// Tên Thuốc
		JLabel lblTen = new JLabel("Tên thuốc: ");
		lblTen.setPreferredSize(new Dimension(90, 25));
		txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));

		// Loại thuốc
		JLabel lblLoai = new JLabel("Loại thuốc: ");
		lblLoai.setPreferredSize(new Dimension(90, 25));
		cbbLoai = new JComboBox<String>();
		cbbLoai.setPreferredSize(new Dimension(360, 25));
		btnAddLoai = new JButton("...");
		btnAddLoai.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddLoai.setBackground(new Color(0, 160, 255));
		btnAddLoai.setPreferredSize(new Dimension(30, 25));
		
//		cbbLoai.addItem("Thuoc cam");
//		cbbLoai.addItem("Thuoc ha sot");
//		cbbLoai.addItem("Thuoc giam dau");
//		cbbLoai.addItem("Thuoc khang sinh");
//		cbbLoai.addItem("Thuoc an than");
//		cbbLoai.addItem("Thuc pham chuc nang");
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblLoai);
		b2.add(cbbLoai);
		b2.add(Box.createHorizontalStrut(5));
		b2.add(btnAddLoai);

		// Đơn vị
		JLabel lblDonVi = new JLabel("Đơn vị:");
		lblDonVi.setPreferredSize(new Dimension(90, 25));
		cbbDonVi = new JComboBox<String>();
		cbbDonVi.setPreferredSize(new Dimension(360, 25));
		btnAddDonVi = new JButton("...");
		btnAddDonVi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAddDonVi.setBackground(new Color(0, 160, 255));
		btnAddDonVi.setPreferredSize(new Dimension(30, 25));
//		cbbDonVi.addItem("Vien");
//		cbbDonVi.addItem("Vi");
//		cbbDonVi.addItem("Hop");
//		cbbDonVi.addItem("Goi");
//		cbbDonVi.addItem("Chai");
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblDonVi);
		b2.add(cbbDonVi);
		b2.add(Box.createHorizontalStrut(5));
		b2.add(btnAddDonVi);
		pnCenterTop.add(b2);
		pnCenterTop.add(Box.createVerticalStrut(5));

		// HSD
		JLabel lblHSD = new JLabel("HSD: ");
		lblHSD.setPreferredSize(new Dimension(90, 25));
		txtHSD = new JTextField(20);
		b3.add(Box.createHorizontalStrut(12));
		b3.add(lblHSD);
		b3.add(txtHSD);
		pnCenterTop.add(b3);
		pnCenterTop.add(Box.createVerticalStrut(5));

		// Giá nhập
		JLabel lblGiaNhap = new JLabel("Giá nhập: ");
		lblGiaNhap.setPreferredSize(new Dimension(90, 25));
		txtGiaNhap = new JTextField(20);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblGiaNhap);
		b3.add(txtGiaNhap);

		// Giá bán
		JLabel lblGiaBan = new JLabel("Giá bán: ");
		lblGiaBan.setPreferredSize(new Dimension(90, 25));
		txtGiaBan = new JTextField(20);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(lblGiaBan);
		b4.add(txtGiaBan);
		pnCenterTop.add(b4);
		pnCenterTop.add(Box.createVerticalStrut(5));

		// Số lượng
		JLabel lblSoLuong = new JLabel("Số lượng: ");
		lblSoLuong.setPreferredSize(new Dimension(90, 25));
		txtSoLuong = new JTextField(20);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(lblSoLuong);
		b4.add(txtSoLuong);
		pnCenterTop.add(b4);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Xuất xứ
		JLabel lblXuatXu = new JLabel("Xuất xứ: ");
		lblXuatXu.setPreferredSize(new Dimension(90, 25));
		txtXuatXu = new JTextField(20);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(lblXuatXu);
		b5.add(txtXuatXu);
		pnCenterTop.add(b5);
		pnCenterTop.add(Box.createVerticalStrut(5));

//		// Thành tiền
//		JLabel lblThanhTien = new JLabel("Thành tiền: ");
//		lblThanhTien.setPreferredSize(new Dimension(90, 25));
//		JTextField txtThanhTien = new JTextField(20);
//		txtThanhTien.setEnabled(false);
//		JLabel lblNgayNhap = new JLabel("Ngày nhập: ");
//		lblNgayNhap.setPreferredSize(new Dimension(90, 25));
//		JTextField txtNgayNhap = new JTextField(20);
//		// Lấy ngày hiện tại
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		String strDate = formatter.format(date);
//		txtNgayNhap.setText(strDate);
//		txtNgayNhap.setEnabled(false);
//
//		b5.add(Box.createHorizontalStrut(10));
//		b5.add(lblThanhTien);
//		b5.add(txtThanhTien);
//		b5.add(Box.createHorizontalStrut(10));
//		b5.add(lblNgayNhap);
//		b5.add(txtNgayNhap);
//

		// BUTTON
		JPanel pnButton = new JPanel();
		btnAdd = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAdd.setBackground(new Color(0, 160, 255));
		btnXoaTrang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setBackground(new Color(0, 160, 255));
		pnButton.add(btnAdd);
		pnButton.add(btnXoaTrang);
		pnCenterBot.add(pnButton);
		// TABLE
		String[] headers = { "NCC", "Mã thuốc", "Tên thuốc", "Loại", "Đơn vị", "HSD", "Giá nhập", "Giá bán", "Số lượng",
				"Xuất xứ" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new java.awt.Dimension(1000, 210));
		pnCenterBot.add(sp);
		pnCenter.add(Box.createVerticalStrut(10));
		// FOOTER
		JPanel pnFooter = new JPanel();
		JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
		JTextField txtTimKiem = new JTextField(20);
		btnTim = new JButton("Tìm");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnLamMoi = new JButton("Làm mới");
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTim.setBackground(new Color(0, 160, 255));
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoa.setBackground(new Color(0, 160, 255));
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSua.setBackground(new Color(0, 160, 255));
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLamMoi.setBackground(new Color(0, 160, 255));
		
		pnFooter.add(lblTimKiem);
		pnFooter.add(txtTimKiem);
		
		pnFooter.add(btnTim);
		pnFooter.add(btnXoa);
		pnFooter.add(btnSua);
		pnFooter.add(btnLamMoi);
		pnMain.add(pnFooter, BorderLayout.SOUTH);

		pnCenter.add(pnCenterTop);
		pnCenter.add(pnCenterBot);
		// ADD TO MAIN
		pnMain.add(pnCenter, BorderLayout.CENTER);

		pnMain.add(pnHead, BorderLayout.NORTH);

		add(pnMain);

		// Action
		btnAdd.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		cbbNCC.addActionListener(this);
		btnAddDonVi.addActionListener(this);
		btnAddLoai.addActionListener(this);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.rowAtPoint(evt.getPoint());
				txtMa.setText(table.getValueAt(row, 1).toString());
				txtMa.setEditable(false);
				txtTen.setText(table.getValueAt(row, 2).toString());
				cbbLoai.setSelectedItem(table.getValueAt(row, 3).toString());
				cbbDonVi.setSelectedItem(table.getValueAt(row, 4).toString());
				txtHSD.setText(table.getValueAt(row, 5).toString());
				txtGiaNhap.setText(table.getValueAt(row, 6).toString());
				txtGiaBan.setText(table.getValueAt(row, 7).toString());
				txtSoLuong.setText(table.getValueAt(row, 8).toString());
				txtXuatXu.setText(table.getValueAt(row, 9).toString());
				cbbNCC.setSelectedItem(table.getValueAt(row, 0).toString());
			}
		});
		hienTable();
		ConnectDB.connect();
	}

	void hienTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy danh sách thuốc từ database
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		
		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		for (Thuoc thuoc : dsThuoc) {
			Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
					thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(), thuoc.getGiaBan(),
					thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
			model.addRow(rowData);
		}
		// add combobox
		NhaCungCap_Dao nccDao = new NhaCungCap_Dao();
		List<NhaCungCap> dsNCC = nccDao.readFromTable();
		for (NhaCungCap ncc : dsNCC) {
			cbbNCC.addItem(ncc.getMaNCC());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			addThuoc();
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if (o.equals(btnTim)) {
			
		}
		if (o.equals(btnXoa)) {
			deleteThuoc();
		}
		if (o.equals(btnSua)) {
			updateThuoc();
		}
		if (o.equals(btnLamMoi)) {
			hienTable();
			xoaTrang();
		}
		if (o.equals(btnAddDonVi)) {
			new DonVi_Gui();
		}
		if (o.equals(btnAddLoai)) {
			new LoaiThuoc_Gui();
		}

	}

	private void updateThuoc() {
		
		if (!xuLyDuLieu()) {
			return;
		}
		
		String maThuoc = txtMa.getText();
		String tenThuoc = txtTen.getText();
		String loaiThuoc = cbbLoai.getSelectedItem().toString();
		String donVi = cbbDonVi.getSelectedItem().toString();
		LocalDate hsd = new java.sql.Date(System.currentTimeMillis()).toLocalDate();

		double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		double giaBan = Double.parseDouble(txtGiaBan.getText());
		int soLuongTon = Integer.parseInt(txtSoLuong.getText());
		String nuocSX = txtXuatXu.getText();
		String maNCC = cbbNCC.getSelectedItem().toString();

		
		Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuoc, donVi, hsd, giaNhap, giaBan, soLuongTon, nuocSX, maNCC);
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa không?", "Chú ý",
				JOptionPane.YES_NO_OPTION);
		if (hoi == JOptionPane.YES_OPTION) {
			thuocDao.updateThuoc(thuoc);
			JOptionPane.showMessageDialog(this, "Sửa thành công");
			hienTable();
			xoaTrang();
		}
	}

	private void xoaTrang() {
		txtMa.setEditable(true);
		txtMa.setText("");
		txtTen.setText("");
		txtHSD.setText("");
		txtGiaNhap.setText("");
		txtGiaBan.setText("");
		txtSoLuong.setText("");
		txtXuatXu.setText("");
		cbbNCC.setSelectedIndex(0);
		cbbDonVi.setSelectedIndex(0);
		cbbLoai.setSelectedIndex(0);
		txtMa.requestFocus();
		
	}

	private void deleteThuoc() {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn thuốc cần xóa");
			return;
		}
		int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?", "Chú ý",
				JOptionPane.YES_NO_OPTION);
		if (hoi == JOptionPane.YES_OPTION) {
			if (!checkTonTai()) {
				String maThuoc = txtMa.getText();
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				thuocDao.deleteThuoc(maThuoc);
				xoaTrang();
				hienTable();
			}
			
		}
	}

	private boolean checkTonTai() {
		String maThuoc = txtMa.getText();
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		HoaDon_Dao hoaDonDao = new HoaDon_Dao();
		DonDat_Dao donDatDao = new DonDat_Dao();
		PhieuNhapThuoc_Dao phieuNhapThuocDao = new PhieuNhapThuoc_Dao();
		
		if (phieuNhapThuocDao.checkThuoc(maThuoc)) {
			JOptionPane.showMessageDialog(this, "Không thể xóa thuốc này vì có phiếu nhập thuốc chưa nhận tồn tại thuốc này");
			return true;
		}
		
		if (donDatDao.checkThuoc(maThuoc)) {
			JOptionPane.showMessageDialog(this, "Không thể xóa thuốc này vì có đơn đặt hàng liên quan");
			return true;
		}
		if (hoaDonDao.checkThuoc(maThuoc)) {
			JOptionPane.showMessageDialog(this, "Không thể xóa thuốc này vì có hóa đơn liên quan");
			return true;
		} else
		if (!thuocDao.checkThuoc(maThuoc)) {
			JOptionPane.showMessageDialog(this, "Mã thuốc không tồn tại");
			return true;
		}
	
		return false;
	}

	private void addThuoc() {
		if (!xuLyDuLieu()) {
			return;
		}
		// Lấy thông tin từ các textfield
		String maThuoc = txtMa.getText();
		String tenThuoc = txtTen.getText();
		String loaiThuoc = cbbLoai.getSelectedItem().toString();
		String donVi = cbbDonVi.getSelectedItem().toString();
		LocalDate hsd = txtHSD.getText().isEmpty() ? null : LocalDate.parse(txtHSD.getText());
		
		double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		double giaBan = Double.parseDouble(txtGiaBan.getText());
		int soLuongTon = Integer.parseInt(txtSoLuong.getText());
		String nuocSX = txtXuatXu.getText();
		String maNCC = cbbNCC.getSelectedItem().toString();
		
		Thuoc thuoc = new Thuoc(maThuoc, tenThuoc, loaiThuoc, donVi, hsd, giaNhap, giaBan, soLuongTon, nuocSX, maNCC);
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		if (thuocDao.checkThuoc(maThuoc)) {
			JOptionPane.showMessageDialog(this, "Mã thuốc đã tồn tại");
			return;
		}
		thuocDao.addThuoc(thuoc);
		xoaTrang();
		// Hiển thị lại table
		hienTable();
	}

	private boolean xuLyDuLieu() {
		// Kiểm tra dữ liệu
		String maThuoc = txtMa.getText();
		String tenThuoc = txtTen.getText();
		String loaiThuoc = cbbLoai.getSelectedItem().toString();
		String donVi = cbbDonVi.getSelectedItem().toString();
		String hsd = txtHSD.getText();
		String giaNhap = txtGiaNhap.getText();
		String giaBan = txtGiaBan.getText();
		String soLuong = txtSoLuong.getText();
		String xuatXu = txtXuatXu.getText();
		String maNCC = cbbNCC.getSelectedItem().toString();
		if (maThuoc.isEmpty() || tenThuoc.isEmpty() || loaiThuoc.isEmpty() || donVi.isEmpty() || hsd.isEmpty()
				|| giaNhap.isEmpty() || giaBan.isEmpty() || soLuong.isEmpty() || xuatXu.isEmpty() || maNCC.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
			return false;
		}
		// Kiểm tra số lượng nhập vào
		try {
			double giaNhap1 = Double.parseDouble(giaNhap);
			double giaBan1 = Double.parseDouble(giaBan);
			int soLuong1 = Integer.parseInt(soLuong);
			if (giaNhap1 <= 0 || giaBan1 <= 0) {
				JOptionPane.showMessageDialog(this, "Giá nhập, giá bán, số lượng phải lớn hơn 0");
				return false;
			}
			else if (giaNhap1 > giaBan1) {
				JOptionPane.showMessageDialog(this, "Giá nhập phải nhỏ hơn giá bán");
				return false;
			} else if (soLuong1 < 0) {
				JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn hoặc bằng 0");
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Giá nhập, giá bán, số lượng phải là số");
			return false;
		}
		
		if (hsd.length() != 10 || !hsd.matches("\\d{4}-\\d{2}-\\d{2}")) {
			JOptionPane.showMessageDialog(this, "Hạn sử dụng phải có dạng yyyy-MM-dd");
			return false;
		}
		LocalDate hsdCheck = LocalDate.parse(hsd);
		if (hsdCheck.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "Hạn sử dụng phải lớn hơn ngày hiện tại");
			return false;
		}
		
		return true;
		
	}

}
