package lambda.overview;

public class UseLambda {

	public static void main(String[] args) {
		Hello h = () -> System.out.println("Hello");
		h.say();
	}

}
