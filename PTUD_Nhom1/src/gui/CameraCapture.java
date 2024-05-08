package gui;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgcodecs.Imgcodecs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class CameraCapture extends JFrame {
    private VideoCapture capture;

    public CameraCapture() {
        super("Camera Capture");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Load thư viện OpenCV
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        capture = new VideoCapture(0); // Mở camera

        if (!capture.isOpened()) {
            System.out.println("Không thể kết nối đến camera.");
            System.exit(-1);
        }

        // Tạo nút để chụp ảnh
        JButton captureButton = new JButton("Chụp Ảnh");
        captureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        LocalDateTime now = LocalDateTime.now();
        String filename = now + ".jpg";
        Imgcodecs.imwrite(filename, frame);

        System.out.println("Đã chụp và lưu ảnh: " + filename);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CameraCapture frame = new CameraCapture();
            frame.setVisible(true);
        });
    }
}
