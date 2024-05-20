package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import dao.NhanVien_Dao;
import dao.TaiKhoan_Dao;
import entity.NhanVien;
import entity.TaiKhoan;

public class DoiMatKhau_Gui extends JPanel implements ActionListener {

	private JButton btnXacNhan;
	private JButton btnThoat;
	private JTextField txtTaiKhoan;
	private JTextField txtMaNV;
	private JTextField txtMatKhau;
	private JTextField txtNewMatKhau;

	public DoiMatKhau_Gui(NhanVien nhanVienDN) {
//		super("Đổi mật khẩu");
		setSize(500, 400);
		setVisible(true);
//		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		setLocationRelativeTo(null);
//		setResizable(false);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

		JPanel pnHeader = new JPanel();
//		pnHeader.setLayout(new BorderLayout());

		JLabel lblHeader = new JLabel("Đổi Mật Khẩu");

		Font fo = new Font("Times New Roman", Font.BOLD, 22);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		lblHeader.setForeground(Color.blue);
		lblHeader.setFont(fo);
		pnHeader.add(lblHeader);

		JPanel pnCenter = new JPanel();
		Box boxCenter = Box.createVerticalBox();
		Box boxMa = Box.createHorizontalBox();
		Box boxTK = Box.createHorizontalBox();
		Box boxMK = Box.createHorizontalBox();
		Box boxNewMK = Box.createHorizontalBox();
		Box boxBtn = Box.createHorizontalBox();

		JLabel lblMaNV = new JLabel("Mã Nhân Viên:");
		lblMaNV.setPreferredSize(new Dimension(120, 35));
		lblMaNV.setFont(fo16);
		txtMaNV = new JTextField(20);
		txtMaNV.setText(nhanVienDN.getMaNV());
		txtMaNV.setEditable(false);

		JLabel lblTaiKhoan = new JLabel("Tên tài khoản:");
		lblTaiKhoan.setPreferredSize(new Dimension(120, 35));
		lblTaiKhoan.setFont(fo16);
		txtTaiKhoan = new JTextField(20);

		JLabel lblMatKhau = new JLabel("Mật khẩu cũ:");
		lblMatKhau.setPreferredSize(new Dimension(120, 35));
		lblMatKhau.setFont(fo16);
		txtMatKhau = new JPasswordField(20);

		JLabel lblNewMatKhau = new JLabel("Mật khẩu mới:");
		lblNewMatKhau.setPreferredSize(new Dimension(120, 35));
		lblNewMatKhau.setFont(fo16);
		txtNewMatKhau = new JPasswordField(20);

		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBackground(new Color(0, 160, 255));
		btnXacNhan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXacNhan.setPreferredSize(new Dimension(150, 35));
		btnThoat = new JButton("Thoát");
		btnThoat.setBackground(new Color(0, 160, 255));
		btnThoat.setPreferredSize(new Dimension(150, 35));
		btnThoat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		boxMa.add(lblMaNV);
		boxMa.add(txtMaNV);

		boxTK.add(lblTaiKhoan);
		boxTK.add(txtTaiKhoan);

		boxMK.add(lblMatKhau);
		boxMK.add(txtMatKhau);

		boxNewMK.add(lblNewMatKhau);
		boxNewMK.add(txtNewMatKhau);

		boxBtn.add(btnXacNhan);
		boxBtn.add(Box.createHorizontalStrut(30));
		boxBtn.add(btnThoat);

		boxCenter.add(Box.createVerticalStrut(50));
		boxCenter.add(boxMa);
		boxCenter.add(Box.createVerticalStrut(20));
		boxCenter.add(boxTK);
		boxCenter.add(Box.createVerticalStrut(30));
		boxCenter.add(boxMK);
		boxCenter.add(Box.createVerticalStrut(30));
		boxCenter.add(boxNewMK);
		boxCenter.add(Box.createVerticalStrut(50));
		boxCenter.add(boxBtn);

		pnCenter.add(boxCenter);

		pnMain.add(pnHeader, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

		add(pnMain);

		btnXacNhan.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnXacNhan) {
			int check = JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu?", "Đổi mật khẩu", JOptionPane.YES_NO_OPTION);
			if (check == JOptionPane.YES_OPTION && kiemTra())
				if (doiMatKhau()) {
					xoaTrang();
					JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công");
				}
		}
		if (o == btnThoat)
			System.exit(0);
	}

	public void xoaTrang() {
		txtMatKhau.setText("");
		txtNewMatKhau.setText("");
		txtTaiKhoan.setText("");
	}

	public boolean kiemTra() {

		String maNV = txtMaNV.getText();
		String tenTK = txtTaiKhoan.getText();
		String matKhau = txtMatKhau.getText();
		String matKhauMoi = txtNewMatKhau.getText();
		if (maNV.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập mã Nhân viên");
			return false;
		}
		if (tenTK.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập tên tài khoản");
			return false;
		}
		if (matKhau.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập mật khẩu");
			return false;
		}
		if (matKhauMoi.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập mật khẩu mới");
			return false;
		}

		return true;

	}

	public boolean doiMatKhau() {
		String maNV = txtMaNV.getText();
		String tenTK = txtTaiKhoan.getText();
		String matKhau = txtMatKhau.getText();
		String matKhauMoi = txtNewMatKhau.getText();
		NhanVien_Dao nvDao = new NhanVien_Dao();

		if (nvDao.getNhanVien(maNV).get(0) == null) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Mã nhân viên sai");
			return false;
		}

		TaiKhoan_Dao tkDao = new TaiKhoan_Dao();
		TaiKhoan tk = tkDao.getTKById(maNV);

		if (!tk.getTenTaiKhoan().equals(tenTK)) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Tên tài khoản không đúng");
			return false;
		}
		if (!tk.getMatKhau().equals(matKhau)) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Mật khẩu không đúng");
			return false;
		}
		if (matKhauMoi.equals("")) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Hãy nhập mật khẩu mới");
			return false;
		}
		if (tk.getMatKhau().equals(matKhauMoi)) {
			JOptionPane.showMessageDialog(this, "Lưu ý: Mật khẩu mới trùng với mật khẩu cũ");
			return false;
		}
		return tkDao.doiMatKhau(tk, matKhauMoi);
	}
}
