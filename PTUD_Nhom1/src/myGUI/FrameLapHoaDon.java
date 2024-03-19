package myGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class FrameLapHoaDon extends JFrame {
	public static void main(String[] args) {
		new FrameLapHoaDon();
	}
	
	public FrameLapHoaDon() {
//		JFRAME
		super("Quản lý hóa đơn");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setSize(1070, 600);
		setVisible(true);
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Lập Hóa Đơn");
		Font fo = new Font("Times New Roman", Font.BOLD, 24);
		headLb.setFont(fo);
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
		lbMaThuoc.setPreferredSize(new Dimension(90,0));
		JTextField tfMaThuoc = new JTextField(15);
		
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbMaThuoc);
		boxNhap.add(Box.createHorizontalStrut(10));
		boxNhap.add(tfMaThuoc);
		boxNhap.add(Box.createHorizontalStrut(30));
		
//		Số lượng
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setPreferredSize(lbMaThuoc.getPreferredSize());
		JTextField tfSoLuong = new JTextField(15);
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbSoLuong);
		boxNhap.add(Box.createHorizontalStrut(10));
		boxNhap.add(tfSoLuong);
		boxNhap.add(Box.createHorizontalStrut(30));
		
//		Ngày Lập
		JLabel lbNgayLap = new JLabel("Ngày Lập HD: ");
		lbNgayLap.setPreferredSize(lbMaThuoc.getPreferredSize());
		JTextField tfNgayLap = new JTextField(15);
		tfNgayLap.setEditable(false);
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(lbNgayLap);
		boxNhap.add(Box.createHorizontalStrut(10));
		boxNhap.add(tfNgayLap);
		boxNhap.add(Box.createHorizontalStrut(30));
		
//		BUTTON Thêm thuốc vào danh sách
		JButton btnThem = new JButton("Thêm");
		boxNhap.add(Box.createHorizontalStrut(30));
		boxNhap.add(btnThem);
		btnThem.setBackground(new Color(0,160,255));
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		boxNhap.add(Box.createHorizontalStrut(30));
		
		pnCenterTop.add(boxNhap);
		
//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableHoaDon = new JPanel();
		JPanel pnTableThuoc = new JPanel();
		
//		Panel Left (Table Hóa Đơn)
		JLabel lbTableHoaDon = new JLabel("Đơn Thuốc");
		Box boxTableHoaDon = Box.createVerticalBox();
		String[] headerHoaDon = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		JTable tableHoaDon = new JTable(modelHoaDon);
		JScrollPane scrollHoaDon = new JScrollPane();
		scrollHoaDon.setViewportView(tableHoaDon = new JTable(modelHoaDon));
		tableHoaDon.setRowHeight(20);

		boxTableHoaDon.add(lbTableHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));
		boxTableHoaDon.add(scrollHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));
		
		pnTableHoaDon.add(boxTableHoaDon);

//		Panel Right (Table Thuốc)
		JLabel lbTableThuoc = new JLabel("Danh Sách Thuốc");
		Box boxTableThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn vị;Đơn giá;HSD".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		JTable tableThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tableThuoc = new JTable(modelThuoc));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableThuoc.setRowHeight(20);
		
		boxTableThuoc.add(lbTableThuoc);
		boxTableThuoc.add(Box.createVerticalStrut(10));
		boxTableThuoc.add(scrollThuoc);
		boxTableThuoc.add(Box.createVerticalStrut(10));
		
		pnTableThuoc.add(boxTableThuoc);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setLeftComponent(pnTableHoaDon);
		jsplit.setRightComponent(pnTableThuoc);
		jsplit.setPreferredSize(new Dimension(1000, 310));  //SET CHIỀU CAO TABLE
		
		
		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));
		
//		TOTAL AND CREATE
		JPanel pnEndHD = new JPanel();
		pnEndHD.setLayout(new BoxLayout(pnEndHD, BoxLayout.X_AXIS));

		Box boxTong = Box.createHorizontalBox();
		
		JLabel lbTong = new JLabel("Tổng thành tiền:");
		lbTong.setPreferredSize(new Dimension(100,0));
		JTextField tfTong = new JTextField();
		tfTong.setPreferredSize(new Dimension(getWidth(), 30)); //SET ĐỘ RỘNG JTEXTFIELD
		tfTong.setEditable(false);
		boxTong.add(Box.createHorizontalStrut(30));
		boxTong.add(lbTong);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(tfTong);
		boxTong.add(Box.createHorizontalStrut(50));
		
		JLabel lbMaHD = new JLabel("Mã Hóa Đơn:");
		lbTong.setPreferredSize(new Dimension(100,0));
		JTextField tfMaHD = new JTextField();
		boxTong.add(Box.createHorizontalStrut(30));
		boxTong.add(lbMaHD);
		boxTong.add(Box.createHorizontalStrut(10));
		boxTong.add(tfMaHD);
		boxTong.add(Box.createHorizontalStrut(50));
		
		pnEndHD.add(boxTong);
		
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);
		pnCenter.add(pnEndHD, BorderLayout.SOUTH);
		pnCenter.add(Box.createVerticalStrut(20));
		
//		BUTTON LẬP HÓA ĐƠN
		JPanel pnSouth = new JPanel();		
		JButton btnLap = new JButton("Lập hóa đơn");
		btnLap.setBackground(new Color(0,160,255));
		btnLap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLap.setPreferredSize(new Dimension(110,35));
		pnSouth.add(btnLap);
		
		
//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);
		
//		END
		add(pnMain);
			
	}
}