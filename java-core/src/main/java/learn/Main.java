package learn;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String s = io.nextLine();
			String s2 = io.nextLine();
			System.out.println(s.replaceAll(s2, ""));
		}
	}
}
