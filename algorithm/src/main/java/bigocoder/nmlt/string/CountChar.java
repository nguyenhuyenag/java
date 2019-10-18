package bigocoder.nmlt.string;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountChar {
	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in)) {
			String str = io.nextLine();
			char[] arr = str.toCharArray();
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
			for (char key : arr) {
				if (!map.containsKey(key)) {
					map.put(key, 1);
				} else {
					map.put(key, map.get(key) + 1);
				}
			}
			map.forEach((k, v) -> System.out.println(k + ": " + v));
		}
	}
}
