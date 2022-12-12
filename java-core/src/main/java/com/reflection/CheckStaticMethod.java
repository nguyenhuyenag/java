package com.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class StaticUtility {

	public static String getAuthorName() {
		return "Umang Budhwar";
	}

	public static LocalDate getLocalDate() {
		return LocalDate.now();
	}

	public static LocalTime getLocalTime() {
		return LocalTime.now();
	}
}

public class CheckStaticMethod {

	public static void main(String[] args) throws NoSuchMethodException {
		Method method = StaticUtility.class.getMethod("getAuthorName");
		System.out.println("Static method: " + Modifier.isStatic(method.getModifiers()));
	}

	public static void getAllStaticMethod() {
		List<Method> methodList = Arrays.asList(StaticUtility.class.getMethods()) //
				.stream() //
				.filter(method -> Modifier.isStatic(method.getModifiers())) //
				.collect(Collectors.toList());
		System.out.println("Static method list: ");
		for (Method method : methodList) {
			System.out.println(method.getName());
		}
	}

}
