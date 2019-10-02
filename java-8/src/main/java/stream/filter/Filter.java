package stream.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

/**
 * @see lambda.predicate.Predicates
 * @see lambda.predicate.BiPredicates
 */
public class Filter {

	public static void main(String[] args) {

		Stream.iterate(1, t -> ++t) //
				.limit(6) //
				.filter(x -> x % 3 == 0) // chia het cho 3
				.forEach(System.out::println);

		List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		List<String> filter = list.stream().filter(StringUtils::isNotEmpty).collect(Collectors.toList());
		System.out.println(filter);
		filter.forEach(System.out::println);
	}

}
