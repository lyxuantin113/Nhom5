package myGUI;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TimThuoc_Gui extends JPanel{
	public TimThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		// HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Tìm thuốc");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
//		pnHead.add(Box.createVerticalStrut(30));
		
		pnMain.add(pnHead, BorderLayout.NORTH);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		
		// Cách tìm kiếm
		JLabel lblCachTim = new JLabel("Tìm theo: ");
		lblCachTim.setPreferredSize(new Dimension(90, 25));
		JComboBox<String> cbbCachTim = new JComboBox<String>();
		cbbCachTim.addItem("Mã thuốc");
		cbbCachTim.addItem("Tên thuốc");
		cbbCachTim.addItem("Loại thuốc");
		cbbCachTim.addItem("Nhà cung cấp");
		b1.add(lblCachTim);
		b1.add(cbbCachTim);
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b1);
		
		// Thông tin tìm kiếm
		JLabel lblThongTin = new JLabel("Thông tin: ");
		lblThongTin.setPreferredSize(new Dimension(90, 25));
		JTextField txtThongTin = new JTextField(20);
		b2.add(lblThongTin);
		b2.add(txtThongTin);
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b2);
		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin tìm kiếm"));
		// Button
		JPanel pnButton = new JPanel();
		JButton btnTim = new JButton("Tìm");
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTim.setBackground(new Color(0,160,255));
        
		pnButton.add(btnTim);
		b3.add(pnButton);
		pnCenterTop.add(b3);
		// Table
		String[] headers = {"Mã thuốc", "Tên thuốc", "Loại thuốc","Đơn vị", "HSD", "Số lượng tồn", "Giá bán", "NCC", "Xuất xứ"};
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		table.setPreferredScrollableViewportSize(new Dimension(1000, 300));
		pnCenterBot.add(sp);
		pnCenter.add(Box.createVerticalStrut(10));
		
		pnCenter.add(pnCenterTop);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		
		add(pnMain);
	}
}
