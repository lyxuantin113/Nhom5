package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.LoaiThuoc_Dao;
import entity.LoaiThuoc;

public class LoaiThuoc_Gui extends JFrame implements ActionListener, MouseListener{
	private JTextField txtMaLoaiThuoc;
	private JTextField txtLoaiThuoc;
	private JTextField txtMoTa;
	private JTable tblLoaiThuoc;
	private JButton btnHuy;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private LoaiThuoc_Dao loaiThuocDao = new LoaiThuoc_Dao();
	private JButton btnXoaTrang;

	public LoaiThuoc_Gui() {
		setSize(1070, 600);
		setVisible(true);
		
	    JPanel pnMain = new JPanel();
	    pnMain.setLayout(new BorderLayout());
	    
	    // Title
	    JPanel pnTitle = new JPanel();
	    JLabel lblTitle = new JLabel("THÊM LOẠI THUỐC MỚI");
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
	    
	    JLabel lblMaLoaiThuoc = new JLabel("Mã loại thuốc: ");
	    txtMaLoaiThuoc = new JTextField(20);
	    txtMaLoaiThuoc.setEditable(false);
	    b1.add(lblMaLoaiThuoc);
	    b1.add(txtMaLoaiThuoc);
	    pnCenterTop.add(b1);
	    
	    
	    JLabel lblLoaiThuoc = new JLabel("Loại thuốc: ");
	    txtLoaiThuoc = new JTextField(20);
	    b2.add(lblLoaiThuoc);
	    b2.add(txtLoaiThuoc);
	    pnCenterTop.add(b2);
	    
	    
	    JLabel lblMoTa = new JLabel("Mô tả: ");
	    txtMoTa = new JTextField(20);
	    b3.add(lblMoTa);
	    b3.add(txtMoTa);
	    pnCenterTop.add(b3);
	    
	    pnCenter.add(pnCenterTop);
	    
	    // Table
	    String[] header = {"Mã loại thuốc", "Loại thuốc", "Mô tả"};
	    DefaultTableModel dtm = new DefaultTableModel(header, 0);
	    tblLoaiThuoc = new JTable(dtm);
	    JScrollPane sc = new JScrollPane(tblLoaiThuoc);
	    tblLoaiThuoc.setPreferredScrollableViewportSize(new Dimension(800, 300));
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
	    hienThiDanhSachLoaiThuoc();
	    
	    btnThem.addActionListener(this);
	    btnXoa.addActionListener(this);
	    btnSua.addActionListener(this);
	    btnXoaTrang.addActionListener(this);
	    btnHuy.addActionListener(this);
	    tblLoaiThuoc.addMouseListener(this);
	    
	}

	private void hienThiDanhSachLoaiThuoc() {
		List<LoaiThuoc> dsLoaiThuoc = loaiThuocDao.readFromTable();
		DefaultTableModel dtm = (DefaultTableModel) tblLoaiThuoc.getModel();
		dtm.setRowCount(0);
		for (LoaiThuoc lt : dsLoaiThuoc) {
			Object[] rowData = { lt.getMaLoai(), lt.getLoaiThuoc(), lt.getMoTa() };
			dtm.addRow(rowData);
		}
		txtLoaiThuoc.requestFocus();
		taoMaLoaiThuoc();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tblLoaiThuoc.getSelectedRow();
		txtMaLoaiThuoc.setText((String) tblLoaiThuoc.getValueAt(row, 0));
		txtLoaiThuoc.setText((String) tblLoaiThuoc.getValueAt(row, 1));
		txtMoTa.setText((String) tblLoaiThuoc.getValueAt(row, 2));
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			themLoaiThuoc();
		}
		if (o.equals(btnXoa)) {
			xoaLoaiThuoc();
		}
		if (o.equals(btnSua)) {
			suaLoaiThuoc();
		}
		if (o.equals(btnHuy)) {
			huy();
		}
		if (o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		
		
	}

	private void xoaTrang() {
		taoMaLoaiThuoc();
		txtLoaiThuoc.setText("");
		txtMoTa.setText("");
		tblLoaiThuoc.clearSelection();
		txtLoaiThuoc.requestFocus();
	}

	private void themLoaiThuoc() {
		if (checkData()) {
			String maLoai = txtMaLoaiThuoc.getText();
			String loaiThuoc = txtLoaiThuoc.getText();
			String moTa = txtMoTa.getText();
			LoaiThuoc lt = new LoaiThuoc(maLoai, loaiThuoc, moTa);
			if (loaiThuocDao.checkMaLoaiThuoc(maLoai)) {
				JOptionPane.showMessageDialog(null, "Mã loại thuốc đã tồn tại");
				return;
			}
			loaiThuocDao.addLoaiThuoc(lt);
			JOptionPane.showMessageDialog(null, "Thêm loại thuốc thành công");
			xoaTrang();
			hienThiDanhSachLoaiThuoc();
			
			
		}
		
	}

	private void taoMaLoaiThuoc() {
		txtMaLoaiThuoc.setText(loaiThuocDao.taoMaLoaiThuoc());
		
	}

	private boolean checkData() {
		if (txtMaLoaiThuoc.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Mã loại thuốc không được để trống");
			return false;
		}
		if (txtMaLoaiThuoc.getText().matches("LT[0-9]{3}") == false) {
			JOptionPane.showMessageDialog(null, "Mã loại thuốc phải có dạng LTXXX với X là số");
			return false;
		}
		if (txtLoaiThuoc.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Loại thuốc không được để trống");
			return false;
		}
		
		return true;
	}

	private void xoaLoaiThuoc() {
		int row = tblLoaiThuoc.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(null, "Chọn loại thuốc cần xóa");
			return;
		}
		String maLoai = tblLoaiThuoc.getValueAt(row, 0).toString();
		int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa không?");
		if (hoi != JOptionPane.YES_OPTION) {
			return;
		}
		if (loaiThuocDao.checkMaLoaiThuoc(maLoai) == true) {
			JOptionPane.showMessageDialog(null, "Không thể xóa loại thuốc này vì có thuốc liên quan");
			return;
		}
		loaiThuocDao.deleteLoaiThuoc(maLoai);
		JOptionPane.showMessageDialog(null, "Xóa thành công");
		xoaTrang();
		hienThiDanhSachLoaiThuoc();
		
	}

	private void suaLoaiThuoc() {
		String maLoai = txtMaLoaiThuoc.getText();
		String loaiThuoc = txtLoaiThuoc.getText();
		String moTa = txtMoTa.getText();
		if (checkData() == false) {
			return;
		}
		LoaiThuoc lt = new LoaiThuoc(maLoai, loaiThuoc, moTa);
		int hoi = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn sửa không?");
		if (hoi != JOptionPane.YES_OPTION) {
			return;
		}
		loaiThuocDao.updateLoaiThuoc(lt);
		JOptionPane.showMessageDialog(null, "Sửa thành công");
		xoaTrang();
		hienThiDanhSachLoaiThuoc();
		
	}

	private void huy() {
		setVisible(false);
		
	}
}
