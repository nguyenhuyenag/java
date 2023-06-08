package com.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodUtils {

	public static Method[] methodOf(Class<?> clazz) {
		return clazz.getDeclaredMethods();
	}

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
	
	
//	public static boolean checkMethodExits2(String methodName) {
//		try {
//			// Method method = MethodClazz.class.getMethod(methodName, String.class);
//			Method method = MethodClazz.class.getDeclaredMethod(methodName, String.class);
//			return method.getReturnType();
//		} catch (NoSuchMethodException | SecurityException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	public static void main(String[] args) {
		// showAllNames();
		// showAllStatic();
		// boolean check = checkMethodExits1("getName");
		// System.out.println(check);
		getAllReturnTypes();
	}

}
