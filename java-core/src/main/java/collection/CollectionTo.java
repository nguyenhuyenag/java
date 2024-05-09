package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings({ "unused" })
public class CollectionTo {

	static Collection<Integer> collection = null;
	
	public static void CollectionToCharArray() {
		Set<Character> set = new HashSet<>(Arrays.asList('a', 'b', 'c'));
		StringBuilder sb = new StringBuilder();
		set.forEach(sb::append);
		char[] arr = sb.toString().toCharArray();
		for (char c : arr) {
			System.out.println(c);
		}
	}

	public static void toList() {
		// use constructor
		ArrayList<Integer> list1 = new ArrayList<>(collection);
		
		// Streams API
		ArrayList<Integer> arrayList = collection.stream().collect(Collectors.toCollection(ArrayList::new));
		
		// Streams API
		List<Integer> list = collection.stream().collect(Collectors.toList());
		
		// Streams API
		Supplier<LinkedList<Integer>> supplier = () -> new LinkedList<>();
		LinkedList<Integer> linkedList = collection.stream().collect(Collectors.toCollection(supplier));
		
		// Streams API
		LinkedList<Integer> linkedList2 = collection.stream().collect(Collectors.toCollection(LinkedList::new));
	}

}