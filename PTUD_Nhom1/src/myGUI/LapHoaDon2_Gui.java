package myGUI;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class LapHoaDon2_Gui extends JPanel{

	public LapHoaDon2_Gui() {
		// JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		//HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Lập Hóa Đơn");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		lblHead.setFont(fo24);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
		pnMain.add(pnHead, BorderLayout.NORTH);
		
		//CENTER
	    JPanel pnCenter = new JPanel();
	    pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
	    
	    Box b1 = Box.createHorizontalBox();
	    JLabel lblKH = new JLabel("Khách hàng: ");
	    lblKH.setPreferredSize(new Dimension(90, 25));
	    JTextField txtKH = new JTextField(15);
	    JLabel lblSDT = new JLabel("Số điện thoại: ");
	    lblSDT.setPreferredSize(new Dimension(90, 25));
	    JTextField txtSDT = new JTextField(15);
	    b1.add(Box.createHorizontalStrut(30));
	    b1.add(lblKH);
	    b1.add(Box.createHorizontalStrut(10));
	    b1.add(txtKH);
	    b1.add(Box.createHorizontalStrut(30));
	    b1.add(lblSDT);
	    b1.add(Box.createHorizontalStrut(10));
	    b1.add(txtSDT);
		pnCenter.add(b1);
		//
		JPanel pnCenterContent = new JPanel();
		pnCenterContent.setLayout(new BoxLayout(pnCenterContent, BoxLayout.X_AXIS));
		//Left
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		JLabel lblTim = new JLabel("Tìm: ");
		JTextField txtTim = new JTextField(15);
		txtTim.setMaximumSize(new Dimension(500, 200));
		JButton btnTim = new JButton("Tìm");
		pnLeft.add(lblTim);
		pnLeft.add(txtTim);
		pnLeft.add(btnTim);
		//Table Left
		String[] headers = {};
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(300, 500));
		pnLeft.add(pane);
		//Right
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		Box b5 = Box.createHorizontalBox();
		Box b6 = Box.createHorizontalBox();
		Box b7 = Box.createHorizontalBox();
		
		JLabel lblMaThuoc = new JLabel("Mã Thuốc: ");
		lblMaThuoc.setPreferredSize(new Dimension(90, 25));
		JTextField txtMaThuoc = new JTextField(15);
		JLabel lblTenThuoc = new JLabel("Tên Thuốc: ");
		lblTenThuoc.setPreferredSize(new Dimension(90, 25));
		JTextField txtTenThuoc = new JTextField(15);
		
		b2.add(lblMaThuoc);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(txtMaThuoc);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblTenThuoc);
		b2.add(Box.createHorizontalStrut(10));
		b2.add(txtTenThuoc);
		
		JLabel lblGia = new JLabel("Giá: ");
		lblGia.setPreferredSize(new Dimension(90, 25));
		JTextField txtGia = new JTextField(15);
		JLabel lblSoLuong = new JLabel("Số Lượng: ");
		lblSoLuong.setPreferredSize(new Dimension(90, 25));
		JTextField txtSoLuong = new JTextField(15);
		
		b3.add(lblGia);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(txtGia);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblSoLuong);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(txtSoLuong);
		
		JLabel lblHSD = new JLabel("Hạn Sử Dụng: ");
		lblHSD.setPreferredSize(new Dimension(90, 25));
		JTextField txtHSD = new JTextField(15);
		JLabel lblTongGia = new JLabel("Tổng Giá: ");
		lblTongGia.setPreferredSize(new Dimension(90, 25));
		JTextField txtTongGia = new JTextField(15);
		
		b4.add(lblHSD);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(txtHSD);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(lblTongGia);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(txtTongGia);
		
		JButton btnThem = new JButton("Thêm");
		b5.add(Box.createVerticalStrut(20));
		b5.add(btnThem);
		
		//Table Right
		String[] headers2 = {"Mã thuốc","Tên thuốc","Giá","Số lượng","HSD","Tổng giá"};
		DefaultTableModel model2 = new DefaultTableModel(headers2, 0);
		JTable table2 = new JTable(model2);
		table2.setPreferredScrollableViewportSize(new Dimension(1000, 500));
		JScrollPane pane2 = new JScrollPane(table2);
		b6.add(pane2);
		
		//Button
		JButton btnLoai = new JButton("Loại bỏ");
		JButton btnLap = new JButton("Lập hóa đơn");
		b7.add(btnLoai);
		b7.add(btnLap);
		
		
		pnRight.add(b2);
		pnRight.add(b3);
		pnRight.add(b4);
		pnRight.add(b5);
		pnRight.add(b6);
		pnRight.add(b7);
		
		
		pnCenterContent.add(pnLeft);
		pnCenterContent.add(Box.createHorizontalStrut(50));
		pnCenterContent.add(pnRight);
		pnCenter.add(Box.createVerticalStrut(30));
		pnCenter.add(pnCenterContent);
		
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		
		add(pnMain);
	}
}
