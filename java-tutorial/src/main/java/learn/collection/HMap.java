package learn.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HMap {

	public static void loopByForEach(HashMap<String, Integer> hmap) {
		hmap.forEach((k, v) -> System.out.println(k + "\t=> " + v));
	}

	public static void loopByKeySet(HashMap<String, Integer> hmap) {
		Set<String> keys = hmap.keySet();
		for (String key : keys) {
			System.out.println(key + "\t=> " + hmap.get(key));
		}
	}

	public static void loopByEntry(HashMap<String, Integer> hmap) {
		Set<Entry<String, Integer>> set = hmap.entrySet();
		for (Entry<String, Integer> e : set) {
			System.out.println(e.getKey() + "\t=> " + e.getValue());
		}
	}

	public static void main(String[] args) {

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		hmap.put("mot", 1);
		hmap.put("hai", 2);
		hmap.put("ba", 3);
		hmap.put("bon", 4);

		Set<String> keys = hmap.keySet();
		for (String k : keys) {
			System.out.println(hmap.get(k));
		}
		
		Collection<Integer> values = hmap.values();
		
		for (Integer v : values) {
			System.out.println(v);
		}

	}
}
