package com.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.util.User;

public class StreamOperations {

	public static List<User> init() {
		List<User> list = new ArrayList<>();
		list.add(new User("Jame", 5));
		list.add(new User("Aman", 5));
		list.add(new User("Rahul", 40));
		list.add(new User("Dan", 27));
		list.add(new User("Dan", 17));
		list.add(new User("Shekhar", 26));
		list.add(new User("Amitabh", 20));
		list.add(new User("Shahrukh", 18));
		return list;
	}

	// filter()
	public static void filter(List<User> list) {
		list = list.stream().filter(p -> p.getName().startsWith("A")).toList();
		System.out.println(list);
	}

	// map()
	public static void map(List<User> list) {
		List<String> names = list.stream().filter(p -> p.getName().startsWith("A")) //
				.map(p -> p.getName().toUpperCase()) //
				.toList();
		System.out.println(names);
	}

	public static void sort(List<User> list) {
		// list.sort(Comparator.comparing(User::getAge));
		// list.sort((u1, u2) -> u1.getAge() - u2.getAge());
		Collections.sort(list, (u1, u2) -> u1.getAge() - u2.getAge());
		System.out.println(list);
	}

	public static void sortMiltipleValue(List<User> list) {
		Comparator<User> comparing = Comparator.comparing(User::getName) //
				.thenComparing(Comparator.comparing(User::getAge));
		list.sort(comparing);
		// list.stream().sorted(comparing); // <- Return a new list
		System.out.println(list);
	}
	
	public static void reverse(List<User> list) {
		Collections.reverse(list);
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<User> list = init();
		// filter(list);
		// map(list);
		// sort(list);
		// sortMiltipleValue(list);
		reverse(list);

		

//		// Stream.collect()
//		List<String> list = Arrays.asList("System", "out", "println", "Stream", "collect", "AB", "A");
//		List<String> upperList = list.stream().sorted().map(String::toUpperCase).collect(Collectors.toList());
//		System.out.println(upperList);
//
//		// Stream.match()
//		boolean matchedResult = list.stream().anyMatch((s) -> s.startsWith("S"));
//		System.out.println(matchedResult);
//
//		matchedResult = list.stream().allMatch((s) -> s.startsWith("S"));
//		System.out.println(matchedResult);
//
//		matchedResult = list.stream().noneMatch((s) -> s.startsWith("A"));
//		System.out.println(matchedResult);
//
//		// Stream.count()
//		long totalMatched = list.stream().filter((s) -> s.startsWith("S")).count();
//		System.out.println(totalMatched);
//
//		// Stream.reduce()
//		Optional<String> reduced = list.stream().reduce((s1, s2) -> s1 + "_" + s2);
//		reduced.ifPresent(out);
//
//		// Stream.findFirst()
//		Optional<String> firstMatchedName = list.stream().filter((s) -> s.startsWith("A")).findFirst();
//		firstMatchedName.ifPresent(out);
//
//		List<Integer> listInt = new ArrayList<Integer>();
//		for (int i = 1; i < 10; i++) {
//			listInt.add(i);
//		}

		// Here creating a parallel stream
//		Integer[] evenNumbers = listInt.stream().filter(t -> t % 2 == 0).toArray(Integer[]::new);
		// System.out.print(Arrays.stream(evenNumbers).collect(Collectors.toList()));
		// Stream.of(evenNumbers).forEach(out);
	}

}
