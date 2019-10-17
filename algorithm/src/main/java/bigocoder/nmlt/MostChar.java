package bigocoder.nmlt;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostChar {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String str = io.nextLine();
			char[] arr = str.toCharArray();
			Map<Character, Integer> map = new HashMap<>();
			for (char key : arr) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					map.put(key, map.get(key) + 1);
				}
			}
			System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey());
		}
	}
}
