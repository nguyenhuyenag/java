package algorithm;

public class HoanViBaSo {

	public static void main(String[] args) {

		int a = 1, b = 2, c = 3;

		// Cach 1
		c = c + a + b;
		a = c - b - a;
		b = c - b - a;
		c = c - b - a;

		// Cach 2
		a = a ^ b ^ c;
		b = a ^ b ^ c;
		c = a ^ b ^ c;
		a = a ^ b ^ c;

		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
	}
}
