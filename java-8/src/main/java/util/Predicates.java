package util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Predicates {

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(key.apply(t));
	}

}
