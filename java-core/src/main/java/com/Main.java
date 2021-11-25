package com;

import common.util.DateTimeUtils;

public class Main {

	public static void main(String[] args) {
		String strDate = "2021-11-08 19:11:51";
		String year = DateTimeUtils.changeDateFormat(strDate, "yyyy-MM-dd HH:mm:ss", "yyyy/MM/dd/HH");
		System.out.println(year);
	}

}
