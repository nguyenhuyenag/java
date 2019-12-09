package lambda.overview;

public class UseImplement implements Hello {

	@Override
	public void say() {
		System.out.println("Hello");
	}

	public static void main(String[] args) {
		Hello h = new UseImplement();
		h.say();
	}

}
