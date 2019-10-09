package learn.basic.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ConcurrentModification {

	/*-
	 * - ConcurrentModificationException
	 * - Khi xóa phần tử khỏi ArrayList bằng vòng lặp for
	 * - Note: Không nên remove trong khi duyệt các phần tử
	 */

	// Get ConcurrentModificationException
	static void removeByForGetException(List<Integer> list) {
		for (Integer x : list) {
			if (x.equals(1)) {
				list.remove(x); // => Exception
			}
		}
	}

	static void removeByIteratorGetException(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer language = iterator.next();
			if (language.equals(1)) {
				list.remove(language); // => Exception
			}
		}
	}

	// Fix ConcurrentModificationException
	static void removeByIndex(List<Integer> list) {
		// Lưu ý lỗi IndexOutOfBoundsException
		for (int i = 0; i < list.size(); i++) {
			Integer x = list.get(i);
			if (x.equals(1)) {
				list.remove(x);
			}
		}
	}

	static void removeByIterator(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			Integer x = iterator.next();
			if (x.equals(1)) {
				iterator.remove();
			}
		}
	}

	static void removeAfterLoop(List<Integer> list) {
		List<Integer> toRemove = new ArrayList<>();
		for (Integer x : list) {
			if (x.equals(1) || x.equals(2)) {
				toRemove.add(x);
			}
		}
		list.removeAll(toRemove); // remove here
	}

	static void removeByRemoveIf(List<Integer> list) {
		list.removeIf(t -> (t.equals(1) || t.equals(2))); // remove if t = 1 or t = 2
		list.forEach(System.out::println);
	}

	static List<Integer> removeByFilter(List<Integer> list) {
		// Cách này tạo ra 1 list mới sau khi filter, không làm thay đổi list ban đầu
		return list.stream() //
				.filter(t -> !(t.equals(1) || t.equals(2))) // filter
				.collect(Collectors.toList());
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

		// removeByForGetException(list); 		// => Exception
		// removeByIteratorGetException(list); 	// => Exception

		// removeByIndex(list);		// => OK
		removeByIterator(list); 	// OK
		// removeAfterLoop(list); 	// OK
		// removeByRemoveIf(list); 	// OK
		// removeByFilter(list); 	// OK
	}
}
