package bigocoder.nmlt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class TinhThuong {
	
//	static float pi = (float) 3.14;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader io = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.valueOf(io.readLine());
		int b = Integer.valueOf(io.readLine());
		// float b = (float) ((float) (pi * a) / 180.0);
		DecimalFormat df = new DecimalFormat("0.0000");
		System.out.print(df.format(a / b));
	}
}
