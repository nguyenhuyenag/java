package com.reflection.method;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class MethodClazz {

	private String name;
	private int age;

	public MethodClazz(String name, int age) {
		this.age = age;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setNameAndAge(String name, int age) {
		this.name = name;
		this.age = age;
	}

	private void sayHelloWithName() {

	}

	public static String getPhone() {
		return "0123456";
	}

	public static LocalDate getLocalDate() {
		return LocalDate.now();
	}

}
