package myGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TimKhachHang_Gui extends JPanel implements ActionListener{
	private JTextField txtSDT;
	private JButton btnTim;

	public TimKhachHang_Gui() {
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
		JLabel lblSDT = new JLabel("SĐT khách hàng: ");
		lblSDT.setPreferredSize(new Dimension(120, 20));
		txtSDT = new JTextField(30);
		b1.add(lblSDT);
		b1.add(txtSDT);
		btnTim = new JButton("Tìm");
		b1.add(btnTim);
		// Table
		String[] headers = {"Tên khách hàng", "SĐT"};
		DefaultTableModel dtm = new DefaultTableModel(headers, 0);
		JTable tbl = new JTable(dtm);
		JScrollPane scp = new JScrollPane(tbl);
		pnCenterBot.add(scp);
		tbl.setPreferredScrollableViewportSize(new Dimension(1000, 500));
		
		pnCenterTop.add(b1);
		pnCenterTop.add(Box.createVerticalStrut(50));
		pnCenterTop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK), "Thông tin tìm kiếm"));
		pnCenterBot.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop);
		pnCenter.add(pnCenterBot);
		
		pnMain.add(pnCenter, BorderLayout.CENTER);
		
		add(pnMain);
		
		txtSDT.addActionListener(this);
		btnTim.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			timKH();
			
		}
		
	}

	private void timKH() {
		String sdt = txtSDT.getText();
		if (sdt.equals("") || sdt == null) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập SĐT khách hàng");
			txtSDT.requestFocus();
			return;
		}
		if (checkSdt(sdt) == false) {
			JOptionPane.showMessageDialog(null, "SĐT không hợp lệ");
			txtSDT.requestFocus();
			txtSDT.selectAll();
			return;
		}
		
		JOptionPane.showMessageDialog(null, "Tìm khách hàng thành công: "+ sdt);
		
	}

	private boolean checkSdt(String sdt) {
		String regex = "0[0-9]{9}";
		if (sdt.matches(regex)) {
			return true;
		}
		
		return false;
	}
}
