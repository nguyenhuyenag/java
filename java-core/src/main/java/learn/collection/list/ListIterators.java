package learn.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIterators {

	public static void main(String[] args) throws Exception {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
		ListIterator<Integer> iterator = list.listIterator();
		// Duyệt xuôi
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
		// Duyệt ngượcc
		while (iterator.hasPrevious()) {
			System.out.print(iterator.previous() + " ");
		}
	}

}
