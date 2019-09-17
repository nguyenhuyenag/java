package learn;

import java.lang.reflect.Field;

@SuppressWarnings("unused")
class A {
	private int age = 20;
	private final static int FIELD = 50;
}

public class AccessPrivate {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		A instance = new A();
		Field field = A.class.getDeclaredField("age");
		field.setAccessible(true);
		
		System.out.println("Now: " + field.get(instance));
		field.setInt(instance, 30);
		System.out.println("Change: " + field.get(instance));
	}

}
