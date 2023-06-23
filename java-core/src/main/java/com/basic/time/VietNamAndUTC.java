package com.basic.time;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class VietNamAndUTC {
	
	public static void main(String[] args) {
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("UTC = " + utc.format(ft));
		ZonedDateTime vn = ZonedDateTime.now(ZoneId.of("Asia/Bangkok"));
		System.out.println("Viet Nam = " + vn.format(ft));
	}
	
}
