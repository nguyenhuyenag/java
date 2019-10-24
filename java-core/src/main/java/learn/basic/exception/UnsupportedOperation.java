package learn.basic.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnsupportedOperation {

	public static void main(String[] args) {
		int start = 2, end = 4;
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));

		// List<Integer> toReverse = list.subList(start, end + 1); // => Exception

		List<Integer> toReverse = new ArrayList<>(list.subList(start, end + 1));

		// OR := list.stream().skip(start).limit(end + 1).collect(Collectors.toList());

		Collections.reverse(toReverse);
		list.removeAll(toReverse);
		list.addAll(start, toReverse);
		System.out.println(list);
	}
}
