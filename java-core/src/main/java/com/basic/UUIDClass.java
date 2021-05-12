//package com.basic;
//
//import java.io.UnsupportedEncodingException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.util.UUID;
//
//import org.apache.directory.api.util.Hex;
//
//public class UUIDClass {
//
//	public static String bytesToHex(byte[] bytes) throws DecoderException {
//		return Hex.encodeHexString(bytes);
//	}
//
//	public byte[] decodeUsingApacheCommons(String hexString) throws DecoderException {
//		return Hex.decodeHex(hexString.toCharArray());
//	}
//
//	public static void main(String[] args)
//			throws UnsupportedEncodingException, NoSuchAlgorithmException, DecoderException {
//		// UUID uuid = UUID.randomUUID();
//		// int variant = uuid.variant();
//		// System.out.println(variant);
//		// int version = uuid.version();
//		// System.out.println(version);
//
//		MessageDigest salt = MessageDigest.getInstance("SHA-256");
//		salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
//		String digest = bytesToHex(salt.digest());
//		System.out.println(digest);
//	}
//
//}
