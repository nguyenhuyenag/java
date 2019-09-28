package learn.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CCollection {

	// check common elements
	public static <T> void hasCommonElements(List<T> src, List<T> des) {
		System.out.println(Collections.disjoint(src, des));
	}

	public static void unmodifiable() {
		List<String> list = Collections.nCopies(5, "Java");
		Collection<String> collection = Collections.unmodifiableCollection(list);
		// try to modify the list
		collection.add("A");
	}

	public static void main(String[] args) {

		// Kiem tra 2 collection co phan tu giong nhau khong
		List<Integer> src = Arrays.asList(1, 3, 5);
		List<Integer> des = Arrays.asList(1, 2, 4, 6);
		hasCommonElements(src, des);

		// Tao List bang cach nhan 5 lan gia tri Java
		List<String> list = Collections.nCopies(5, "Java");
		Iterator<String> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// Tao collection khong the thay doi
		// unmodifiable();
	}

}
