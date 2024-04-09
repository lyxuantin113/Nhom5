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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietDonDat_Dao;
import dao.ChiTietHoaDon_Dao;
import dao.DonDat_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.NhanVien_Dao;
import dao.Thuoc_Dao;
import entity.DonDat;
import entity.HoaDon;

public class DSHoaDon extends JPanel implements ActionListener, MouseListener{
	private JComboBox<String> cbbTim;
	private JTable tableThuoc;
	private JTable tableHoaDon;
	private JButton btnTim;
	private JButton btnIn;
	private JButton btnReset;
	private Thuoc_Dao thuocDao;
	private NhanVien_Dao nhanVienDao;
	private KhachHang_Dao khachHangDao;
	private HoaDon_Dao hoaDonDao;
	private ChiTietHoaDon_Dao cthdDao;

	public DSHoaDon() {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Hóa Đơn");
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

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableHoaDon = new JPanel();
		JPanel pnTableThuoc = new JPanel();

//		Panel Right (Table Các Loại Thuốc Trong Đơn Đang Chọn)
		JLabel lbTableDSThuoc = new JLabel("Danh Sách Thuốc Trong Đơn:");
		lbTableDSThuoc.setFont(fo16);
		Box boxTableDSThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		tableThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tableThuoc = new JTable(modelThuoc));
		tableThuoc.setRowHeight(20);

		boxTableDSThuoc.add(lbTableDSThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));
		boxTableDSThuoc.add(scrollThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));

		pnTableHoaDon.add(boxTableDSThuoc);

//		Panel Left (Table Danh Sách Hóa Đơn Tìm Được)
		JLabel lbTableHoaDon = new JLabel("Danh Sách Hóa Đơn:");
		lbTableHoaDon.setFont(fo16);
		Box boxTableHoaDon = Box.createVerticalBox();
		String[] headerHoaDon = "Mã đơn;Mã NV;Tên khách;SĐT Khách;Ngày lập;Ngày nhận".split(";");
		DefaultTableModel modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		tableHoaDon = new JTable(modelHoaDon);
		JScrollPane scrollHoaDon = new JScrollPane();
		scrollHoaDon.setViewportView(tableHoaDon = new JTable(modelHoaDon));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableHoaDon.setRowHeight(20);

		boxTableHoaDon.add(lbTableHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));
		boxTableHoaDon.add(scrollHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));

		pnTableThuoc.add(boxTableHoaDon);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setRightComponent(pnTableHoaDon);
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
		
		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 160, 255));
		btnReset.setPreferredSize(new Dimension(100, 35));
		btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnIn = new JButton("In hóa đơn");
		btnIn.setBackground(new Color(0, 160, 255));
		btnIn.setPreferredSize(new Dimension(100, 35));
		btnIn.setCursor(new Cursor(Cursor.HAND_CURSOR));

		pnSouth.add(cbbTim);
		pnSouth.add(tfTim);
		pnSouth.add(btnTim);
		pnSouth.add(btnReset);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnIn);

//		ADD Center Panel
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);

//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);

//		END
		add(pnMain);
		
		thuocDao = new Thuoc_Dao();
		nhanVienDao = new NhanVien_Dao();
		khachHangDao = new KhachHang_Dao();
		hoaDonDao = new HoaDon_Dao();
		cthdDao = new ChiTietHoaDon_Dao();
		
		tableHoaDon.addMouseListener(this);
		tableThuoc.addMouseListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnIn.addActionListener(this);
		
		hienTableHoaDon();

	}

	private void hienTableHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
		model.setRowCount(0);

		List<HoaDon> listHoaDon = hoaDonDao.getDSHD();
		if (listHoaDon != null) {
			for (HoaDon hoaDon : listHoaDon) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaNV().getMaNV(), hoaDon.getMaKH().getHoTen()
						, hoaDon.getMaKH().getSoDienThoai(), hoaDon.getNgayLap(), hoaDon.getNgayNhan()}; // Tạo dữ liệu hàng mới

				model.addRow(rowData); // Thêm hàng vào model
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
