package learn.generic.array;

public class ArrayContructor {

	static int recursive(int n) {
		if (n == 0)
			return 1;
		else if (n == 1)
			return 2;
		return 2 * recursive(n - 1) + recursive(n - 2);
	}

	public static int dequy(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 2;
		}
		return 2 * dequy(n - 1) + dequy(n - 2);
	}

	public static int seq(int n) {
		int[] arr = new int[n + 1];
		if (n == 0) {
			return 1;
		}
		arr[0] = 1; arr[1] = 2;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = 2 * arr[i - 1] + arr[i - 2];
		}
		return arr[n];
	}

	public static void main(String[] args) {
		int n = 2;
		System.out.println(recursive(n));
		System.out.println(dequy(n));
		System.out.println(seq(n));
	}

}
