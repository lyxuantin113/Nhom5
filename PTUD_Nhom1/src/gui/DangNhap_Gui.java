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
	private JPasswordField txtMatKhau;
	private JTextField txtTaiKhoan;
	private JLabel lblThongBao;

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
		JLabel lblHheader = new JLabel("CHÀO MỪNG ĐẾN VỚI HỆ THỐNG THUỐC TTV");
		Font fo = new Font("Times New Roman", Font.BOLD, 30);
		lblHheader.setFont(fo);
		lblHheader.setHorizontalAlignment(JLabel.CENTER);
		pnHead.setBackground(new Color(0, 160, 255));
		pnHead.setPreferredSize(new Dimension(getWidth(), 80));
		pnHead.add(lblHheader);

//		CENTER
//		TEXT ĐĂNG NHẬP
		Box containerBox = Box.createVerticalBox();
		JPanel pnBox = new JPanel();
		JLabel lblDN = new JLabel("<html><div text-align='center'>Đăng Nhập</div></html>");
		Font foDN = new Font("Times New Roman", Font.BOLD, 24);
		lblDN.setFont(foDN);
//		dnBox.add(lbDN);

//		FORM ĐĂNG NHẬP
		Box loginBox = Box.createVerticalBox();

		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		ImageIcon iconUser = new ImageIcon("src//Icon//user.png");
		Image imageUser = iconUser.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconUser = new ImageIcon(imageUser);
		lblTaiKhoan.setIcon(iconUser);

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setPreferredSize(new Dimension(0, 30));

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		ImageIcon iconPass = new ImageIcon("src//Icon//key.png");
		Image imagePass = iconPass.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconPass = new ImageIcon(imagePass);
		lblMatKhau.setIcon(iconPass);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setPreferredSize(new Dimension(0, 30));

		lblThongBao = new JLabel();
		lblThongBao.setPreferredSize(new Dimension(0, 30));
		lblThongBao.setForeground(Color.RED);

		loginBox.add(lblDN);
		loginBox.add(Box.createVerticalStrut(15));
		loginBox.add(lblTaiKhoan);
		loginBox.add(Box.createVerticalStrut(10));
		loginBox.add(txtTaiKhoan);
		loginBox.add(Box.createVerticalStrut(15));
		loginBox.add(lblMatKhau);
		loginBox.add(Box.createVerticalStrut(10));
		loginBox.add(txtMatKhau);
		loginBox.add(Box.createVerticalStrut(15));
		loginBox.add(lblThongBao);
		loginBox.add(Box.createVerticalStrut(10));

//		BUTTON ĐĂNG NHẬP
		JPanel dnBtnPn = new JPanel();
		Box btnBox = Box.createHorizontalBox();
		btnDangNhap = new JButton("Đăng Nhập");
		btnDangNhap.setBackground(new Color(0, 160, 255));
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(0, 160, 255));
		
		btnBox.add(btnDangNhap);
		btnBox.add(Box.createHorizontalStrut(50));
		btnBox.add(btnThoat);
		dnBtnPn.add(btnBox);
//		END FORM
		add(pnHead, BorderLayout.NORTH);
		pn.add(pnBox, BorderLayout.CENTER);
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
			String taiKhoan = txtTaiKhoan.getText();
			String matKhau = new String(txtMatKhau.getPassword());

			// Kiểm tra đăng nhập
			if (dstk.kiemTraDangNhap(taiKhoan, matKhau)) {
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
				// Mở cửa sổ mới sau khi đăng nhập thành công
				NhanVien nv = dstk.getNVByAccount(taiKhoan, matKhau);
				if (nv.getChucVu().equals("Nhan vien ban hang"))
					new ManHinhNV_GUI(nv);
				else
					new ManHinh_GUI(nv);
				// Đóng cửa sổ đăng nhập
				dispose();
			} else {
				lblThongBao.setText("Tài khoản hoặc mật khẩu không đúng.");
			}
		} else if (e.getSource() == btnThoat) {
			System.exit(0);
		}
	}
}
