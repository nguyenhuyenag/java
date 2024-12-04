package crypto.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Slf4j
public class CryptoUtils {

    public static String executeCipher(Cipher cipher, int cipherMode, SecretKey secretKey, String data) {
        String mode = "";
        try {
            if (cipher == null || secretKey == null) {
                log.error("Cipher or SecretKey is null");
                return "";
            }
            byte[] result;
            switch (cipherMode) {
                case Cipher.ENCRYPT_MODE:
                    mode = "Encryption";
                    result = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
                    return Base64.getEncoder().encodeToString(result);

                case Cipher.DECRYPT_MODE:
                    mode = "Decryption";
                    result = cipher.doFinal(Base64.getDecoder().decode(data));
                    return new String(result, StandardCharsets.UTF_8);

                default:
                    log.error("Invalid cipher mode: {}", cipherMode);
                    return "";
            }
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            log.error("{} with {} failed. Error: {}", mode, cipher.getAlgorithm(), e.getMessage());
        }
        return "";
    }

}
