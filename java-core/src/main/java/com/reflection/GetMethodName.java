package com.reflection;

public class GetMethodName {

	public static String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getClassName() //
				+ "." + Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	public static void test1() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(name);
	}

	public static void test2() {
		class Local {
		}
		String name = Local.class.getEnclosingMethod().getName();
		System.out.println(name);
	}

	public static void main(String[] args) {
		test1();
		test2();
	}

}
