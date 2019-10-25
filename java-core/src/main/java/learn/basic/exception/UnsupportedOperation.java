package learn.basic.exception;

import java.util.Arrays;
import java.util.List;

/**
 * Arrays.asList trả về List có kích thước cố định (fixed-size list)
 * 
 * => Không thể ADD, REMOVE, MODIFY List này được
 */
public class UnsupportedOperation {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
		// list.remove(1);
		list.add(1);
	}
}
