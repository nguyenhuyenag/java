package com.qr;

import static java.lang.String.format;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SystemUtils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * Test class for testing out zxing and QR Codes.
 */
public class WifiQRCode {
	
	public static void generateQRCodeForWiFi() throws IOException, WriterException {
        // Remember to encode the string if it contains unusual characters - see internet page
        String ssid = "abc";
        String password = "def";

        String wifiString = "WIFI:S:%s;T:WPA;P:%s;;";
        wifiString = format(wifiString, ssid, password);

        MultiFormatWriter writer = new MultiFormatWriter();
        // Hashtable<EncodeHintType, ErrorCorrectionLevel> hints = new Hashtable<>();
        Map<EncodeHintType, ErrorCorrectionLevel> hints = new HashMap<>();
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

        // Image has to be big enough to print onto A4 in reasonable quality so 1600 should do
	    Path path = Paths.get(SystemUtils.USER_DIR, "output", "wifi_qr_code.png");
        BitMatrix bitMatrix = writer.encode(wifiString, BarcodeFormat.QR_CODE, 1600, 1600, hints);
        MatrixToImageWriter.writeToPath(bitMatrix, "png", path);
    }

	public static void main(String[] args) throws Exception {
		generateQRCodeForWiFi();
	    System.out.println("OK");
	}

}
