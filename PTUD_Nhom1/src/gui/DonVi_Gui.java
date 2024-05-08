package gui;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DonVi_Gui extends JFrame {

	private JTable tblDonVi;

	public DonVi_Gui() {
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
	    JTextField txtMaDonVi = new JTextField(20);
	    b1.add(lblMaDonVi);
	    b1.add(txtMaDonVi);
	    pnCenterTop.add(b1);
	    
	    
	    JLabel lblTenDonVi = new JLabel("Tên đơn vị: ");
	    JTextField txtTenDonVi = new JTextField(20);
	    b2.add(lblTenDonVi);
	    b2.add(txtTenDonVi);
	    pnCenterTop.add(b2);
	    
	    
	    JLabel lblQuyDoi = new JLabel("Quy đổi: ");
	    JTextField txtQuyDoi = new JTextField(20);
	    b3.add(lblQuyDoi);
	    b3.add(txtQuyDoi);
	    pnCenterTop.add(b3);
	    
	    pnCenter.add(pnCenterTop);
	    
	    // Table
	    String[] header = {"Mã đơn vị", "Tên đơn vị", "Quy đổi"};
	    DefaultTableModel dtm = new DefaultTableModel(header, 0);
	    tblDonVi = new JTable(dtm);
	    JScrollPane sc = new JScrollPane(tblDonVi);
	    tblDonVi.setPreferredScrollableViewportSize(new Dimension(800, 300));
	    pnCenterBot.add(sc);
	    
	    pnCenter.add(pnCenterBot);
	    
	    pnMain.add(pnCenter, BorderLayout.CENTER);
	    
	    // Button
	    JPanel pnButton = new JPanel();
	    JButton btnLuu = new JButton("Lưu");
	    JButton btnHuy = new JButton("Hủy");
	    pnButton.add(btnLuu);
	    pnButton.add(btnHuy);
	    pnMain.add(pnButton, BorderLayout.SOUTH);
	   
	    add(pnMain);
	    
	    
		
	}
	
}
