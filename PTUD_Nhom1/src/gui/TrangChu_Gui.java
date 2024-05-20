package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;

public class TrangChu_Gui extends JPanel {
    private JLabel lblClock;
	private JLabel lblDate;
	private JLabel lblWelcomeNV;

	public TrangChu_Gui(NhanVien nhanVienDN) {
        setLayout(new BorderLayout());

        // Thêm hình ảnh nhà thuốc
        ImageIcon originalIcon = new ImageIcon("src//Icon//bg.png");
        Image scaledImage = originalIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel lblImage = new JLabel(scaledIcon, SwingConstants.CENTER);

        // Thêm chữ chào mừng
        JLabel lblWelcome = new JLabel("Hệ Thống Quản Lý Hiệu Thuốc", SwingConstants.CENTER);
        lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 32)); // Tăng kích thước font
        lblWelcome.setForeground(Color.BLUE);
        lblWelcome.setVerticalAlignment(SwingConstants.BOTTOM); // Canh lề dưới
        lblWelcome.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 0, 30, 0)); // Đặt khoảng cách dưới là 20px
        
        // Tạo JLabel để hiển thị đồng hồ
        JPanel pnTime = new JPanel();
        Box boxContainer = Box.createVerticalBox();
        Box boxWelComeNV = Box.createHorizontalBox();
        lblWelcomeNV = new JLabel("Xin Kính Chào " + nhanVienDN.getTenNV().toUpperCase());
        lblWelcomeNV.setFont(new Font("Times New Roman", Font.BOLD, 24));
        boxWelComeNV.add(lblWelcomeNV);
        
        Box boxTime = Box.createHorizontalBox();
        boxTime.setBorder(BorderFactory.createEmptyBorder(0, 50, 30, 50)); 
        lblDate = new JLabel("Hôm Nay: " + LocalDate.now() + " - Giờ: ");
        lblDate.setOpaque(true);
        lblDate.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        
        lblClock = new JLabel("",  SwingConstants.CENTER);
        lblClock.setOpaque(true);
        lblClock.setFont(new Font("Times New Roman", Font.BOLD, 22)); 
        boxTime.add(lblDate);
        boxTime.add(lblClock);
        boxContainer.add(boxWelComeNV);
        boxContainer.add(Box.createVerticalStrut(15));
        boxContainer.add(boxTime);
        pnTime.add(boxContainer);
        // Thêm hình ảnh và chữ chào mừng vào panel chính
        JPanel pnTop = new JPanel(new BorderLayout());
        pnTop.add(lblWelcome);
        JPanel panelCenter = new JPanel(new BorderLayout());
        
        panelCenter.add(pnTime, BorderLayout.NORTH);
        panelCenter.add(lblImage, BorderLayout.CENTER);

        add(pnTop, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        // Bắt đầu luồng cập nhật đồng hồ
        startClockThread();
    }

    // Phương thức để tạo ImageIcon từ tệp hình ảnh
    protected ImageIcon createImageIcon(String path) {
        URL imgUrl = getClass().getResource(path);
        if (imgUrl != null) {
            return new ImageIcon(imgUrl);
        } else {
            System.err.println("Không thể tìm thấy hình ảnh: " + path);
            return null;
        }
    }
    // Khởi tạo và bắt đầu luồng cập nhật đồng hồ
    private void startClockThread() {
        Thread clockThread = new Thread(() -> {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            while (true) {
                String time = sdf.format(new Date());
                lblClock.setText(time);
                try {
                    Thread.sleep(1000); // Đợi 1 giây trước khi cập nhật lại đồng hồ
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        clockThread.start();
    }
}
