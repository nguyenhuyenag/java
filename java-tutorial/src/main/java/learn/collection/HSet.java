package learn.collection;

import java.util.HashSet;
import java.util.Iterator;

public class HSet {

	public static void main(String[] args) {
		// create hash set
		HashSet<String> hset = new HashSet<String>();
		// populate hash set
		hset.add("Learning");
		hset.add("Easy");
		hset.add("Simply");
		System.out.println(hset.contains("Simply"));

		// create an iterator
		Iterator<String> iterator = hset.iterator();
		// check values
		while (iterator.hasNext()) {
			System.out.println("Value: " + iterator.next() + " ");
		}
	}

}
