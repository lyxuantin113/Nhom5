package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class FrameDanhSach extends JFrame {

	public static void main(String[] args) {
		// Tạo một HashMap để lưu trữ thông tin về các thuốc
		Map<String, String[]> drugInfo = new HashMap<>();
		drugInfo.put("D001", new String[] { "Paracetamol", "500mg", "Painkiller" });
		drugInfo.put("D002", new String[] { "Amoxicillin", "250mg", "Antibiotic" });
		// Thêm thông tin của các thuốc khác vào đây...

		// Tạo giao diện đồ họa
		JFrame frame = new JFrame("Drug Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(4, 2, 5, 5)); // 4 hàng, 2 cột, với khoảng cách 5px giữa các thành phần

		// Tạo các JLabel và JTextField
		JLabel labelDrugCode = new JLabel("Mã thuốc:");
		JTextField textFieldDrugCode = new JTextField();
		JLabel labelDrugName = new JLabel("Tên thuốc:");
		JTextField textFieldDrugName = new JTextField();
		JLabel labelDosage = new JLabel("Liều lượng:");
		JTextField textFieldDosage = new JTextField();
		JLabel labelDescription = new JLabel("Miêu tả:");
		JTextField textFieldDescription = new JTextField();

		// Thêm các thành phần vào giao diện
		contentPane.add(labelDrugCode);
		contentPane.add(textFieldDrugCode);
		contentPane.add(labelDrugName);
		contentPane.add(textFieldDrugName);
		contentPane.add(labelDosage);
		contentPane.add(textFieldDosage);
		contentPane.add(labelDescription);
		contentPane.add(textFieldDescription);

		// Thêm sự kiện cho textFieldDrugCode
		textFieldDrugCode.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String drugCode = textFieldDrugCode.getText();
				String[] info = drugInfo.get(drugCode);
				if (info != null) {
					textFieldDrugName.setText(info[0]);
					textFieldDosage.setText(info[1]);
					textFieldDescription.setText(info[2]);
				} else {
					textFieldDrugName.setText("Không tìm thấy thông tin cho mã thuốc này.");
					textFieldDosage.setText("");
					textFieldDescription.setText("");
				}
			}
		});

		// Cài đặt kích thước và hiển thị frame
		frame.setSize(400, 200);
		frame.setVisible(true);
	}

}
