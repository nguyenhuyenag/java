package learn;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ChangeFinal {

	public static void main(String[] args)
			throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {

		A instance = new A();
		Field field = A.class.getDeclaredField("FIELD");
		field.setAccessible(true);
		
		Field modifiersField = Field.class.getDeclaredField("modifiers");
		modifiersField.setAccessible(true);
		modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
		
		System.out.println("Now: " + field.get(instance));
		field.set(instance, 100);
		System.out.println("Change: " + field.get(instance));
	}
}
