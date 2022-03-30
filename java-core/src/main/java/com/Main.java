package com;

import java.util.Date;

import common.util.TimeUtils;

public class Main {

	public static void main(String[] args) {
		Date after = TimeUtils.after().day(1);
		Date before = TimeUtils.before().day(2);
		System.out.println(after);
		System.out.println(before);
	}

}
