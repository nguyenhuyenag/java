package bigocoder.nmlt;

import java.util.Scanner;

public class DoiTien {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			int soto;
			int[] arr = { 500, 200, 100, 50, 20, 10 };
			int sotien = io.nextInt();
			for (int menhgia : arr) {
				soto = sotien / menhgia;
				if (soto > 0) {
					System.out.println(menhgia + " " + soto);
				}
				sotien -= menhgia * soto;
				soto = 0;
			}
		}
	}
}
