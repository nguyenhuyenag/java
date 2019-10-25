package learn.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

@SuppressWarnings({ "unused", "null" })
public class CollectionTo {

	public static TreeSet<String> listToTreeSet(List<String> list) {
		// Collectors.toCollection(HashSet::new)
		// Collectors.toCollection(TreeSet::new)
		// Collectors.toCollection(ArrayList::new)
		// Collectors.toCollection(LinkedList::new)
		// Collectors.toCollection(ReferenceList::new)
		// Collectors.toCollection(() -> list)
		// Supplier<List<Shape>> supplier = () -> new LinkedList<Shape>();
		// List<Shape> blue = shapes.stream()
		// .collect(Collectors.toCollection(supplier));
		return list.stream().collect(Collectors.toCollection(TreeSet::new));
	}

	public static void toList() {
		Collection<Integer> collection = null;

		// use constructor
		ArrayList<Integer> list1 = new ArrayList<>(collection);

		// Streams API
		ArrayList<Integer> list2 = collection.stream().collect(Collectors.toCollection(ArrayList::new));

		// Streams API
		List<Integer> list3 = collection.stream().collect(Collectors.toList());
	}

}
