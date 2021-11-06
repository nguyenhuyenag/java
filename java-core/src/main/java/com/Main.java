package com;

import org.apache.commons.lang3.StringUtils;

import common.util.DateTimeUtils;

public class Main {

	public static String getTagValue(String xml, String tagName) {
		return StringUtils.substringBetween(xml, "<" + tagName + ">", "</" + tagName + ">");
	}
	
	public static boolean isNumeric(String str) {
		return str.matches("\\d+");
	}

	public static void main(String[] args) {
		String date = "2021-11-06 11:25:54";
		System.out.println(DateTimeUtils.changeDateFormat(date, "yyyy-MM-dd HH:mm:ss", "HH:mm:ss"));
	}

}
