package lambda;

interface Addable {
	int add(int a, int b);
}

public class MultiParameters {

	public static void main(String[] args) {

		// with return keyword
		Addable addable = (a, b) -> {
			return a + b;
		};
		System.out.println(addable.add(1, 2));

		// without return keyword
		Addable iAdd = (a, b) -> (a + b);
		System.out.println(iAdd.add(1, 2));

	}

}
