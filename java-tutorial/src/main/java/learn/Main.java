package learn;

public class Main {

	public static String toBinary(int n) {
		String str = "";
		while (n != 0) {
			str = n % 2 + str;
			n = n / 2;
		}
		return str;
	}

	public static void main(String[] args) {

	}

}
