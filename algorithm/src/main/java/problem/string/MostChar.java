package problem.string;

import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

// Ký tự xuất hiện nhiều nhất
public class MostChar {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String s = io.nextLine();
			Map<Character, Integer> map = CountChar.countCharacter(s);
			System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
		}
	}

}
