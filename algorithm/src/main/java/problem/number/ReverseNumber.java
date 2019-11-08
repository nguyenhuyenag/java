package problem.number;

import java.util.Scanner;

public class ReverseNumber {
	
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int n = io.nextInt();
			String s = "";
			while (n != 0) {
				s += n % 10;
				n /= 10;
			}
			System.out.println(s);
		}
	}
	
}
