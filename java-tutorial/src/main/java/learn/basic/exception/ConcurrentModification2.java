package learn.basic.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ConcurrentModification2 {

	public static void main(String[] args) {
		int startIndex = 2;
		int endIndex = 4;
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
		// List<Integer> toReverse = list.subList(startIndex, endIndex + 1); // error
		List<Integer> toReverse = new ArrayList<>(list.subList(startIndex, endIndex + 1));
		// List<Integer> toReverse = list.stream().skip(startIndex).limit(endIndex + 1).collect(Collectors.toList());
		Collections.reverse(toReverse);
		list.removeAll(toReverse);
		list.addAll(startIndex, toReverse);
		System.out.println(list);
	}
}
