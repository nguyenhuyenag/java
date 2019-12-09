package lambda.overview;

public class UseAnonymousClass {

	public static void main(String[] args) {
		Hello h = new Hello() {
			@Override
			public void say() {
				System.out.println("Hello");
			}
		};
		h.say();
	}

}
