package myGUI;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DSNhanVien_Gui extends JPanel {

	private JButton bntXoaRong;
	private JButton bntThem;
	private JButton bntXoa;
	private JButton bntSua;
	private JButton bntLuu;
	private JLabel lb1;
	private Component comboBox;

	public DSNhanVien_Gui() {
//				JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//				HEADER
		JPanel pnHead = new JPanel();
		JLabel lbHead = new JLabel("Quản Lý Nhân Viên");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		lbHead.setFont(fo24);
		lbHead.setForeground(Color.blue);
		pnHead.add(lbHead);
//		WEST
		JPanel pnWest = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.X_AXIS));

		Box containerBox = Box.createVerticalBox();

//				MÃ NHÂN VIÊN
		Box boxMa = Box.createHorizontalBox();
		JLabel lbMaNV = new JLabel("Mã Nhân Viên:");
		lbMaNV.setPreferredSize(new Dimension(100, -10));
		JTextField tfMaNV = new JTextField(20);
		tfMaNV.setPreferredSize(new Dimension(0, 10));
		boxMa.add(Box.createHorizontalStrut(15));
		boxMa.add(lbMaNV);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfMaNV);
		boxMa.add(Box.createHorizontalStrut(15));

//				TÊN NHÂN VIÊN
		Box boxChucVu = Box.createHorizontalBox();
		JLabel lbChucVu = new JLabel("Chức Vụ: ");
		lbChucVu.setPreferredSize(new Dimension(100, -10));
		JTextField tfChucVu = new JTextField(20);
		tfChucVu.setPreferredSize(new Dimension(0, 10));
		boxChucVu.add(Box.createHorizontalStrut(15));
		boxChucVu.add(lbChucVu);
		boxChucVu.add(Box.createHorizontalStrut(10));
		boxChucVu.add(tfChucVu);
		boxChucVu.add(Box.createHorizontalStrut(15));

//		 		SĐT NHÂN VIÊN
		Box boxSDT = Box.createHorizontalBox();
		JLabel lbSdtNV = new JLabel("SĐT NV: ");
		lbSdtNV.setPreferredSize(new Dimension(100, -10));
		JTextField tfSdtNV = new JTextField(20);
		tfSdtNV.setPreferredSize(new Dimension(0, 10));
		boxSDT.add(Box.createHorizontalStrut(15));
		boxSDT.add(lbSdtNV);
		boxSDT.add(Box.createHorizontalStrut(10));
		boxSDT.add(tfSdtNV);
		boxSDT.add(Box.createHorizontalStrut(15));

//				TEN NV
		Box boxTen = Box.createHorizontalBox();
		JLabel lbTenNV = new JLabel("Tên NV: ");
		lbTenNV.setPreferredSize(new Dimension(100, -10));
		JTextField tfTenNV = new JTextField(20);
		boxTen.setPreferredSize(new Dimension(0, 10));
		boxTen.add(Box.createHorizontalStrut(15));
		boxTen.add(lbTenNV);
		boxTen.add(Box.createHorizontalStrut(10));
		boxTen.add(tfTenNV);
		boxTen.add(Box.createHorizontalStrut(15));

//				EMAIL
		Box boxEmail = Box.createHorizontalBox();
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setPreferredSize(new Dimension(100, -10));
		JTextField tfEmail = new JTextField(20);
		tfEmail.setPreferredSize(new Dimension(0, 10));
		boxEmail.add(Box.createHorizontalStrut(15));
		boxEmail.add(lbEmail);
		boxEmail.add(Box.createHorizontalStrut(10));
		boxEmail.add(tfEmail);
		boxEmail.add(Box.createHorizontalStrut(15));

//				add Box1 Box2
		containerBox.add(boxMa);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxChucVu);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxSDT);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxTen);
		containerBox.add(Box.createVerticalStrut(60));
		containerBox.add(boxEmail);
		pnWest.setBorder(BorderFactory.createTitledBorder("Nhap thong tin NV"));
		pnWest.add(containerBox);

//		CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.X_AXIS));

		Box boxTableNhanVien = Box.createVerticalBox();
		String[] headerNhanVien = "Mã NV;Tên NV;Sđt NV;Chức vụ;Email".split(";");
		DefaultTableModel modelNhanVien = new DefaultTableModel(headerNhanVien, 0);
		JTable tableNhanVien = new JTable(modelNhanVien);
		JScrollPane scrollNhanVien = new JScrollPane();
		scrollNhanVien.setViewportView(tableNhanVien = new JTable(modelNhanVien));
		scrollNhanVien.setPreferredSize(new Dimension(700, 450)); // SET CHIỀU CAO TABLE
		tableNhanVien.setRowHeight(20);

		boxTableNhanVien.add(scrollNhanVien);
//		boxTableNhanVien.add(Box.createVerticalStrut(20));
		pnCenter.add(Box.createHorizontalStrut(10));
		pnCenter.add(boxTableNhanVien);

//				FOOTER		
		JPanel pnFoot = new JPanel();

		Box boxC1 = Box.createHorizontalBox();
		boxC1.add(bntThem = new JButton("Them"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(bntXoaRong = new JButton("Xoa Rong"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(bntXoa = new JButton("Xoa"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(bntSua = new JButton("Sua"));
		boxC1.add(Box.createHorizontalStrut(10));
		boxC1.add(bntLuu = new JButton("Luu"));
		pnFoot.add(boxC1);

		pnMain.add(pnWest, BorderLayout.WEST);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnFoot, BorderLayout.SOUTH);

		add(pnMain);
	}
}