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
import entity.DonDat;
import entity.Thuoc;

public class DSDonDat_Gui extends JPanel implements ActionListener, MouseListener {

	private JComboBox<String> cbbTim;
	private JButton btnReset;
	private JButton btnHoanThanh;
	private JButton btnTim;
	private JTable tableDonDat;
	private JTable tblThuoc;
	private Thuoc_Dao thuocDao;
	private NhanVien_Dao nhanVienDao;
	private KhachHang_Dao khachHangDao;
	private DonDat_Dao donDatDao;
	private ChiTietDonDat_Dao ctddDao;

//	Nút Chuyển Qua DS Hóa Đơn ????????????????

	public DSDonDat_Gui() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Đơn Đặt");
		Font fo = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		headLb.setFont(fo);
		headLb.setForeground(Color.blue);
		pnHead.add(headLb);

//		CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();
//		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableDonDat = new JPanel();
		JPanel pnTableThuoc = new JPanel();

//		Panel Right (Table Các Loại Thuốc Trong Đơn Đang Chọn)
		JLabel lblTableDSThuoc = new JLabel("Danh Sách Thuốc Trong Đơn:");
		lblTableDSThuoc.setFont(fo16);
		Box boxTableDSThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		tblThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tblThuoc = new JTable(modelThuoc));
		tblThuoc.setRowHeight(20);

		boxTableDSThuoc.add(lblTableDSThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));
		boxTableDSThuoc.add(scrollThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));

		pnTableDonDat.add(boxTableDSThuoc);

//		Panel Left (Table Danh Sách Hóa Đơn Tìm Được)
		JLabel lblTableDonDat = new JLabel("Danh Sách Đơn Đặt:");
		lblTableDonDat.setFont(fo16);
		Box boxTableDonDat = Box.createVerticalBox();
		String[] headerDonDat = "Mã đơn;Mã NV;Tên khách;SĐT Khách;Ngày lập;Ngày nhận".split(";");
		DefaultTableModel modelDonDat = new DefaultTableModel(headerDonDat, 0);
		tableDonDat = new JTable(modelDonDat);
		JScrollPane scrollDonDat = new JScrollPane();
		scrollDonDat.setViewportView(tableDonDat = new JTable(modelDonDat));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableDonDat.setRowHeight(20);

		boxTableDonDat.add(lblTableDonDat);
		boxTableDonDat.add(Box.createVerticalStrut(10));
		boxTableDonDat.add(scrollDonDat);
		boxTableDonDat.add(Box.createVerticalStrut(10));

		pnTableThuoc.add(boxTableDonDat);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setRightComponent(pnTableDonDat);
		jsplit.setLeftComponent(pnTableThuoc);
		jsplit.setSize(1500, 470);
		jsplit.setPreferredSize(new Dimension(950, 470)); // SET CHIỀU CAO TABLE

		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));

//		SOUTH
		JPanel pnSouth = new JPanel();

		cbbTim = new JComboBox<String>();
		cbbTim.addItem("Mã đơn");
		cbbTim.addItem("Mã Nhân viên");
		cbbTim.addItem("Ngày lập");
		cbbTim.addItem("Ngày nhận");
		cbbTim.setPreferredSize(new Dimension(110, 35));

		JTextField tfTim = new JTextField(17);
		tfTim.setPreferredSize(new Dimension(0, 35));
		btnTim = new JButton("Tìm kiếm");
		btnTim.setBackground(new Color(0, 160, 255));
		btnTim.setPreferredSize(new Dimension(100, 35));
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnHoanThanh = new JButton("Hoàn Thành Đơn");
		btnHoanThanh.setBackground(new Color(0, 160, 255));
		btnHoanThanh.setPreferredSize(new Dimension(150, 35));
		btnHoanThanh.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 160, 255));
		btnReset.setPreferredSize(new Dimension(150, 35));
		btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

		pnSouth.add(cbbTim);
		pnSouth.add(tfTim);
		pnSouth.add(btnTim);
		pnSouth.add(btnReset);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnHoanThanh);

//		End
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);

		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnSouth, BorderLayout.SOUTH);
		add(pnMain);
		
		thuocDao = new Thuoc_Dao();
		nhanVienDao = new NhanVien_Dao();
		khachHangDao = new KhachHang_Dao();
		donDatDao = new DonDat_Dao();
		ctddDao = new ChiTietDonDat_Dao();
		
		tblThuoc.addMouseListener(this);
		tableDonDat.addMouseListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnHoanThanh.addActionListener(this);

		hienTableDonDat();
	}

	private void hienTableDonDat() {
		DefaultTableModel model = (DefaultTableModel) tableDonDat.getModel();
		model.setRowCount(0);

		List<DonDat> listDonDat = donDatDao.getDSPDT();
		if (listDonDat != null) {
			for (DonDat donDat : listDonDat) {
				Object[] rowData = { donDat.getMaDonDat(), donDat.getMaNV().getMaNV(), donDat.getMaKH().getHoTen()
						, donDat.getMaKH().getSoDienThoai(), donDat.getNgayLap(), donDat.getNgayNhan()}; // Tạo dữ liệu hàng mới

				model.addRow(rowData); // Thêm hàng vào model
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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
