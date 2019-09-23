package common.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class Predicates {
	
	private Predicates() {
		
	}

	public static <T> Predicate<T> not(Predicate<T> t) {
		return t.negate();
	}

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(key.apply(t));
	}

}
