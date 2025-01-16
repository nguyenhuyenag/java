package com.qr.googleqr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Base64;

@Slf4j
public class QRCodeUtils {

    // private static final Logger log = LoggerFactory.getLogger(QRCodeUtils.class);

    public static String generateSecretKey() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[10]; // 80 bits
        random.nextBytes(bytes);
        Base32 base32 = new Base32();
        return base32.encodeToString(bytes).replace("=", ""); // Remove padding
    }

    public static String createQRCode(String account, String secretKey) {
        String issuer = "TS24ID";
        String otpAuthUrl = String.format("otpauth://totp/%s?secret=%s&issuer=%s", account, secretKey, issuer);
        return generateBase64QRCode(otpAuthUrl, "png", 300, 300);
    }

    private static String generateBase64QRCode(String input, String extension, int width, int height) {
        extension = StringUtils.isNotEmpty(extension) ? extension : "png";
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            BitMatrix matrix = new MultiFormatWriter().encode(input, BarcodeFormat.QR_CODE, width, height);
            MatrixToImageWriter.writeToStream(matrix, extension, bos);
            return Base64.getEncoder().encodeToString(bos.toByteArray());
        } catch (IOException | WriterException e) {
            log.error("Error generating QR code: {}", e.getMessage(), e);
        }
        return "";
    }

}
