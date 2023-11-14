package com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.SystemUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class BarCodeGenerator {

	public static void main(String[] args) throws WriterException, IOException {
		String barcodeData = "123456789012";
		String filePath = SystemUtils.USER_DIR + "/output/EAN13_Barcode.png";

		generateEAN13Barcode(barcodeData, filePath);
		// generateEAN13Barcode2(barcodeData, filePath);
		System.out.println("Mã vạch đã được tạo thành công.");
	}

	protected static void generateEAN13Barcode(String barcodeData, String filePath)
			throws WriterException, IOException {
		int width = 300;
		int height = 150;
		BitMatrix bitMatrix = new MultiFormatWriter().encode(barcodeData, BarcodeFormat.EAN_13, width, height);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", Paths.get(filePath));
	}

	protected static void generateEAN13Barcode2(String barcodeData, String filePath) throws Exception {
		// BarcodeFormat barcodeFormat = BarcodeFormat.EAN_13;
		int width = 300;
		int height = 150;

		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		BitMatrix bitMatrix = multiFormatWriter.encode(barcodeData, BarcodeFormat.EAN_13, width, height);

		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				bufferedImage.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}

		File file = new File(filePath);
		ImageIO.write(bufferedImage, "png", file);
	}

}
