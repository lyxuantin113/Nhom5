package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.Thuoc_Dao;
import entity.ChiTietHoaDon;
import entity.DanhSachThuoc;
import entity.Thuoc;

public class LapDonThuoc_Gui extends JPanel implements ActionListener {
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
	private JButton btnTimThuoc;
	
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
		String[] headerHoaDon = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Số lượng;Thành tiền".split(";");
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
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Đơn giá;HSD".split(";");
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
		tfTimThuoc = new JTextField();
		btnTimThuoc = new JButton("Tìm");
		timThuocBox.add(Box.createHorizontalStrut(50));
		timThuocBox.add(tfTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(btnTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(50));
		
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
		btnLapDD = new JButton("Lập Hóa Đơn");
		btnLapDD.setBackground(new Color(0, 160, 255));
		btnLapDD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLapDD.setPreferredSize(new Dimension(150, 35));
		
		btnLapHD = new JButton("Lập Đơn Đặt");
		btnLapHD.setBackground(new Color(0, 160, 255));
		btnLapHD.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLapHD.setPreferredSize(new Dimension(150, 35));

		pnSouth.add(btnLapDD);	
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnLapHD);

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
		btnThem.addActionListener(this);
		btnLapHD.addActionListener(this);
		btnLapDD.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnThem) {
			themThuocVaoDon();
		}
		if (o == btnLapHD) {
			lapHoaDon();
		}
		if (o == btnLapDD) {
			
		}

	}

	public void themThuocVaoDon() {
		String maThuoc = tfMaThuoc.getText();
		int soLuong = Integer.parseInt(tfSoLuong.getText());
		Thuoc_Dao td = new Thuoc_Dao();
//		Thuoc thuoc = td.timThuocTheoMa(maThuoc); -> Trả về Thuốc
//		String[] rowData = {thuoc.getMaThuoc, thuoc.getTenThuoc, thuoc.getLoaiThuoc
//						, thuoc.getDonVi, soLuong+"", thuoc.getGiaBan*soLuong+""};
//		modelHoaDon.addRow(rowData);

//		Total Price
		double total = 0;
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			total += Double.parseDouble(modelHoaDon.getValueAt(i, 6).toString());
		}
		tfTong.setText(total + "");
	}

	public ChiTietHoaDon lapHoaDon() {
		ChiTietHoaDon cthd = null;
		List<DanhSachThuoc> dst = null;
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
//			Add Thuốc Vào Danh sách Thuốc
			dst = new ArrayList<>();
			String ma = modelHoaDon.getValueAt(i, 1).toString();
			Thuoc t = new Thuoc(ma, "", "", "", null, 0, 0, null);
			int sl = Integer.parseInt(modelHoaDon.getValueAt(i, 5).toString());

			DanhSachThuoc ds = new DanhSachThuoc(t, sl);
			dst.add(ds);
		}
		
//		cthd = new ChiTietHoaDon(, dst)
		return cthd;
	}
}
