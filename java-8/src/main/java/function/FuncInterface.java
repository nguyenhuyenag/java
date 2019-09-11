package function;

@FunctionalInterface // optional
interface FunInterf {

	// abstract method
	void showName(String name);

	// default method, non-abstract method
	default void show() {
		System.out.println("I'm default method 1");
	}

	static void showStatic() {
		System.out.println("I'm static method");
	}

}

public class FuncInterface implements FunInterf {

	@Override
	public void showName(String name) {
		System.out.println("I'm " + name);
	}

	public static void main(String[] args) {

		FuncInterface fi = new FuncInterface();

		// implements
		fi.showName("Java");

		// without implements
		fi.show();

		// static
		FunInterf.showStatic();

	}

}
