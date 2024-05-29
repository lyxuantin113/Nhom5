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
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
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
import dao.DonDat_Dao;
import dao.HoaDon_Dao;
import dao.KhachHang_Dao;
import dao.NhanVien_Dao;
import dao.Thuoc_Dao;
import entity.ChiTietDonDat;
import entity.ChiTietHoaDon;
import entity.DonDat;
import entity.HoaDon;
import entity.NhanVien;

public class DSDonDat_Gui extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6238333580670353303L;
	private JComboBox<String> cbbTim;
	private JButton btnReset;
	private JButton btnHoanThanh;
	private JButton btnTim;
	private JTable tableDonDat;
	private JTable tblThuoc;
	private Thuoc_Dao thuocDao;
	@SuppressWarnings("unused")
	private NhanVien_Dao nhanVienDao;
	@SuppressWarnings("unused")
	private KhachHang_Dao khachHangDao;
	private DonDat_Dao donDatDao;
	private ChiTietDonDat_Dao ctddDao;
	private DefaultTableModel modelDonDat;
	private JTextField tfTim;

//	Nút Chuyển Qua DS Hóa Đơn ????????????????

	public DSDonDat_Gui(NhanVien nhanVienDN) {
//		JPANEL
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

//		HEADER
		JPanel pnHead = new JPanel();
		JLabel headLb = new JLabel("Danh Sách Đơn Đặt");
		Font fo = new Font("Times New Roman", Font.BOLD, 24);
		Font fo16 = new Font("Times New Roman", Font.BOLD, 16);
		headLb.setFont(fo);
		headLb.setForeground(Color.blue);
		pnHead.add(headLb);

//		CENTER
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		JPanel pnCenterTop = new JPanel();
		pnCenterTop.setLayout(new BoxLayout(pnCenterTop, BoxLayout.X_AXIS));
		JPanel pnCenterBot = new JPanel();
//		pnCenterBot.setLayout(new BoxLayout(pnCenterBot, BoxLayout.Y_AXIS));

//		TABLES
		JSplitPane jsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		JPanel pnTableDonDat = new JPanel();
		JPanel pnTableThuoc = new JPanel();

//		Panel Right (Table Các Loại Thuốc Trong Đơn Đang Chọn)
		JLabel lblTableDSThuoc = new JLabel("Danh Sách Thuốc Trong Đơn:");
		lblTableDSThuoc.setFont(fo16);
		Box boxTableDSThuoc = Box.createVerticalBox();
		String[] headerThuoc = "Mã thuốc;Tên thuốc;Loại;Đơn giá;Đơn vị;Số lượng;Thành tiền".split(";");
		DefaultTableModel modelThuoc = new DefaultTableModel(headerThuoc, 0);
		tblThuoc = new JTable(modelThuoc);
		JScrollPane scrollThuoc = new JScrollPane();
		scrollThuoc.setViewportView(tblThuoc = new JTable(modelThuoc));
		tblThuoc.setRowHeight(20);

		boxTableDSThuoc.add(lblTableDSThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));
		boxTableDSThuoc.add(scrollThuoc);
		boxTableDSThuoc.add(Box.createVerticalStrut(10));

		pnTableDonDat.add(boxTableDSThuoc);

//		Panel Left (Table Danh Sách Hóa Đơn Tìm Được)
		JLabel lblTableDonDat = new JLabel("Danh Sách Đơn Đặt:");
		lblTableDonDat.setFont(fo16);
		Box boxTableDonDat = Box.createVerticalBox();
		String[] headerDonDat = "Mã đơn;Tên NV;Tên khách;SĐT Khách;Ngày lập;Ngày nhận;Tổng tiền".split(";");
		modelDonDat = new DefaultTableModel(headerDonDat, 0);
		tableDonDat = new JTable(modelDonDat);
		JScrollPane scrollDonDat = new JScrollPane();
		scrollDonDat.setViewportView(tableDonDat = new JTable(modelDonDat));
//		scrollThuoc.setPreferredSize(new Dimension(0, 310));  //SET CHIỀU CAO TABLE
		tableDonDat.setRowHeight(20);

		boxTableDonDat.add(lblTableDonDat);
		boxTableDonDat.add(Box.createVerticalStrut(10));
		boxTableDonDat.add(scrollDonDat);
		boxTableDonDat.add(Box.createVerticalStrut(10));

		pnTableThuoc.add(boxTableDonDat);

		jsplit.add(Box.createHorizontalStrut(30));
		jsplit.setRightComponent(pnTableDonDat);
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

		btnHoanThanh = new JButton("Hoàn Thành Đơn");
		btnHoanThanh.setBackground(new Color(0, 160, 255));
		btnHoanThanh.setPreferredSize(new Dimension(150, 35));
		btnHoanThanh.setCursor(new Cursor(Cursor.HAND_CURSOR));

		btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(0, 160, 255));
		btnReset.setPreferredSize(new Dimension(100, 35));
		btnReset.setCursor(new Cursor(Cursor.HAND_CURSOR));

		pnSouth.add(cbbTim);
		pnSouth.add(tfTim);
		pnSouth.add(btnTim);
		pnSouth.add(btnReset);
		pnSouth.add(Box.createHorizontalStrut(100));
		pnSouth.add(btnHoanThanh);

//		End
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterTop, BorderLayout.NORTH);
		pnCenter.add(Box.createVerticalStrut(10));
		pnCenter.add(pnCenterBot, BorderLayout.CENTER);

		pnMain.add(pnHead, BorderLayout.NORTH);
		pnMain.add(pnCenter, BorderLayout.CENTER);
		pnMain.add(pnSouth, BorderLayout.SOUTH);
		add(pnMain);

		thuocDao = new Thuoc_Dao();
		nhanVienDao = new NhanVien_Dao();
		khachHangDao = new KhachHang_Dao();
		donDatDao = new DonDat_Dao();
		ctddDao = new ChiTietDonDat_Dao();

		tblThuoc.addMouseListener(this);
		tableDonDat.addMouseListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		btnHoanThanh.addActionListener(this);

		hienTableDonDat();
	}

	private void hienTableDonDat() {
		DefaultTableModel model = (DefaultTableModel) tableDonDat.getModel();
		model.setRowCount(0);

		List<DonDat> listDonDat = donDatDao.readFromTable();
		if (listDonDat != null) {
			for (DonDat donDat : listDonDat) {
				Object[] rowData = { donDat.getMaDonDat(), donDat.getMaNV().getTenNV(), donDat.getMaKH().getHoTen(),
						donDat.getMaKH().getSoDienThoai(), donDat.getNgayLap(), donDat.getNgayNhan(),
						donDatDao.tinhTongTien(donDat) };

				model.addRow(rowData); // Thêm hàng vào model
			}
		}

	}

	private void hienTableChiTietDonDat(int rowSelected) {
		if (rowSelected != -1) {
			String maHoaDon = modelDonDat.getValueAt(rowSelected, 0).toString();

			DefaultTableModel model = (DefaultTableModel) tblThuoc.getModel();
			model.setRowCount(0);

			List<ChiTietDonDat> listChiTietDonDat = ctddDao.findByID(maHoaDon);
			if (listChiTietDonDat != null) {
				for (ChiTietDonDat chiTietDonDat : listChiTietDonDat) {
					Object[] rowData = { chiTietDonDat.getMaThuoc().getMaThuoc(),
							chiTietDonDat.getMaThuoc().getTenThuoc(), chiTietDonDat.getMaThuoc().getMaLoai().getLoaiThuoc(),
							chiTietDonDat.getMaThuoc().getGiaBan(), chiTietDonDat.getMaThuoc().getMaDonVi().getDonVi(),
							chiTietDonDat.getSoLuong(),
							chiTietDonDat.getSoLuong() * chiTietDonDat.getMaThuoc().getGiaBan() }; // Tạo dữ liệu hàng
																									// mới
					model.addRow(rowData); // Thêm hàng vào model
				}
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
			hienTableDonDat();
			tfTim.setText("");
			DefaultTableModel model = (DefaultTableModel) tblThuoc.getModel();
			model.setRowCount(0);
		}
		if (o.equals(btnHoanThanh)) {
			hoanThanhDon();
		}
	}

	private void hoanThanhDon() {
		int rowSelected = tableDonDat.getSelectedRow();

		if (rowSelected != -1) {

			int choice = JOptionPane.showConfirmDialog(this, "Xác nhận Hoàn thành đơn?", "Xác nhận đơn",
					JOptionPane.YES_NO_OPTION);

			if (choice == JOptionPane.YES_OPTION) {

				DonDat donDat = donDatDao.findByID(modelDonDat.getValueAt(rowSelected, 0).toString());

//				CHECK NGÀY NHẬN
				if (donDat.getNgayNhan().isAfter(LocalDate.now())) {
					int checkNhanTruoc = JOptionPane.showConfirmDialog(this,
							"Đơn hàng chưa đến ngày được nhận, xác nhận nhận trước ?", "Xác nhận nhận trước",
							JOptionPane.YES_NO_OPTION);
					if (checkNhanTruoc != JOptionPane.YES_OPTION)
						return;
				}

//				Đổi ngày nhận thành ngày đơn được xác nhận
				donDat.setNgayNhan(LocalDate.now());

				List<ChiTietDonDat> listCTDD = ctddDao.findByID(donDat.getMaDonDat());
				boolean flag = true;

				for (ChiTietDonDat chiTietDonDat : listCTDD) {
					if (chiTietDonDat.getSoLuong() > chiTietDonDat.getMaThuoc().getSoLuongTon()) {
						flag = false;
						break;
					}
				}

				if (flag) {
					HoaDon_Dao hoaDonDao = new HoaDon_Dao();
					HoaDon hoaDon = new HoaDon(donDat.getMaDonDat(), donDat.getMaKH(), donDat.getMaNV(),
							donDat.getNgayLap(), donDat.getNgayNhan());

					List<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
					for (ChiTietDonDat ctdd : listCTDD) {
						ChiTietHoaDon cthd = new ChiTietHoaDon(ctdd.getMaThuoc(), ctdd.getSoLuong());
						thuocDao.updateThuocQuatity(ctdd.getMaThuoc().getMaThuoc(), ctdd.getSoLuong());
						listCTHD.add(cthd);
					}

					hoaDon.setListChiTietHoaDon(listCTHD);
					hoaDonDao.addOne(hoaDon);

					modelDonDat.removeRow(rowSelected);

					ctddDao.deleteByID(donDat.getMaDonDat());
					donDatDao.deleteByID(donDat.getMaDonDat());

					DefaultTableModel model = (DefaultTableModel) tblThuoc.getModel();
					model.setRowCount(0);

					JOptionPane.showMessageDialog(this, "Đơn hàng đã được xác nhận, đang in đơn xác nhận ...");
					inHoaDon(hoaDon);
				} else {
					JOptionPane.showMessageDialog(this,
							"Đơn hàng không thể Hoàn thành. Vui lòng kiểm tra số lượng từng loại thuốc trong đơn!");
				}
			}
		}
	}

	public void timKiem() {
		String typeSearch = cbbTim.getSelectedItem().toString();
		String textFind = tfTim.getText();

		if (textFind.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin tìm kiếm.");
		} else {
			if (typeSearch.equalsIgnoreCase("Mã đơn")) {
				DonDat donDat = donDatDao.findByID(textFind);
				if (donDat != null) {
					DefaultTableModel model = (DefaultTableModel) tableDonDat.getModel();
					model.setRowCount(0);

					Object[] rowData = { donDat.getMaDonDat(), donDat.getMaNV().getTenNV(), donDat.getMaKH().getHoTen(),
							donDat.getMaKH().getSoDienThoai(), donDat.getNgayLap(), donDat.getNgayNhan(),
							donDatDao.tinhTongTien(donDat) };

					model.addRow(rowData);
				}
			} else if (typeSearch.equalsIgnoreCase("Mã Nhân viên")) {
				List<DonDat> listHD = donDatDao.findByNhanVien(textFind);
				if (listHD != null) {
					DefaultTableModel model = (DefaultTableModel) tableDonDat.getModel();
					model.setRowCount(0);
					for (DonDat donDat : listHD) {
						Object[] rowData = { donDat.getMaDonDat(), donDat.getMaNV().getTenNV(),
								donDat.getMaKH().getHoTen(), donDat.getMaKH().getSoDienThoai(), donDat.getNgayLap(),
								donDat.getNgayNhan(), donDatDao.tinhTongTien(donDat) };
						model.addRow(rowData);
					}
				}
			} else if (typeSearch.equalsIgnoreCase("Ngày lập")) {
				try {
					LocalDate textFindDate = LocalDate.parse(tfTim.getText());
					List<DonDat> listHD = donDatDao.findByNgayLap(textFindDate);
					if (listHD != null) {
						DefaultTableModel model = (DefaultTableModel) tableDonDat.getModel();
						model.setRowCount(0);
						for (DonDat donDat : listHD) {
							Object[] rowData = { donDat.getMaDonDat(), donDat.getMaNV().getTenNV(),
									donDat.getMaKH().getHoTen(), donDat.getMaKH().getSoDienThoai(), donDat.getNgayLap(),
									donDat.getNgayNhan(), donDatDao.tinhTongTien(donDat) };
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
					List<DonDat> listHD = donDatDao.findByNgayNhan(textFindDate);
					if (listHD != null) {
						DefaultTableModel model = (DefaultTableModel) tableDonDat.getModel();
						model.setRowCount(0);
						for (DonDat donDat : listHD) {
							Object[] rowData = { donDat.getMaDonDat(), donDat.getMaNV().getTenNV(),
									donDat.getMaKH().getHoTen(), donDat.getMaKH().getSoDienThoai(), donDat.getNgayLap(),
									donDat.getNgayNhan(), donDatDao.tinhTongTien(donDat) };
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

//	IN ĐƠN NHẬN
	public void inHoaDon(HoaDon hoaDon) {

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
			url += hoaDon.getMaHoaDon() + ".pdf";
			String filename = url;
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			// Tiêu đề
			String tenQuan = "NHÀ THUỐC TTV";
			Paragraph ten = new Paragraph(tenQuan,
					new com.itextpdf.text.Font(unicodeFont, 20, com.itextpdf.text.Font.BOLD));
			ten.setAlignment(Element.ALIGN_CENTER);
			document.add(ten);

			String diaChi = "Đường số 28, phường 6, Gò Vấp, Thành phố Hồ Chí Minh\n";
			Paragraph dc = new Paragraph(diaChi, unicodeFontObject);
			dc.setAlignment(Element.ALIGN_CENTER);
			document.add(dc);

			Paragraph hoaDonThanhToan = new Paragraph("ĐƠN XÁC NHẬN NHẬN THUỐC",
					new com.itextpdf.text.Font(unicodeFont, 20, com.itextpdf.text.Font.BOLD));
			Paragraph dong = new Paragraph("********************", unicodeFontObject);
			hoaDonThanhToan.setAlignment(Element.ALIGN_CENTER);
			document.add(hoaDonThanhToan);
			dong.setAlignment(Element.ALIGN_CENTER);
			document.add(dong);

			// THÔNG TIN QUÁN VÀ THÔNG TIN KHÁCH HÀNH NHÂN VIÊN
//			Mã Hóa Đơn
			String maDon = hoaDon.getMaHoaDon();
			Paragraph maDonPara = new Paragraph(maDon,
					new com.itextpdf.text.Font(unicodeFont, 16, com.itextpdf.text.Font.NORMAL));
			maDonPara.setAlignment(Element.ALIGN_CENTER);
			document.add(maDonPara);
//			Table ngày
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

//          Table tên NV, KH

			String nv = "Tên nhân viên: " + hoaDon.getMaNV().getTenNV();
			Paragraph nvPara = new Paragraph(nv, unicodeFontObject);
			nvPara.setAlignment(Element.ALIGN_LEFT);

			String kh = "Tên khách hàng: " + hoaDon.getMaKH().getHoTen();
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

//          Table Chi Tiết
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
			// Thêm dữ
			for (ChiTietHoaDon cthd : hoaDon.getListChiTietHoaDon()) {
				String tenThuoc = cthd.getMaThuoc().getTenThuoc();
				String donGia = cthd.getMaThuoc().getGiaBan() + "";
				String donVi = cthd.getMaThuoc().getMaDonVi().getMaDonVi();
				String soluong = cthd.getSoLuong() + "";
				double thanhTien = cthd.getMaThuoc().getGiaBan() * cthd.getSoLuong();
				table.addCell(new PdfPCell(new Paragraph(tenThuoc, unicodeFontObject)));
				table.addCell(new PdfPCell(new Paragraph(donGia, unicodeFontObject)));
				table.addCell(new PdfPCell(new Paragraph(donVi, unicodeFontObject)));
				table.addCell(new PdfPCell(new Paragraph(soluong, unicodeFontObject)));
				table.addCell(new PdfPCell(new Paragraph(thanhTien + "", unicodeFontObject)));
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
			HoaDon_Dao hDao = new HoaDon_Dao();
			String tongTien = "Tổng Tiền: " + hDao.tinhTongTien(hoaDon) + " VNĐ";

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

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelectedDon = tableDonDat.getSelectedRow();
		if (rowSelectedDon != -1) {
			hienTableChiTietDonDat(rowSelectedDon);
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
