package gui;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

public class CameraFrame extends JFrame {
	private JLabel videoLabel;
	private VideoCapture capture;

	public CameraFrame() {
		super("Camera Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		videoLabel = new JLabel();
		add(videoLabel, BorderLayout.CENTER);

		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		capture = new VideoCapture(0); // Mở camera

		if (!capture.isOpened()) {
			System.out.println("Không thể kết nối đến camera.");
			System.exit(-1);
		}

		new Thread(() -> {
			Mat frame = new Mat();
			BufferedImage bufImage;

			while (true) {
				capture.read(frame);

				if (!frame.empty()) {
					bufImage = Mat2BufferedImage(frame);

					ImageIcon imageIcon = new ImageIcon(bufImage);
					videoLabel.setIcon(imageIcon);
				}
			}
		}).start();

		// Tạo nút để chụp ảnh
		JButton captureButton = new JButton("Chụp Ảnh");
		captureButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				captureAndSaveImage();
			}
		});

		// Hiển thị nút trong cửa sổ
		add(captureButton, BorderLayout.SOUTH);
	}

	private void captureAndSaveImage() {
		Mat frame = new Mat();
		capture.read(frame); // Đọc frame từ camera

		// Lưu frame thành file ảnh
		LocalDateTime dateNow = LocalDateTime.now();
		String filename = dateNow.getHour() + dateNow.getMinute() + dateNow.getSecond() + dateNow.getNano() + ".jpg";
		Imgcodecs.imwrite(filename, frame);
		
		QRCodeReader qrReader = new QRCodeReader();
		qrReader.inThongTin("TH006_bd219356-8513-4c98-a183-728c023c4f24.png");
		
		System.exit(0);
	}

	private BufferedImage Mat2BufferedImage(Mat frame) {
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (frame.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize = frame.channels() * frame.cols() * frame.rows();
		byte[] buffer = new byte[bufferSize];
		frame.get(0, 0, buffer);

		BufferedImage image = new BufferedImage(frame.cols(), frame.rows(), type);
		final byte[] targetPixels = ((java.awt.image.DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(buffer, 0, targetPixels, 0, buffer.length);

		return image;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			CameraFrame frame = new CameraFrame();
			frame.setVisible(true);
		});
	}
}
