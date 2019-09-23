package common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.activation.DataHandler;

public class Base64Utils {

	/**
	 * Base64 encode
	 * @param src the byte array to encode
	 * @return byte array encoded
	 */
	public static byte[] encode(byte[] src) {
		return Base64.getEncoder().encode(src);
	}
	
	/**
	 * Base64 decode
	 * @param src the byte array to decode
	 * @return byte array decoded
	 */
	public static byte[] decode(byte[] src) {
		return Base64.getDecoder().decode(src);
	}

	/**
	 * Base64 decode with Charset
	 * @param src the string to encode
	 * @param charset is Charset
	 * @return byte array encoded
	 */
	public static byte[] encode(String src, Charset charset) {
		byte[] bytes = src.getBytes(charset);
		return encode(bytes);
	}

	/**
	 * Base64 encode with UTF-8
	 * @param src the string to encode
	 * @return byte array encoded
	 */
	public static byte[] encode(String src) {
		return encode(src, StandardCharsets.UTF_8);
	}

	/**
	 * Base64 encode to string with Charset
	 * @param src the byte array to encode
	 * @param charset is Charset
	 * @return string encoded
	 */
	public static String encodeToString(byte[] src, Charset charset) {
		byte[] bytes = encode(src);
		return new String(bytes, charset);
	}

	/**
	 * Base64 encode to string with UTF-8
	 * @param src the byte array to encode
	 * @return string encoded
	 */
	public static String encodeToString(byte[] src) {
		return encodeToString(src, StandardCharsets.UTF_8);
	}
	
	/**
	 * Base64 encode DataHandler
	 * @param path of file
	 * @return
	 * @throws IOException
	 */
	public static String encode(DataHandler handler) {
		byte[] bytes = FilesUtils.toByteArray(handler);
		return encodeToString(bytes);
	}
	
	/**
	 * Base64 encode DataHandler without Charset
	 * @param path of file
	 * @return
	 * @throws IOException
	 */
	public static String encodeWithoutCharset(DataHandler handler) {
		byte[] bytes = FilesUtils.toByteArray(handler);
		return Base64.getEncoder().encodeToString(bytes);
	}

	/**
	 * Base64 decode with Charset
	 * @param src the string Base64
	 * @param charset is Charset
	 * @return byte array decoded
	 */
	public static byte[] decode(String src, Charset charset) {
		byte[] bytes = src.getBytes(charset);
		return decode(bytes);
	}

	/**
	 * Base64 decode with UTF-8
	 * @param src the string Base64
	 * @return byte array decoded
	 */
	public static byte[] decode(String src) {
		return decode(src, StandardCharsets.UTF_8);
	}

	/**
	 * Base64 decode to string with Charset
	 * @param src the string Base64
	 * @param charset is Charset
	 * @return string decoded
	 */
	public static String decodeToString(String src, Charset charset) {
		byte[] bytes = decode(src, charset);
		return new String(bytes, charset);
	}

	/**
	 * Base64 decode to string with UTF-8
	 * @param src the string Base64
	 * @return string decoded
	 */
	public static String decodeToString(String base64) {
		return decodeToString(base64, StandardCharsets.UTF_8);
	}

}
