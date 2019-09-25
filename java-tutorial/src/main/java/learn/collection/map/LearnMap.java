package learn.collection.map;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class LearnMap {

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
		return Comparator.comparing(e -> e.getValue());
	}

	public static <K, V extends Comparable<V>> Comparator<Entry<K, V>> valueComparingReverse() {
		return Comparator.comparing(Entry::getValue, Comparator.reverseOrder());
	}

	public static <K extends Comparable<K>, V> Comparator<Entry<K, V>> maxKey() {
		return (e1, e2) -> e1.getKey().compareTo(e2.getKey());
	}

	public static <K extends Comparable<K>, V> Comparator<Entry<K, V>> minKey() {
		return (e1, e2) -> e2.getKey().compareTo(e1.getKey());
	}

	// ----------------------------------------------------------------------- //

	static <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingCollectionsMaxAndLambda(Map<K, V> map) {
		Entry<K, V> entry = Collections.max(map.entrySet(), (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		return entry;
	}

	static <K, V extends Comparable<V>> Entry<K, V> findminByValueUsingCollectionsMinAndLambda(Map<K, V> map) {
		Entry<K, V> entry = Collections.min(map.entrySet(), (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
		return entry;
	}

	static <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingCollectionsMax(Map<K, V> map) {
		Entry<K, V> entry = Collections.max(map.entrySet(), new Comparator<Entry<K, V>>() {
			public int compare(Entry<K, V> e1, Entry<K, V> e2) {
				return e1.getValue().compareTo(e2.getValue());
			}
		});
		return entry;
	}

	static <K, V extends Comparable<V>> Entry<K, V> findMaxByValueUsingStreamAndMethodReference(Map<K, V> map) {
		Optional<Entry<K, V>> maxEntry = map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
		return maxEntry.get();
	}

}
