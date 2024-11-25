package compress.desecb;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import common.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Slf4j
public class DesEcbUtils {

	private static final String DES_ALGORITHM = "DES";
	private static final String TRANSFORMATION = "DES/ECB/PKCS5Padding";

	private static final String CRYPTO_SECRET_KEY = "AAECAwQFBgc=";

	private static SecretKey createKey(String key) {
		if (key == null || key.length() != 8) {
			log.error("DES key must be 8 bytes long.");
			return null;
		}
		return new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), DES_ALGORITHM);
	}

	private static Cipher createCipher(int mode, SecretKey key) {
		try {
			Cipher cipher = Cipher.getInstance(TRANSFORMATION);
			cipher.init(mode, key);
			return cipher;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			log.error("Failed to initialize Cipher with mode {} and key: {}", mode, key, e);
		}
		return null;
	}

	private static String encrypt(String data, String key) {
		try {
			SecretKey secretKey = createKey(key);
			if (secretKey == null) {
				return "";
			}
			Cipher cipher = createCipher(Cipher.ENCRYPT_MODE, secretKey);
			if (cipher != null) {
				byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
				return Base64.getEncoder().encodeToString(encryptedData);
			}
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			log.error("Encryption failed for data: {}. Ensure the key and input are valid.", data, e);
		}
		return "";
	}

	private static String decrypt(String encryptedData, String key) {
		try {
			SecretKey secretKey = createKey(key);
			if (secretKey == null) {
				return "";
			}
			Cipher cipher = createCipher(Cipher.DECRYPT_MODE, secretKey);
			if (cipher != null) {
				byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
				return new String(decryptedData, StandardCharsets.UTF_8);
			}
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			log.error("Decryption failed for encrypted data. Ensure the data and key are valid.", e);
		}
		return "";
	}

	public static String encrypt(String data) {
		String secretKey = Base64Utils.decodeToString(CRYPTO_SECRET_KEY);
		return encrypt(data, secretKey);
	}

	public static String decrypt(String encryptedData) {
		String secretKey = Base64Utils.decodeToString(CRYPTO_SECRET_KEY);
		return decrypt(encryptedData, secretKey);
	}

}
