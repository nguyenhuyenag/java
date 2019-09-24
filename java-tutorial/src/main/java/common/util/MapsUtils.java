package common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.TreeMap;

public class MapsUtils {

	public static Map<String, Integer> randomMap() {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 9; i++) {
			map.put(RandomUtils.getRandomString().toUpperCase(), RandomUtils.randomInt());
		}
		return map;
	}

	public static <K, V> Map<K, V> sortByKey(Map<K, V> map) {
		// TreeMap<K, V> sorted = new TreeMap<>();
		// sorted.putAll(map);
		// return sorted;
		return new TreeMap<>(map);
	}

	public static <K, V> Map<K, V> sortByKeyDesc(Map<K, V> map) {
		Map<K, V> treemap = new TreeMap<>(Collections.reverseOrder());
		treemap.putAll(map);
		return treemap;
	}

	// private static class ByValue<K, V extends Comparable<V>> implements
	// Comparator<Entry<K, V>> {
	// public int compare(Entry<K, V> o1, Entry<K, V> o2) {
	// System.out.println(o1.getValue().compareTo(o2.getValue()));
	// return o1.getValue().compareTo(o2.getValue());
	// }
	// }

	public static <K, V extends Comparable<V>> List<Entry<K, V>> sortByValue(Map<K, V> map) {
		List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>(map.entrySet());
		// Collections.sort(entries, new ByValue<K, V>());
		entries.sort(Comparator.comparing(Entry::getValue));
		return entries;
	}

	public static <K, V extends Comparable<V>> List<Entry<K, V>> sortByValueDesc(Map<K, V> map) {
		List<Entry<K, V>> entries = new ArrayList<Entry<K, V>>(map.entrySet());
		entries.sort(Comparator.comparing(Entry::getValue, Collections.reverseOrder()));
		return entries;
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMaxByValue(Map<K, V> map) {
		Optional<Entry<K, V>> entry = map.entrySet().stream()
				.max((Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
		return entry.get();
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMinByValue(Map<K, V> map) {
		Optional<Entry<K, V>> entry = map.entrySet().stream()
				.min((Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
		return entry.get();
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingCollectionsMaxAndLambda(Map<K, V> map) {
		Entry<K, V> entry = Collections.max(map.entrySet(), //
				(Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
		return entry;
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findminByValueUsingCollectionsMinAndLambda(Map<K, V> map) {
		Entry<K, V> entry = Collections.min(map.entrySet(), //
				(Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
		return entry;
	}

	public <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingCollectionsMax(Map<K, V> map) {
		Entry<K, V> entry = Collections.max(map.entrySet(), new Comparator<Entry<K, V>>() {
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		return entry;
	}

	public <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingStreamAndLambda(Map<K, V> map) {
		Optional<Entry<K, V>> maxEntry = map.entrySet().stream() //
				.max((Entry<K, V> e1, Entry<K, V> e2) -> e1.getValue().compareTo(e2.getValue()));
		return maxEntry.get();
	}

	public <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingStreamAndMethodReference(Map<K, V> map) {
		Optional<Entry<K, V>> maxEntry = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
		return maxEntry.get();
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMinByKey(Map<K, V> map) {
		TreeMap<K, V> tree = new TreeMap<>(map);
		return tree.firstEntry();
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMaxByKey(Map<K, V> map) {
		TreeMap<K, V> tree = new TreeMap<>(map);
		return tree.lastEntry();
	}

}
