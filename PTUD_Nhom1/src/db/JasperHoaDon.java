package db;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.ChiTietHoaDon;
import entity.HoaDon;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class JasperHoaDon {

	public void generateHoaDonReport(HoaDon hoaDon) throws JRException {
		InputStream arq = JasperHoaDon.class.getResourceAsStream("/jasper/hoaDon.jrxml");

		JasperReport report = JasperCompileManager.compileReport(arq);

		// Create parameters map and set the parameter values
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("maHoaDon", hoaDon.getMaHoaDon());
		parameters.put("tenKhachHang", hoaDon.getMaKH().getHoTen());
		parameters.put("sdtKhachHang", hoaDon.getMaKH().getSoDienThoai());
		parameters.put("ngayLap", hoaDon.getNgayLap().toString());
		parameters.put("ngayNhan", hoaDon.getNgayNhan().toString());
		parameters.put("tenNhanVien", hoaDon.getMaNV().getTenNV());

		// Create a list to hold detail data
		List<Map<String, Object>> detailData = new ArrayList<>();
		// Iterate through ChiTietHoaDon list to populate detail data
		for (ChiTietHoaDon chiTiet : hoaDon.getListChiTietHoaDon()) {
			Map<String, Object> detailRow = new HashMap<>();
			detailRow.put("tenThuoc", chiTiet.getMaThuoc().getTenThuoc());
			detailRow.put("loaiThuoc", chiTiet.getMaThuoc().getLoaiThuoc());
			detailRow.put("soLuong", chiTiet.getSoLuong());
			detailRow.put("donVi", chiTiet.getMaThuoc().getDonVi());
			detailRow.put("thanhTien", chiTiet.getSoLuong() * chiTiet.getMaThuoc().getGiaBan());
			detailData.add(detailRow);
		}

		// Create a JRMapCollectionDataSource for detail data
		JRBeanCollectionDataSource detailDataSource = new JRBeanCollectionDataSource(detailData);

		JasperPrint print = JasperFillManager.fillReport(report, parameters, detailDataSource);

		JasperViewer.viewReport(print, false);
	}

}
