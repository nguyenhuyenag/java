package problem.number;

import java.util.Scanner;
/**
 * Ước chung lớn nhất của 2 số
 */
public class UCLN {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int a = io.nextInt(), b = io.nextInt();
			while (a != b) {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}
			System.out.println(a); // hay b cũng được
		}
	}

}
