package myGUI;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class DangNhap_Gui extends JFrame {
	public static void main(String[] args) {
		new DangNhap_Gui();
	}
	
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
		pnHead.setBackground(new Color(0,160,255));	
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
		
		JTextField tfTaiKhoan = new JTextField();
		tfTaiKhoan.setPreferredSize(new Dimension(0,30));
		
		JLabel lbMatKhau = new JLabel("Mật khẩu:");
		ImageIcon iconPass = new ImageIcon("src//Icon//key.png");
		Image imagePass = iconPass.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		iconPass = new ImageIcon(imagePass);
		lbMatKhau.setIcon(iconPass);
		
		JTextField tfMatKhau = new JTextField();
		tfMatKhau.setPreferredSize(new Dimension(0,30));
		
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
		
//		BUTTON ĐĂNG NHẬP
		JPanel dnBtnPn = new JPanel();
		Box btnBox = Box.createHorizontalBox();
		JButton btnDangNhap = new JButton("Đăng Nhập");
		JButton btnThoat = new JButton("Thoát");
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
		add(pn);
		
	}
}
