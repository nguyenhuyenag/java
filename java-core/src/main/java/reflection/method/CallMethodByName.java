package reflection.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CallMethodByName {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		String className = "com.reflection.method.MethodClazz";
		Class<?> clazz = Class.forName(className); 	// Convert string classname to class
		Object instance = clazz.newInstance(); 		// Invoke empty constructor

		// Set name
		Method setNameMethod = instance.getClass().getMethod("setName", String.class);
		setNameMethod.invoke(instance, "HuyeNV"); // pass arg

		// Get name
		Method getNameMethod = instance.getClass().getMethod("getName");
		String name = (String) getNameMethod.invoke(instance);
		System.out.println("Name: " + name);

		// Set multiple value
		Class<?>[] paramTypes = { String.class, int.class };
		Method multipleSetValue = instance.getClass().getMethod("setNameAndAge", paramTypes);
		multipleSetValue.invoke(instance, name, 29); // pass args
		
		// Get age
		Method getAgeMethod = instance.getClass().getMethod("getAge");
		int age = (int) getAgeMethod.invoke(instance);
		System.out.println("Age: " + age);
		
		// Using contructor
		Constructor<?> dogConstructor = clazz.getConstructor(String.class, int.class);
		instance = dogConstructor.newInstance("Hachiko", 10);
	}

}
