package myGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_Dao;
import dao.PhieuNhapThuoc_Dao;
import dao.ChiTietPhieuNhapThuoc_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.ChiTietPhieuNhapThuoc;
import entity.NhaCungCap;
import entity.PhieuNhapThuoc;
import entity.Thuoc;

public class NhapThuoc_Gui extends JPanel implements ActionListener {
	private JButton btnAdd;
	private JButton btnXoaTrang;
	private JButton btnTim;
	private JButton btnXoa;
	private JTextField txtMa;

	private JTextField txtGiaNhap;
	private JTextField txtHSD;
	private JTextField txtSoLuong;
	private JComboBox<String> cbbDonVi;
	private JTextField txtThanhTien;
	private JTextField txtNgayNhap;
	private JComboBox<String> cbbNCC;
	private JTable table;
	private JTextField txtMaCTPNT;
	private JTextField txtMaPNT;
	private JTextField txtMaNV;
	private JTextField txtTongTien;
	private JButton btnTao;
	private JButton btnHuy;
	private JComboBox<String> cbbMaThuoc;
	private JButton btnSua;
	private JButton btnXacNhan;

	public NhapThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Phiếu nhập thuốc");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));

		
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		JPanel pnTTPNT = new JPanel();
		pnTTPNT.setLayout(new BoxLayout(pnTTPNT, BoxLayout.Y_AXIS));
		Box b01 = Box.createHorizontalBox();
		Box b11 = Box.createHorizontalBox();
		Box b21 = Box.createHorizontalBox();
		// Nhân viên
		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		lblMaNV.setPreferredSize(new Dimension(90, 25));
		txtMaNV = new JTextField(20);
		b01.add(Box.createHorizontalStrut(10));
		b01.add(lblMaNV);
		b01.add(txtMaNV);
		pnTTPNT.add(b01);
		pnTTPNT.add(Box.createVerticalStrut(5));
		// Mã phiếu nhập
		JLabel lblMaPNT = new JLabel("Mã phiếu nhập: ");
		lblMaPNT.setPreferredSize(new Dimension(90, 25));
		txtMaPNT = new JTextField(20);
		b11.add(Box.createHorizontalStrut(10));
		b11.add(lblMaPNT);
		b11.add(txtMaPNT);
		// Ngày nhập
		JLabel lblNgayNhap = new JLabel("Ngày nhập: ");
		lblNgayNhap.setPreferredSize(new Dimension(90, 25));
		txtNgayNhap = new JTextField(20);
		// Lấy ngày hiện tại
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = formatter.format(date);
		txtNgayNhap.setText(strDate);
		txtNgayNhap.setEnabled(false);
		b11.add(Box.createHorizontalStrut(10));
		b11.add(lblNgayNhap);
		b11.add(txtNgayNhap);
		pnTTPNT.add(Box.createVerticalStrut(5));
		pnTTPNT.add(b11);
		pnTTPNT.add(Box.createVerticalStrut(5));
		// Nhà cung cấp
		JLabel lblNCC = new JLabel("Nhà cung cấp: ");
		lblNCC.setPreferredSize(new Dimension(90, 25));
		cbbNCC = new JComboBox<String>();
		cbbNCC.setPreferredSize(new Dimension(395, 25));
		b21.add(Box.createHorizontalStrut(10));
		b21.add(lblNCC);
		b21.add(cbbNCC);

		pnTTPNT.add(Box.createVerticalStrut(10));
		// Tổng tiền
		JLabel lblTongTien = new JLabel("Tổng tiền: ");
		lblTongTien.setPreferredSize(new Dimension(90, 25));
		txtTongTien = new JTextField(20);
		txtTongTien.setEnabled(false);
		b21.add(Box.createHorizontalStrut(10));
		b21.add(lblTongTien);
		b21.add(txtTongTien);
		pnTTPNT.add(b21);
		pnTTPNT.add(Box.createVerticalStrut(5));
		pnCenterTop.add(pnTTPNT);
		pnTTPNT.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Thông tin phiếu nhập thuốc"));
		pnCenterTop.add(Box.createVerticalStrut(5));
		JPanel pnTTThuoc = new JPanel();
		pnTTThuoc.setLayout(new BoxLayout(pnTTThuoc, BoxLayout.Y_AXIS));
		pnTTThuoc.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin thuốc nhập"));
		// Button tạo phiếu
		JPanel pnButtonTaoPhieu = new JPanel();
		
		btnTao = new JButton("Tạo phiếu");
		btnHuy = new JButton("Hủy");
		btnTao.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTao.setBackground(new Color(0, 160, 255));
		btnHuy.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnHuy.setBackground(new Color(0, 160, 255));
		pnButtonTaoPhieu.add(btnTao);
		pnButtonTaoPhieu.add(btnHuy);
		
		pnTTPNT.add(Box.createVerticalStrut(5));
		pnCenterTop.add(pnButtonTaoPhieu);
		
		
		// Mã thuốc
		JLabel lblMa = new JLabel("Mã thuốc: ");
		lblMa.setPreferredSize(new Dimension(90, 25));
//		txtMa = new JTextField(20);
		cbbMaThuoc = new JComboBox<String>();
		cbbMaThuoc.setPreferredSize(new Dimension(395, 25));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMa);
		b1.add(cbbMaThuoc);
//		// Tên Thuốc
//		JLabel lblTen = new JLabel("Tên thuốc: ");
//		lblTen.setPreferredSize(new Dimension(90, 25));
//		txtTen = new JTextField(20);
//		b1.add(Box.createHorizontalStrut(10));
//		b1.add(lblTen);
//		b1.add(txtTen);
		pnTTThuoc.add(b1);
		pnTTThuoc.add(Box.createVerticalStrut(5));
		// Giá nhập
		JLabel lblGiaNhap = new JLabel("Giá nhập: ");
		lblGiaNhap.setPreferredSize(new Dimension(90, 25));
		txtGiaNhap = new JTextField(20);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblGiaNhap);
		b2.add(txtGiaNhap);
		// HSD
		JLabel lblHSD = new JLabel("HSD: ");
		lblHSD.setPreferredSize(new Dimension(90, 25));
		txtHSD = new JTextField(20);
		b2.add(Box.createHorizontalStrut(12));
		b2.add(lblHSD);
		b2.add(txtHSD);
		pnTTThuoc.add(b2);
		pnTTThuoc.add(Box.createVerticalStrut(5));

		// Số lượng
		JLabel lblSoLuong = new JLabel("Số lượng: ");
		lblSoLuong.setPreferredSize(new Dimension(90, 25));
		txtSoLuong = new JTextField(20);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblSoLuong);
		b3.add(txtSoLuong);
		pnTTThuoc.add(b3);
		pnTTThuoc.add(Box.createVerticalStrut(5));
		// Đơn vị
		JLabel lblDonVi = new JLabel("Đơn vị:");
		lblDonVi.setPreferredSize(new Dimension(90, 25));
		cbbDonVi = new JComboBox<String>();
		cbbDonVi.setPreferredSize(new Dimension(395, 25));
		cbbDonVi.addItem("Viên");
		cbbDonVi.addItem("Chai");
		cbbDonVi.addItem("Hộp");
		cbbDonVi.addItem("Gói");
		cbbDonVi.addItem("Lọ");
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblDonVi);
		b3.add(cbbDonVi);

//		// Loại thuốc
//		JLabel lblLoai = new JLabel("Loại thuốc: ");
//		lblLoai.setPreferredSize(new Dimension(90, 25));
//		JComboBox<String> cbbLoai = new JComboBox<String>();
//		cbbLoai.setPreferredSize(new Dimension(395, 25));
//		cbbLoai.addItem("Thuốc cảm");
//		cbbLoai.addItem("Thuốc hạ sốt");
//		cbbLoai.addItem("Thực phẩm chức năng");
//		b4.add(Box.createHorizontalStrut(10));
//		b4.add(lblLoai);
//		b4.add(cbbLoai);
//		
//		
//		JLabel lblXuatXu = new JLabel("Xuất xứ: ");
//		lblXuatXu.setPreferredSize(new Dimension(90, 25));
//		JTextField txtXuatXu = new JTextField(20);
//		b4.add(Box.createHorizontalStrut(10));
//		b4.add(lblXuatXu);
//		b4.add(txtXuatXu);
//		pnCenterTop.add(b4);
//		pnCenterTop.add(Box.createVerticalStrut(5));

		// Thành tiền
		JLabel lblThanhTien = new JLabel("Thành tiền: ");
		lblThanhTien.setPreferredSize(new Dimension(90, 25));
		txtThanhTien = new JTextField(20);
		txtThanhTien.setEnabled(false);
//		JLabel lblNgayNhap = new JLabel("Ngày nhập: ");
//		lblNgayNhap.setPreferredSize(new Dimension(90, 25));
//		txtNgayNhap = new JTextField(20);
//		// Lấy ngày hiện tại
//		Date date = new Date();
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		String strDate = formatter.format(date);
//		txtNgayNhap.setText(strDate);
//		txtNgayNhap.setEnabled(false);
		// Mã CTPNT
		JLabel lblMaCTPNT = new JLabel("Mã CTPNT: ");
		lblMaCTPNT.setPreferredSize(new Dimension(90, 25));
		txtMaCTPNT = new JTextField(20);
//		txtMaCTPNT.setEnabled(false);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(lblThanhTien);
		b5.add(txtThanhTien);
		b5.add(Box.createHorizontalStrut(10));
		b5.add(lblMaCTPNT);
		b5.add(txtMaCTPNT);

//		b5.add(lblNgayNhap);
//		b5.add(txtNgayNhap);

		pnTTThuoc.add(b5);
		pnCenterTop.add(pnTTThuoc);
		// Set ko nhập
		cbbMaThuoc.setEnabled(false);
//		txtTen.setEnabled(false);
		txtGiaNhap.setEnabled(false);
		txtHSD.setEnabled(false);
		txtSoLuong.setEnabled(false);
		cbbDonVi.setEnabled(false);
		txtThanhTien.setEnabled(false);
		txtMaCTPNT.setEnabled(false);
		
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
		String[] headers = { "Mã thuốc", "Giá nhập", "Hạn sử dụng", "Số lượng", "Đơn vị", "Thành tiền",
				"Mã CTPNT" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new java.awt.Dimension(1000, 210));
		pnCenterBot.add(sp);
		pnCenter.add(Box.createVerticalStrut(10));
		// FOOTER
		JPanel pnFooter = new JPanel();
		
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnXacNhan = new JButton("Xác nhận");
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoa.setBackground(new Color(0, 160, 255));
		btnSua.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSua.setBackground(new Color(0, 160, 255));
		btnXacNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXacNhan.setBackground(new Color(0, 160, 255));
		
		
		pnFooter.add(btnXoa);
		pnFooter.add(btnSua);
		pnFooter.add(btnXacNhan);
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
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnXacNhan.addActionListener(this);
		btnTao.addActionListener(this);
		btnHuy.addActionListener(this);
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				int row = table.getSelectedRow();
				String ma = table.getValueAt(row, 0).toString();
				String giaNhap = table.getValueAt(row, 1).toString();
				String hsd = table.getValueAt(row, 2).toString();
				String soLuong = table.getValueAt(row, 3).toString();
				String donVi = table.getValueAt(row, 4).toString();
				String thanhTien = table.getValueAt(row, 5).toString();
				String maCTPNT = table.getValueAt(row, 6).toString();
				cbbMaThuoc.setSelectedItem(ma);
				txtGiaNhap.setText(giaNhap);
				txtHSD.setText(hsd);
				txtSoLuong.setText(soLuong);
				cbbDonVi.setSelectedItem(donVi);
				txtThanhTien.setText(thanhTien);
				txtMaCTPNT.setText(maCTPNT);
			}
		});
//		table.addMouseListener(new java.awt.event.MouseAdapter() {
//			public void mouseClicked(java.awt.event.MouseEvent evt) {
//				int row = table.getSelectedRow();
//				String ncc = table.getValueAt(row, 0).toString();
//				String ma = table.getValueAt(row, 1).toString();
//				String ten = table.getValueAt(row, 2).toString();
//				String giaNhap = table.getValueAt(row, 3).toString();
//				String soLuong = table.getValueAt(row, 4).toString();
//				String donVi = table.getValueAt(row, 5).toString();
//				String thanhTien = table.getValueAt(row, 6).toString();
//				String ngayNhap = table.getValueAt(row, 7).toString();
//				cbbNCC.setSelectedItem(ncc);
//				txtMa.setText(ma);
//				txtTen.setText(ten);
//				txtGiaNhap.setText(giaNhap);
//				txtSoLuong.setText(soLuong);
//				cbbDonVi.setSelectedItem(donVi);
//				txtThanhTien.setText(thanhTien);
//				txtNgayNhap.setText(ngayNhap);
//			}
//		});
		
		ConnectDB.connect();
		// Đổ dữ liệu cho combobox
		addCombobox();
	}

	private void addCombobox() {
		NhaCungCap_Dao nccDao = new NhaCungCap_Dao();
		for (NhaCungCap ncc : nccDao.readFromTable()) {
			cbbNCC.addItem(ncc.getMaNCC());
		}
		
	}

	private void hienTable(String maPhieuNhap) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy dữ liệu từ database
		ChiTietPhieuNhapThuoc_Dao pntDao = new ChiTietPhieuNhapThuoc_Dao();
		for (ChiTietPhieuNhapThuoc ct : pntDao.readFromTable(maPhieuNhap)) {
			model.addRow(new Object[] { ct.getMaThuoc(), ct.getGiaNhap(), ct.getHsd(),
					ct.getSoLuong(), ct.getDonVi(), ct.getThanhTien(), ct.getMaCTPNT() });
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTao)) {
			taoPhieu();
		}
		if (o.equals(btnAdd)) {
			addThuocDat();
			txtMaCTPNT.setEnabled(false);
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if (o.equals(btnXoa)) {
			xoa();
		}
		if (o.equals(btnSua)) {
			sua();
		}
	}

	private void sua() {
		String giaNhap = txtGiaNhap.getText();
		String soLuong = txtSoLuong.getText();
		String hsd = txtHSD.getText();
		
		// Cập nhật dữ liệu vào database
		String maCTPNT = txtMaCTPNT.getText();
		String maThuoc = cbbMaThuoc.getSelectedItem().toString();
		Double gia = Double.parseDouble(giaNhap);
		Integer sl = Integer.parseInt(soLuong);
		String donVi = cbbDonVi.getSelectedItem().toString();
		Double thanhTien = gia * sl;
		ChiTietPhieuNhapThuoc ct = new ChiTietPhieuNhapThuoc(maCTPNT, maThuoc, sl, gia, LocalDate.parse(hsd), donVi, thanhTien);
		ChiTietPhieuNhapThuoc_Dao ctDao = new ChiTietPhieuNhapThuoc_Dao();
		if (ctDao.update(ct)) {
			JOptionPane.showMessageDialog(this, "Sửa thành công.");
			// Hiển thị lại table
			hienTable(txtMaCTPNT.getText());
		} else {
			JOptionPane.showMessageDialog(this, "Sửa thất bại.");
		}
		
		
	}

	private void xoa() {
		// Xóa dữ liệu trong table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		String maCTPNT = model.getValueAt(row, 6).toString();
		int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");
		if (hoi == JOptionPane.YES_OPTION) {
			
			// Xóa dữ liệu trong database
			ChiTietPhieuNhapThuoc_Dao ctDao = new ChiTietPhieuNhapThuoc_Dao();
			if (ctDao.delete(maCTPNT)) {
				JOptionPane.showMessageDialog(this, "Xóa thành công.");
				model.removeRow(row);
			} else {
				JOptionPane.showMessageDialog(this, "Xóa thất bại.");
			}
		}
		
		
	}

	private void taoPhieu() {
		String maPNT = txtMaPNT.getText();
		String maNV = txtMaNV.getText();
		LocalDate ngayNhap = LocalDate.now();
		String tenNCC = cbbNCC.getSelectedItem().toString();
		Double tongTien = 0.0;
		Boolean trangThai = false;
		
		PhieuNhapThuoc pnt = new PhieuNhapThuoc(maPNT, tenNCC, maNV, ngayNhap, tongTien, trangThai);
		PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
		if (pntDao.create(pnt)) {
			JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thành công.");
			txtMaPNT.setEnabled(false);
			txtMaNV.setEnabled(false);
			txtNgayNhap.setEnabled(false);
			cbbNCC.setEnabled(false);
			txtTongTien.setEnabled(false);
			cbbMaThuoc.setEnabled(true);
//			txtTen.setEnabled(true);
			txtGiaNhap.setEnabled(true);
			txtHSD.setEnabled(true);
			txtSoLuong.setEnabled(true);
			cbbDonVi.setEnabled(true);
			txtMaCTPNT.setText(maPNT);
			// Add mã thuốc theo ncc vào combobox
			Thuoc_Dao thuocDao = new Thuoc_Dao();
			for (Thuoc thuoc : thuocDao.getDSTByNCC(tenNCC)) {
				cbbMaThuoc.addItem(thuoc.getMaThuoc());
			}
			
			hienTable(maPNT);
			
		} else {
			JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thất bại.");
		}
		
	
		
	}

	private void xoaTrang() {
//		txtMa.setText("");
//		txtTen.setText("");
		cbbMaThuoc.setSelectedIndex(0);
		txtGiaNhap.setText("");
		txtSoLuong.setText("");
//		txtThanhTien.setText("");
		txtHSD.setText("");

		cbbDonVi.setSelectedIndex(0);
		cbbNCC.setSelectedIndex(0);

	}

	private void addThuocDat() {
//		String maCTPNT = txtMa.getText();
		String ma = cbbMaThuoc.getSelectedItem().toString();
		Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		LocalDate hsd = LocalDate.parse(txtHSD.getText());
		Integer soLuong = Integer.parseInt(txtSoLuong.getText());
		String donVi = cbbDonVi.getSelectedItem().toString();
		String maCTPNT = txtMaCTPNT.getText();
		Double thanhTien = giaNhap * soLuong;
		
		// Thêm vào database
		ChiTietPhieuNhapThuoc ct = new ChiTietPhieuNhapThuoc(maCTPNT, ma, soLuong,
				giaNhap, hsd, donVi, thanhTien);
		ChiTietPhieuNhapThuoc_Dao ctDao = new ChiTietPhieuNhapThuoc_Dao();
		if (ctDao.create(ct)) {
			JOptionPane.showMessageDialog(this, "Thêm thành công.");
			// Cập nhật tổng tiền
			PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
			PhieuNhapThuoc pnt = pntDao.readFromTable().get(pntDao.readFromTable().size() - 1);
			pnt.setTongTien(pnt.getTongTien() + thanhTien);
			pntDao.updateTongTien(pnt);
			txtTongTien.setText(pnt.getTongTien().toString());
			// Cập nhật lại table
			hienTable(maCTPNT);
		} else {
			JOptionPane.showMessageDialog(this, "Thêm thất bại.");
		}
	}

	
		
	

}
