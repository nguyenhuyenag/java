package learn.basic.other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadConsole {

	public static void main(String[] args) {
		try {
			BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter: ");
			String input = buff.readLine();
			System.out.println(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
