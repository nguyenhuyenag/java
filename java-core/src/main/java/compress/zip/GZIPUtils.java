package compress.zip;
//package com.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.zip.GZIPInputStream;
//import java.util.zip.GZIPOutputStream;
//
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//public class GZIPUtils {
//
//	public static String encodeToString(String str) {
//		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			GZIPOutputStream gzos = new GZIPOutputStream(baos);
//			byte[] byteArr = str.getBytes(StandardCharsets.UTF_8);
//			gzos.write(byteArr, 0, byteArr.length);
//			gzos.close();
//			byte[] b = baos.toByteArray();
//			String zipData = new BASE64Encoder().encode(b).replace("\r\n", "");
//			baos.close();
//			return zipData;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//
//	public static String decodeToString(String strZipped) {
//		try {
//			int len;
//			byte[] buf = new byte[1024];
//			GZIPInputStream gzis = new GZIPInputStream(new ByteArrayInputStream(new BASE64Decoder().decodeBuffer(strZipped)));
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			while ((len = gzis.read(buf)) > 0) {
//				baos.write(buf, 0, len);
//			}
//			gzis.close();
//			baos.close();
//			return new String(baos.toByteArray(), StandardCharsets.UTF_8);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return "";
//	}
//
//	public static void main(String[] args) {
////		String xml = "<NDUNG_DC><GIAODICH><MA_GDICH>TVAN_THAISON020620152055132840101300842-999</MA_GDICH></NDUNG_DC>";
//		String xml = "";
//		String zip = encodeToString(xml);
//		System.out.println("Encode: " + zip);
//		System.out.println("Decode: " + decodeToString(zip));
//	}
//
//}
