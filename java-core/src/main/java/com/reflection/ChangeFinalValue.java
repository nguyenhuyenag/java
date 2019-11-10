package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@SuppressWarnings("unused")
class Reflections {
	private static final int FIELD = 50;
}

public class ChangeFinalValue {

	public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException {

		Reflections ref = new Reflections();
		Field field = Reflections.class.getDeclaredField("FIELD");
		field.setAccessible(true);

		Field modifiers = Field.class.getDeclaredField("modifiers");
		modifiers.setAccessible(true);
		modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

		System.out.println("Static value: " + field.get(ref));
		field.set(ref, 100);
		System.out.println("Change to: " + field.get(ref));
	}
}
