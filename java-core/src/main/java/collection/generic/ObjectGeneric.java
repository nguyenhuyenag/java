package collection.generic;

import common.object.User;

// Object generic
class ObjGeneric<T> {

	private T object;

	@SuppressWarnings("deprecation")
	public ObjGeneric(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		this.object = (T) clazz.newInstance();
	}

	public T getInstance() {
		return object;
	}
}

public class ObjectGeneric {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// T obj = new T(); // Error
		ObjGeneric<User> generic = new ObjGeneric<>(User.class);
		User user = generic.getInstance();
		user.setName("Java");
		user.setAge(8);
		System.out.println(user.toString());
	}

}
