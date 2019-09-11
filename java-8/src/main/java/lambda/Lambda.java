package lambda;

interface Draw {
	void draw();
}

public class Lambda {

	public static void main(String[] args) {

		int width = 10;

		// without lambda
		Draw withoutLambda = new Draw() {
			@Override
			public void draw() {
				System.out.println("Without lambda drawing ~ " + width);
			}
		};
		withoutLambda.draw();

		// lambda
		Draw lambda = () -> {
			System.out.println("Lambda drawing ~ " + width);
		};
		lambda.draw();

	}

}
