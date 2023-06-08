package com.reflection;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class MethodClazz {

	private void getName() {

	}

	public int getAge() {
		return 15;
	}

	public static String getPhone() {
		return "0123456";
	}

	public static LocalDate getLocalDate() {
		return LocalDate.now();
	}

}
