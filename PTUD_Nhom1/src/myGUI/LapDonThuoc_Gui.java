package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dao.Thuoc_Dao;
import entity.ChiTietDonDat;
import entity.ChiTietHoaDon;
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
	private JComboBox<String> cbbTimThuoc;
	private Thuoc_Dao thuocDao;
	private HoaDon_Dao hoaDonDao;
	private DonDat_Dao donDatDao;
	private ChiTietHoaDon_Dao cthdDao;
	private ChiTietDonDat_Dao ctddDao;

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

		cbbTimThuoc = new JComboBox<String>();
		cbbTimThuoc.addItem("Mã thuốc");
		cbbTimThuoc.addItem("Tên thuốc");
		cbbTimThuoc.addItem("Loại thuốc");
		cbbTimThuoc.addItem("Nhà cung cấp");

		tfTimThuoc = new JTextField();
		btnTimThuoc = new JButton("Tìm");
		btnTimThuoc.setBackground(new Color(0, 160, 255));

		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(cbbTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(tfTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(10));
		timThuocBox.add(btnTimThuoc);
		timThuocBox.add(Box.createHorizontalStrut(10));

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

		thuocDao = new Thuoc_Dao();
		hoaDonDao = new HoaDon_Dao();
		donDatDao = new DonDat_Dao();
		cthdDao = new ChiTietHoaDon_Dao();
		ctddDao = new ChiTietDonDat_Dao();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		Map<Thuoc, Integer> listChiTiet = null;
		if (o == btnThem) {
			if (this.checkQuatity())
				listChiTiet = this.addOrderDetail();
			else
				JOptionPane.showMessageDialog(this, "Lưu ý: Số thuốc vượt quá thuốc tồn kho!");
		}
		if (o == btnXoa) {
			listChiTiet = this.deleteOrderDetail(listChiTiet);
		}
		if (o == btnLapHD) {
			
		}
		if (o == btnLapDD) {

		}

	}

	public boolean checkQuatity() {
//		Thuoc thuoc = thuocDao.findById(tfMaThuoc.getText()); //Tim Thuoc
//		if(thuoc.getSoLuong() < Integer.parseInt(tfSoLuong.getText())) 
//			return false;
		return true;
	}

	public Map<Thuoc, Integer> addOrderDetail() {
//		Mở hết comment
		Map<Thuoc, Integer> listChiTiet = null;
		String maThuoc = tfMaThuoc.getText();
//		Thuoc thuoc = thuocDao.findById(maThuoc); //Tim Thuoc
		int soLuong = Integer.parseInt(tfSoLuong.getText());

//		Add OrderDetail vao' Map
//		if (listChiTiet.containsKey(thuoc)) {
//            int value = listChiTiet.get(thuoc);
//            int newValue = value + soLuong;
//		}
//		listChiTiet.put(thuoc, soLuong)
//		String[] rowData = {thuoc.getMaThuoc, thuoc.getTenThuoc, thuoc.getLoaiThuoc
//						, thuoc.getGiaBan, thuoc.getDonVi, soLuong+"", thuoc.getGiaBan*soLuong+""};
//		modelHoaDon.addRow(rowData);

//		Total Price
		double total = 0;
		for (int i = 0; i < modelHoaDon.getRowCount(); i++) {
			total += Double.parseDouble(modelHoaDon.getValueAt(i, 7).toString());
		}
		tfTong.setText(total + "");

		return listChiTiet;
	}

	public Map<Thuoc, Integer> deleteOrderDetail(Map<Thuoc, Integer> listChiTiet) {
		int selectedRow = tableHoaDon.getSelectedRow();
		if (selectedRow != -1) {
			String maThuoc = (String) tableHoaDon.getValueAt(selectedRow, 0);

			// Tìm thuốc trong listChiTiet có mã là maThuoc và xóa nó nếu tồn tại
			Iterator<Map.Entry<Thuoc, Integer>> iterator = listChiTiet.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<Thuoc, Integer> entry = iterator.next();
				Thuoc thuoc = entry.getKey();
				if (thuoc.getMaThuoc().equals(maThuoc))
					iterator.remove();
			}
		} else
			JOptionPane.showMessageDialog(null, "Lưu ý: Chưa có cột được chọn!");

		return listChiTiet;
	}

}
