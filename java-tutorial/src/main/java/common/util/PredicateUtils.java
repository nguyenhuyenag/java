package common.util;

import java.util.function.Predicate;

public class PredicateUtils {

	public static <T> Predicate<T> not(Predicate<T> t) {
		return t.negate();
	}

}
