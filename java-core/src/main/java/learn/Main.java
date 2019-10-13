package learn;

public class Main {

	public static void check(int n) {
		while (n != 0) {
			System.out.println(n % 10);
			n /= 10;
		}
	}

	public static void main(String[] args) {
		int n = 123456;
		check(n);
	}

}
