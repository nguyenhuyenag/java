package learn.collection.stream;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ToCollection {

	public static TreeSet<String> listToTreeSet(List<String> list) {
		
		// Collectors.toCollection(HashSet::new)
		// Collectors.toCollection(TreeSet::new)
		// Collectors.toCollection(ArrayList::new)
		// Collectors.toCollection(LinkedList::new)
		// Collectors.toCollection(ReferenceList::new)
		// Collectors.toCollection(() -> list)

		// Supplier<List<Shape>> supplier = () -> new LinkedList<Shape>();
		// List<Shape> blue = shapes.stream() .collect(Collectors.toCollection(supplier));
		
		return list.stream().collect(Collectors.toCollection(TreeSet::new));
	}

}
