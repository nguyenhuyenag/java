package crypto.md5;

import jakarta.xml.bind.DatatypeConverter;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {

    public static String md5(String input) throws NoSuchAlgorithmException {
        // String hash = "35454B055CC325EA1AF2126E27707052";
        // String password = "ILoveJava";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        // The module javax.xml.bind has been put outside the jdk as of Java 9
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String password = "ILoveJava";
        String hash = "35454B055CC325EA1AF2126E27707052";

        String md5Hex1 = md5(password);
        String md5Hex2 = DigestUtils.md5Hex(password).toUpperCase();
        System.out.println("Check = " + hash.equals(md5Hex1));
        System.out.println("Check = " + hash.equals(md5Hex2));
    }

}
