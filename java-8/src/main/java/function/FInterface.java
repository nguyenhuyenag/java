package function;

@FunctionalInterface // optional
interface FuncInterface {

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

public class FInterface implements FuncInterface {

	@Override
	public void showName(String name) {
		System.out.println("I'm " + name);
	}

	public static void main(String[] args) {

		FInterface f = new FInterface();
		
		// implements
		f.showName("Java");
		
		// without implements
		f.show();
		
		// static
		FuncInterface.showStatic();

	}

}
