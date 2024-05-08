package gui;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeReader {
	public String inThongTin(String QRFilePath) {
		// Đường dẫn đến file ảnh chứa mã QR code
		String imagePath = QRFilePath;

		try {
			// Đọc file ảnh
			File file = new File(imagePath);
			BufferedImage image = ImageIO.read(file);

			// Tạo đối tượng BinaryBitmap từ hình ảnh
			BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));

			// Sử dụng MultiFormatReader để đọc mã QR code từ BinaryBitmap
			MultiFormatReader reader = new MultiFormatReader();
			Result result = reader.decode(binaryBitmap);

			// Lấy thông tin từ kết quả giải mã
			String content = result.getText();
			return content;
		} catch (IOException | NotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
