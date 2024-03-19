package jmenubar;

import javax.swing.*;

import myGUI.CustomPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class a extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public a() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        // Khởi tạo card layout và panel chứa card
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Thêm các card vào panel
        JPanel trangChuCard = new JPanel();
        trangChuCard.add(new JLabel("Trang chủ"));

        
        JPanel otherCard = new JPanel();
        otherCard.add(new JLabel("Other"));

        cardPanel.add(trangChuCard, "Trang chủ");
        cardPanel.add(new CustomPanel(), "Other");

        // Thêm panel chứa card vào frame
        getContentPane().add(cardPanel, BorderLayout.CENTER);

        // Tạo một JMenuBar và JMenu để chuyển đổi card
        JMenuBar menuBar = new JMenuBar();
        JMenu trangChuMenu = new JMenu("Trang Chủ");
        JMenu otherMenu = new JMenu("Other");

        trangChuMenu.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Trang chủ" );
			}
		});
        otherMenu.addMouseListener(new MouseAdapter() {
        	@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel, "Other");
			}
		});

        menuBar.add(trangChuMenu);
        menuBar.add(otherMenu);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            a example = new a();
            example.setVisible(true);
        });
    }
}
