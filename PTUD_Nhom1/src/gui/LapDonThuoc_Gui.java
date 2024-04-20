package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_Dao;
import dao.DonDat_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.NhanVien_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.ChiTietDonDat;
import entity.ChiTietHoaDon;
import entity.DonDat;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Thuoc;

public class LapDonThuoc_Gui extends JPanel implements ActionListener, MouseListener, DocumentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5029635508754943464L;
	JButton btnThem;
	private JTextField txtMaThuoc;
	private JTextField txtSoLuong;
	private DefaultTableModel modelHoaDon;
	private JTable tblHoaDon;
	private JScrollPane scrollHoaDon;
	private JTextField txtTong;
	private JTextField txtNgayLap;
	private JTextField txtNgayNhan;
	private JTextField txtMaNV;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JButton btnLapHD;
	private JButton btnLapDD;
	private JButton btnXoa;

//	TEMPORARY tạm lưu danh sách ChiTietHoaDon
	List<ChiTietHoaDon> tempListHD = new ArrayList<ChiTietHoaDon>();
	List<ChiTietDonDat> tempListDD = new ArrayList<ChiTietDonDat>();
	private JButton btnShowThuoc;
	private JTable tblFrameThuoc;
	private Font fo24;
	private JComboBox<String> cbbTimFrame;
	private JButton btnTimFrame;
	private JButton btnResetFrame;
	private JButton btnChonFrame;
	private JTextField txtTimFrame;
	protected DefaultTableModel modelFrame;
	protected JFrame newFrame;
	private JLabel lblTenThuoc;
	private JTextField txtTenThuoc;
	private JLabel lblLoaiThuoc;
	private JTextField txtLoaiThuoc;
	private JTextField txtDonVi;
	private JTextField txtHSD;

	public LapDonThuoc_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Lập Đơn Thuốc");
		fo24 = new Font("Times New Roman", Font.BOLD, 24);
		headLb.setFont(fo24);
		headLb.setForeground(Color.blue);
		headPn.add(headLb);

//		CENTER

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();

		Box boxNhap = Box.createVerticalBox();

//		Mã Thuốc - Tên Thuốc - Loại thuốc
		Box boxThuoc = Box.createHorizontalBox();

		JLabel lblMaThuoc = new JLabel("Mã thuốc: ");
		lblMaThuoc.setPreferredSize(new Dimension(90, 30));
		txtMaThuoc = new JTextField(15);
		txtMaThuoc.getDocument().addDocumentListener(this);
		btnShowThuoc = new JButton("+");
		btnShowThuoc.setBackground(new Color(0, 160, 255));
		btnShowThuoc.setPreferredSize(new Dimension(30, 0));

		lblTenThuoc = new JLabel("Tên thuốc: ");
		lblTenThuoc.setPreferredSize(new Dimension(90, 0));
		txtTenThuoc = new JTextField(15);
		txtTenThuoc.getDocument().addDocumentListener(this);

		lblLoaiThuoc = new JLabel("Loại thuốc: ");
		lblLoaiThuoc.setPreferredSize(new Dimension(90, 0));
		txtLoaiThuoc = new JTextField(15);
		txtLoaiThuoc.setEditable(false);

		boxThuoc.add(Box.createHorizontalStrut(30));
		boxThuoc.add(lblMaThuoc);
		boxThuoc.add(Box.createHorizontalStrut(5));
		boxThuoc.add(txtMaThuoc);
		boxThuoc.add(btnShowThuoc);
		boxThuoc.add(Box.createHorizontalStrut(20));
		boxThuoc.add(lblTenThuoc);
		boxThuoc.add(Box.createHorizontalStrut(5));
		boxThuoc.add(txtTenThuoc);
		boxThuoc.add(Box.createHorizontalStrut(20));
		boxThuoc.add(lblLoaiThuoc);
		boxThuoc.add(Box.createHorizontalStrut(5));
		boxThuoc.add(txtLoaiThuoc);
		boxThuoc.add(Box.createHorizontalStrut(30));

//		Đơn vị - HSD - Số lượng
		Box boxThongTin = Box.createHorizontalBox();

		JLabel lblDonVi = new JLabel("Đơn vị: ");
		lblDonVi.setPreferredSize(new Dimension(85, 30));
		txtDonVi = new JTextField(19);
		txtDonVi.setEditable(false);

		JLabel lblHSD = new JLabel("HSD: ");
		lblHSD.setPreferredSize(new Dimension(90, 0));
		txtHSD = new JTextField(15);
		txtHSD.setEditable(false);

		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setPreferredSize(new Dimension(90, 0));
		txtSoLuong = new JTextField(15);

		boxThongTin.add(Box.createHorizontalStrut(30));
		boxThongTin.add(lblDonVi);
		boxThongTin.add(Box.createHorizontalStrut(5));
		boxThongTin.add(txtDonVi);
		boxThongTin.add(Box.createHorizontalStrut(20));
		boxThongTin.add(lblHSD);
		boxThongTin.add(Box.createHorizontalStrut(5));
		boxThongTin.add(txtHSD);
		boxThongTin.add(Box.createHorizontalStrut(20));
		boxThongTin.add(lbSoLuong);
		boxThongTin.add(Box.createHorizontalStrut(5));
		boxThongTin.add(txtSoLuong);
		boxThongTin.add(Box.createHorizontalStrut(30));

//		BUTTON Thêm, xóa thuốc trong danh sách
		Box boxThem = Box.createHorizontalBox();

		btnThem = new JButton("Thêm");
		boxThem.add(Box.createHorizontalStrut(30));
		boxThem.add(btnThem);
		btnThem.setBackground(new Color(0, 160, 255));
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnXoa = new JButton("Xóa");
		boxThem.add(Box.createHorizontalStrut(20));
		boxThem.add(btnXoa);
		btnXoa.setBackground(new Color(0, 160, 255));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boxThem.add(Box.createHorizontalStrut(30));

		boxNhap.add(Box.createVerticalStrut(5));
		boxNhap.add(boxThuoc);
		boxNhap.add(Box.createVerticalStrut(5));
		boxNhap.add(boxThongTin);
		boxNhap.add(Box.createVerticalStrut(5));
		boxNhap.add(boxThem);
		boxNhap.add(Box.createVerticalStrut(5));
		boxNhap.setBorder(BorderFactory.createTitledBorder("Thông tin thuốc"));
		pnCenterTop.add(boxNhap);

//		TABLE
		JPanel pnTableHoaDon = new JPanel();

//		TABLE
		Box boxTableHoaDon = Box.createVerticalBox();
		String[] headerHoaDon = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;HSD;Số lượng;Thành tiền".split(";");
		modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		tblHoaDon = new JTable(modelHoaDon);
		scrollHoaDon = new JScrollPane();
		scrollHoaDon.setViewportView(tblHoaDon = new JTable(modelHoaDon));
		scrollHoaDon.setPreferredSize(new Dimension(1100, 230));
		tblHoaDon.setRowHeight(20);
		tblHoaDon.setAutoCreateRowSorter(true);

		boxTableHoaDon.add(scrollHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));

		pnTableHoaDon.add(boxTableHoaDon);

		pnCenterBot.add(pnTableHoaDon);

//		TOTAL AND CREATE
		JPanel pnEndHD = new JPanel();
		pnEndHD.setLayout(new BoxLayout(pnEndHD, BoxLayout.Y_AXIS));
		pnEndHD.setBorder(BorderFactory.createTitledBorder("Thông Tin Đơn Đặt"));

		Box boxTong = Box.createHorizontalBox();
		Box boxMa = Box.createHorizontalBox();
		Box boxKH = Box.createHorizontalBox();

//		BOX1 Tổng - Ngày Lập - Ngày Nhận
//		Tổng thành tiền
		JLabel lbTong = new JLabel("Tổng thành tiền:");
		lbTong.setPreferredSize(new Dimension(100, 30));
		txtTong = new JTextField(20);
		txtTong.setEditable(false);
		txtTong.setText(0 + "");
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(lbTong);
		boxTong.add(txtTong);

//		Ngày Lập
		JLabel lbNgayLap = new JLabel("Ngày Lập HD: ");
		lbNgayLap.setPreferredSize(new Dimension(100, 30));
		txtNgayLap = new JTextField(20);
		txtNgayLap.setText(LocalDate.now().toString());
		txtNgayLap.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(30));
		boxTong.add(lbNgayLap);
		boxTong.add(txtNgayLap);

		pnEndHD.add(boxTong);
		pnEndHD.add(Box.createVerticalStrut(10));

//		BOX2
//		Mã NV
		JLabel lbMaNV = new JLabel("Mã Nhân Viên: ");
		lbMaNV.setPreferredSize(new Dimension(100, 30));
		txtMaNV = new JTextField(20);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(lbMaNV);
		boxMa.add(txtMaNV);
		pnEndHD.add(boxMa);
		pnEndHD.add(Box.createVerticalStrut(10));

//		Ngày Nhận
		JLabel lbNgayNhan = new JLabel("Ngày Nhận: ");
		lbNgayNhan.setPreferredSize(new Dimension(100, 30));
		txtNgayNhan = new JTextField(20);
		boxMa.add(Box.createHorizontalStrut(30));
		boxMa.add(lbNgayNhan);
		boxMa.add(txtNgayNhan);

//		Box 3
//		Số Điện Thoại KH
		JLabel lbSDT = new JLabel("Số ĐT Khách:");
		lbSDT.setPreferredSize(new Dimension(100, 30));
		txtSDT = new JTextField(20);
		txtSDT.getDocument().addDocumentListener(this);
		boxKH.add(Box.createHorizontalStrut(10));
		boxKH.add(lbSDT);
		boxKH.add(txtSDT);

//		Tên Khách Hàng
		JLabel lbTenKH = new JLabel("Tên Khách: ");
		lbTenKH.setPreferredSize(new Dimension(100, 30));
		txtTenKH = new JTextField(20);
		boxKH.add(Box.createHorizontalStrut(30));
		boxKH.add(lbTenKH);
		boxKH.add(txtTenKH);

		pnEndHD.add(boxKH);
		pnEndHD.add(Box.createVerticalStrut(5));

//		BUTTON LẬP HÓA ĐƠN
		JPanel pnSouth = new JPanel();
		btnLapHD = new JButton("Lập Hóa Đơn");
		btnLapHD.setBackground(new Color(0, 160, 255));
		btnLapHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLapHD.setPreferredSize(new Dimension(150, 35));

		btnLapDD = new JButton("Lập Đơn Đặt");
		btnLapDD.setBackground(new Color(0, 160, 255));
		btnLapDD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLapDD.setPreferredSize(new Dimension(150, 35));

		pnSouth.add(btnLapHD);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnLapDD);

//		Add Center
		pnCenter.add(Box.createVerticalStrut(5));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(5));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);
		pnCenter.add(pnEndHD, BorderLayout.SOUTH);
		pnCenter.add(Box.createVerticalStrut(5));

//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);

//		END
		add(pnMain);

//		ADD ACTIONLISTENER
		btnShowThuoc.addActionListener(this);
//		btnTim.addActionListener(this);
//		btnReset.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnLapHD.addActionListener(this);
		btnLapDD.addActionListener(this);
//		tableThuoc.addMouseListener(this);
		tblHoaDon.addMouseListener(this);

		ConnectDB.connect();
		hienTableHoaDon();
	}

	private void hienTableHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
		model.setRowCount(0);

		ChiTietHoaDon_Dao cthdDao = new ChiTietHoaDon_Dao();

		List<ChiTietHoaDon> listChiTietHD = cthdDao.getList();
		if (listChiTietHD != null) {
			for (ChiTietHoaDon chiTietHoaDon : listChiTietHD) {
				Thuoc thuoc = chiTietHoaDon.getMaThuoc();
				Integer soLuong = chiTietHoaDon.getSoLuong();

				Object[] rowData = { thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getLoaiThuoc(), thuoc.getGiaBan(),
						thuoc.getDonVi(), thuoc.getHSD(), soLuong, thuoc.getGiaBan() * soLuong }; // Tạo dữ liệu hàng
																									// mới

				model.addRow(rowData); // Thêm hàng vào model
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnThem) {
			if (this.checkQuatity() && hasThuoc()) // && checkHSD()
				this.addOrderDetail();
		}
		if (o == btnXoa) {
			this.deleteOrderDetail();

		}
		if (o == btnLapHD) {
			if (checkValidLap()) {
				lapHoaDon();
				xoaTrangTatCa();
			}
		}
		if (o == btnLapDD) {
			if (checkDate() && checkValidLap() && hasKhach()) {
				lapDonDat();
				xoaTrangTatCa();
			}
		}
		if (o.equals(btnShowThuoc)) {
			hienFrameThuoc();
		}
		if (o.equals(btnChonFrame)) {
			chonThuoc();
		}
	}

	public void chonThuoc() {
		int rowSelected = tblFrameThuoc.getSelectedRow();
		String ma = (String) modelFrame.getValueAt(rowSelected, 1);
		String ten = (String) modelFrame.getValueAt(rowSelected, 2);
		String loai = (String) modelFrame.getValueAt(rowSelected, 3);
		String donVi = (String) modelFrame.getValueAt(rowSelected, 4);
		LocalDate hsd = (LocalDate) modelFrame.getValueAt(rowSelected, 5);
		newFrame.setVisible(false);
		txtMaThuoc.setText(ma);
		txtTenThuoc.setText(ten);
		txtLoaiThuoc.setText(loai);
		txtDonVi.setText(donVi);
		txtHSD.setText(hsd.toString());
	}

	public void xoaTrangThuoc() {
		txtMaThuoc.setText("");
		txtSoLuong.setText("");
		txtTenThuoc.setText("");
		txtLoaiThuoc.setText("");
		txtDonVi.setText("");
		txtHSD.setText("");
		txtMaThuoc.requestFocus();
	}

	public void xoaTrangTatCa() {
		txtMaThuoc.setText("");
		txtSoLuong.setText("");
		txtMaNV.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtTenThuoc.setText("");
		txtLoaiThuoc.setText("");
		txtDonVi.setText("");
		txtHSD.setText("");
		txtMaThuoc.requestFocus();
	}

	// KIỂM TRA VIỆC THÊM XÓA THUỐC VÀO ĐƠN

	private boolean checkHSD() {
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		Thuoc thuoc = thuocDao.timTheoMa(txtMaThuoc.getText()).get(0);
		if (thuoc.getHSD().isBefore(LocalDate.now().minusDays(3))) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Thuốc đã quá hạn hoặc sắp hết hạn!");
			return false;
		}
		return true;
	}

	public boolean checkQuatity() {
		if (txtSoLuong.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Vui lòng nhập số lượng thuốc!");
			return false;
		}

		Thuoc_Dao thuocDao = new Thuoc_Dao();
		List<Thuoc> listThuoc = thuocDao.timTheoMa(txtMaThuoc.getText()); // Tim Thuoc
		for (Thuoc thuoc : listThuoc) {
			if (thuoc.getSoLuongTon() < Integer.parseInt(txtSoLuong.getText())) {
				JOptionPane.showMessageDialog(this, "Lưu ý: Số lượng thuốc yêu cầu vượt quá thuốc tồn kho!");
				return false;
			}
		}

		try {
			int soLuongThuoc = Integer.parseInt(txtSoLuong.getText());
			if (soLuongThuoc <= 0) {
				JOptionPane.showMessageDialog(this, "Lưu ý: Số lượng phải > 0");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Nhập số lượng là số");
			return false;
		}
	}

	public boolean checkDate() {
		if (txtNgayNhan.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Vui lòng nhập Ngày lập");
			return false;
		}

		try {
			LocalDate ngayLapHD = LocalDate.parse(txtNgayLap.getText());
			LocalDate ngayNhanHD = LocalDate.parse(txtNgayNhan.getText());
			String ngayNhanText = txtNgayNhan.getText();

			if (ngayLapHD.isAfter(ngayNhanHD)) {
				JOptionPane.showMessageDialog(this, "Lưu ý: Ngày nhận phải sau Ngày lập");
				return false;
			}

			if (ngayNhanText.equals("")) {
				JOptionPane.showMessageDialog(this, "Lưu ý: Vui lòng nhập ngày nhận (yyyy-MM-dd)");
				return false;
			}

			if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2}", ngayNhanText)) {
				JOptionPane.showMessageDialog(this, "Lưu ý: Ngày nhận có định dạng là (yyyy-MM-dd)");
				return false;
			}
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Ngày nhận sai định dạng ngày (yyyy-MM-dd)");
			return false;
		}

		return true;
	}

	public boolean checkValidLap() {
		String maNV = txtMaNV.getText();
		String tenKhach = txtTenKH.getText();
		String sdt = txtSDT.getText();

		NhanVien_Dao nvDao = new NhanVien_Dao();

		if (nvDao.getNhanVien(maNV).isEmpty()) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Mã nhân viên không tồn tại");
			return false;
		}
		if (maNV.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập mã nhân viên");
			return false;
		}
		if (!Pattern.matches("([A-Z]{1}[a-z]+)( [A-Z]{1}[a-z]*)*", tenKhach) && !tenKhach.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Tên Khách chưa đúng định dạng");
			return false;
		}
		if (!Pattern.matches("^((84|0)(3[2-9]|5[2689]|7[06789]|8[1-9]|9[0-9])\\d{7})$", sdt) && !sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Số điện thoại chưa đúng định dạng");
			return false;
		}

		return true;
	}

//	XỬ LÝ SỰ KIỆN
	public boolean hasKhach() {
		if (txtTenKH.getText().equals("") || txtSDT.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Đơn đặt phải có đầy đủ thông tin Khách hàng");
			return false;
		}
		return true;
	}

	public boolean hasThuoc() {
		if (txtMaThuoc.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập thông tin thuốc!");
			return false;
		}
		return true;
	}

	public void addOrderDetail() {

		Thuoc_Dao thuocDao = new Thuoc_Dao();
		String maThuoc = txtMaThuoc.getText();
		Thuoc thuoc = thuocDao.timTheoMa(maThuoc).get(0);
		int soLuong = Integer.parseInt(txtSoLuong.getText());
		ChiTietHoaDon cthd = new ChiTietHoaDon(thuoc, soLuong);
		ChiTietDonDat ctdd = new ChiTietDonDat(thuoc, soLuong);

		int check = 0;
		for (int i = 0; i < tempListHD.size(); i++) {
			if (tempListHD.get(i).getMaThuoc().getMaThuoc().equalsIgnoreCase(maThuoc)
					&& tempListDD.get(i).getMaThuoc().getMaThuoc().equalsIgnoreCase(maThuoc)) {
				int slHD = tempListHD.get(i).getSoLuong();

				if (thuoc.getSoLuongTon() < slHD + soLuong) {
					JOptionPane.showMessageDialog(this, "Lưu ý: Số lượng thuốc yêu cầu vượt quá thuốc tồn kho!");
					check++;
					break;
				} else {
					tempListHD.get(i).setSoLuong(slHD + soLuong);
					tempListDD.get(i).setSoLuong(slHD + soLuong);
					check++;
					break;
				}
			}
		}

		if (check == 0) {
			tempListHD.add(cthd);
			tempListDD.add(ctdd);

			String[] rowData = { thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getLoaiThuoc(), thuoc.getGiaBan() + "",
					thuoc.getDonVi(), thuoc.getHSD() + "", soLuong + "", thuoc.getGiaBan() * soLuong + "" };
			modelHoaDon.addRow(rowData);
			xoaTrangThuoc();
		} else {
			int rowCount = modelHoaDon.getRowCount();
			for (int i = rowCount - 1; i >= 0; i--) {
				modelHoaDon.removeRow(i);
			}
			for (ChiTietDonDat chiTietDonDat : tempListDD) {
				String[] rowData = { chiTietDonDat.getMaThuoc().getMaThuoc(), chiTietDonDat.getMaThuoc().getTenThuoc(),
						chiTietDonDat.getMaThuoc().getLoaiThuoc(), chiTietDonDat.getMaThuoc().getGiaBan() + "",
						chiTietDonDat.getMaThuoc().getDonVi(), chiTietDonDat.getMaThuoc().getHSD() + "",
						chiTietDonDat.getSoLuong() + "",
						chiTietDonDat.getMaThuoc().getGiaBan() * chiTietDonDat.getSoLuong() + "" };
				modelHoaDon.addRow(rowData);
				xoaTrangThuoc();
			}
		}

//		Total Price
		double total = 0;
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			total += Double.parseDouble((String) modelHoaDon.getValueAt(i, 7));
		}
		txtTong.setText(total + "");
		System.out.println(tempListDD);
	}

	public void deleteOrderDetail() {
		int selectedRow = tblHoaDon.getSelectedRow();
		if (selectedRow != -1) {
			modelHoaDon.removeRow(selectedRow);
			resetTempListDD();
			resetTempListHD();
			xoaTrangThuoc();

			double total = 0;
			for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				String maThuoc = (String) tblHoaDon.getValueAt(i, 0);
				Thuoc thuoc = thuocDao.timTheoMa(maThuoc).get(0);
				int soLuong = Integer.parseInt(tblHoaDon.getValueAt(i, 6).toString());

				ChiTietHoaDon cthd = new ChiTietHoaDon(thuoc, soLuong);
				ChiTietDonDat ctdd = new ChiTietDonDat(thuoc, soLuong);
				tempListHD.add(cthd);
				tempListDD.add(ctdd);
				total += Double.parseDouble(modelHoaDon.getValueAt(i, 7).toString());
			}
			txtTong.setText(total + "");

			System.out.println(tempListDD);
		} else
			JOptionPane.showMessageDialog(null, "Lưu ý: Chưa có cột được chọn!");
	}

//	LẬP HÓA ĐƠN
	private void lapHoaDon() {
		KhachHang_Dao khachHangDao = new KhachHang_Dao();
		List<KhachHang> listKH = khachHangDao.getDSKH();
		String tenKH = txtTenKH.getText();
		String sdtKH = txtSDT.getText();
		KhachHang kh = khachHangDao.findBySDT(sdtKH);
		if (tenKH.equals("") && sdtKH.equals("")) {
			kh = khachHangDao.findById("KH00000");
		} else if (kh == null && !sdtKH.equals("")) {
			kh = new KhachHang(sdtKH, tenKH);
			int i = 0;
			while (i < listKH.size()) {
				if (listKH.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH())) {
					kh.setMaKH();
					i = 0;
				} else
					i++;
			}
			khachHangDao.addKhachHang(kh);
		} else if (kh == null && !tenKH.equals("")) {
			kh = new KhachHang("", tenKH);
			int i = 0;
			while (i < listKH.size()) {
				if (listKH.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH())) {
					kh.setMaKH();
					i = 0;
				} else
					i++;
			}
			khachHangDao.addKhachHang(kh);
		}

		NhanVien_Dao nhanVienDao = new NhanVien_Dao();
		String maNV = txtMaNV.getText();
		NhanVien nv = nhanVienDao.getNhanVien(maNV).get(0);

		LocalDate ngayLapHD = LocalDate.parse(txtNgayLap.getText());
		LocalDate ngayNhanHD = ngayLapHD;

		HoaDon_Dao hoaDonDao = new HoaDon_Dao();
		HoaDon hoaDon = new HoaDon(kh, nv, ngayLapHD, ngayNhanHD, tempListHD);

		hoaDonDao.addOne(hoaDon);
		int rowCount = modelHoaDon.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modelHoaDon.removeRow(i);
		}

//		Cập nhật số lượng trong kho
		for (ChiTietHoaDon chiTietHoaDon : hoaDon.getListChiTietHoaDon()) {
			Thuoc_Dao thuocDao = new Thuoc_Dao();
			thuocDao.updateThuocQuatity(chiTietHoaDon.getMaThuoc().getMaThuoc(), chiTietHoaDon.getSoLuong());
		}

		int rowCount2 = modelFrame.getRowCount();
		for (int i = rowCount2 - 1; i >= 0; i--) {
			modelFrame.removeRow(i);
		}

		resetTempListHD();
		resetTempListDD();
	}

//	LẬP ĐƠN ĐẶT
	private void lapDonDat() {
		KhachHang_Dao khachHangDao = new KhachHang_Dao();
		List<KhachHang> listKH = khachHangDao.getDSKH();
		String tenKH = txtTenKH.getText();
		String sdtKH = txtSDT.getText();
		KhachHang kh = khachHangDao.findBySDT(sdtKH);
		if (kh == null) {
			kh = new KhachHang(sdtKH, tenKH);
			int i = 0;
			while (i < listKH.size()) {
				if (listKH.get(i).getMaKH().equalsIgnoreCase(kh.getMaKH())) {
					kh.setMaKH();
					i = 0;
				} else
					i++;
			}
			khachHangDao.addKhachHang(kh);
		}

		NhanVien_Dao nhanVienDao = new NhanVien_Dao();
		String maNV = txtMaNV.getText();
		NhanVien nv = nhanVienDao.getNhanVien(maNV).get(0);

		LocalDate ngayLapHD = LocalDate.parse(txtNgayLap.getText());
		LocalDate ngayNhanHD = LocalDate.parse(txtNgayNhan.getText());

		DonDat_Dao donDatDao = new DonDat_Dao();
		DonDat donDat = new DonDat(kh, nv, ngayLapHD, ngayNhanHD, tempListDD);
		donDatDao.addOne(donDat);

		int rowCount = modelHoaDon.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modelHoaDon.removeRow(i);
		}

//		Cập nhật số lượng trong kho
		for (ChiTietDonDat chiTietDonDat : donDat.getListChiTietDonDat()) {
			Thuoc_Dao thuocDao = new Thuoc_Dao();
			thuocDao.updateThuocQuatity(chiTietDonDat.getMaThuoc().getMaThuoc(), chiTietDonDat.getSoLuong());
		}

		int rowCount2 = modelFrame.getRowCount();
		for (int i = rowCount2 - 1; i >= 0; i--) {
			modelFrame.removeRow(i);
		}

		resetTempListDD();
		resetTempListHD();
	}

//	RESET TEMP LIST
	public void resetTempListHD() {
		tempListHD.clear();
	}

	public void resetTempListDD() {
		tempListDD.clear();
	}

//	Frame Danh Sách Thuốc
	public void hienFrameThuoc() {
		newFrame = new JFrame("Danh Sách Thuốc");
		newFrame.setSize(1100, 400);
		newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

//		HEADER
		JPanel pnFrameNorth = new JPanel();
		JLabel lbNorth = new JLabel("Danh Sách Thuốc");
		lbNorth.setFont(fo24);
		lbNorth.setForeground(Color.blue);
		pnFrameNorth.add(lbNorth);

//			TABLE
		JPanel pnFrameCenter = new JPanel();
		String[] headers = { "NCC", "Mã thuốc", "Tên thuốc", "Loại", "Đơn vị", "HSD", "Giá nhập", "Giá bán", "Số lượng",
				"Xuất xứ" };
		modelFrame = new DefaultTableModel(headers, 0);
		tblFrameThuoc = new JTable(modelFrame);
		JScrollPane sp = new JScrollPane(tblFrameThuoc);
		tblFrameThuoc.setPreferredScrollableViewportSize(new Dimension(1000, 210));

		pnFrameCenter.add(sp);

		hienTableFrame();

//		Footer    		
		JPanel pnFrameSouth = new JPanel();

		Box boxFooterFrame = Box.createHorizontalBox();

		cbbTimFrame = new JComboBox<String>();
		cbbTimFrame.addItem("Mã thuốc");
		cbbTimFrame.addItem("Tên thuốc");
		cbbTimFrame.addItem("Loại thuốc");

		txtTimFrame = new JTextField(15);
		btnTimFrame = new JButton("Tìm");
		btnTimFrame.setBackground(new Color(0, 160, 255));

		btnResetFrame = new JButton("Reset");
		btnResetFrame.setBackground(new Color(0, 160, 255));

		btnChonFrame = new JButton("Chọn");
		btnChonFrame.setBackground(new Color(0, 160, 255));

		boxFooterFrame.add(cbbTimFrame);
		boxFooterFrame.add(Box.createHorizontalStrut(10));
		boxFooterFrame.add(txtTimFrame);
		boxFooterFrame.add(Box.createHorizontalStrut(10));
		boxFooterFrame.add(btnTimFrame);
		boxFooterFrame.add(Box.createHorizontalStrut(10));
		boxFooterFrame.add(btnResetFrame);
		boxFooterFrame.add(Box.createHorizontalStrut(50));
		boxFooterFrame.add(btnChonFrame);
		pnFrameSouth.add(boxFooterFrame);

		newFrame.add(pnFrameNorth, BorderLayout.NORTH);
		newFrame.add(pnFrameCenter, BorderLayout.CENTER);
		newFrame.add(pnFrameSouth, BorderLayout.SOUTH);
		newFrame.setVisible(true);

		btnTimFrame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timThuoc();
			}
		});

		btnResetFrame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtTimFrame.setText("");
				hienTableFrame();
			}
		});
		btnChonFrame.addActionListener(this);
	}

	public void hienTableFrame() {
		DefaultTableModel model = (DefaultTableModel) tblFrameThuoc.getModel();
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

//	TÌM THUỐC
	private void timThuoc() {
		// Lấy thông tin tìm kiếm
		String thongTin = txtTimFrame.getText();
		// Lấy cách tìm kiếm
		String cachTim = (String) cbbTimFrame.getSelectedItem();
		Thuoc_Dao thuocDao = new Thuoc_Dao();
		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		if (thongTin.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
			return;
		} else {
			if (cachTim.equals("Mã thuốc")) {
				List<Thuoc> listThuoc = thuocDao.timTheoMa(thongTin);
				if (listThuoc != null) {
					for (Thuoc thuoc : listThuoc) {
						DefaultTableModel model = (DefaultTableModel) tblFrameThuoc.getModel();
						model.setRowCount(0);
						Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
								thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(),
								thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
						model.addRow(rowData);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã thuốc.");
					hienTableFrame();
				}

			}
			if (cachTim.equals("Tên thuốc")) {
				if (thuocDao.timTheoTen(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) tblFrameThuoc.getModel();
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
					hienTableFrame();
				}
			}
			if (cachTim.equals("Loại thuốc")) {
				if (thuocDao.timTheoLoai(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) tblFrameThuoc.getModel();
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
					hienTableFrame();
				}
			}
		}

	}

//	MOUSE LISTENER
	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelectedDon = tblHoaDon.getSelectedRow();

		if (rowSelectedDon != -1) {
			txtMaThuoc.setText((String) tblHoaDon.getValueAt(rowSelectedDon, 0));
			txtSoLuong.setText((String) tblHoaDon.getValueAt(rowSelectedDon, 6));
			txtTenThuoc.setText((String) tblHoaDon.getValueAt(rowSelectedDon, 1));
			txtLoaiThuoc.setText((String) tblHoaDon.getValueAt(rowSelectedDon, 2));
			txtDonVi.setText((String) tblHoaDon.getValueAt(rowSelectedDon, 4));
			txtHSD.setText((String) tblHoaDon.getValueAt(rowSelectedDon, 5));
		}

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

//	DOCUMENT LISTENER
	private boolean processingDocumentEvent = false;

	@Override
	public void insertUpdate(DocumentEvent e) {
		if (!processingDocumentEvent) {
			processingDocumentEvent = true;
			if (txtTenThuoc.getDocument().equals(e.getDocument())) {
				updateDocByTen();
			} else {
				updateDocByMa();
			}
			processingDocumentEvent = false;
		}

		updateTenKHBySDT();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		if (!processingDocumentEvent) {
			processingDocumentEvent = true;
			if (txtTenThuoc.getDocument().equals(e.getDocument())) {
				updateDocByTen();
			} else {
				updateDocByMa();
			}
			processingDocumentEvent = false;
		}

		updateTenKHBySDT();
	}

	public void updateDocByMa() {
		if (processingDocumentEvent) {
			String maThuoc = txtMaThuoc.getText();
			Thuoc_Dao tDao = new Thuoc_Dao();

			if (!tDao.timTheoMa(maThuoc).isEmpty()) {
				Thuoc thuoc = tDao.timTheoMa(maThuoc).get(0);
				txtTenThuoc.setText(thuoc.getTenThuoc());
				txtLoaiThuoc.setText(thuoc.getLoaiThuoc());
				txtDonVi.setText(thuoc.getDonVi());
				txtHSD.setText(thuoc.getHSD().toString());
			} else {
				txtTenThuoc.setText("");
				txtLoaiThuoc.setText("");
				txtDonVi.setText("");
				txtHSD.setText("");
			}
		}
	}

	public void updateDocByTen() {
		if (processingDocumentEvent) {
			String tenThuoc = txtTenThuoc.getText();
			Thuoc_Dao tDao = new Thuoc_Dao();
			if (tDao.findByName(tenThuoc) != null) {
				Thuoc thuoc = tDao.findByName(tenThuoc);
				txtMaThuoc.setText(thuoc.getMaThuoc());
				txtLoaiThuoc.setText(thuoc.getLoaiThuoc());
				txtDonVi.setText(thuoc.getDonVi());
				txtHSD.setText(thuoc.getHSD().toString());
			} else {
				txtMaThuoc.setText("");
				txtLoaiThuoc.setText("");
				txtDonVi.setText("");
				txtHSD.setText("");
			}
		}
	}

	public void updateTenKHBySDT() {
		KhachHang_Dao khDao = new KhachHang_Dao();

		if (khDao.findBySDT(txtSDT.getText()) != null) {
			KhachHang kh = khDao.findBySDT(txtSDT.getText());
			txtTenKH.setText(kh.getHoTen());
			txtTenKH.setEditable(false);
		} else {
			txtTenKH.setText("");
			txtTenKH.setEditable(true);
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}
}
