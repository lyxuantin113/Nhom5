package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

import dao.DonVi_Dao;
import entity.DonVi;
import entity.NhanVien;

public class DonVi_Gui extends JFrame implements ActionListener, MouseListener{

	private JTable tblDonVi;
	
	private JButton btnHuy;
	private JTextField txtMaDonVi;
	private JTextField txtTenDonVi;
	private JTextField txtQuyDoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	
	private DonVi_Dao donViDao = new DonVi_Dao();

	private JButton btnXoaTrang;

	public DonVi_Gui(NhanVien nhanVienDN) {
		setSize(1070, 600);
		setVisible(true);
		
	    JPanel pnMain = new JPanel();
	    pnMain.setLayout(new BorderLayout());
	    
	    // Title
	    JPanel pnTitle = new JPanel();
	    JLabel lblTitle = new JLabel("THÊM ĐƠN VỊ MỚI");
	    lblTitle.setHorizontalAlignment(JLabel.CENTER);
	    Font font20 = new Font("Times New Roman", Font.BOLD, 20);
	    lblTitle.setFont(font20);
	    lblTitle.setForeground(java.awt.Color.BLUE);
	    
	    pnTitle.add(Box.createVerticalStrut(20));
	    pnTitle.add(lblTitle);
	    pnTitle.add(Box.createVerticalStrut(20));
	   
	    pnMain.add(pnTitle, BorderLayout.NORTH);
	   
	    
	    // Form
	    JPanel pnCenter = new JPanel();
	    pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
	    
	    JPanel pnCenterTop = new JPanel();
	    JPanel pnCenterBot = new JPanel();
	    
	    // Box
	    Box b1 = Box.createHorizontalBox();
	    Box b2 = Box.createHorizontalBox();
	    Box b3 = Box.createHorizontalBox();
	    
	    JLabel lblMaDonVi = new JLabel("Mã đơn vị: ");
	    txtMaDonVi = new JTextField(20);
	    txtMaDonVi.setEditable(false);
	    b1.add(lblMaDonVi);
	    b1.add(txtMaDonVi);
	    pnCenterTop.add(b1);
	    
	    
	    JLabel lblTenDonVi = new JLabel("Tên đơn vị: ");
	    txtTenDonVi = new JTextField(20);
	    b2.add(lblTenDonVi);
	    b2.add(txtTenDonVi);
	    pnCenterTop.add(b2);
	    
	    
	    pnCenter.add(pnCenterTop);
	    
	    // Table
	    String[] header = {"Mã đơn vị", "Tên đơn vị"};
	    DefaultTableModel dtm = new DefaultTableModel(header, 0);
	    tblDonVi = new JTable(dtm);
	    JScrollPane sc = new JScrollPane(tblDonVi);
	    tblDonVi.setPreferredScrollableViewportSize(new Dimension(800, 300));
	    pnCenterBot.add(sc);
	    
	    pnCenter.add(pnCenterBot);
	    
	    pnMain.add(pnCenter, BorderLayout.CENTER);
	    
	    // Button
	    JPanel pnButton = new JPanel();
	    btnThem = new JButton("Thêm");
	    btnXoa = new JButton("Xóa");
	    btnSua = new JButton("Sửa");
	    btnXoaTrang = new JButton("Xóa trắng");
	    btnHuy = new JButton("Hủy");
	    pnButton.add(btnThem);
	    pnButton.add(btnXoa);
	    pnButton.add(btnSua);
	    pnButton.add(btnXoaTrang);
	    pnButton.add(btnHuy);
	    pnMain.add(pnButton, BorderLayout.SOUTH);
	   
	    add(pnMain);
	    hienThiDanhSachDonVi();
	    
	    btnThem.addActionListener(this);
	    btnXoa.addActionListener(this);
	    btnSua.addActionListener(this);
	    btnXoaTrang.addActionListener(this);
	    btnHuy.addActionListener(this);
	    tblDonVi.addMouseListener(this);
		
	}

	private void hienThiDanhSachDonVi() {
		List<DonVi> dsDonVi = new DonVi_Dao().readFromTable();
		DefaultTableModel dtm = (DefaultTableModel) tblDonVi.getModel();
		dtm.setRowCount(0);
		for (DonVi dv : dsDonVi) {
			Object[] rowData = { dv.getMaDonVi(), dv.getDonVi() };
			dtm.addRow(rowData);
		}
		txtTenDonVi.requestFocus();
		taoMaDonVi();
		
		
	}

	private void taoMaDonVi() {
		txtMaDonVi.setText(donViDao.taoMaDonVi());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			themDonVi();
		}
		if (o.equals(btnXoa)) {
			xoaDonVi();
		}
		if (o.equals(btnSua)) {
			suaDonVi();
		}
		if (o.equals(btnHuy)) {
			huy();
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		
	}

	private void xoaTrang() {
		txtMaDonVi.setText(donViDao.taoMaDonVi());
		txtTenDonVi.setText("");
		tblDonVi.clearSelection();
		txtTenDonVi.requestFocus();
	}

	private void huy() {
		setVisible(false);
		
	}

	private void suaDonVi() {
		int row = tblDonVi.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn vị cần sửa");
			return;
		}
		if (checkData() == false) {
			return;
		}
		String maDonVi = (String) tblDonVi.getValueAt(row, 0);
		String tenDonVi = txtTenDonVi.getText();
		DonVi dv = new DonVi(maDonVi, tenDonVi);
		int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa đơn vị này không?");
		if (hoi != JOptionPane.YES_OPTION) {
			return;
		}
		donViDao.updateDonVi(dv);
		JOptionPane.showMessageDialog(null, "Sửa đơn vị thành công");
		xoaTrang();
		hienThiDanhSachDonVi();
		
		
	}

	private void xoaDonVi() {
		int row = tblDonVi.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn đơn vị cần xóa");
			return;
		}
		String maDonVi = (String) tblDonVi.getValueAt(row, 0);
		int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa đơn vị này không?");
		if (hoi != JOptionPane.YES_OPTION) {
			return;
		}
		if (donViDao.checkTonTaiThuoc(maDonVi)) {
			JOptionPane.showMessageDialog(null, "Không thể xóa đơn vị này vì có thuốc liên quan");
			return;
		}
		donViDao.deleteDonVi(maDonVi);
		JOptionPane.showMessageDialog(null, "Xóa đơn vị thành công");
		xoaTrang();
		hienThiDanhSachDonVi();
		
	}

	private void themDonVi() {
		
		if (checkData()) {
			String maDonVi = txtMaDonVi.getText();
			String tenDonVi = txtTenDonVi.getText();
			String quyDoi = txtQuyDoi.getText();
			DonVi dv = new DonVi(maDonVi, tenDonVi);
			if (donViDao.checkMaDonVi(maDonVi)) {
				JOptionPane.showMessageDialog(null, "Mã đơn vị đã tồn tại");
				return;
			}
			donViDao.addDonVi(dv);
			JOptionPane.showMessageDialog(null, "Thêm đơn vị thành công");
			xoaTrang();
			hienThiDanhSachDonVi();
		}
		
	}

	private boolean checkData() {
		if (txtMaDonVi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã đơn vị không được để trống");
			return false;
		}
		if (txtMaDonVi.getText().matches("DV[0-9]{3}") == false) {
			JOptionPane.showMessageDialog(null, "Mã đơn vị phải có dạng DVXXX với X là số");
			return false;
		}
		if (txtTenDonVi.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Tên đơn vị không được để trống");
			return false;
		}
		
		return true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblDonVi.getSelectedRow();
		txtMaDonVi.setText((String) tblDonVi.getValueAt(row, 0));
		txtTenDonVi.setText((String) tblDonVi.getValueAt(row, 1));

	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
