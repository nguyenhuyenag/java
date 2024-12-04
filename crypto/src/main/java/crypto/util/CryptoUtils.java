package crypto.util;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.util.Base64;

@Slf4j
public class CryptoUtils {

    public static String executeCipher(Cipher cipher, int cipherMode, byte[] data) {
        String cryptoMode = "";
        try {
            if (cipher == null) {
                log.error("Cipher is null");
                return "";
            }
            if (data == null) {
                log.error("Data is null");
                return "";
            }
            switch (cipherMode) {
                case Cipher.ENCRYPT_MODE:
                    cryptoMode = "Encryption";
                    break;

                case Cipher.DECRYPT_MODE:
                    cryptoMode = "Decryption";
                    break;

                default:
                    log.error("Invalid cipher cryptoMode: {}", cipherMode);
                    return "";
            }
            byte[] result = cipher.doFinal(data);
            return Base64.getEncoder().encodeToString(result);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            log.error("{} with {} failed. Error: {}", cryptoMode, cipher.getAlgorithm(), e.getMessage());
        }
        return "";
    }

}
