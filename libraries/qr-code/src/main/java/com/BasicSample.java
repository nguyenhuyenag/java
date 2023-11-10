package com;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.commons.lang3.SystemUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class BasicSample {

	public static void main(String[] args) throws WriterException, IOException {
	    String data = "Hà Nội mùa thu";
	    QRCodeWriter qrCodeWriter = new QRCodeWriter();
	    // Size image output : 200 x 200
	    BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, 200, 200);

	    // Write to file image
	    String outputFile = SystemUtils.USER_DIR +  "/output/image.png";
	    Path path = FileSystems.getDefault().getPath(outputFile);
	    MatrixToImageWriter.writeToPath(matrix, "PNG", path);
	    
	    System.out.println("OK");
	}

}
