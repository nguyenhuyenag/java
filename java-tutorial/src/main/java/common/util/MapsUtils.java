package common.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapsUtils {
	
	private MapsUtils() {
		
	}
	
	/**
	 * Comparator by value
	 * @param <K> is key
	 * @param <V> is value
	 * @return Comparable generic
	 */
	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparing() {
		return Comparator.comparing(e -> e.getValue());
	}
	
	/**
	 * Comparator reverse by value
	 * @param <K> is key
	 * @param <V> is value
	 * @return Comparable generic
	 */
	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparingReverse() {
		return Comparator.comparing(Entry::getValue, Comparator.reverseOrder());
	}
	
	/**
	 * Sort a map by key
	 * @param map the map to be sorted
	 * @return map sorted
	 */
	public static <K, V> Map<K, V> sortByKey(Map<K, V> map) {
		return new TreeMap<>(map);
	}

	/**
	 * Sort a map by key descending
	 * @param map the map to be sorted
	 * @return map sorted
	 */
	public static <K, V> Map<K, V> sortByKeyDesc(Map<K, V> map) {
		TreeMap<K, V> tree = new TreeMap<>(Collections.reverseOrder());
		tree.putAll(map);
		return tree;
	}

	/**
	 * Sort a map by value
	 * @param map the map to be sorted
	 * @param asc ascending is {@code true}, descending is {@code false}
	 * @return map sorted
	 */
	private static <K, V extends Comparable<V>> Map<K, V> sortByValue(Map<K, V> map, boolean asc) {
		Map<K, V> linked = new LinkedHashMap<>();
		map.entrySet().stream() //
				.sorted(asc == true ? valueComparing() : valueComparingReverse()) //
				.forEach(e -> linked.put(e.getKey(), e.getValue()));
		return linked;
	}

	/**
	 * Sort a map by value
	 * @param map the map to be sorted
	 * @return map sorted
	 */
	public static <K, V extends Comparable<V>> Map<K, V> sortByValue(Map<K, V> map) {
		return sortByValue(map, true);
	}

	/**
	 * Sort a map by value descending
	 * @param map the map to be sorted
	 * @return map sorted
	 */
	public static <K, V extends Comparable<V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
		return sortByValue(map, false);
	}

	/**
	 * Find key minimum of map
	 * @param map the map to find
	 * @return entry
	 */
	public static <K, V extends Comparable<V>> Entry<K, V> minByKey(Map<K, V> map) {
		TreeMap<K, V> tree = new TreeMap<>(map);
		return tree.firstEntry();
	}

	/**
	 * Find key maximum of map
	 * @param map the map to find
	 * @return entry
	 */
	public static <K, V extends Comparable<V>> Entry<K, V> maxByKey(Map<K, V> map) {
		TreeMap<K, V> tree = new TreeMap<>(map);
		return tree.lastEntry();
	}

	/**
	 * Find value mnimum of map
	 * @param map the map to find
	 * @return entry
	 */
	public static <K, V extends Comparable<V>> Entry<K, V> minByValue(Map<K, V> map) {
		return Collections.min(map.entrySet(), Map.Entry.comparingByValue());
	}

	/**
	 * Find key maximum of map
	 * @param map the map to find
	 * @return entry
	 */
	public static <K, V extends Comparable<V>> Entry<K, V> maxByValue(Map<K, V> map) {
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue());
	}
	
}
