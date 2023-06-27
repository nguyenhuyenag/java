package com.reflection.field;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("unused")
public class ObjectToMap {

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	private static class Employee {
		private String name;
		private Double salary;
	}

	private static Map<String, Object> convertUsingReflection(Object object) throws IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			map.put(field.getName(), field.get(object));
		}
		return map;
	}

	public static void main(String[] args) throws IllegalAccessException {
		Map<String, Object> convert = convertUsingReflection(new Employee("Jame", 30.5));
		convert.forEach((k, v) -> System.out.println(k + ", " + v));
	}

}
