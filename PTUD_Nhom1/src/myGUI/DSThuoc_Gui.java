package myGUI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSThuoc_Gui extends JPanel{
	public DSThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
//		HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Quản lý thuốc");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
		// CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));

		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin thuốc"));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		// Box
		Box b0 = Box.createHorizontalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		// Nhà cung cấp
		JLabel lblNCC = new JLabel("Nhà cung cấp: ");
		lblNCC.setPreferredSize(new Dimension(90, 25));
		JComboBox<String> cbbNCC = new JComboBox<String>();
		cbbNCC.addItem("Nhà thuốc A");
		cbbNCC.addItem("Nhà thuốc B");
		cbbNCC.addItem("Nhà thuốc C");
		cbbNCC.addItem("Nhà thuốc D");
		b0.add(Box.createHorizontalStrut(10));
		b0.add(lblNCC);
		b0.add(cbbNCC);
		pnCenterTop.add(b0);
		pnCenterTop.add(Box.createVerticalStrut(5));
		
		// Mã thuốc
		JLabel lblMa = new JLabel("Mã thuốc: ");
		lblMa.setPreferredSize(new Dimension(90, 25));
		JTextField txtMa = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblMa);
		b1.add(txtMa);
		// Tên Thuốc
		JLabel lblTen = new JLabel("Tên thuốc: ");
		lblTen.setPreferredSize(new Dimension(90, 25));
		JTextField txtTen = new JTextField(20);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblTen);
		b1.add(txtTen);
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Loại thuốc
		JLabel lblLoai = new JLabel("Loại thuốc: ");
		lblLoai.setPreferredSize(new Dimension(90, 25));
//		JTextField txtLoai = new JTextField(17);
		JComboBox<String> cbbLoai = new JComboBox<String>();
		cbbLoai.setPreferredSize(new Dimension(395, 25));
		cbbLoai.addItem("Thuốc cảm");
		cbbLoai.addItem("Thuốc hạ sốt");
		cbbLoai.addItem("Thực phẩm chức năng");
		
		b2.add(Box.createHorizontalStrut(10));
		b2.add(lblLoai);
		b2.add(cbbLoai);
//		b2.add(txtLoai);
		// HSD
		JLabel lblHSD = new JLabel("HSD: ");
		lblHSD.setPreferredSize(new Dimension(90, 25));
		JTextField txtHSD = new JTextField(20);
		b2.add(Box.createHorizontalStrut(12));
		b2.add(lblHSD);
		b2.add(txtHSD);
		pnCenterTop.add(b2);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Giá bán
		JLabel lblGiaBan = new JLabel("Giá bán: ");
		lblGiaBan.setPreferredSize(new Dimension(90, 25));
		JTextField txtGiaBan = new JTextField(20);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblGiaBan);
		b3.add(txtGiaBan);
		// Số lượng
		JLabel lblSoLuong = new JLabel("Số lượng: ");
		lblSoLuong.setPreferredSize(new Dimension(90, 25));
		JTextField txtSoLuong = new JTextField(20);
		txtSoLuong.setEditable(false);
		b3.add(Box.createHorizontalStrut(10));
		b3.add(lblSoLuong);
		b3.add(txtSoLuong);
		pnCenterTop.add(b3);
		pnCenterTop.add(Box.createVerticalStrut(5));
		// Đơn vị
		JLabel lblDonVi = new JLabel("Đơn vị:");
		lblDonVi.setPreferredSize(new Dimension(90, 25));
		JComboBox<String> cbbDonVi = new JComboBox<String>();
		cbbDonVi.setPreferredSize(new Dimension(395, 25));
		cbbDonVi.addItem("Viên");
		cbbDonVi.addItem("Chai");
		cbbDonVi.addItem("Hộp");
		cbbDonVi.addItem("Gói");
		cbbDonVi.addItem("Lọ");
		JLabel lblXuatXu = new JLabel("Xuất xứ: ");
		lblXuatXu.setPreferredSize(new Dimension(90, 25));
		JTextField txtXuatXu = new JTextField(20);
		b4.add(Box.createHorizontalStrut(10));
		b4.add(lblDonVi);
		b4.add(cbbDonVi);
		b4.add(Box.createHorizontalStrut(12));
		b4.add(lblXuatXu);
		b4.add(txtXuatXu);
		pnCenterTop.add(b4);
		
		// BUTTON
		JPanel pnButton = new JPanel();
		JButton btnAdd = new JButton("Thêm");
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAdd.setBackground(new Color(0,160,255));
		btnXoaTrang.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnXoaTrang.setBackground(new Color(0,160,255));
		pnButton.add(btnAdd);
		pnButton.add(btnXoaTrang);
		pnCenterBot.add(pnButton);
		// TABLE
        String[] headers = {"Mã thuốc", "Tên thuốc", "Loại thuốc","Đơn vị", "HSD", "Số lượng", "Giá", "NCC", "Xuất xứ"};
        DefaultTableModel model = new DefaultTableModel(headers, 0);
        JTable table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new java.awt.Dimension(1000, 210));
        pnCenterBot.add(sp);
        pnCenter.add(Box.createVerticalStrut(10));
        // FOOTER
        JPanel pnFooter = new JPanel();
        JLabel lblTimKiem = new JLabel("Tìm kiếm: ");
        JTextField txtTimKiem = new JTextField(20);
        JButton btnTim = new JButton("Tìm");
        JButton btnXoa = new JButton("Xóa");
        btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnTim.setBackground(new Color(0,160,255));
        btnXoa.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnXoa.setBackground(new Color(0,160,255));
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
	}
}
