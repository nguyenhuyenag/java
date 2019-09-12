package function;

interface IFunc1 {
	// default method
	default void show() {
		System.out.println("I'm default method 1");
	}
}

interface IFunc2 {
	// default method
	default void show() {
		System.out.println("I'm default method 2");
	}
}

// Da thua ke
public class MultiInher implements IFunc1, IFunc2 {

	@Override
	public void show() {
		IFunc1.super.show();
	}

	public static void main(String[] args) {
		MultiInher fi = new MultiInher();
		fi.show(); // <- I'm default method 1
	}

}
