package com.qr;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.SystemUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode {

	public static void main(String[] args) throws WriterException, IOException {
	    String data = "https://translate.google.com";

	    int width = 400;
		int height = 400;
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);

	    // Write to file imaged
	    String outputFile = SystemUtils.USER_DIR +  "/output/qr_code.png";
	    Path path = Paths.get(outputFile);
	    MatrixToImageWriter.writeToPath(matrix, "PNG", path);
	    
	    System.out.println("OK");
	}

}
