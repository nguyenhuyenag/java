package learn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static String toBinary(int n) {
		String str = "";
		while (n != 0) {
			str = n % 2 + str;
			n = n / 2;
		}
		return str;
	}

	public static void main(String[] args) {
		int startIndex = 2;
		int endIndex = 4;
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		List<Integer> toReverse = list.subList(startIndex, endIndex + 1);
		Collections.reverse(toReverse);
		list.removeAll(toReverse);
		list.addAll(startIndex, toReverse);
	}

}
