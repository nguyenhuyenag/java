package bigocoder.nmlt.array;

import java.util.Arrays;
import java.util.Scanner;

// Input: n là số tiền cần đổi
public class DoiTien {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int[] arr = { 500, 200, 100, 50, 20, 10 };
			Arrays.sort(arr);
			int soto, sotien = io.nextInt();
			for (int menhgia : arr) {
				soto = sotien / menhgia;
				if (soto > 0) {
					System.out.println(menhgia + " " + soto);
					sotien -= soto * menhgia;
				}
				soto = 0;
			}
		}
	}

}
