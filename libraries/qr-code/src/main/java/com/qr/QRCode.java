package com.qr;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import com.google.zxing.MultiFormatWriter;
import org.apache.commons.lang3.SystemUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCode {

    static int width = 400;
    static int height = 400;
    private static final String extension = "png";

    // Using QRCodeWriter()
    public static void toQRImage() throws WriterException, IOException {
        String data = "https://translate.google.com";
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
        // Write to file imaged
        Path path = Paths.get(SystemUtils.USER_DIR, "output", "qr_code.png");
        MatrixToImageWriter.writeToPath(matrix, extension, path);
        System.out.println("OK");
    }

    // Using QRCodeWriter()
    public static void toQRBase64() throws WriterException, IOException {
        String url = "https://news.bbc.co.uk";
        BitMatrix matrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(matrix, extension, bos);
        String image = Base64.getEncoder().encodeToString(bos.toByteArray()); // base64 encode
        System.out.println("Base64: " + image);
    }

    public static void main(String[] args) throws IOException, WriterException {
        // toQRImage();
        toQRBase64();
    }

}
