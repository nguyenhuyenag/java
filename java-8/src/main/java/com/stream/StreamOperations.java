package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.util.User;

public class StreamOperations {

	public static void main(String[] args) {

		Consumer<Object> out = System.out::println;

		List<User> personList = new ArrayList<User>();
		personList.add(new User("Rahul", 40));
		personList.add(new User("Shekhar", 10));
		personList.add(new User("Aman", 5));
		personList.add(new User("Amitabh", 20));
		personList.add(new User("Shahrukh", 8));
		personList.add(new User("Van", 50));
		personList.add(new User("Nguyen", 77));

		// Stream.filter()
		personList.stream() //
				.filter(p -> p.getName().startsWith("A")) //
				.forEach(p -> System.out.println(p.getName()));

		// Stream.map()
		personList.stream() //
				.filter(p -> p.getName().startsWith("A")) //
				.map(p -> p.getName().toUpperCase()).forEach(System.out::println);

		Consumer<User> action = p -> System.out.println(p.getName() + ", " + p.getAge());

		// List.sort()
		personList.sort(Comparator.comparing(User::getAge));
		personList.stream().forEach(action);

		// Stream.sorted()
		personList.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge).reversed())
				.forEach(action);

		Collections.reverse(personList);

		// Stream.collect()
		List<String> list = Arrays.asList("System", "out", "println", "Stream", "collect", "AB", "A");
		List<String> upperList = list.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(upperList);

		// Stream.match()
		boolean matchedResult = list.stream().anyMatch((s) -> s.startsWith("S"));
		System.out.println(matchedResult);

		matchedResult = list.stream().allMatch((s) -> s.startsWith("S"));
		System.out.println(matchedResult);

		matchedResult = list.stream().noneMatch((s) -> s.startsWith("A"));
		System.out.println(matchedResult);

		// Stream.count()
		long totalMatched = list.stream().filter((s) -> s.startsWith("S")).count();
		System.out.println(totalMatched);

		// Stream.reduce()
		Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "_" + s2);
		reduced.ifPresent(out);

		// Stream.findFirst()
		Optional<String> firstMatchedName = list.stream().filter((s) -> s.startsWith("A")).findFirst();
		firstMatchedName.ifPresent(out);

		List<Integer> listInt = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++) {
			listInt.add(i);
		}

		// Here creating a parallel stream
		Integer[] evenNumbers = listInt.stream().filter(t -> t % 2 == 0).toArray(Integer[]::new);
		System.out.print(Arrays.stream(evenNumbers).collect(Collectors.toList()));
		Stream.of(evenNumbers).forEach(out);

	}

}
