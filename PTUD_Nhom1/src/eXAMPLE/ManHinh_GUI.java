package eXAMPLE;
//package gui;
//
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Desktop;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.File;
//import java.sql.SQLException;
//
//import javax.swing.UnsupportedLookAndFeelException;
//
//import entity.NhanVien;
//
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.UIManager;
//
//public class ManHinh_GUI extends JFrame {
//	private JMenuBar jMenuBar;
//	private JMenuItem jMenuItem_thayDoiMatKhau;
//	private JMenuItem jMenuItem_dangXuat;
//	private JMenuItem jMenuItem_phieuNhapHang;
//	private JMenuItem jMenuItem_quanLyHoaDon;
//	private JMenuItem jMenuItem_quanLyNhaCungCap;
//	private JMenuItem jMenuItem_quanLyPhieuNhapHang;
//	private JMenuItem jMenuItem_taoHoaDon;
//	private JMenu jMenu_taiKhoan;
//	private JMenu jMenu_hoaDon;
//	private JMenu jMenu_khachHang;
//	private JMenu jMenu_nhaCungCap;
//	private JMenu jMenu_nhanVien;
//	private JMenu jMenu_sanPham;
//	private JMenu jMenu_thongKe;
//	private JMenu jMenu_trangChu;
//	private JMenu jMenu_troGiup;
//	private CardLayout cardLayout;
//	private JPanel cardPanel;
//	private NhanVien nhanVien = new NhanVien();
//
//	public ManHinh_GUI(NhanVien nhanVien) {
//		this.nhanVien = nhanVien;
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//		setTitle("Quản Lý Quầy Thuốc");
//		setPreferredSize(new java.awt.Dimension(1070, 600));
//		setResizable(false);
//
//		createMenu();
//		cardLayout = new CardLayout();
//		cardPanel = new JPanel(cardLayout);
//
//		cardPanel.add(new TrangChu_Panel(nhanVien), "TrangChu");
//		cardPanel.add(new SanPham_Panel(nhanVien), "SanPham");
////		cardPanel.add(new KhachHang_Panel(nhanVien), "KhachHang");
////		cardPanel.add(new TaoHoaDon_Panel(nhanVien), "TaoHoaDon");
////		cardPanel.add(new QuanLyHoaDon_Panel(nhanVien), "QuanLyHoaDon");
////		cardPanel.add(new NhanVien_Panel(nhanVien), "NhanVien");
////		cardPanel.add(new PhieuNhapHang_Panel(nhanVien), "PhieuNhapHang");
////		cardPanel.add(new QuanLyPhieuNhapHang_Panel(nhanVien), "QuanLyPhieuNhapHang");
////		cardPanel.add(new NhaCungCap_Panel(nhanVien), "NhaCungCap");
////		cardPanel.add(new ThongKe_Panel(nhanVien), "ThongKe");
//
//		this.setBackground(new Color(179, 255, 185));
//
//		setJMenuBar(jMenuBar);
//		setContentPane(cardPanel);
//
//		pack();
//		setLocationRelativeTo(null);
//	}
//
//	public void createMenu() {
//		jMenuBar = new JMenuBar();
//
//		jMenu_trangChu = new JMenu();
//		jMenu_trangChu.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				cardLayout.show(cardPanel, "TrangChu");
//			}
//		});
//		jMenu_sanPham = new JMenu();
//		jMenu_sanPham.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				cardLayout.show(cardPanel, "SanPham");
//			}
//		});
//
//		jMenu_khachHang = new JMenu();
//		jMenu_khachHang.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				cardLayout.show(cardPanel, "KhachHang");
//			}
//		});
//
//		jMenu_hoaDon = new JMenu();
//
//		jMenuItem_taoHoaDon = new JMenuItem();
//		jMenuItem_taoHoaDon.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(cardPanel, "TaoHoaDon");
//			}
//		});
//
//		jMenuItem_quanLyHoaDon = new JMenuItem();
//		jMenuItem_quanLyHoaDon.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(cardPanel, "QuanLyHoaDon");
//			}
//		});
//
//		jMenu_nhanVien = new JMenu();
//		jMenu_nhanVien.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				cardLayout.show(cardPanel, "NhanVien");
//			}
//		});
//
//		jMenu_nhaCungCap = new JMenu();
//
//		jMenuItem_phieuNhapHang = new JMenuItem();
//		jMenuItem_phieuNhapHang.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(cardPanel, "PhieuNhapHang");
//			}
//		});
//
//		jMenuItem_quanLyPhieuNhapHang = new JMenuItem();
//		jMenuItem_quanLyPhieuNhapHang.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(cardPanel, "QuanLyPhieuNhapHang");
//			}
//		});
//
//		jMenuItem_quanLyNhaCungCap = new JMenuItem();
//		jMenuItem_quanLyNhaCungCap.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				cardLayout.show(cardPanel, "NhaCungCap");
//			}
//		});
//
//		jMenu_thongKe = new JMenu();
//		jMenu_thongKe.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				cardLayout.show(cardPanel, "ThongKe");
//			}
//		});
//
//		jMenu_troGiup = new JMenu();
//		jMenu_troGiup.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				try {
//					System.out.println("Start..");
//					File file = new java.io.File("src/HTMLFile/HELPPAGE/main.html").getAbsoluteFile();
//					Desktop.getDesktop().open(file);
//					System.out.println("End..");
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//
//		jMenu_taiKhoan = new JMenu();
//
//		jMenuItem_thayDoiMatKhau = new JMenuItem();
//		jMenuItem_thayDoiMatKhau.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
////				new ThayDoiMatKhau_GUI(nhanVien).setVisible(true);
//			}
//		});
//		jMenuItem_dangXuat = new JMenuItem();
//		jMenuItem_dangXuat.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				dispose();
////				new DangNhap_GUI().setVisible(true);
//			}
//		});
//
//		jMenu_trangChu.setText("Trang Chủ");
//		jMenuBar.add(jMenu_trangChu);
//
//		jMenu_sanPham.setText("Sản Phẩm");
//		jMenuBar.add(jMenu_sanPham);
//
//		jMenu_khachHang.setText("Khách Hàng");
//		jMenuBar.add(jMenu_khachHang);
//
//		jMenu_hoaDon.setText("Hoá Đơn");
//
//		jMenuItem_taoHoaDon.setText("Tạo hoá đơn");
//		jMenu_hoaDon.add(jMenuItem_taoHoaDon);
//
//		jMenuItem_quanLyHoaDon.setText("Quản lý hoá đơn");
//		jMenu_hoaDon.add(jMenuItem_quanLyHoaDon);
//
//		jMenuBar.add(jMenu_hoaDon);
//
//		jMenu_nhanVien.setText("Nhân Viên");
//		jMenuBar.add(jMenu_nhanVien);
//
//		jMenu_nhaCungCap.setText("Nhà Cung Cấp");
//
//		jMenuItem_phieuNhapHang.setText("Phiếu nhập hàng");
//		jMenu_nhaCungCap.add(jMenuItem_phieuNhapHang);
//
//		jMenuItem_quanLyPhieuNhapHang.setText("Quản lý phiếu nhập hàng");
//		jMenu_nhaCungCap.add(jMenuItem_quanLyPhieuNhapHang);
//
//		jMenuItem_quanLyNhaCungCap.setText("Quản lý nhà cung cấp");
//		jMenu_nhaCungCap.add(jMenuItem_quanLyNhaCungCap);
//
//		jMenuBar.add(jMenu_nhaCungCap);
//
//		jMenu_thongKe.setText("Thống kê");
//		jMenuBar.add(jMenu_thongKe);
//
//		jMenu_troGiup.setText("Trợ Giúp");
//		jMenuBar.add(jMenu_troGiup);
//
//		jMenu_taiKhoan.setText("Tài khoản");
//
//		jMenuItem_thayDoiMatKhau.setText("Thay đổi mật khẩu");
//		jMenu_taiKhoan.add(jMenuItem_thayDoiMatKhau);
//
//		jMenuItem_dangXuat.setText("Đăng xuất");
//		jMenu_taiKhoan.add(jMenuItem_dangXuat);
//
//		jMenuBar.add(jMenu_taiKhoan);
//
////      Thêm icon
//		ImageIcon img_btnTrangChu = new ImageIcon("src//img//icon//home.png");
//		Image scaled_btnTrangChu = img_btnTrangChu.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnTrangChu = new ImageIcon(scaled_btnTrangChu);
//		jMenu_trangChu.setIcon(img_btnTrangChu);
//
//		ImageIcon img_btnHoaDon = new ImageIcon("src//img//icon//hoadon.png");
//		Image scaled_btnHoaDon = img_btnHoaDon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnHoaDon = new ImageIcon(scaled_btnHoaDon);
//		jMenu_hoaDon.setIcon(img_btnHoaDon);
//
//		ImageIcon img_btnLamMoi = new ImageIcon("src//img//icon//customer.png");
//		Image scaled_btnLamMoi = img_btnLamMoi.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnLamMoi = new ImageIcon(scaled_btnLamMoi);
//		jMenu_khachHang.setIcon(img_btnLamMoi);
//		ImageIcon img_btnThem = new ImageIcon("src//img//icon//nhacungcap.png");
//		Image scaled_btnThem = img_btnThem.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnThem = new ImageIcon(scaled_btnThem);
//		jMenu_nhaCungCap.setIcon(img_btnThem);
//
//		ImageIcon img_btnCapNhat = new ImageIcon("src//img//icon//user_nam.png");
//		Image scaled_btnCapNhat = img_btnCapNhat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnCapNhat = new ImageIcon(scaled_btnCapNhat);
//		jMenu_nhanVien.setIcon(img_btnCapNhat);
//
//		ImageIcon img_btntroGiup = new ImageIcon("src//img//icon//Trogiup.png");
//		Image scaled_btntroGiup = img_btntroGiup.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btntroGiup = new ImageIcon(scaled_btntroGiup);
//		jMenu_troGiup.setIcon(img_btntroGiup);
//
//		ImageIcon img_btntaiKhoan = new ImageIcon("src//img//icon//taikhoan.png");
//		Image scaled_btntaiKhoan = img_btntaiKhoan.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btntaiKhoan = new ImageIcon(scaled_btntaiKhoan);
//		jMenu_taiKhoan.setIcon(img_btntaiKhoan);
//
//		ImageIcon img_btnthongKe = new ImageIcon("src//img//icon//thongke.png");
//		Image scaled_btnthongKe = img_btnthongKe.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnthongKe = new ImageIcon(scaled_btnthongKe);
//		jMenu_thongKe.setIcon(img_btnthongKe);
//
//		ImageIcon img_btnsanPham = new ImageIcon("src//img//icon//productbox.png");
//		Image scaled_btnsanPham = img_btnsanPham.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnsanPham = new ImageIcon(scaled_btnsanPham);
//		jMenu_sanPham.setIcon(img_btnsanPham);
//
//		ImageIcon img_btnDoiMatKhau = new ImageIcon("src//img//icon//key.png");
//		Image scaled_btnDoiMatKhau = img_btnDoiMatKhau.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnDoiMatKhau = new ImageIcon(scaled_btnDoiMatKhau);
//		jMenuItem_thayDoiMatKhau.setIcon(img_btnDoiMatKhau);
//
//		ImageIcon img_btnDangXuat = new ImageIcon("src//img//icon//logout.png");
//		Image scaled_btnDangXuat = img_btnDangXuat.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnDangXuat = new ImageIcon(scaled_btnDangXuat);
//		jMenuItem_dangXuat.setIcon(img_btnDangXuat);
//
//		ImageIcon img_btnTaoHoaDon = new ImageIcon("src//img//icon//buttonTaoDonHang.png");
//		Image scaled_btnTaoHoaDon = img_btnTaoHoaDon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnTaoHoaDon = new ImageIcon(scaled_btnTaoHoaDon);
//		jMenuItem_taoHoaDon.setIcon(img_btnTaoHoaDon);
//
//		ImageIcon img_btnQuanLyHoaDon = new ImageIcon("src//img//icon//hoadon.png");
//		Image scaled_btnQuanLyHoaDon = img_btnQuanLyHoaDon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnQuanLyHoaDon = new ImageIcon(scaled_btnQuanLyHoaDon);
//		jMenuItem_quanLyHoaDon.setIcon(img_btnQuanLyHoaDon);
//
//		ImageIcon img_btnQuanLyNCC = new ImageIcon("src//img//icon//nhacungcap.png");
//		Image scaled_btnQuanLyNCC = img_btnQuanLyNCC.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnQuanLyNCC = new ImageIcon(scaled_btnQuanLyNCC);
//		jMenuItem_quanLyNhaCungCap.setIcon(img_btnQuanLyNCC);
//
//		ImageIcon img_btnPhieuNhapHang = new ImageIcon("src//img//icon//phieunhap.png");
//		Image scaled_btnPhieuNhapHang = img_btnPhieuNhapHang.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnPhieuNhapHang = new ImageIcon(scaled_btnPhieuNhapHang);
//		jMenuItem_phieuNhapHang.setIcon(img_btnPhieuNhapHang);
//
//		ImageIcon img_btnQuanLyNhapHang = new ImageIcon("src//img//icon//buttonNhapHang.png");
//		Image scaled_btnQuanLyNhapHang = img_btnQuanLyNhapHang.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
//		img_btnQuanLyNhapHang = new ImageIcon(scaled_btnQuanLyNhapHang);
//		jMenuItem_quanLyPhieuNhapHang.setIcon(img_btnQuanLyNhapHang);
//	}
//
//	public static void main(String args[]) {
//		try {
//			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
//				if ("Nimbus".equals(info.getName())) {
//					UIManager.setLookAndFeel(info.getClassName());
//					break;
//				}
//			}
//
//		} catch (ClassNotFoundException ex) {
//			java.util.logging.Logger.getLogger(TrangChu_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null,
//					ex);
//		} catch (InstantiationException ex) {
//			java.util.logging.Logger.getLogger(TrangChu_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null,
//					ex);
//		} catch (IllegalAccessException ex) {
//			java.util.logging.Logger.getLogger(TrangChu_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null,
//					ex);
//		} catch (UnsupportedLookAndFeelException ex) {
//			java.util.logging.Logger.getLogger(TrangChu_Panel.class.getName()).log(java.util.logging.Level.SEVERE, null,
//					ex);
//		}
//
//	}
//
//}