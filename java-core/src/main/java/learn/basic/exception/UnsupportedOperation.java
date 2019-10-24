package learn.basic.exception;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList returning a fixed-size list.
 * 
 * So can't ADD to it, can't REMOVE from it, can't structurally modify the List.
 */
public class UnsupportedOperation {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
		// list.remove(1);
		list.add(1);
	}
}
