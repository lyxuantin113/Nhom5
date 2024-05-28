package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PrinterJob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.print.PrintService;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import dao.ChiTietPhieuNhapThuoc_Dao;
import dao.PhieuNhapThuoc_Dao;
import dao.Thuoc_Dao;
import db.ConnectDB;
import entity.ChiTietPhieuNhapThuoc;
import entity.NhanVien;
import entity.PhieuNhapThuoc;
import entity.Thuoc;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class DanhSachPhieuNhapThuoc_Gui extends JPanel implements ActionListener, MouseListener {

	private JTable table;
	private JTable table2;
	private JButton btnDaNhan;
	private JButton btnInExcel;
	private AbstractButton btnLamMoi;
	
	private NhanVien nvdn;
	

	public DanhSachPhieuNhapThuoc_Gui(NhanVien nhanVienDN) {
		setSize(1070, 600);
		setVisible(true);

		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

		// HEADER
		JPanel pnHead = new JPanel();
		JLabel lblHead = new JLabel("Danh sách phiếu nhập thuốc");
		Font fo20 = new Font("Times New Roman", Font.BOLD, 20);
		lblHead.setFont(fo20);
		lblHead.setForeground(Color.blue);
		pnHead.add(lblHead);

		pnMain.add(pnHead, BorderLayout.NORTH);
		// Center
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.Y_AXIS));
		JPanel pnCenterBot = new JPanel();
		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

		// Table
		String[] headers = { "Mã phiếu nhập", "Ngày nhập", "Nhân viên", "Nhà cung cấp", "Tổng tiền", "Trạng thái" };
		DefaultTableModel model = new DefaultTableModel(headers, 0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new java.awt.Dimension(1000, 300));
		JScrollPane sp = new JScrollPane(table);
		pnCenterTop.add(sp);
		// Button
		JPanel pnButton = new JPanel();
		btnDaNhan = new JButton("Đã nhận");
		btnDaNhan.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDaNhan.setBackground(new Color(0, 160, 255));
		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnLamMoi.setBackground(new Color(0, 160, 255));

		pnButton.add(btnDaNhan);
		pnButton.add(btnLamMoi);

		pnCenterTop.add(pnButton);
		// Table danh sách thuốc trong phiếu nhập
		String[] headers2 = { "Mã thuốc","Tên thuốc", "Số lượng", "Giá nhập", "Hạn sử dụng", "Đơn vị", "Thành tiền", "Mã CTPNT" };
		DefaultTableModel model2 = new DefaultTableModel(headers2, 0);
		table2 = new JTable(model2);
		table2.setPreferredScrollableViewportSize(new java.awt.Dimension(1000, 300));
		JScrollPane sp2 = new JScrollPane(table2);
		pnCenterBot.add(sp2);
		pnCenterBot.setBorder(BorderFactory.createTitledBorder("Danh sách thuốc trong phiếu nhập thuốc"));

		pnCenter.add(pnCenterTop);
		pnCenter.add(pnCenterBot);
		pnMain.add(pnCenter, BorderLayout.CENTER);

		// Footer
		JPanel pnFoot = new JPanel();
		btnInExcel = new JButton("Xuất file Excel");
		btnInExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnInExcel.setBackground(new Color(0, 160, 255));
		pnFoot.add(btnInExcel);
		pnMain.add(pnFoot, BorderLayout.SOUTH);

		add(pnMain);
		// Action
		btnDaNhan.addActionListener(this);
		btnInExcel.addActionListener(this);
		btnLamMoi.addActionListener(this);

		// Hiển thị danh sách phiếu nhập
		hienTable();
		ConnectDB.connect();
		table.addMouseListener(this);
		
		nvdn = nhanVienDN;

	}

	private void hienTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		// Lấy danh sách phiếu nhập từ database
		List<PhieuNhapThuoc> dsPNT = new PhieuNhapThuoc_Dao().readFromTableSort();
		for (PhieuNhapThuoc pnt : dsPNT) {
			Object[] rowData = new Object[6];
			rowData[0] = pnt.getMaPhieuNhap();
			rowData[1] = pnt.getNgayNhap();
			rowData[2] = pnt.getNhanVien().getTenNV();
			rowData[3] = pnt.getNhaCungCap().getTenNCC();
			rowData[4] = pnt.getTongTien();
			Boolean trangThai = pnt.getTrangThai();
			if (trangThai == true) {
				rowData[5] = "Đã nhận";
			} else {
				rowData[5] = "Chưa nhận";
			}
			
			model.addRow(rowData);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDaNhan)) {
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần nhận!");
				return;
			}
			if (table.getValueAt(table.getSelectedRow(), 5).equals("Đã nhận")) {
				JOptionPane.showMessageDialog(this, "Phiếu nhập đã được nhận!");
				return;
			}
			int hoiNhac = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn đã nhận thuốc?");
			if (hoiNhac == JOptionPane.YES_OPTION) {
				// Đánh dấu phiếu nhập đã nhận
				int row = table.getSelectedRow();
				String maPhieuNhap = table.getValueAt(row, 0).toString();
				PhieuNhapThuoc_Dao pntDao = new PhieuNhapThuoc_Dao();
				pntDao.updateTrangThai(maPhieuNhap);

				// Update thông tin thuốc trong kho
				List<ChiTietPhieuNhapThuoc> dsCTPNT = new ChiTietPhieuNhapThuoc_Dao().readFromTable(maPhieuNhap);
				List<Thuoc> dsThuoc = new Thuoc_Dao().readFromTable();
				for (ChiTietPhieuNhapThuoc ctPNT : dsCTPNT) {
					for (Thuoc thuoc : dsThuoc) {
						if (ctPNT.getThuoc().getMaThuoc().equals(thuoc.getMaThuoc())) {
							int soLuongTon = thuoc.getSoLuongTon() + ctPNT.getSoLuong();
							thuoc.setSoLuongTon(soLuongTon);
						}
					}
				}
				// Cập nhật lại thông tin thuốc trong database
				Thuoc_Dao thuocDao = new Thuoc_Dao();
				for (Thuoc thuoc : dsThuoc) {
					thuocDao.updateTTThuoc(thuoc);
				}
				DSThuoc_Gui thuocGui = new DSThuoc_Gui(nvdn);
				thuocGui.hienTable();

				hienTable();
			}

		}
		
		if (o.equals(btnInExcel)) {

			// Lấy mã phiếu nhập
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần in chi tiết!");
				return;
			}
			String maPhieuNhap = "data/";
			maPhieuNhap += table.getValueAt(row, 0).toString();
			// In danh sách chi tiết phiếu nhập
			maPhieuNhap += ".xlsx";
			inPhieuNhap(table2, maPhieuNhap);
			

		}
		if (o.equals(btnLamMoi)) {
			hienTable();
		}

	}


	private void inPhieuNhap(JTable table, String filePath) {

		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Sheet1");

			DefaultTableModel model = (DefaultTableModel) table.getModel();

			// Lấy header
			Row headerRow = ((XSSFSheet) sheet).createRow(0);
			for (int col = 0; col < model.getColumnCount(); col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(model.getColumnName(col));
			}

			// Lấy data
			for (int row = 0; row < model.getRowCount(); row++) {
				Row excelRow = ((XSSFSheet) sheet).createRow(row + 1);
				for (int col = 0; col < model.getColumnCount(); col++) {
					Object value = model.getValueAt(row, col);
					Cell cell = excelRow.createCell(col);
					if (value != null) {
						cell.setCellValue(value.toString());
					}
				}
			}

			// Viết vào file
			FileOutputStream fileOut = new FileOutputStream(filePath);
			workbook.write(fileOut);
			fileOut.close();
			workbook.close();

			JOptionPane.showMessageDialog(this, "In thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("In thất bại!");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Hiển thị danh sách chi tiết phiếu nhập thuốc
		int row = table.getSelectedRow();

		String maPhieuNhap = table.getValueAt(row, 0).toString();
		DefaultTableModel model = (DefaultTableModel) table2.getModel();
		model.setRowCount(0);
		List<ChiTietPhieuNhapThuoc> dsCTPNT = new ChiTietPhieuNhapThuoc_Dao().readFromTable(maPhieuNhap);
		for (ChiTietPhieuNhapThuoc ctPNT : dsCTPNT) {
			Object[] rowData = { ctPNT.getThuoc().getMaThuoc(), ctPNT.getThuoc().getTenThuoc(),ctPNT.getSoLuong(), ctPNT.getGiaNhap(), ctPNT.getHsd(),
					ctPNT.getDonVi(), ctPNT.getThanhTien(), ctPNT.getMaPhieuNhap().getMaPhieuNhap() };
			model.addRow(rowData);
		}

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
