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
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.ChiTietPhieuNhapThuoc;
import entity.NhaCungCap;
import entity.Thuoc;

public class NhapThuoc_Gui extends JPanel implements ActionListener {
	private JButton btnAdd;
	private JButton btnXoaTrang;
	private JButton btnTim;
	private JButton btnXoa;
	private JTextField txtMa;
	private JTextField txtTen;
	private JTextField txtGiaNhap;
	private JTextField txtHSD;
	private JTextField txtSoLuong;
	private JComboBox<String> cbbDonVi;
	private JTextField txtThanhTien;
	private JTextField txtNgayNhap;
	private JComboBox<String> cbbNCC;
	private JTable table;
	private JTextField txtMaCTPNT;

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

		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK),
				"Thông tin phiếu nhập thuốc"));
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
		pnCenterTop.add(b2);
		pnCenterTop.add(Box.createVerticalStrut(5));

		// Số lượng
		JLabel lblSoLuong = new JLabel("Số lượng: ");
		lblSoLuong.setPreferredSize(new Dimension(90, 25));
		txtSoLuong = new JTextField(20);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblSoLuong);
		b3.add(txtSoLuong);
		pnCenterTop.add(b3);
		pnCenterTop.add(Box.createVerticalStrut(5));
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
		JLabel lblNgayNhap = new JLabel("Ngày nhập: ");
		lblNgayNhap.setPreferredSize(new Dimension(90, 25));
		txtNgayNhap = new JTextField(20);
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

		pnCenterTop.add(b5);

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
		String[] headers = { "Mã thuốc", "Tên thuốc", "Giá nhập", "Hạn sử dụng","Số lượng", "Đơn vị", "Thành tiền", "Mã CTPNT" };
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
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTim.setBackground(new Color(0, 160, 255));
		btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoa.setBackground(new Color(0, 160, 255));
		pnFooter.add(lblTimKiem);
		pnFooter.add(txtTimKiem);
		pnFooter.add(btnTim);
		pnFooter.add(btnXoa);
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
		
		
		hienTable();
		ConnectDB.connect();
	}

	private void hienTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// add combobox
		
		NhaCungCap_Dao nccDao = new NhaCungCap_Dao();
		for (NhaCungCap ncc : nccDao.readFromTable()) {
			cbbNCC.addItem(ncc.getTenNCC());
		}
		// Lấy dữ liệu từ database
		PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
		for (ChiTietPhieuNhapThuoc ct : pntDao.readFromTable()) {
			model.addRow(new Object[] { ct.getMaThuoc(), ct.getTenThuoc(), ct.getGiaNhap(),
					ct.getHsd(),ct.getSoLuong(), ct.getDonVi(), ct.getThanhTien(), ct.getMaCTPNT() });
		}
		
		
	}
		
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			addThuocDat();
			txtMaCTPNT.setEnabled(false);
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
	}

	private void xoaTrang() {
		txtMa.setText("");
		txtTen.setText("");
		txtGiaNhap.setText("");
		txtSoLuong.setText("");
		txtThanhTien.setText("");
		txtHSD.setText("");
		
		cbbDonVi.setSelectedIndex(0);
		cbbNCC.setSelectedIndex(0);
		
		
	}

	private void addThuocDat() {
//		String maCTPNT = txtMa.getText();
		String ma = txtMa.getText();
		String ten = txtTen.getText();
		String giaNhap = txtGiaNhap.getText();
		String hsd = txtHSD.getText();
		String soLuong = txtSoLuong.getText();
		String donVi = cbbDonVi.getSelectedItem().toString();
		String maCTPNT = txtMaCTPNT.getText();
		
		Double thanhTienDouble = Double.parseDouble(giaNhap) * Integer.parseInt(soLuong);
		String thanhTien = String.valueOf(thanhTienDouble);
		String[] row = { ma, ten, giaNhap,hsd, soLuong, donVi, thanhTien, maCTPNT };
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(row);
		
		
	}

}
