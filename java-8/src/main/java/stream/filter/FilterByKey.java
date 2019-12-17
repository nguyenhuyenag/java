package stream.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import lambda.fi.predicate.PredicateUtils;
import util.User;

public class FilterByKey {

	static Consumer<User> out = u -> System.out.println(u.getName() + " => " + u.getAge());

	public static void filterByName(List<User> list) {
		list.stream().filter(PredicateUtils.distinctByKey(User::getName)) //
				.collect(Collectors.toList()) // to list
				.forEach(out);
	}

	public static void filterByAge(List<User> list) {
		list.stream().filter(PredicateUtils.distinctByKey(User::getAge)) //
				.forEach(out);
	}

	public static void useSet(List<User> list) {
		Set<String> set = new HashSet<>();
		list.stream().filter(p -> set.add(p.getName())) // filter name
				.forEach(out);
	}

	public static void main(String[] args) {

		List<User> list = Arrays.asList( //
			new User("A", 12), //
			new User("B", 13), //
			new User("C", 14), //
			new User("D", 12), //
			new User("A", 12) //
		);

		// filterByName(list);
		// filterByAge(list);
		useSet(list);
	}

}
