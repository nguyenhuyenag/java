package patterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import patterns.creational.singleton.init.Eager;

public class ReflectionBreak {

	/**
	 * Phá vỡ cấu trúc Singleton Pattern bằng Reflection
	 */
	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException, InvocationTargetException {

		Eager instanceOne = Eager.getInstance();
		Eager instanceTwo = null;

		Constructor<?>[] constructors = Eager.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			constructor.setAccessible(true);
			instanceTwo = (Eager) constructor.newInstance();
		}

		System.out.println(instanceOne.hashCode());
		System.out.println(instanceTwo.hashCode());
	}

}
