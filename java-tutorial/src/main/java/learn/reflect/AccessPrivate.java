package learn.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@SuppressWarnings("unused")
class Reflection {

	private int age = 20;
	private int level = 100;

	public void hello(String name) {
		System.out.println("Hello " + name);
	}

}

public class AccessPrivate {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		int now, change;
		Reflection ref = new Reflection();
		// Method[] methods = Reflection.class.getMethods();
		Field[] fields = Reflection.class.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			System.out.println("Field name: `" + field.getName() + "`");
			// get private value
			now = field.getInt(ref);
			field.setInt(ref, 30);
			// change private value
			change = field.getInt(ref);
			System.out.println("Change value from " + now + " to " + change + "\n");
		}

	}

}
