package learn.collection.set;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreesSet {

	public static void main(String[] args) {
		// Set<Integer> set = new TreeSet<>();
		Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());
		set.add(12);
		set.add(0);
		set.add(-15);
		System.out.println(set);
	}
}
