package lambda;

interface Say {

	void sayHello(String name);

}

public class SingleParameter {

	public static void main(String[] args) {
		// hoặc (String name) -> {};
		Say say = (name) -> System.out.println("Hello " + name);
		say.sayHello("Java");
	}

}
