package collection.map;

import java.util.Collection;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

/**
 * - How to store duplicate keys in a Map in Java?
 */
public class MultiMap {

	public static void main(String[] args) {
		// MultiValueMap<String, String> map = new MultiValueMap<>();
		// Multimap<String, String> map2 = ArrayListMultimap.create();
		MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
		map.put("key", "A");
		map.put("key", "B");
		map.put("key", "C");
		Collection<String> collection = map.get("key");
		System.out.println(collection);
	}

}
