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

//				CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

		Box containerBox = Box.createVerticalBox();

		Box boxMa = Box.createHorizontalBox();
		Box boxChucVu = Box.createHorizontalBox();
//				MÃ NHÂN VIÊN
		JLabel lbMaNV = new JLabel("Mã Nhân Viên:");
		lbMaNV.setPreferredSize(new Dimension(100, 0));
		JTextField tfMaNV = new JTextField();
		tfMaNV.setPreferredSize(new Dimension(getWidth(), 25)); // SET ĐỘ RỘNG JTEXTFIELD
		boxMa.add(Box.createHorizontalStrut(15));
		boxMa.add(lbMaNV);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfMaNV);
		boxMa.add(Box.createHorizontalStrut(15));

//				TÊN NHÂN VIÊN
		JLabel lbChucVu = new JLabel("Chức Vụ: ");
		lbChucVu.setPreferredSize(new Dimension(90, 0));
		JTextField tfChucVu = new JTextField();
		boxMa.add(Box.createHorizontalStrut(15));
		boxMa.add(lbChucVu);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfChucVu);
		boxMa.add(Box.createHorizontalStrut(15));

//		 		SĐT NHÂN VIÊN
		JLabel lbSdtNV = new JLabel("SĐT NV: ");
		lbSdtNV.setPreferredSize(new Dimension(80, 0));
		JTextField tfSdtNV = new JTextField();
		boxMa.add(Box.createHorizontalStrut(15));
		boxMa.add(lbSdtNV);
		boxMa.add(Box.createHorizontalStrut(10));
		boxMa.add(tfSdtNV);
		boxMa.add(Box.createHorizontalStrut(15));

//				CHỨC VỤ
		JLabel lbTenNV = new JLabel("Tên NV: ");
		lbTenNV.setPreferredSize(new Dimension(55, 0));
		JTextField tfTenNV = new JTextField();
		tfChucVu.setPreferredSize(new Dimension(0, 25));
		boxChucVu.add(Box.createHorizontalStrut(25));
		boxChucVu.add(lbTenNV);
		boxChucVu.add(Box.createHorizontalStrut(10));
		boxChucVu.add(tfTenNV);
		boxChucVu.add(Box.createHorizontalStrut(20));

//				EMAIL
		JLabel lbEmail = new JLabel("Email:");
		lbEmail.setPreferredSize(new Dimension(80, 0));
		JTextField tfEmail = new JTextField();
		boxChucVu.add(Box.createHorizontalStrut(20));
		boxChucVu.add(lbEmail);
		boxChucVu.add(Box.createHorizontalStrut(10));
		boxChucVu.add(tfEmail);
		boxChucVu.add(Box.createHorizontalStrut(25));

//				add Box1 Box2
		containerBox.add(boxMa);
		containerBox.add(Box.createVerticalStrut(15));
		containerBox.add(boxChucVu);
		containerBox.add(Box.createVerticalStrut(15));
		pnCenter.add(containerBox);

		Box boxTableNhanVien = Box.createVerticalBox();
		String[] headerNhanVien = "Mã NV;Tên NV;Sđt NV;Chức vụ;Email".split(";");
		DefaultTableModel modelNhanVien = new DefaultTableModel(headerNhanVien, 0);
		JTable tableNhanVien = new JTable(modelNhanVien);
		JScrollPane scrollNhanVien = new JScrollPane();
		scrollNhanVien.setViewportView(tableNhanVien = new JTable(modelNhanVien));
		scrollNhanVien.setPreferredSize(new Dimension(700, 330)); // SET CHIỀU CAO TABLE
		tableNhanVien.setRowHeight(20);

		boxTableNhanVien.add(scrollNhanVien);
		boxTableNhanVien.add(Box.createVerticalStrut(10));

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

		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnFoot, BorderLayout.SOUTH);

		add(pnMain);

	}
}
