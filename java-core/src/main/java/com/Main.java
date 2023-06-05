package com;

public class Main {

	public static void getCurrentMethodName() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String name = stackTrace[2].getMethodName();
		System.out.println(name);
	}

	public static void nestedMethod() {
		getCurrentMethodName();
	}

	public static void test1() {
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(name);
	}

	public static void main(String[] args) {
		// test1();
		nestedMethod();
		getCurrentMethodName();
	}

}
