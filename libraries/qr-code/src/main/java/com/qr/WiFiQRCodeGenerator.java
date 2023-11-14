package com.qr;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SystemUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Thay đổi giá trị của ssid, password, và securityType tùy thuộc vào thông tin
 * WiFi
 */
public class WiFiQRCodeGenerator {

	public static void main(String[] args) {
		String ssid 		= "YourSSID";
		String password 	= "YourPassword";
		String securityType = "WPA"; // Thay đổi loại bảo mật nếu cần (WPA, WEP, Open)

		String filePath = SystemUtils.USER_DIR + "/output/WiFi_QRCode.png";

		try {
			generateWiFiQRCode(ssid, password, securityType, filePath);
			System.out.println("Mã QR code WiFi đã được tạo thành công.");
		} catch (WriterException | IOException e) {
			e.printStackTrace();
		}
	}

	private static void generateWiFiQRCode(String ssid, String password, String securityType, String filePath)
			throws WriterException, IOException {

		String wifiData = String.format("WIFI:S:%s;T:%s;P:%s;;", ssid, securityType, password);
		BarcodeFormat barcodeFormat = BarcodeFormat.QR_CODE;
		int width = 300;
		int height = 300;

		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

		BitMatrix bitMatrix = new MultiFormatWriter().encode(wifiData, barcodeFormat, width, height, hints);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

}
