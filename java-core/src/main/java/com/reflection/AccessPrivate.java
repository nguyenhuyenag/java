package com.reflection;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
class Reflection {
	
	private int age = 20;
	private int level = 100;

	public void hello(String name) {
		System.out.println("Hello " + name);
	}
}

public class AccessPrivate {

	public static void main(String[] args) throws IllegalAccessException {
		int now, change;
		Reflection ref = new Reflection();
		Field[] allField = Reflection.class.getDeclaredFields();
		for (Field field : allField) {
			field.setAccessible(true);
			System.out.println("Field name: `" + field.getName() + "`");
			// get private value
			now = field.getInt(ref);
			field.setInt(ref, 30);
			// change private value
			change = field.getInt(ref);
			System.out.println("Change value from `" + now + "` to `" + change + "`\n");
		}
	}

}
