package collection.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import common.util.MapsUtils;

public class MapComparable {

	public static <K extends Comparable<K>, V> Comparator<Entry<K, V>> keyComparatorPreJava8() {
		return new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e1.getKey().compareTo(e2.getKey());
			}
		};
	}

	public static <K extends Comparable<K>, V> Comparator<Entry<K, V>> keyComparatorReversePreJava8() {
		return new Comparator<Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e2.getKey().compareTo(e1.getKey());
			}
		};
	}

	public static <K extends Comparable<K>, V> Comparator<Entry<K, V>> keyComparatorWithLambda() {
		return (e1, e2) -> e1.getKey().compareTo(e2.getKey());
	}

	public static <K extends Comparable<K>, V> Comparator<Entry<K, V>> keyComparatorReverseWithLambda() {
		return (e1, e2) -> e2.getKey().compareTo(e1.getKey());
	}

	public static <K extends Comparable<? super K>, V> Comparator<Entry<K, V>> keyComparatorWithMapEntry() {
		return Map.Entry.<K, V>comparingByKey();
	}

	public static <K extends Comparable<? super K>, V> Comparator<Entry<K, V>> keyComparatorReverseWithMapEntry() {
		return Map.Entry.<K, V>comparingByKey(Comparator.reverseOrder());
	}

	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparator() {
		return (e1, e2) -> e1.getValue().compareTo(e2.getValue());
	}

	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparatorReverse() {
		return (e1, e2) -> e2.getValue().compareTo(e1.getValue());
	}

	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparing() {
		return MapsUtils.valueComparing();
	}

	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparingReverse() {
		return MapsUtils.valueComparingReverse();
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMaxValue(Map<K, V> map) {
		return Collections.max(map.entrySet(), valueComparator());
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMinValue(Map<K, V> map) {
		return Collections.min(map.entrySet(), valueComparator());
	}

	static <K extends Comparable<K>, V> Entry<K, V> findMinValuePreJava8(Map<K, V> map) {
		return Collections.max(map.entrySet(), keyComparatorPreJava8());
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMaxValueByStream(Map<K, V> map) {
		Optional<Entry<K, V>> maxEntry = map.entrySet().stream().max(valueComparing());
		return maxEntry.get();
	}

	public static <K, V extends Comparable<V>> Entry<K, V> findMinValueByStream(Map<K, V> map) {
		Optional<Entry<K, V>> maxEntry = map.entrySet().stream().min(valueComparingReverse());
		return maxEntry.get();
	}

}
