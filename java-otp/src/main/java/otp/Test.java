package otp;

import com.eatthepath.otp.TimeBasedOneTimePasswordGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.time.Duration;
import java.time.Instant;
import java.util.Base64;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Test {

    private static final TimeBasedOneTimePasswordGenerator totp = new TimeBasedOneTimePasswordGenerator();

    private static int convertSecretKeyToOtp(String secretKey) {
        byte[] decodedKey = new Base32().decode(secretKey);
        Key key = new SecretKeySpec(decodedKey, "HmacSHA1");
        try {
            // Mặc định là 30s
            TimeBasedOneTimePasswordGenerator totpGenerator //
                    = new TimeBasedOneTimePasswordGenerator(Duration.ofSeconds(60));
            return totpGenerator.generateOneTimePassword(key, Instant.now());
        } catch (InvalidKeyException | NumberFormatException e) {
            log.error("Error verifyOtp: {}", e.getMessage(), e);
        }
        return -1;
    }

    public static boolean verifyOtp(String secretKey, String otpCode) {
        if (StringUtils.isNotEmpty(secretKey) && StringUtils.isEmpty(otpCode)) {
            return false;
        }
        byte[] decodedKey = new Base32().decode(secretKey);
        Key key = new SecretKeySpec(decodedKey, "HmacSHA1");
        try {
            int generatedOtp = totp.generateOneTimePassword(key, Instant.now());
            return generatedOtp == Integer.parseInt(otpCode);
        } catch (InvalidKeyException | NumberFormatException e) {
            log.error("Error verifyOtp: {}", e.getMessage(), e);
        }
        return false;
    }

//    private static int convertSecretKeyToOtp(String secretKey) {
//        byte[] decodedKey = new Base32().decode(secretKey);
//        Key key = new SecretKeySpec(decodedKey, "HmacSHA1");
//        try {
//            TimeBasedOneTimePasswordGenerator totpGenerator //
//                    = new TimeBasedOneTimePasswordGenerator(Duration.ofSeconds(60));
//            return totpGenerator.generateOneTimePassword(key, Instant.now());
//        } catch (InvalidKeyException | NumberFormatException e) {
//            log.error("Error verifyOtp: {}", e.getMessage(), e);
//        }
//        return -1;
//    }
//
//    public static boolean verifyOtp(String secretKey, String otpCode) {
//        if (StringUtils.isNotEmpty(secretKey) && StringUtils.isEmpty(otpCode)) {
//            return false;
//        }
//        byte[] decodedKey = new Base32().decode(secretKey);
//        Key key = new SecretKeySpec(decodedKey, "HmacSHA1");
//        TimeBasedOneTimePasswordGenerator totpGenerator = new TimeBasedOneTimePasswordGenerator();
//        Instant now = Instant.now(); // TODO: JDK 8
//        try {
//            int generatedOtp = totpGenerator.generateOneTimePassword(key, now);
//            return Integer.parseInt(otpCode) == generatedOtp;
//        } catch (InvalidKeyException | NumberFormatException e) {
//            log.error("Error verifyOtp: {}", e.getMessage(), e);
//        }
//        return false;
//    }

    public static void main(String[] args) throws Exception {
//        String secretKey = "MSLUIOU6YWPR7KEF";
//        while (true) {
//            System.out.println("otp = " + convertSecretKeyToOtp(secretKey));
//            TimeUnit.SECONDS.sleep(1);
//        }
        final KeyGenerator keyGenerator = KeyGenerator.getInstance(totp.getAlgorithm());

        // Key length should match the length of the HMAC output (160 bits for SHA-1, 256 bits
        // for SHA-256, and 512 bits for SHA-512). Note that while Mac#getMacLength() returns a
        // length in _bytes,_ KeyGenerator#init(int) takes a key length in _bits._
        final int macLengthInBytes = Mac.getInstance(totp.getAlgorithm()).getMacLength();
        keyGenerator.init(macLengthInBytes * 8);

        SecretKey key = keyGenerator.generateKey();

        Base32 base32 = new Base32();
        String encodedKey = base32.encodeToString(key.getEncoded());
        System.out.println("Secret Key (Base32): " + encodedKey);

        encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
        System.out.println("Secret Key (Base64): " + encodedKey);


        final Instant now = Instant.now();
        final Instant later = now.plus(totp.getTimeStep());

        System.out.println("Current password: " + totp.generateOneTimePasswordString(key, now));
        System.out.println("Future password:  " + totp.generateOneTimePasswordString(key, later));
    }

}
