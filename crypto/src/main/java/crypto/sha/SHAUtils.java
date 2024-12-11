package crypto.sha;

import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAUtils {

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String sha256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(bytes);
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String text = "MessageDigest is not thread-safe";
        String hash1 = sha256(text);
        String hash2 = DigestUtils.sha256Hex(text);
        System.out.println("Hash 1 = " + hash1);
        System.out.println("Hash 2 = " + hash2);
        System.out.println("Test = " + hash1.equals(hash2));
    }

}
