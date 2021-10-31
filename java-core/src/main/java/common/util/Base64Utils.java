package common.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Utils {

	/**
	 * Base64 encode
	 * 
	 * @param byteArr the byte array to encode
	 * @return byte array encoded
	 */
	public static byte[] encode(byte[] byteArr) {
		return Base64.getEncoder().encode(byteArr);
	}

	public static String encodeToString(byte[] byteArr) {
		byte[] arr = Base64.getEncoder().encode(byteArr);
		return new String(arr, StandardCharsets.UTF_8);
	}

	public static String encodeToString(String str) {
		byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
		return encodeToString(byteArr);
	}

//	public static String encodeToString(Path path) {
//		byte[] byteArr = FileUtils.toByteArray(path);
//		return encodeToString(byteArr);
//	}

	/**
	 * Base64 decode
	 * 
	 * @param src the byte array to decode
	 * @return byte array decoded
	 */
	public static byte[] decode(byte[] byteArr) {
		return Base64.getDecoder().decode(byteArr);
	}

	/**
	 * Base64 decode with UTF-8
	 * 
	 * @param base64 is a String Base64
	 * @return byte array decoded
	 */
	public static byte[] decode(String base64) {
		byte[] byteArr = base64.getBytes(StandardCharsets.UTF_8);
		return decode(byteArr);
	}

//	/**
//	 * Base64 decode with UTF-8
//	 * @param src the string Base64
//	 * @return byte array decoded
//	 */
//	public static byte[] decode(String src) {
//		return decode(src, StandardCharsets.UTF_8);
//	}

	public static String decodeToString(String base64) {
		byte[] byteArr = base64.getBytes(StandardCharsets.UTF_8);
		byteArr = Base64.getDecoder().decode(byteArr);
		return new String(byteArr);
	}

//	/**
//	 * Base64 decode to string with UTF-8
//	 * @param src the string Base64
//	 * @return string decoded
//	 */
//	public static String decodeToString(String base64) {
//		return decodeToString(base64, StandardCharsets.UTF_8);
//	}

//	/**
//	 * Base64 encode with UTF-8
//	 * @param src the string to encode
//	 * @return byte array encoded
//	 */
//	public static byte[] encode(String src) {
//		return encode(src, StandardCharsets.UTF_8);
//	}

//	/**
//	 * Base64 encode to string with UTF-8
//	 * @param byteArr the byte array to encode
//	 * @return string encoded
//	 */
//	public static String encodeToString(byte[] byteArr) {
//		return encodeToString(byteArr, StandardCharsets.UTF_8);
//	}

//	/**
//	 * Base64 encode DataHandler
//	 * @param path of file
//	 * @return
//	 * @throws IOException
//	 */
//	public static String encode(DataHandler handler) {
//		byte[] byteArr = FilesUtils.toByteArray(handler);
//		return encodeToString(byteArr);
//	}

//	/**
//	 * Base64 encode DataHandler without Charset
//	 * @param path of file
//	 * @return
//	 * @throws IOException
//	 */
//	public static String encodeWithoutCharset(DataHandler handler) {
//		byte[] byteArr = FilesUtils.toByteArray(handler);
//		return Base64.getEncoder().encodeToString(byteArr);
//	}

}
