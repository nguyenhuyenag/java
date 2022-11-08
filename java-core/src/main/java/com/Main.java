package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

//	public static void test() {
//		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/892_03_TNDN_TT80_251.xlsx");
//		String base64 = Base64Utils.encodeToString(path);
//		System.out.println(base64.trim());
//		ClipboardUtils.copy(base64);
//	}

	private final static String HOME = System.getProperty("user.dir");
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://192.168.0.51:3306/invoice_master?useUnicode=true&characterEncoding=utf-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Ho_Chi_Minh";
		System.out.println(StringUtils.substringBetween(url, "://", ":"));
	}

}
