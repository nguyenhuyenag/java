package com.reflection;

import java.lang.reflect.Method;

public class FindTheNumberOfMethods {

	public void x() {

	}

	public void y() {

	}

	public static void main(String[] args) {
		Method[] methods = FindTheNumberOfMethods.class.getDeclaredMethods();
		System.out.println(methods.length);
		// int count = 0;
		// for (Method m : methods) {
		// count++;
		// }
		// System.out.println(count);
	}

}
