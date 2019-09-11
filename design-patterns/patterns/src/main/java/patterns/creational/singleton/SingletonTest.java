package patterns.creational.singleton;

public class SingletonTest {

	public static void main(String[] args) {

		// illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// Eager eager = new Eager();

		// Get the only object available
		Eager eager = Eager.getInstance();

		// show the message
		eager.showMessage();

	}

}
