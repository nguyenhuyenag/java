package function;

interface FunIn1 {

	// default method
	default void show() {
		System.out.println("I'm default method 1");
	}

}

interface FunIn2 {

	// default method
	default void show() {
		System.out.println("I'm default method 2");
	}

}

public class MultiInheritance implements FunIn1, FunIn2 {

	@Override
	public void show() {
		FunIn1.super.show();
	}

	public static void main(String[] args) {
		MultiInheritance fi = new MultiInheritance();
		fi.show();
	}

}
