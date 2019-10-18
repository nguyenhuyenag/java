package bigocoder.nmlt.number;

import java.util.Scanner;

public class UCLN {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int a = io.nextInt();
			int b = io.nextInt();
			while (a != b) {
				if (a > b) {
					a = a - b;
				} else {
					b = b - a;
				}
			}
			System.out.println(a);
		}
	}
}
