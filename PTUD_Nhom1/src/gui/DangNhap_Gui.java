package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import dao.TaiKhoan_Dao;
import db.ConnectDB;
import entity.NhanVien;

public class DangNhap_Gui extends JFrame implements ActionListener {
	public static void main(String[] args) {
		new DangNhap_Gui();
	}

	private JButton btnDangNhap;
	private JButton btnThoat;
	private JPasswordField tfMatKhau;
	private JTextField tfTaiKhoan;
	private JLabel lbThongBao;

	private TaiKhoan_Dao dstk = new TaiKhoan_Dao();

	public DangNhap_Gui() {
		super("Màn Hình Đăng Nhập");
		setSize(1070, 600);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

//		HEADER
		JPanel pn = new JPanel();

		JPanel pnHead = new JPanel();
		JLabel header = new JLabel("CHÀO MỪNG ĐẾN VỚI HỆ THỐNG THUỐC TTV");
		Font fo = new Font("Times New Roman", Font.BOLD, 30);
		header.setFont(fo);
		header.setHorizontalAlignment(JLabel.CENTER);
		pnHead.setBackground(new Color(0, 160, 255));
		pnHead.setPreferredSize(new Dimension(getWidth(), 80));
		pnHead.add(header);

//		CENTER
//		TEXT ĐĂNG NHẬP
		Box containerBox = Box.createVerticalBox();
		JPanel dnBox = new JPanel();
		JLabel lbDN = new JLabel("<html><div text-align='center'>Đăng Nhập</div></html>");
		Font foDN = new Font("Times New Roman", Font.BOLD, 24);
		lbDN.setFont(foDN);
//		dnBox.add(lbDN);

//		FORM ĐĂNG NHẬP
		Box loginBox = Box.createVerticalBox();

		JLabel lbTaiKhoan = new JLabel("Tài khoản:");
		ImageIcon iconUser = new ImageIcon("src//Icon//user.png");
		Image imageUser = iconUser.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconUser = new ImageIcon(imageUser);
		lbTaiKhoan.setIcon(iconUser);

		tfTaiKhoan = new JTextField();
		tfTaiKhoan.setPreferredSize(new Dimension(0, 30));

		JLabel lbMatKhau = new JLabel("Mật khẩu:");
		ImageIcon iconPass = new ImageIcon("src//Icon//key.png");
		Image imagePass = iconPass.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconPass = new ImageIcon(imagePass);
		lbMatKhau.setIcon(iconPass);

		tfMatKhau = new JPasswordField();
		tfMatKhau.setPreferredSize(new Dimension(0, 30));

		lbThongBao = new JLabel();
		lbThongBao.setPreferredSize(new Dimension(0, 30));
		lbThongBao.setForeground(Color.RED);

		loginBox.add(lbDN);
		loginBox.add(Box.createVerticalStrut(15));
		loginBox.add(lbTaiKhoan);
		loginBox.add(Box.createVerticalStrut(10));
		loginBox.add(tfTaiKhoan);
		loginBox.add(Box.createVerticalStrut(15));
		loginBox.add(lbMatKhau);
		loginBox.add(Box.createVerticalStrut(10));
		loginBox.add(tfMatKhau);
		loginBox.add(Box.createVerticalStrut(15));
		loginBox.add(lbThongBao);
		loginBox.add(Box.createVerticalStrut(10));

//		BUTTON ĐĂNG NHẬP
		JPanel dnBtnPn = new JPanel();
		Box btnBox = Box.createHorizontalBox();
		btnDangNhap = new JButton("Đăng Nhập");
		btnThoat = new JButton("Thoát");

		btnBox.add(btnDangNhap);
		btnBox.add(Box.createHorizontalStrut(50));
		btnBox.add(btnThoat);
		dnBtnPn.add(btnBox);
//		END FORM
		add(pnHead, BorderLayout.NORTH);
		pn.add(dnBox, BorderLayout.CENTER);
		containerBox.add(Box.createVerticalStrut(15));
		containerBox.add(loginBox);
		containerBox.add(dnBtnPn);
		pn.add(containerBox);

		// Đăng ký sự kiện cho các nút
		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);

		add(pn);
		ConnectDB.connect();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDangNhap) {
			String taiKhoan = tfTaiKhoan.getText();
			String matKhau = new String(tfMatKhau.getPassword());

			// Kiểm tra đăng nhập
			if (dstk.kiemTraDangNhap(taiKhoan, matKhau)) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
				// Mở cửa sổ mới sau khi đăng nhập thành công
				NhanVien nv = dstk.getNVByAccount(taiKhoan, matKhau);
				if (nv.getChucVu().equals("Nhan vien ban hang"))
					new ManHinhNV_GUI();
				else
					new ManHinh_GUI();
				// Đóng cửa sổ đăng nhập
				dispose();
			} else {
				lbThongBao.setText("Tài khoản hoặc mật khẩu không đúng.");
			}
		} else if (e.getSource() == btnThoat) {
			System.exit(0);
		}
	}
}
