package com.qr.googleqr;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.time.Instant;

public class OTPVerifier {

    public static boolean verifyOtp(String secretKey, String otpCode) {
        if (StringUtils.isNotEmpty(secretKey) && StringUtils.isEmpty(otpCode)) {
            return false;
        }
        byte[] decodedKey = new Base32().decode(secretKey);
        Key key = new SecretKeySpec(decodedKey, "HmacSHA1");
        TimeBasedOneTimePasswordGenerator totpGenerator = new TimeBasedOneTimePasswordGenerator();
        Instant now = Instant.now();
        try {
            int generatedOtp = totpGenerator.generateOneTimePassword(key, now);
            return Integer.parseInt(otpCode) == generatedOtp;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) throws Exception {
//        String secretKey = "V5FLLR4UT5TVHKD6"; // Replace with the actual Secret Key
//        String userOtp = "284224"; // OTP entered by the user
//
//        if (verifyOtp(secretKey, userOtp)) {
//            System.out.println("OTP is valid!");
//        } else {
//            System.out.println("Invalid OTP.");
//        }
//    }

//	public static boolean verifyOtp(String secretKey, String otpCode) throws Exception {
//        // Decode Base64 secret key
//        byte[] decodedKey = Base64.getDecoder().decode(secretKey);
//        Key key = new SecretKeySpec(decodedKey, "HmacSHA1");
//
//        // Create TOTP generator
//        TimeBasedOneTimePasswordGenerator totpGenerator = new TimeBasedOneTimePasswordGenerator();
//
//        // Get the current OTP
//        Instant now = Instant.now();
//        int generatedOtp = totpGenerator.generateOneTimePassword(key, now);
//
//        // Compare the generated OTP with the user's input
//        return Integer.parseInt(otpCode) == generatedOtp;
//    }
//
//    public static void main(String[] args) throws Exception {
//        String secretKey = "op4j21YLQFUBCpmNlSAXdFa6kTA=";
//        String userOtp = "585447"; // Mã OTP mà người dùng nhập
//
//        if (verifyOtp(secretKey, userOtp)) {
//            System.out.println("OTP is valid!");
//        } else {
//            System.out.println("Invalid OTP.");
//        }
//    }

}
