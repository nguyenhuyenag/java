package collection.iterable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IteratorToList {

	public static void main(String[] args) {
		Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
		List<Integer> list = new ArrayList<>();
		iterator.forEachRemaining(list::add);
		list.forEach(t -> System.out.println(t));

		List<Integer> list2 = StreamSupport //
				.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED), false) //
				.collect(Collectors.toList());
		list2.forEach(t -> System.out.println(t));
	}

}
