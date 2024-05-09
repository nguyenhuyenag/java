package basic.passed;

public class ByValue {

	public static void increment(int value) {
		value = value + 1;
	}

	public static void main(String[] args) {
		int x = 1_000;
		System.out.println("Before: " + x);
		increment(x);
		System.out.println("After: " + x);
	}
}
