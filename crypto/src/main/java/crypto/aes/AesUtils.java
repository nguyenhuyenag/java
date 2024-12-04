package crypto.aes;

import crypto.util.Base64Utils;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static crypto.util.CryptoUtils.executeCipher;

@Slf4j
public class AesUtils {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    private static final String AES_SECRET_KEY = "HStamiaNIACkeTURnAlBeresTabLylAO";
    private static final String AES_ENCRYPTION_IV = "VGumLqshd4kVkg7C";

    private static SecretKey generateKey(String key) {
        if (key == null) {
            log.error("AES secret key is null.");
            return null;
        }
        int length = key.length();
        if (length != 16 && length != 24 && length != 32) {
            log.error("AES secret key must be 16, 24, or 32 bytes long.");
            return null;
        }
        return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    }

    private static IvParameterSpec generateIv(String iv) {
        if (iv == null || iv.length() != 16) {
            log.error("IvParameter must be 16 bytes long.");
            return null;
        }
        return new IvParameterSpec(iv.getBytes(StandardCharsets.UTF_8));
    }

    private static String cryptoHelper(int cipherMode, byte[] data) {
        try {
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKey secretKey = generateKey(AES_SECRET_KEY);
            IvParameterSpec iv = generateIv(AES_ENCRYPTION_IV);

            if (iv == null) {
                log.error("IvParameter is null");
                return "";
            }

            cipher.init(cipherMode, secretKey, iv);
            return executeCipher(cipher, cipherMode, data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 InvalidAlgorithmParameterException e) {
            log.error("AES {} failed. Error: {}",
                    cipherMode == Cipher.ENCRYPT_MODE ? "encryption" : "decryption", e.getMessage());
        }
        return "";
    }

    public static String encrypt(String base64) {
        byte[] data = Base64Utils.decodeToByte(base64);
        return cryptoHelper(Cipher.ENCRYPT_MODE, data);
    }

    public static String decrypt(String base64) {
        byte[] data = Base64Utils.decodeToByte(base64);
        return cryptoHelper(Cipher.DECRYPT_MODE, data);
    }

}
