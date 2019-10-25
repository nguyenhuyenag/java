package common.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.activation.DataHandler;

public class Base64Utils {
	
	private Base64Utils() {
		
	}

	/**
	 * Base64 encode
	 * @param byteArr the byte array to encode
	 * @return byte array encoded
	 */
	public static byte[] encode(byte[] byteArr) {
		return Base64.getEncoder().encode(byteArr);
	}
	
	/**
	 * Base64 decode
	 * @param src the byte array to decode
	 * @return byte array decoded
	 */
	public static byte[] decode(byte[] byteArr) {
		return Base64.getDecoder().decode(byteArr);
	}

	/**
	 * Base64 decode with Charset
	 * @param src the string to encode
	 * @param charset is Charset
	 * @return byte array encoded
	 */
	public static byte[] encode(String src, Charset charset) {
		byte[] byteArr = src.getBytes(charset);
		return encode(byteArr);
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
	 * @param byteArr the byte array to encode
	 * @param charset is Charset
	 * @return string encoded
	 */
	public static String encodeToString(byte[] byteArr, Charset charset) {
		byte[] arr = encode(byteArr);
		return new String(arr, charset);
	}

	/**
	 * Base64 encode to string with UTF-8
	 * @param byteArr the byte array to encode
	 * @return string encoded
	 */
	public static String encodeToString(byte[] byteArr) {
		return encodeToString(byteArr, StandardCharsets.UTF_8);
	}
	
	/**
	 * Base64 encode DataHandler
	 * @param path of file
	 * @return
	 * @throws IOException
	 */
	public static String encode(DataHandler handler) {
		byte[] byteArr = FilesUtils.toByteArray(handler);
		return encodeToString(byteArr);
	}
	
	/**
	 * Base64 encode DataHandler without Charset
	 * @param path of file
	 * @return
	 * @throws IOException
	 */
	public static String encodeWithoutCharset(DataHandler handler) {
		byte[] byteArr = FilesUtils.toByteArray(handler);
		return Base64.getEncoder().encodeToString(byteArr);
	}

	/**
	 * Base64 decode with Charset
	 * @param src the string Base64
	 * @param charset is Charset
	 * @return byte array decoded
	 */
	public static byte[] decode(String src, Charset charset) {
		byte[] byteArr = src.getBytes(charset);
		return decode(byteArr);
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
		byte[] byteArr = decode(src, charset);
		return new String(byteArr, charset);
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
