package lambda.fi.predicate;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateUtils {

	public static <T> Predicate<T> distinctByKey(Function<? super T, ?> key) {
		Set<Object> seen = ConcurrentHashMap.newKeySet();
		return t -> seen.add(key.apply(t));
	}

}
