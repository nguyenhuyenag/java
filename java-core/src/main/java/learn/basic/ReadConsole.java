package learn.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.print("Nhập vào một số: ");
			String input = buff.readLine();
			if (isNumeric(input)) {
				System.out.println("OK :D");
				return;
			}
			System.out.println("Sai rồi!");
		}
	}

}
