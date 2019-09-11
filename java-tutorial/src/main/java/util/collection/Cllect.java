package util.collection;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class Cllect {

	public static void main(String[] args) {

		// create map
		Map<String, Boolean> map = new WeakHashMap<String, Boolean>();
		// create a set from map
		Set<String> set = Collections.newSetFromMap(map);
		// add values in set
		set.add("Java");
		set.add("C");
		set.add("C++");
		// set and map values are
		System.out.println("Set is: " + set);
		System.out.println("Map is: " + map);

		// create a list with n copies
		List<String> list = Collections.nCopies(5, "tuitorial Point");
		// create an iterator
		Iterator<String> itr = list.iterator();
		System.out.println("Values are :");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		// make the list unmodifiable
		Collection<String> immutable = Collections.unmodifiableCollection(list);
		// try to modify the list
		immutable.add("A");

	}

}
