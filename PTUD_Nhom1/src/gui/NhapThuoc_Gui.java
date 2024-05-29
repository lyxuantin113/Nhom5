package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.NhaCungCap_Dao;
import dao.NhanVien_Dao;
import dao.PhieuNhapThuoc_Dao;
import dao.ChiTietPhieuNhapThuoc_Dao;
import dao.DonVi_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.ChiTietPhieuNhapThuoc;
import entity.DonVi;
import entity.NhaCungCap;
import entity.NhanVien;
import entity.PhieuNhapThuoc;
import entity.Thuoc;

public class NhapThuoc_Gui extends JPanel implements ActionListener, MouseListener {
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
	private JButton btnLamMoi;

	public NhapThuoc_Gui(NhanVien nhanVienDN) {
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
		JLabel lblMaNV = new JLabel("Nhân viên: ");
		lblMaNV.setPreferredSize(new Dimension(90, 25));
		txtMaNV = new JTextField(20);
		txtMaNV.setEnabled(false);
		b01.add(Box.createHorizontalStrut(10));
		b01.add(lblMaNV);
		b01.add(txtMaNV);
		pnTTPNT.add(b01);
		pnTTPNT.add(Box.createVerticalStrut(5));
		// Mã phiếu nhập
		JLabel lblMaPNT = new JLabel("Mã phiếu nhập: ");
		lblMaPNT.setPreferredSize(new Dimension(90, 25));
		txtMaPNT = new JTextField(20);
		txtMaPNT.setEnabled(false);
		b11.add(Box.createHorizontalStrut(10));
		b11.add(lblMaPNT);
		b11.add(txtMaPNT);
		// Ngày nhập
		JLabel lblNgayNhap = new JLabel("Ngày nhập: ");
		lblNgayNhap.setPreferredSize(new Dimension(90, 25));
		txtNgayNhap = new JTextField(20);
		// Lấy ngày hiện tại
		LocalDate date =  LocalDate.now();
		txtNgayNhap.setText(date.toString());
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
		txtTongTien.setText("0");
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
		cbbMaThuoc = new JComboBox<String>();
		cbbMaThuoc.setPreferredSize(new Dimension(395, 25));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMa);
		b1.add(cbbMaThuoc);
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
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblDonVi);
		b3.add(cbbDonVi);



		// Thành tiền
		JLabel lblThanhTien = new JLabel("Thành tiền: ");
		lblThanhTien.setPreferredSize(new Dimension(90, 25));
		txtThanhTien = new JTextField(20);
		txtThanhTien.setEnabled(false);

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

		pnTTThuoc.add(b5);
		pnCenterTop.add(pnTTThuoc);
		// Set ko nhập
		cbbMaThuoc.setEnabled(false);
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
		String[] headers = { "Mã thuốc", "Mã phiếu nhập", "Giá nhập", "Hạn sử dụng", "Số lượng", "Đơn vị",
				"Thành tiền" };
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

		cbbMaThuoc.addActionListener(this);

		table.addMouseListener(this);

		ConnectDB.connect();
		// Đổ dữ liệu cho combobox
		addCombobox();
		addComboboxDonVi();
		// Lấy tên nhân viên
		txtMaNV.setText(nhanVienDN.getTenNV());
		
		// Khóa các nút
		btnAdd.setEnabled(false);
		btnXoaTrang.setEnabled(false);
		btnXoa.setEnabled(false);
		btnSua.setEnabled(false);
		btnXacNhan.setEnabled(false);
		
	}


	private void addComboboxDonVi() {
		DonVi_Dao dvDao = new DonVi_Dao();
		for (DonVi dv : dvDao.readFromTable()) {
			cbbDonVi.addItem(dv.getDonVi());
		}
		
	}


	private void addCombobox() {
		NhaCungCap_Dao nccDao = new NhaCungCap_Dao();
		for (NhaCungCap ncc : nccDao.readFromTable()) {
			cbbNCC.addItem(ncc.getTenNCC());
		}
		taoMaPhieuNhap();
	}

	private void hienTable(String maPhieuNhap) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy dữ liệu từ database
		ChiTietPhieuNhapThuoc_Dao pntDao = new ChiTietPhieuNhapThuoc_Dao();
		for (ChiTietPhieuNhapThuoc ct : pntDao.readFromTable(maPhieuNhap)) {
			model.addRow(new Object[] { ct.getThuoc().getMaThuoc(), ct.getMaPhieuNhap().getMaPhieuNhap(), ct.getGiaNhap(),
					ct.getHsd(), ct.getSoLuong(), ct.getDonVi(), ct.getThanhTien() });
		}
		

	}

	private void taoMaPhieuNhap() {
		txtMaPNT.setText(PhieuNhapThuoc_Dao.taoMaPhieuNhap());
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
		if (o.equals(btnHuy)) {
			huy();
		}
		if (o.equals(btnXacNhan)) {
			xacNhan();
		}

	}

	private void xacNhan() {
		// Kiểm tra số lượng chi tiết phiếu nhập
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowCounts = model.getRowCount();
		if (rowCounts < 1) {
			JOptionPane.showMessageDialog(this, "Phải có ít nhất 1 thông tin thuốc.");
			return;
		} else {
			JOptionPane.showMessageDialog(this, "Xác nhận thành công.");
			
			// Set tổng tiền cho phiếu nhập
			Double tongTien = Double.parseDouble(txtTongTien.getText());
			String maPNT = txtMaPNT.getText();
			PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
			PhieuNhapThuoc pnt = pntDao.timTheoMa(maPNT);
			pnt.setTongTien(tongTien);
			pntDao.updateTongTien(pnt);
			
			
			XoaTrangToanBo();
			taoMaPhieuNhap();
		}

	}

	private void XoaTrangToanBo() {
		cbbNCC.setEnabled(true);
		cbbMaThuoc.setEnabled(false);
		txtGiaNhap.setEnabled(false);
		txtHSD.setEnabled(false);
		txtSoLuong.setEnabled(false);
		cbbDonVi.setEnabled(false);
		txtMaCTPNT.setText("");
		txtGiaNhap.setText("");
		cbbDonVi.setSelectedIndex(0);
		cbbMaThuoc.setSelectedIndex(0);
		txtHSD.setText("");
		txtSoLuong.setText("");
		txtThanhTien.setText("");
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

	}

	private void huy() {
		// Xóa phiếu đặt thuốc trong database
		String maPNT = txtMaPNT.getText();
		PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
		if (pntDao.delete(maPNT)) {
			JOptionPane.showMessageDialog(this, "Hủy thành công.");
			
			cbbNCC.setEnabled(true);
			cbbMaThuoc.setEnabled(false);
			txtGiaNhap.setEnabled(false);
			txtHSD.setEnabled(false);
			txtSoLuong.setEnabled(false);
			cbbDonVi.setEnabled(false);
			txtMaCTPNT.setText("");
			txtTongTien.setText("0");
			txtGiaNhap.setText("");
			txtHSD.setText("");
			txtSoLuong.setText("");
			txtThanhTien.setText("0");
			// Khóa các nút
			btnAdd.setEnabled(false);
			btnXoaTrang.setEnabled(false);
			btnXoa.setEnabled(false);
			btnSua.setEnabled(false);
			btnXacNhan.setEnabled(false);
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.setRowCount(0);
			
			 // Tạm thời xóa ActionListener trước khi xóa các mục trong JComboBox
	        ActionListener[] listeners = cbbMaThuoc.getActionListeners();
	        for (ActionListener listener : listeners) {
	            cbbMaThuoc.removeActionListener(listener);
	        }

	        // Xóa dữ liệu trong combobox
	        cbbMaThuoc.removeAllItems();
	        
	        // Thêm lại các ActionListener sau khi hoàn tất
	        for (ActionListener listener : listeners) {
	            cbbMaThuoc.addActionListener(listener);
	        }
			
		} else {
			JOptionPane.showMessageDialog(this, "Hủy thất bại.");

		}

	}

	private void sua() {
		if (!checkData()) {
			return;
		}
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn thông tin thuốc cần sửa.");
			return;
		}
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
		
		PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
		PhieuNhapThuoc pnt = pntDao.timTheoMa(maCTPNT);
		
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		Thuoc thuoc = thuocDao.timTheoMa(maThuoc);
		
		ChiTietPhieuNhapThuoc ct = new ChiTietPhieuNhapThuoc(pnt, thuoc, sl, gia, LocalDate.parse(hsd), donVi,thanhTien);
		ChiTietPhieuNhapThuoc_Dao ctDao = new ChiTietPhieuNhapThuoc_Dao();
		if (ctDao.update(ct)) {
			JOptionPane.showMessageDialog(this, "Sửa thành công.");
			
			// Hiển thị lại table
			hienTable(txtMaCTPNT.getText());
			upDateTongTien();
		} else {
			JOptionPane.showMessageDialog(this, "Sửa thất bại.");
		}

	}

	private void xoa() {
		// Xóa dữ liệu trong table
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int rowCounts = model.getRowCount();
		if (rowCounts <= 1) {
			JOptionPane.showMessageDialog(this, "Phải có ít nhất 1 thông tin thuốc.");
			return;
		} else {
			int row = table.getSelectedRow();
			String maCTPNT = model.getValueAt(row, 1).toString();
			int hoi = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa?");
			if (hoi == JOptionPane.YES_OPTION) {
				// Xóa dữ liệu trong database
				ChiTietPhieuNhapThuoc_Dao ctDao = new ChiTietPhieuNhapThuoc_Dao();
				if (ctDao.delete(maCTPNT)) {
					JOptionPane.showMessageDialog(this, "Xóa thành công.");
					model.removeRow(row);
					xoaTrang();
					upDateTongTien();
				} else {
					JOptionPane.showMessageDialog(this, "Xóa thất bại.");
				}
			}
		}

	}

	private void taoPhieu() {
		if (checkDataPhieuNhap()) {
			
			String maPNT = txtMaPNT.getText();
			String tenNV = txtMaNV.getText();
			// Lấy mã NV
			NhanVien_Dao nvDao = new NhanVien_Dao();
			NhanVien nv = nvDao.getNhanVienByName(tenNV);
			
			LocalDate ngayNhap = LocalDate.parse(txtNgayNhap.getText());
			NhaCungCap_Dao nccDao = new NhaCungCap_Dao();
			String tenNCC = cbbNCC.getSelectedItem().toString();
			String maNCC = nccDao.getMaNCC(tenNCC);
			Double tongTien = 0.0;
			Boolean trangThai = false;

			
			if (!nvDao.maNhanVienDaTonTai(nv.getMaNV())) {
				JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại.");
				return;
			}
			
			NhaCungCap ncc = nccDao.getNhaCungCap(maNCC);
			
			
			
			PhieuNhapThuoc pnt = new PhieuNhapThuoc(maPNT, ncc, nv, ngayNhap, tongTien, trangThai);
			PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();

			if (pntDao.findMaPhieuNhap(maPNT)) {
				JOptionPane.showMessageDialog(this, "Mã phiếu nhập đã tồn tại.");
				return;
			}
			if (pntDao.create(pnt)) {
				JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thành công.");
				addMaThuoc(maNCC);
				txtMaPNT.setEnabled(false);
				txtMaNV.setEnabled(false);
				txtNgayNhap.setEnabled(false);
				cbbNCC.setEnabled(false);
				txtTongTien.setEnabled(false);
				
				cbbMaThuoc.setEnabled(true);
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				if (cbbMaThuoc.getItemCount() == 0) {
					JOptionPane.showMessageDialog(this, "Nhà cung cấp không có thuốc.");
					huy();
					return;
				}
				String maThuoc = cbbMaThuoc.getSelectedItem().toString();
				Thuoc thuoc = thuocDao.timTheoMa(maThuoc);
				Double giaNhap = thuoc.getGiaNhap();
				txtGiaNhap.setText(giaNhap.toString());
				String hsd = thuoc.getHSD().toString();
				txtHSD.setText(hsd);
				txtSoLuong.setEnabled(true);
				String donVi = thuoc.getMaDonVi().getDonVi();
				cbbDonVi.setSelectedItem(donVi);
				txtMaCTPNT.setText(maPNT);

				hienTable(maPNT);
				// Mở các nút
				btnAdd.setEnabled(true);
				btnXoaTrang.setEnabled(true);

			} else {
				JOptionPane.showMessageDialog(this, "Tạo phiếu nhập thất bại.");
			}
		}

	}

	private boolean checkDataPhieuNhap() {
		String maPNT = txtMaPNT.getText();
		String maNV = txtMaNV.getText();
		try {
			LocalDate ngayNhap = LocalDate.parse(txtNgayNhap.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ.");
			return false;
		}
		LocalDate ngayNhap = LocalDate.parse(txtNgayNhap.getText());
		
		

		if (maPNT.isEmpty() || maNV.isEmpty()  || ngayNhap == null) {
			JOptionPane.showMessageDialog(this, "Không được để trống thông tin.");
			return false;
		}
		
		
		String check = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		if (!txtNgayNhap.getText().matches(check)) {
			JOptionPane.showMessageDialog(this, "Ngày nhập không hợp lệ (dd-MM-yyyy).");
			return false;
		}

		return true;

	}

	private void addMaThuoc(String maNCC) {
		
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		for (Thuoc thuoc : thuocDao.getDSTByNCC(maNCC)) {
			cbbMaThuoc.addItem(thuoc.getMaThuoc());
		}
		layThongTin();
	}

	private void layThongTin() {
		cbbMaThuoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String maThuoc = cbbMaThuoc.getSelectedItem().toString();
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				Thuoc thuoc = thuocDao.timTheoMa(maThuoc);
				Double giaNhap = thuoc.getGiaNhap();
				txtGiaNhap.setText(giaNhap.toString());
				txtHSD.setText(thuoc.getHSD().toString());
				cbbDonVi.setSelectedItem(thuoc.getMaDonVi().getDonVi());
				txtSoLuong.setText("");
				txtThanhTien.setText("");
			}
		});
		
	}


	private void xoaTrang() {
		cbbMaThuoc.setSelectedIndex(0);
		txtSoLuong.setText("");

	}

	private void addThuocDat() {
		
		if (checkData()) {
			capNhatThanhTien();
			btnXoa.setEnabled(true);
			btnSua.setEnabled(true);
			btnXacNhan.setEnabled(true);
			String ma = cbbMaThuoc.getSelectedItem().toString();
			Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
			LocalDate hsd = LocalDate.parse(txtHSD.getText());
			Integer soLuong = Integer.parseInt(txtSoLuong.getText());
			String donVi = cbbDonVi.getSelectedItem().toString();
			String maCTPNT = txtMaCTPNT.getText();
			Double thanhTien = giaNhap * soLuong;
			
			PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
			PhieuNhapThuoc pnt = pntDao.timTheoMa(maCTPNT);
			Thuoc_Dao thuocDao = new Thuoc_Dao();
			Thuoc thuoc = thuocDao.timTheoMa(ma);
			
			// Thêm vào database
			ChiTietPhieuNhapThuoc ct = new ChiTietPhieuNhapThuoc(pnt, thuoc, soLuong, giaNhap, hsd, donVi, thanhTien);
			ChiTietPhieuNhapThuoc_Dao ctDao = new ChiTietPhieuNhapThuoc_Dao();
			if (ctDao.findMaPhieuNhap(maCTPNT, ma)) {
				JOptionPane.showMessageDialog(this, "Mã thuốc nhập đã tồn tại.");
				return;
			}
			if (ctDao.create(ct)) {
				JOptionPane.showMessageDialog(this, "Thêm thành công.");
				
				// Cập nhật lại table
				xoaTrang();
				hienTable(maCTPNT);
				upDateTongTien();
			} else {
				JOptionPane.showMessageDialog(this, "Thêm thất bại.");
			}
		}

	}

	private void upDateTongTien() {
		Double tongTien = 0.0;
		for (int i = 0; i < table.getRowCount(); i++) {
			Double thanhTien = Double.parseDouble(table.getValueAt(i, 6).toString());
			tongTien += thanhTien;
			
		}
		
		txtTongTien.setText(tongTien.toString());
		
	}


	private void capNhatThanhTien() {
		Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		Integer soLuong = Integer.parseInt(txtSoLuong.getText());
		Double thanhTien = giaNhap * soLuong;
		txtThanhTien.setText(thanhTien.toString());
	
		
	}


	private boolean checkData() {
		if (txtMaPNT.getText()== "" || cbbMaThuoc.getSelectedIndex() == -1 || txtGiaNhap.getText().isEmpty() || txtHSD.getText().isEmpty()
				|| txtSoLuong.getText().isEmpty() || cbbDonVi.getSelectedIndex()== -1 ) {
			JOptionPane.showMessageDialog(this, "Không được để trống thông tin.");
			return false;

		}
		
		
		try {
			Double gia = Double.parseDouble(txtGiaNhap.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Giá nhập không hợp lệ.");
				return false;
		}
		Double giaNhap = Double.parseDouble(txtGiaNhap.getText());
		try {
			Integer soLuong = Integer.parseInt(txtSoLuong.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ.");
			return false;
		}
		try {
			Double thanhTien = giaNhap * Integer.parseInt(txtSoLuong.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Thành tiền không hợp lệ.");
			return false;
		}
		LocalDate hsd = LocalDate.parse(txtHSD.getText());
		
		if (hsd.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(this, "Hạn sử dụng không hợp lệ.");
			return false;
		}
		// kiểm tra hạn sử dụng có đúng format không
		if (txtHSD.getText().length() != 10) {
			JOptionPane.showMessageDialog(this, "Hạn sử dụng không hợp lệ.");
			return false;
		}
		String check = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		if (!txtHSD.getText().matches(check)) {
			JOptionPane.showMessageDialog(this, "Hạn sử dụng không hợp lệ.");
			return false;
		}

		return true;
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		String ma = table.getValueAt(row, 0).toString();
		String giaNhap = table.getValueAt(row, 2).toString();
		String hsd = table.getValueAt(row, 3).toString();
		String soLuong = table.getValueAt(row, 4).toString();
		String donVi = table.getValueAt(row, 5).toString();
		String thanhTien = table.getValueAt(row, 6).toString();
		String maCTPNT = table.getValueAt(row, 1).toString();
		cbbMaThuoc.setSelectedItem(ma);
		txtGiaNhap.setText(giaNhap);
		txtHSD.setText(hsd);
		txtSoLuong.setText(soLuong);
		cbbDonVi.setSelectedItem(donVi);
		txtThanhTien.setText(thanhTien);
		txtMaCTPNT.setText(maCTPNT);
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
