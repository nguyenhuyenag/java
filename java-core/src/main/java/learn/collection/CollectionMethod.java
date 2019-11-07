package learn.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CollectionMethod {

	private static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

	// Kiểm tra 2 collection có phần tử chung hay không?
	public static void hasCommonElements() {
		List<Integer> des = Arrays.asList(1, 2, 4, 6);
		boolean check = Collections.disjoint(list, des);
		System.out.println(check);
	}

	// Tạo List bằng cách copy N lần giá trị cho trước
	public static void initList() {
		List<String> copies = Collections.nCopies(5, "Java");
		Iterator<String> itr = copies.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	// Tạo collection read-only
	public static void unmodifiableCollection() {
		List<String> src = Collections.nCopies(5, "Java");
		// Tương tự cho: Set, List, Map
		Collection<String> collection = Collections.unmodifiableCollection(src);
		collection.add("A"); // => UnsupportedOperationException
	}

	public static void method() {
		Collections.rotate(list, 1); // xoay ngược cuối lên đầu
		Collections.rotate(list, -1); // xoay thuận đầu về cuối
		// Collections.copy(null, null);
		// Collections.fill(list, obj);
		// Collections.frequency(c, o);
		// Collections.indexOfSubList(source, target);
		// Collections.lastIndexOfSubList(source, target);
		// Collections.shuffle(list);
		// Collections.swap(list, i, j);
	}

	public static void main(String[] args) {
		method();
		// initList();
		// hasCommonElements();
		// unmodifiableCollection();
	}

}
