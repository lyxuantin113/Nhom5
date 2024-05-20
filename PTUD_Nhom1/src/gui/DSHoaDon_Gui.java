package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import dao.ChiTietDonDat_Dao;
import dao.ChiTietHoaDon_Dao;
import dao.DonDat_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.NhanVien_Dao;
import dao.Thuoc_Dao;
import entity.ChiTietHoaDon;
import entity.DonDat;
import entity.HoaDon;
import entity.NhanVien;

public class DSHoaDon_Gui extends JPanel implements ActionListener, MouseListener {
	private JComboBox<String> cbbTim;
	private JTable tableThuoc;
	private JTable tableHoaDon;
	private JButton btnTim;
	private JButton btnIn;
	private JButton btnReset;
	private Thuoc_Dao thuocDao;
	private NhanVien_Dao nhanVienDao;
	private KhachHang_Dao khachHangDao;
	private HoaDon_Dao hoaDonDao;
	private ChiTietHoaDon_Dao cthdDao;
	private DefaultTableModel modelHoaDon;
	private JTextField tfTim;

	public DSHoaDon_Gui(NhanVien nhanVienDN) {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel headPn = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Hóa Đơn");
		Font fo24 = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		headLb.setFont(fo24);
		headLb.setForeground(Color.blue);
		headPn.add(headLb);

//		CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();
//		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableHoaDon = new JPanel();
		JPanel pnTableThuoc = new JPanel();

//		Panel Right (Table Các Loại Thuốc Trong Đơn Đang Chọn)
		JLabel lbTableDSThuoc = new JLabel("Danh Sách Thuốc Trong Đơn:");
		lbTableDSThuoc.setFont(fo16);
		Box boxTableDSThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		tableThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tableThuoc = new JTable(modelThuoc));
		tableThuoc.setRowHeight(20);

		boxTableDSThuoc.add(lbTableDSThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));
		boxTableDSThuoc.add(scrollThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));

		pnTableHoaDon.add(boxTableDSThuoc);

//		Panel Left (Table Danh Sách Hóa Đơn Tìm Được)
		JLabel lbTableHoaDon = new JLabel("Danh Sách Hóa Đơn:");
		lbTableHoaDon.setFont(fo16);
		Box boxTableHoaDon = Box.createVerticalBox();
		String[] headerHoaDon = "Mã đơn;Mã NV;Tên khách;SĐT Khách;Ngày lập;Ngày nhận;Tổng tiền".split(";");
		modelHoaDon = new DefaultTableModel(headerHoaDon, 0);
		tableHoaDon = new JTable(modelHoaDon);
		JScrollPane scrollHoaDon = new JScrollPane();
		scrollHoaDon.setViewportView(tableHoaDon = new JTable(modelHoaDon));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableHoaDon.setRowHeight(20);

		boxTableHoaDon.add(lbTableHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));
		boxTableHoaDon.add(scrollHoaDon);
		boxTableHoaDon.add(Box.createVerticalStrut(10));

		pnTableThuoc.add(boxTableHoaDon);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setRightComponent(pnTableHoaDon);
		jsplit.setLeftComponent(pnTableThuoc);
		jsplit.setSize(1500, 470);
		jsplit.setPreferredSize(new Dimension(950, 470)); // SET CHIỀU CAO TABLE
		jsplit.setResizeWeight(0.0);
		jsplit.setDividerSize(0);

		pnCenterBot.add(jsplit);
		pnCenterBot.add(Box.createVerticalStrut(10));

//		SOUTH
		JPanel pnSouth = new JPanel();

		cbbTim = new JComboBox<String>();
		cbbTim.addItem("Mã đơn");
		cbbTim.addItem("Mã Nhân viên");
		cbbTim.addItem("Ngày lập");
		cbbTim.addItem("Ngày nhận");
		cbbTim.setPreferredSize(new Dimension(110, 35));

		tfTim = new JTextField(17);
		tfTim.setPreferredSize(new Dimension(0, 35));
		btnTim = new JButton("Tìm kiếm");
		btnTim.setBackground(new Color(0, 160, 255));
		btnTim.setPreferredSize(new Dimension(100, 35));
		btnTim.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 160, 255));
		btnReset.setPreferredSize(new Dimension(100, 35));
		btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnIn = new JButton("In hóa đơn");
		btnIn.setBackground(new Color(0, 160, 255));
		btnIn.setPreferredSize(new Dimension(100, 35));
		btnIn.setCursor(new Cursor(Cursor.HAND_CURSOR));

		pnSouth.add(cbbTim);
		pnSouth.add(tfTim);
		pnSouth.add(btnTim);
		pnSouth.add(btnReset);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnIn);

//		ADD Center Panel
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);

//		ADD TOP
		pnMain.add(headPn, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);

//		ADD BUTTON
		pnMain.add(pnSouth, BorderLayout.SOUTH);

//		END
		add(pnMain);

		thuocDao = new Thuoc_Dao();
		nhanVienDao = new NhanVien_Dao();
		khachHangDao = new KhachHang_Dao();
		hoaDonDao = new HoaDon_Dao();
		cthdDao = new ChiTietHoaDon_Dao();

		tableHoaDon.addMouseListener(this);
		tableThuoc.addMouseListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnIn.addActionListener(this);

		hienTableHoaDon();
	}

	public void hienTableHoaDon() {
		DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
		model.setRowCount(0);

		List<HoaDon> listHoaDon = hoaDonDao.readFromTable();
		if (listHoaDon != null) {
			for (HoaDon hoaDon : listHoaDon) {
				Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaNV().getMaNV(), hoaDon.getMaKH().getHoTen(),
						hoaDon.getMaKH().getSoDienThoai(), hoaDon.getNgayLap(), hoaDon.getNgayNhan(),
						hoaDonDao.tinhTongTien(hoaDon) };

				model.addRow(rowData); // Thêm hàng vào model
			}
		}
	}

	private void hienTableChiTietHoaDon(int rowSelected) {
		String maHoaDon = modelHoaDon.getValueAt(rowSelected, 0).toString();

		DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
		model.setRowCount(0);

		List<ChiTietHoaDon> listChiTietHoaDon = cthdDao.findByID(maHoaDon);
		if (listChiTietHoaDon != null) {
			for (ChiTietHoaDon chiTietHoaDon : listChiTietHoaDon) {
				Object[] rowData = { chiTietHoaDon.getMaThuoc().getMaThuoc(), chiTietHoaDon.getMaThuoc().getTenThuoc(),
						chiTietHoaDon.getMaThuoc().getLoaiThuoc(), chiTietHoaDon.getMaThuoc().getGiaBan(),
						chiTietHoaDon.getMaThuoc().getDonVi(), chiTietHoaDon.getSoLuong(),
						chiTietHoaDon.getSoLuong() * chiTietHoaDon.getMaThuoc().getGiaBan() }; // Tạo dữ liệu hàng mới
				model.addRow(rowData); // Thêm hàng vào model
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnTim)) {
			timKiem();
			tfTim.setText("");
			tfTim.requestFocus();
		}
		if (o.equals(btnReset)) {
			hienTableHoaDon();
			tfTim.setText("");
			DefaultTableModel model = (DefaultTableModel) tableThuoc.getModel();
			model.setRowCount(0);
		}
		if (o.equals(btnIn)) {
			int rowSelected = tableHoaDon.getSelectedRow();
			if (rowSelected == -1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần in!");
				return;
			}
			String maHoaDon = modelHoaDon.getValueAt(rowSelected, 0).toString();
			String maNV = modelHoaDon.getValueAt(rowSelected, 1).toString();
			NhanVien_Dao nvDao = new NhanVien_Dao();
			String tenNV =  nvDao.getTenNV(maNV);
			String tenKH = modelHoaDon.getValueAt(rowSelected, 2).toString();
			String tongTienTT = modelHoaDon.getValueAt(rowSelected, 6).toString();
			try {
				// Tạo tài liệu in
				String urlFont = System.getProperty("user.dir") + "\\lib\\Arial Unicode MS.ttf";
				BaseFont unicodeFont = BaseFont.createFont(urlFont, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
				com.itextpdf.text.Font unicodeFontObject = new com.itextpdf.text.Font(unicodeFont, 12);
				Document document = new Document();
				document.setMargins(50, 50, 10, 0);
				// Nơi lưu file
				String url = "";
				url = System.getProperty("user.dir") + "\\fileOutput\\";
				url +=  maHoaDon + ".pdf";
				String filename = url;
				PdfWriter.getInstance(document, new FileOutputStream(filename));
				document.open();
				// Tiêu đề
				String tenQuan = "NHÀ THUỐC TTV";
				Paragraph ten = new Paragraph(tenQuan, new com.itextpdf.text.Font(unicodeFont, 20, com.itextpdf.text.Font.BOLD));
				ten.setAlignment(Element.ALIGN_CENTER);
				document.add(ten);
				
				String diaChi = "Đường số 28, phường 6, Gò Vấp, Thành phố Hồ Chí Minh\n";
				Paragraph dc = new Paragraph(diaChi, unicodeFontObject);
				dc.setAlignment(Element.ALIGN_CENTER);
				document.add(dc);
				
				Paragraph hoaDonThanhToan = new Paragraph("HÓA ĐƠN BÁN HÀNG", new com.itextpdf.text.Font(unicodeFont, 20, com.itextpdf.text.Font.BOLD));
				Paragraph dong = new Paragraph("********************", unicodeFontObject);
				hoaDonThanhToan.setAlignment(Element.ALIGN_CENTER);
				document.add(hoaDonThanhToan);
				dong.setAlignment(Element.ALIGN_CENTER);
				document.add(dong);

				// THÔNG TIN QUÁN VÀ THÔNG TIN KHÁCH HÀNH NHÂN VIÊN
//				Mã Hóa Đơn
				String maDon = maHoaDon;
				Paragraph maDonPara = new Paragraph(maDon, new com.itextpdf.text.Font(unicodeFont, 16, com.itextpdf.text.Font.NORMAL));
				maDonPara.setAlignment(Element.ALIGN_CENTER);
				document.add(maDonPara);			
//				Table ngày
				String ngayTao = "Ngày lập: " + LocalDate.now();
				Paragraph ngayLap = new Paragraph(ngayTao, unicodeFontObject);
				ngayLap.setAlignment(Element.ALIGN_LEFT);
				
				String ngayXuat = "Ngày nhận: " + LocalDate.now();
				Paragraph ngayNhan = new Paragraph(ngayXuat, unicodeFontObject);
				ngayNhan.setAlignment(Element.ALIGN_RIGHT);
				
				PdfPTable tableNgay = new PdfPTable(2);
	            tableNgay.setWidthPercentage(70);

	            PdfPCell cellLap = new PdfPCell(ngayLap);
	            PdfPCell cellNhan = new PdfPCell(ngayNhan);
	            cellLap.setBorder(Rectangle.NO_BORDER);
	            cellNhan.setBorder(Rectangle.NO_BORDER);
	            cellLap.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellNhan.setHorizontalAlignment(Element.ALIGN_RIGHT);

	            tableNgay.addCell(cellLap);
	            tableNgay.addCell(cellNhan);
	            
	            tableNgay.setHorizontalAlignment(Element.ALIGN_CENTER);

	            document.add(tableNgay);
	            
//	          Table tên NV, KH
				
				String nv = "Tên nhân viên: " + tenNV;
				Paragraph nvPara = new Paragraph(nv, unicodeFontObject);
				nvPara.setAlignment(Element.ALIGN_LEFT);

				String kh = "Tên khách hàng: " + tenKH ;
				Paragraph khPara = new Paragraph(kh, unicodeFontObject);
				khPara.setAlignment(Element.ALIGN_RIGHT);

				PdfPTable tableTen = new PdfPTable(2);
	            tableTen.setWidthPercentage(70);

	            PdfPCell cellTenNV = new PdfPCell(nvPara);
	            PdfPCell cellTenKH = new PdfPCell(khPara);
	            cellTenNV.setBorder(Rectangle.NO_BORDER);
	            cellTenKH.setBorder(Rectangle.NO_BORDER);
	            cellTenNV.setHorizontalAlignment(Element.ALIGN_LEFT);
	            cellTenKH.setHorizontalAlignment(Element.ALIGN_RIGHT);

	            tableTen.addCell(cellTenNV);
	            tableTen.addCell(cellTenKH);
	            
	            tableTen.setHorizontalAlignment(Element.ALIGN_CENTER);

	            document.add(tableTen);
	            
//	          Table Chi Tiết
				document.add(Chunk.NEWLINE);

				// tạo bảng
				PdfPTable table = new PdfPTable(5);
				table.setTotalWidth(new float[] { 100f, 70f, 60f, 50f, 70f });
				table.setWidthPercentage(100);
				// Thêm tiêu đề cho bảng
				table.addCell(new PdfPCell(new Phrase("Tên thuốc", unicodeFontObject))); 
				table.addCell(new PdfPCell(new Phrase("Đơn giá", unicodeFontObject)));
				table.addCell(new PdfPCell(new Phrase("Đơn vị", unicodeFontObject)));
				table.addCell(new PdfPCell(new Phrase("Số lượng", unicodeFontObject)));
				table.addCell(new PdfPCell(new Phrase("Thành tiền", unicodeFontObject)));
				// Thêm dữ liệu
				HoaDon ds = hoaDonDao.findByID(maHoaDon);
				for (ChiTietHoaDon cthd : ds.getListChiTietHoaDon()) {
					String tenThuoc = cthd.getMaThuoc().getTenThuoc();
					String donGia = cthd.getMaThuoc().getGiaBan()+"";
					String donVi = cthd.getMaThuoc().getDonVi();
					String soluong = cthd.getSoLuong()+"";
					double thanhTien = cthd.getMaThuoc().getGiaBan() * cthd.getSoLuong();
					table.addCell(new PdfPCell(new Paragraph(tenThuoc, unicodeFontObject)));
					table.addCell(new PdfPCell(new Paragraph(donGia, unicodeFontObject)));
					table.addCell(new PdfPCell(new Paragraph(donVi, unicodeFontObject)));
					table.addCell(new PdfPCell(new Paragraph(soluong, unicodeFontObject)));
					table.addCell(new PdfPCell(new Paragraph(thanhTien+"", unicodeFontObject)));
				}
				for (PdfPRow row : table.getRows()) {
					for (PdfPCell cell : row.getCells()) {
						cell.setBorder(Rectangle.NO_BORDER);
					}
				}
				for (PdfPRow row : table.getRows()) {
					for (PdfPCell cell : row.getCells()) {
						cell.setBorder(Rectangle.BOTTOM);
					}
				}
				
				document.add(table);
				document.add(Chunk.NEWLINE);
				String tongTien = "Tổng Tiền: " + tongTienTT + " VNĐ";
				

				Paragraph tongTienPara = new Paragraph(tongTien, unicodeFontObject);
				tongTienPara.setAlignment(Element.ALIGN_RIGHT);
				document.add(tongTienPara);


				document.add(Chunk.NEWLINE);
				Paragraph dong3 = new Paragraph("\n---Mọi Thắc Mắc Vui Lòng Liên Hệ---\nĐT: 0912644361\nXin Cảm Ơn!",
						new com.itextpdf.text.Font(unicodeFont, 10, com.itextpdf.text.Font.BOLD));
				dong3.setAlignment(Element.ALIGN_CENTER);
				document.add(dong3);

				document.close();
				JOptionPane.showMessageDialog(this, "In thành công!");
				openPdf(filename);
			} catch (DocumentException | FileNotFoundException | MalformedURLException e1) {
				// TODO: handle exception
				e1.printStackTrace();
				System.out.println("1");
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("2");
			}
		}
	}

	private static void openPdf(String filePath) {
		try {
			File pdfFile = new File(filePath);
			if (pdfFile.exists())
				if (Desktop.isDesktopSupported())
					Desktop.getDesktop().open(pdfFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void timKiem() {
		String typeSearch = cbbTim.getSelectedItem().toString();
		String textFind = tfTim.getText();

		if (textFind.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
		} else {
			if (typeSearch.equalsIgnoreCase("Mã đơn")) {
				HoaDon hoaDon = hoaDonDao.findByID(textFind);
				if (hoaDon != null) {
					DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
					model.setRowCount(0);

					Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaNV().getMaNV(), hoaDon.getMaKH().getHoTen(),
							hoaDon.getMaKH().getSoDienThoai(), hoaDon.getNgayLap(), hoaDon.getNgayNhan(),
							hoaDonDao.tinhTongTien(hoaDon) };

					model.addRow(rowData);
				}
			} else if (typeSearch.equalsIgnoreCase("Mã Nhân viên")) {
				List<HoaDon> listHD = hoaDonDao.findByNhanVien(textFind);
				if (listHD != null) {
					DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
					model.setRowCount(0);
					for (HoaDon hoaDon : listHD) {
						Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaNV().getMaNV(),
								hoaDon.getMaKH().getHoTen(), hoaDon.getMaKH().getSoDienThoai(), hoaDon.getNgayLap(),
								hoaDon.getNgayNhan(), hoaDonDao.tinhTongTien(hoaDon) };
						model.addRow(rowData);
					}
				}
			} else if (typeSearch.equalsIgnoreCase("Ngày lập")) {
				try {
					LocalDate textFindDate = LocalDate.parse(tfTim.getText());
					List<HoaDon> listHD = hoaDonDao.findByNgayLap(textFindDate);
					if (listHD != null) {
						DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
						model.setRowCount(0);
						for (HoaDon hoaDon : listHD) {
							Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaNV().getMaNV(),
									hoaDon.getMaKH().getHoTen(), hoaDon.getMaKH().getSoDienThoai(), hoaDon.getNgayLap(),
									hoaDon.getNgayNhan(), hoaDonDao.tinhTongTien(hoaDon) };
							model.addRow(rowData);
						}
					}
				} catch (DateTimeParseException e) {
					JOptionPane.showMessageDialog(this, "Lưu ý: Ngày nhận sai định dạng ngày (yyyy-MM-dd)");
					return;
				}
			} else if (typeSearch.equalsIgnoreCase("Ngày nhận")) {
				try {
					LocalDate textFindDate = LocalDate.parse(tfTim.getText());
					List<HoaDon> listHD = hoaDonDao.findByNgayNhan(textFindDate);
					if (listHD != null) {
						DefaultTableModel model = (DefaultTableModel) tableHoaDon.getModel();
						model.setRowCount(0);
						for (HoaDon hoaDon : listHD) {
							Object[] rowData = { hoaDon.getMaHoaDon(), hoaDon.getMaNV().getMaNV(),
									hoaDon.getMaKH().getHoTen(), hoaDon.getMaKH().getSoDienThoai(), hoaDon.getNgayLap(),
									hoaDon.getNgayNhan(), hoaDonDao.tinhTongTien(hoaDon) };
							model.addRow(rowData);
						}
					}
				} catch (DateTimeParseException e) {
					JOptionPane.showMessageDialog(this, "Lưu ý: Ngày nhận sai định dạng ngày (yyyy-MM-dd)");
					return;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelectedDon = tableHoaDon.getSelectedRow();
		if (rowSelectedDon != -1) {
			hienTableChiTietHoaDon(rowSelectedDon);
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
