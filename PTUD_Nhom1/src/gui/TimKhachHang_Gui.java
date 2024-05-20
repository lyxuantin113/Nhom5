package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.KhachHang_Dao;
import db.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;

public class TimKhachHang_Gui extends JPanel implements ActionListener{
	private JTextField txtSDT;
	private JButton btnTim;
	private JTable tbl;
	private JButton btnLamMoi;

	public TimKhachHang_Gui(NhanVien nhanVienDN) {
		setSize(1070, 600);
		setVisible(true);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		//HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Tìm kiếm khách hàng");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);
		
		pnMain.add(pnHead, BorderLayout.NORTH);
		
		//CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));
		//Box
		Box b1 = Box.createHorizontalBox();
		
		//SĐT khách hàng
		JLabel lblSDT = new JLabel("Số điện thoại khách hàng: ");
		lblSDT.setPreferredSize(new Dimension(165, 20));
		txtSDT = new JTextField(30);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(lblSDT);
		b1.add(txtSDT);
		btnTim = new JButton("Tìm");
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnTim.setBackground(new Color(0,160,255));
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLamMoi.setBackground(new Color(0,160,255));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnTim);
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnLamMoi);
		// Table
		String[] headers = {"Mã khách hàng","Số điện thoại","Tên khách hàng"};
		DefaultTableModel dtm = new DefaultTableModel(headers, 0);
		tbl = new JTable(dtm);
		JScrollPane scp = new JScrollPane(tbl);
		pnCenterBot.add(scp);
		tbl.setPreferredScrollableViewportSize(new Dimension(1000, 500));
		pnCenterTop.add(Box.createVerticalStrut(10));
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(20));
		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin tìm kiếm"));
		pnCenterBot.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop);
		Box b2 = Box.createHorizontalBox();
		JLabel lblDSKH = new JLabel("Danh sách khách hàng");
		lblDSKH.setPreferredSize(new Dimension(165, 20));
		lblDSKH.setFont(fo20);
		b2.add(lblDSKH);
		pnCenter.add(Box.createVerticalStrut(20));
		pnCenter.add(b2);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot);
		
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		add(pnMain);
		
		
		btnTim.addActionListener(this);
		btnLamMoi.addActionListener(this);
		
		ConnectDB.connect();
		hienTable();
	}

	private void hienTable() {
		DefaultTableModel model = (DefaultTableModel) tbl.getModel();
		model.setRowCount(0);
		// Lấy dữ liệu từ database
		 List<KhachHang> dsKH = new KhachHang_Dao().readFromTable();
		 for (KhachHang kh : dsKH) {
		 model.addRow(new Object[] { kh.getMaKH(), kh.getSoDienThoai(), kh.getHoTen() });
		 }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			timKH();
		}
		if (o.equals(btnLamMoi)) {
			txtSDT.setText("");
			tbl.clearSelection();
		}
		
	}

	private void timKH() {
		String sdt = txtSDT.getText();
		if (sdt.equals("") || sdt == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập số điện thoại khách hàng");
			txtSDT.requestFocus();
			return;
		}
		if (checkSdt(sdt) == false) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không hợp lệ");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return;
		} else {
			// Tìm trong database
			KhachHang kh = new KhachHang_Dao().findKhachHangBySDT(sdt);
			if (kh == null) {
				JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
				txtSDT.requestFocus();
				txtSDT.selectAll();
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Tìm thấy khách hàng");
				DefaultTableModel model = (DefaultTableModel) tbl.getModel();
				for (int i = 0; i < model.getRowCount(); i++) {
					if (model.getValueAt(i, 1).equals(sdt)) {
						tbl.setRowSelectionInterval(i, i);
						break;
					}
				}
			}
		}
		
		
		
	}

	private boolean checkSdt(String sdt) {
		String regex = "0[0-9]{9}";
		if (sdt.matches(regex)) {
			return true;
		}
		
		return false;
	}
}
