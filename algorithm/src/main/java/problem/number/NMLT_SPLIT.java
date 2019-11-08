package problem.number;

import java.util.ArrayList;
import java.util.Scanner;

public class NMLT_SPLIT {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String input = io.nextLine();
			int number = 0;
			boolean continueNumber = true;
			ArrayList<Integer> numbers = new ArrayList<>();
			for (int i = 0; i < input.length(); i++) {
				if (Character.isDigit(input.charAt(i)))
					if (continueNumber)
						number = number * 10 + (input.charAt(i) - '0');
					else {
						continueNumber = true;
						number = input.charAt(i) - '0';
					}
				else {
					if (i > 0 && Character.isDigit(input.charAt(i - 1)))
						numbers.add(number);
					continueNumber = false;
					number = -1;
				}
			}
			if (number != -1)
				numbers.add(number);
			for (int x : numbers) {
				System.out.println(x);
			}
		}
	}

}
