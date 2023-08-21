package com.reflection.method;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodUtils {

	public static Method[] methodOf(Class<?> clazz) {
		return clazz.getDeclaredMethods();
	}

	// Get all method in MethodClazz.class
	public static void showAllNames() {
		Method[] methods = methodOf(MethodClazz.class);
		for (Method m : methods) {
			System.out.println(m.getName());
		}
	}

	// isPublic(), isPrivate, isSynchronized(), ...
	public static void showAllStatic() {
		Method[] methods = methodOf(MethodClazz.class);
		for (Method m : methods) {
			if (Modifier.isStatic(m.getModifiers())) {
				System.out.println(m.getName());
			}
		}
	}

	public static void getAllReturnTypes() {
		Method[] methods = methodOf(MethodClazz.class);
		for (Method m : methods) {
			System.out.println(m.getName() + ", ReturnType = " + m.getReturnType().getSimpleName());
		}
	}

	public static boolean checkMethodExits1(String methodName) {
		Method[] methods = methodOf(MethodClazz.class);
		for (Method m : methods) {
			if (m.getName().equals(methodName)) {
				return true;
			}
		}
		return false;
	}

	public static String getCurrentMethodName() {
		return Thread.currentThread().getStackTrace()[2].getMethodName();
	}

	public static void testGetMethodName() {
		String name = getCurrentMethodName();
		System.out.println(name);
	}

	public static void main(String[] args) {
		// showAllNames();
		// showAllStatic();
		// boolean check = checkMethodExits1("getName");
		// System.out.println(check);
		// getAllReturnTypes();
		testGetMethodName();
	}

}
