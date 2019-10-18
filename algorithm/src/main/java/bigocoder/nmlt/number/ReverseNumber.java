package bigocoder.nmlt.number;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			String str = "";
			while (n != 0) {
				str += n % 10;
				n /= 10;
			}
			System.out.println(str);
		}
	}
}
