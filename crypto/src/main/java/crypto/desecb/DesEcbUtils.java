package crypto.desecb;

import crypto.util.Base64Utils;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static crypto.util.CryptoUtils.executeCipher;

@Slf4j
public class DesEcbUtils {

    private static final String ALGORITHM = "DES";
    private static final String TRANSFORMATION = "DES/ECB/PKCS5Padding";

    private static final String DES_ECB_SECRET_KEY = "AAECAwQFBgc=";

    private static SecretKey generateKey(String key) {
        if (key == null || key.length() != 8) {
            log.error("DES/ECB key must be 8 bytes long.");
            return null;
        }
        return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    }

    private static String cryptoHelper(int cipherMode, String data) {
        try {
            SecretKey secretKey = generateKey(Base64Utils.decodeToString(DES_ECB_SECRET_KEY));
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            return executeCipher(cipher, cipherMode, secretKey, data);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            log.error("DES/ECB {} failed. Error: {}",
                    cipherMode == Cipher.ENCRYPT_MODE ? "encryption" : "decryption", e.getMessage());
        }
        return "";
    }

    public static String encrypt(String data) {
        return cryptoHelper(Cipher.ENCRYPT_MODE, data);
    }

    public static String decrypt(String encryptedData) {
        return cryptoHelper(Cipher.DECRYPT_MODE, encryptedData);
    }

}
