package basic.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ConcurrentModificationException: Xảy ra khi xóa phần tử khỏi List lúc đang duyệt
 */
@SuppressWarnings("unused")
public class ConcurrentModification {

	/**
	 * ConcurrentModificationException
	 */
	static void showException(List<Integer> list) {
		for (int x : list) {
			if (x == 1) {
				list.remove(x); // => Exception
			}
		}
	}

	/**
	 * ConcurrentModificationException
	 */
	static void getException(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int el = iterator.next();
			if (el == 1) {
				list.remove(el); // => Exception
			}
		}
	}

	// => OK
	private static void useGetIndex(List<Integer> list) {
		// Lưu ý IndexOutOfBoundsException
		for (int i = 0; i < list.size(); i++) {
			int el = list.get(i);
			if (el == 1) {
				list.remove(el);
			}
		}
	}

	// => OK
	private static void useIterator(List<Integer> list) {
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int el = iterator.next();
			if (el == 1) {
				iterator.remove();
			}
		}
	}

	// => OK
	private static void useRemoveAll(List<Integer> list) {
		List<Integer> willRemove = new ArrayList<>();
		for (int x : list) {
			if (x == 1 || x == 2) {
				willRemove.add(x);
			}
		}
		list.removeAll(willRemove); // => remove here
	}

	// => OK (Java 8+)
	private static void useRemoveIf(List<Integer> list) {
		list.removeIf(t -> (t.equals(1) || t.equals(2))); // remove 1 & 2
	}

	// => OK
	// Cách này tạo ra 1 list mới, không thay đổi list ban đầu
	private static List<Integer> useStreamFilter(List<Integer> list) {
		return list.stream() //
				.filter(t -> !(t.equals(1) || t.equals(2))) // filter
				.collect(Collectors.toList());
	}

	private static void exceptionWhenRemove() {
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5));

		// showException(list); // => Exception
		// getException(list); // => Exception

		// useGetIndex(list); // => OK
		// useIterator(list); // => OK
		// useRemoveAll(list); // => OK
		useRemoveIf(list); // => OK
	}

	static void exceptionWhenModifySubList() {
		List<String> list = new ArrayList<>();
		list.addAll(Arrays.asList("Java", "PHP", "SQL", "Angular"));
		List<String> subs = list.subList(0, 2);
		list.add("NodeJS"); // Modify the list size and get exception
		System.out.println(subs); // this line throws exception
	}

	static void exceptionWhenSubList() {
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(0, 1, 2, 3, 4, 5));
		List<Integer> subs = list.subList(0, 2); // => From here

		// List<Integer> toReverse = new ArrayList<>(list.subList(start, end + 1));
		// = list.stream().skip(0).limit(2).collect(Collectors.toList());

		list.removeAll(subs);
		list.addAll(subs); // => will show Exception
	}

	public static void main(String[] args) {
		// exceptionWhenRemove();
		exceptionWhenSubList();
		// exceptionWhenModifySubList();
	}
}
