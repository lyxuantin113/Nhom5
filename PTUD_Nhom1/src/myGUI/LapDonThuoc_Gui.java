package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Console;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietDonDat_Dao;
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

public class LapDonThuoc_Gui extends JPanel implements ActionListener, MouseListener {
	JButton btnThem;
	private JTextField tfMaThuoc;
	private JTextField tfSoLuong;
	private DefaultTableModel modelHoaDon;
	private JTable tableHoaDon;
	private JScrollPane scrollHoaDon;
	private DefaultTableModel modelThuoc;
	private JTable tableThuoc;
	private JScrollPane scrollThuoc;
	private JTextField tfTong;
	private JTextField tfNgayLap;
	private JTextField tfNgayNhan;
	private JTextField tfMaHD;
	private JTextField tfMaNV;
	private JTextField tfTenKH;
	private JTextField tfSDT;
	private JButton btnLapHD;
	private JButton btnLapDD;
	private JButton btnXoa;
	private JTextField tfTimThuoc;
	private JComboBox<String> cbbTimThuoc;
	private Thuoc_Dao thuocDao;
	private NhanVien_Dao nhanVienDao;
	private KhachHang_Dao khachHangDao;
	private HoaDon_Dao hoaDonDao;
	private DonDat_Dao donDatDao;
	private ChiTietHoaDon_Dao cthdDao;
	private ChiTietDonDat_Dao ctddDao;
	private JButton btnReset;
	private JButton btnTim;

	public LapDonThuoc_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Lập Đơn Thuốc");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		headLb.setFont(fo24);
		headLb.setForeground(Color.blue);
		headPn.add(headLb);

//		CENTER

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();
//		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

		Box boxNhap = Box.createHorizontalBox();

//		Mã Thuốc
		JLabel lbMaThuoc = new JLabel("Mã Thuốc: ");
		lbMaThuoc.setPreferredSize(new Dimension(90, 0));
		tfMaThuoc = new JTextField(15);

		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbMaThuoc);
		boxNhap.add(Box.createHorizontalStrut(5));
		boxNhap.add(tfMaThuoc);
		boxNhap.add(Box.createHorizontalStrut(30));

//		Số lượng
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setPreferredSize(lbMaThuoc.getPreferredSize());
		tfSoLuong = new JTextField(15);
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbSoLuong);
		boxNhap.add(Box.createHorizontalStrut(5));
		boxNhap.add(tfSoLuong);
		boxNhap.add(Box.createHorizontalStrut(30));

//		BUTTON Thêm, xóa thuốc trong danh sách
		btnThem = new JButton("Thêm");
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(btnThem);
		btnThem.setBackground(new Color(0, 160, 255));
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnXoa = new JButton("Xóa");
		boxNhap.add(Box.createHorizontalStrut(20));
		boxNhap.add(btnXoa);
		btnXoa.setBackground(new Color(0, 160, 255));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boxNhap.add(Box.createHorizontalStrut(30));

		pnCenterTop.add(boxNhap);

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableHoaDon = new JPanel();
		JPanel pnTableThuoc = new JPanel();
		pnTableThuoc.setLayout(new BoxLayout(pnTableThuoc, BoxLayout.Y_AXIS));

//		Panel Left (Table Đơn Đặt)
		JLabel lbTableHoaDon = new JLabel("Đơn Thuốc:");
		lbTableHoaDon.setFont(fo16);
		Box boxTableHoaDon = Box.createVerticalBox();
		String[] headerHoaDon = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;Số lượng;Thành tiền".split(";");
		modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		tableHoaDon = new JTable(modelHoaDon);
		scrollHoaDon = new JScrollPane();
		scrollHoaDon.setViewportView(tableHoaDon = new JTable(modelHoaDon));
		tableHoaDon.setRowHeight(20);
		tableHoaDon.setAutoCreateRowSorter(true);

		boxTableHoaDon.add(lbTableHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));
		boxTableHoaDon.add(scrollHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));

		pnTableHoaDon.add(boxTableHoaDon);

//		Panel Right (Table Thuốc)
		JLabel lbTableThuoc = new JLabel("Danh Sách Thuốc:");
		lbTableThuoc.setFont(fo16);
		Box boxTableThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Đơn giá;Tồn kho".split(";");
		modelThuoc = new DefaultTableModel(headerThuoc, 0);
		tableThuoc = new JTable(modelThuoc);
		tableThuoc.setAutoCreateRowSorter(true);
		scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tableThuoc = new JTable(modelThuoc));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableThuoc.setRowHeight(20);

		boxTableThuoc.add(lbTableThuoc);
		boxTableThuoc.add(Box.createVerticalStrut(10));
		boxTableThuoc.add(scrollThuoc);
		boxTableThuoc.add(Box.createVerticalStrut(10));

//		Box Tim Kiem Thuoc
		Box timThuocBox = Box.createHorizontalBox();

		cbbTimThuoc = new JComboBox<String>();
		cbbTimThuoc.addItem("Mã thuốc");
		cbbTimThuoc.addItem("Tên thuốc");
		cbbTimThuoc.addItem("Loại thuốc");
		cbbTimThuoc.addItem("Nhà cung cấp");

		tfTimThuoc = new JTextField();
		btnTim = new JButton("Tìm");
		btnTim.setBackground(new Color(0, 160, 255));

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 160, 255));

		timThuocBox.add(cbbTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(tfTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(btnTim);
		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(btnReset);

		pnTableThuoc.add(boxTableThuoc);
//		pnTableThuoc.add(Box.createVerticalStrut(10));
		pnTableThuoc.add(timThuocBox);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setLeftComponent(pnTableHoaDon);
		jsplit.setRightComponent(pnTableThuoc);
		jsplit.setPreferredSize(new Dimension(1000, 330)); // SET CHIỀU CAO TABLE

		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));

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
		tfTong = new JTextField(20);
		tfTong.setEditable(false);
		tfTong.setText(0 + "");
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(lbTong);
		boxTong.add(tfTong);

//		Ngày Lập
		JLabel lbNgayLap = new JLabel("Ngày Lập HD: ");
		lbNgayLap.setPreferredSize(new Dimension(100, 30));
		tfNgayLap = new JTextField(20);
		tfNgayLap.setText(LocalDate.now().toString());
		tfNgayLap.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(30));
		boxTong.add(lbNgayLap);
		boxTong.add(tfNgayLap);

//		Ngày Nhận
		JLabel lbNgayNhan = new JLabel("Ngày Nhận: ");
		lbNgayNhan.setPreferredSize(new Dimension(100, 30));
		tfNgayNhan = new JTextField(20);
		boxTong.add(Box.createHorizontalStrut(30));
		boxTong.add(lbNgayNhan);
		boxTong.add(tfNgayNhan);

		pnEndHD.add(boxTong);
		pnEndHD.add(Box.createVerticalStrut(10));

//		BOX2
//		Mã Đơn Đặt
		JLabel lbMaHD = new JLabel("Mã Đơn:");
		lbMaHD.setPreferredSize(new Dimension(100, 30));
		tfMaHD = new JTextField(20);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(lbMaHD);
		boxMa.add(tfMaHD);

//		Mã NV
		JLabel lbMaNV = new JLabel("Mã Nhân Viên: ");
		lbMaNV.setPreferredSize(new Dimension(100, 30));
		tfMaNV = new JTextField(20);
		boxMa.add(Box.createHorizontalStrut(30));
		boxMa.add(lbMaNV);
		boxMa.add(tfMaNV);
		pnEndHD.add(boxMa);
		pnEndHD.add(Box.createVerticalStrut(10));

//		Box 3
//		Tên Khách Hàng
		JLabel lbTenKH = new JLabel("Tên Khách: ");
		lbTenKH.setPreferredSize(new Dimension(100, 30));
		tfTenKH = new JTextField(20);
		boxKH.add(Box.createHorizontalStrut(10));
		boxKH.add(lbTenKH);
		boxKH.add(tfTenKH);

//		Số Điện Thoại KH
		JLabel lbSDT = new JLabel("Số ĐT Khách:");
		lbSDT.setPreferredSize(new Dimension(100, 30));
		tfSDT = new JTextField(20);
		boxKH.add(Box.createHorizontalStrut(30));
		boxKH.add(lbSDT);
		boxKH.add(tfSDT);
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
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);
		pnCenter.add(pnEndHD, BorderLayout.SOUTH);
		pnCenter.add(Box.createVerticalStrut(20));

//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);

//		END
		add(pnMain);

//		ADD ACTIONLISTENER
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnThem.addActionListener(this);
		btnLapHD.addActionListener(this);
		btnLapDD.addActionListener(this);
		tableThuoc.addMouseListener(this);
		tableHoaDon.addMouseListener(this);

		thuocDao = new Thuoc_Dao();
		nhanVienDao = new NhanVien_Dao();
		khachHangDao = new KhachHang_Dao();
		hoaDonDao = new HoaDon_Dao();
		donDatDao = new DonDat_Dao();
		cthdDao = new ChiTietHoaDon_Dao();
		ctddDao = new ChiTietDonDat_Dao();

		ConnectDB.connect();
		hienTableThuoc();
		hienTableHoaDon();
	}

	private void hienTableThuoc() {
		DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
		model.setRowCount(0);
		// Lấy danh sách thuốc từ database
		Thuoc_Dao thuocDao = new Thuoc_Dao();

		List<Thuoc> dsThuoc = thuocDao.readFromTable();
		for (Thuoc thuoc : dsThuoc) {
			Object[] rowData = { thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getLoaiThuoc(),
					thuoc.getDonVi(), thuoc.getGiaBan(), thuoc.getSoLuongTon()};
			model.addRow(rowData);
		}
	}

	private void hienTableHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
		model.setRowCount(0);

		Map<Thuoc, Integer> mapThuoc = cthdDao.getDanhSachDon();
		if(mapThuoc!=null) {
			for (Map.Entry<Thuoc, Integer> entry : mapThuoc.entrySet()) {
				Thuoc thuoc = entry.getKey();
				Integer soLuong = entry.getValue();

				Object[] rowData = { thuoc.getMaThuoc(), thuoc.getTenThuoc(), soLuong }; // Tạo dữ liệu hàng mới

				model.addRow(rowData); // Thêm hàng vào model
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnThem) {
			if (this.checkQuatity()) {
				this.addOrderDetail();
				xoaTrangThuoc();
			} else
				JOptionPane.showMessageDialog(this, "Lưu ý: Số thuốc vượt quá thuốc tồn kho!");
		}
		if (o == btnXoa) {
			this.deleteOrderDetail();
		}
		if (o == btnLapHD) {
//			Check isValid();
			lapHoaDon();
			cthdDao.resetDanhSachDon();
			xoaTrangTatCa();
		}
		if (o == btnLapDD) {
//			Check ngày lập và nhận
			lapDonDat();
			cthdDao.resetDanhSachDon();
			xoaTrangTatCa();
		}
		if (o.equals(btnTim)) {
			timThuoc();
		}
		if (o.equals(btnReset)) {
			tfTimThuoc.setText("");
			hienTableThuoc();
		}

	}

	public void xoaTrangThuoc() {
		tfMaThuoc.setText("");
		tfSoLuong.setText("");
		tfMaThuoc.requestFocus();
	}

	public void xoaTrangTatCa() {
		tfMaThuoc.setText("");
		tfSoLuong.setText("");
		tfMaHD.setText("");
		tfMaNV.setText("");
		tfTenKH.setText("");
		tfSDT.setText("");
		tfMaThuoc.requestFocus();
	}

	// KIỂM TRA VIỆC THÊM XÓA THUỐC VÀO ĐƠN
	public boolean checkQuatity() {
		List<Thuoc> listThuoc = thuocDao.timTheoMa(tfMaThuoc.getText()); //Tim Thuoc
		for (Thuoc thuoc : listThuoc) {			
			if(thuoc.getSoLuongTon() < Integer.parseInt(tfSoLuong.getText())) 
				return false;
		}
		return true;
	}

	public void addOrderDetail() {
		Map<Thuoc, Integer> dshd = cthdDao.getDanhSachDon();
		String maThuoc = tfMaThuoc.getText();
		List<Thuoc> listThuoc = thuocDao.timTheoMa(maThuoc); // Tim Thuoc
		int soLuong = Integer.parseInt(tfSoLuong.getText());
		Thuoc thuoc = listThuoc.get(0);
//		Add OrderDetail vao' Map
		if (dshd != null && dshd.containsKey(thuoc)) {
			int value = dshd.get(thuoc);
			int newValue = value + soLuong;
			cthdDao.addDanhSachDon(thuoc, newValue);
		} else
			cthdDao.addDanhSachDon(thuoc, soLuong);

//		Trừ đi số lương tồn
		int updateTonKho = thuoc.getSoLuongTon() - soLuong;
		thuoc.setSoLuongTon(updateTonKho);

		String[] rowData = { thuoc.getMaThuoc(), thuoc.getTenThuoc(), thuoc.getLoaiThuoc(), thuoc.getGiaBan() + "",
				thuoc.getDonVi(), soLuong + "", thuoc.getGiaBan() * soLuong + "" };
		modelHoaDon.addRow(rowData);

//		Total Price
		double total = 0;
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			total += Double.parseDouble(modelHoaDon.getValueAt(i, 6).toString());
		}
		tfTong.setText(total + "");

	}

	public void deleteOrderDetail() {
		Map<Thuoc, Integer> dshd = cthdDao.getDanhSachDon();
		int selectedRow = tableHoaDon.getSelectedRow();
		if (selectedRow != -1) {
			String maThuoc = (String) tableHoaDon.getValueAt(selectedRow, 0);
			int soLuong = (int) tableHoaDon.getValueAt(selectedRow, 5);
			// Tìm thuốc trong danhSachDon có mã là maThuoc và xóa nó nếu tồn tại
			Iterator<Map.Entry<Thuoc, Integer>> iterator = dshd.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Thuoc, Integer> entry = iterator.next();
				Thuoc thuoc = entry.getKey();
				if (thuoc.getMaThuoc().equals(maThuoc)) {
					iterator.remove();
					int updateTonKho = thuoc.getSoLuongTon() + soLuong;
					thuoc.setSoLuongTon(updateTonKho);
					
					cthdDao.deleteDanhSachDon(thuoc);
					modelHoaDon.removeRow(selectedRow);
				}
			}
		} else
			JOptionPane.showMessageDialog(null, "Lưu ý: Chưa có cột được chọn!");
	}

//	LẬP HÓA ĐƠN
	private void lapHoaDon() {
		Map<Thuoc, Integer> dshd = cthdDao.getDanhSachDon();
		String tenKH = tfTenKH.getText();
		String sdtKH = tfSDT.getText();
		KhachHang kh = new KhachHang(tenKH, sdtKH);
		if (!khachHangDao.getDSKH().contains(kh))
			khachHangDao.addKhachHang(kh);
		System.out.println(kh);
		String maNV = tfMaNV.getText();
		List<NhanVien> listNhanVien = nhanVienDao.getNhanVien(maNV);
		NhanVien nv = listNhanVien.get(0);
		System.out.println(nv);

		LocalDate ngayLapHD = LocalDate.parse(tfNgayLap.getText());
		LocalDate ngayNhanHD = ngayLapHD;

		HoaDon hoaDon = new HoaDon(kh, nv, ngayLapHD, ngayNhanHD, null);

//		Tạo List<ChiTietHoaDon>
		List<ChiTietHoaDon> listChiTietHoaDon = new ArrayList<>();

		// Duyệt qua mỗi cặp key-value trong mapChiTiet
		for (Map.Entry<Thuoc, Integer> entry : dshd.entrySet()) {
			Thuoc thuoc = entry.getKey();
			int soLuong = entry.getValue();

			ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(hoaDon, thuoc, soLuong);
			chiTietHoaDon.setMaThuoc(thuoc);
			chiTietHoaDon.setSoLuong(soLuong);
			listChiTietHoaDon.add(chiTietHoaDon);
		}

		hoaDon.setCthd(listChiTietHoaDon);

		hoaDonDao.addOne(hoaDon);
		int rowCount = modelHoaDon.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modelHoaDon.removeRow(i);
		}
	}

//	LẬP ĐƠN ĐẶT
	private void lapDonDat() {
		Map<Thuoc, Integer> dshd = cthdDao.getDanhSachDon();
		String tenKH = tfTenKH.getText();
		String sdtKH = tfSDT.getText();
		KhachHang kh = new KhachHang(tenKH, sdtKH);
		if (!khachHangDao.getDSKH().contains(kh))
			khachHangDao.addKhachHang(kh);

		String maNV = tfMaNV.getText();
		List<NhanVien> listNhanVien = nhanVienDao.getNhanVien(maNV);
		NhanVien nv = listNhanVien.get(0);

		LocalDate ngayLapHD = LocalDate.parse(tfNgayLap.getText());
		LocalDate ngayNhanHD = LocalDate.parse(tfNgayNhan.getText());
		;

		DonDat donDat = new DonDat(kh, nv, ngayLapHD, ngayNhanHD, null);

//		Tạo List<ChiTietDonDat>
		List<ChiTietDonDat> listChiTietDonDat = new ArrayList<>();

		// Duyệt qua mỗi cặp key-value trong mapChiTiet
		for (Map.Entry<Thuoc, Integer> entry : dshd.entrySet()) {
			Thuoc thuoc = entry.getKey();
			int soLuong = entry.getValue();

			ChiTietDonDat chiTietDonDat = new ChiTietDonDat(donDat, thuoc, soLuong);
			chiTietDonDat.setMaThuoc(thuoc);
			chiTietDonDat.setSoLuong(soLuong);
			listChiTietDonDat.add(chiTietDonDat);
		}

		donDat.setCtdd(listChiTietDonDat);

		donDatDao.addOne(donDat);
		int rowCount = modelHoaDon.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modelHoaDon.removeRow(i);
		}
	}
	
//	TÌM THUỐC
	private void timThuoc() {
		// Lấy thông tin tìm kiếm
		String thongTin = tfTimThuoc.getText();
		// Lấy cách tìm kiếm
		String cachTim = (String) cbbTimThuoc.getSelectedItem();
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
						DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
						model.setRowCount(0);
						Object[] rowData = { thuoc.getMaNCC(), thuoc.getMaThuoc(), thuoc.getTenThuoc(),
								thuoc.getLoaiThuoc(), thuoc.getDonVi(), thuoc.getHSD(), thuoc.getGiaNhap(),
								thuoc.getGiaBan(), thuoc.getSoLuongTon(), thuoc.getNuocSanXuat() };
						model.addRow(rowData);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã thuốc.");
					hienTableThuoc();
				}

			}
			if (cachTim.equals("Tên thuốc")) {
				if (thuocDao.timTheoTen(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
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
					hienTableThuoc();
				}
			}
			if (cachTim.equals("Loại thuốc")) {
				if (thuocDao.timTheoLoai(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
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
					hienTableThuoc();
				}
			}
			if (cachTim.equals("Nhà cung cấp")) {
				if (thuocDao.timTheoNCC(thongTin)) {
					DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
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
					hienTableThuoc();
				}
			}

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		Bắt sự kiện Mouse cho Danh Sách Thuốc
		int rowSelectedThuoc = tableThuoc.getSelectedRow();
		int rowSelectedDon = tableHoaDon.getSelectedRow();

		if (rowSelectedThuoc != -1) {
			tfMaThuoc.setText((String) tableThuoc.getValueAt(rowSelectedThuoc, 0));
		}

		if (rowSelectedDon != -1) {
			tfMaThuoc.setText((String) tableHoaDon.getValueAt(rowSelectedDon, 0));
			tfSoLuong.setText((String) tableHoaDon.getValueAt(rowSelectedDon, 5));
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
}
