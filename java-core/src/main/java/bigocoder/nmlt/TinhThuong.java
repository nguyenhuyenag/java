package bigocoder.nmlt;

import java.util.Scanner;
import java.text.DecimalFormat;

public class TinhThuong {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			int a = io.nextInt();
			int b = io.nextInt();
			float div = (float) a / b;
			div = (float) (Math.round(div * 100)) / 100;
			DecimalFormat df = new DecimalFormat("0.00");
			System.out.print(a + " / " + b + " = " + df.format(div));
		}
	}
}
