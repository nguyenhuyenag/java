package codewars.number;

// Bình phương từng chữ số
public class SquareDigit {

	public static int squareDigits(int n) {
		String s = "";
		while (n != 0) {
			int digit = n % 10;
			s = digit * digit + s;
			n /= 10;
		}
		return Integer.parseInt(s);
	}

	public static void main(String[] args) {
		System.out.println(squareDigits(9119));
	}

}
