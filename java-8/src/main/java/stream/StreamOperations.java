package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {

	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}

public class StreamOperations {

	public static void main(String[] args) {

		Consumer<Object> out = System.out::println;

		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Rahul", 40));
		personList.add(new Person("Shekhar", 10));
		personList.add(new Person("Aman", 5));
		personList.add(new Person("Amitabh", 20));
		personList.add(new Person("Shahrukh", 8));
		personList.add(new Person("Van", 50));
		personList.add(new Person("Nguyen", 77));

		// Stream.filter()
		personList.stream() //
				.filter(p -> p.getName().startsWith("A")) //
				.forEach(p -> System.out.println(p.getName()));

		// Stream.map()
		personList.stream() //
				.filter(p -> p.getName().startsWith("A")) //
				.map(p -> p.getName().toUpperCase()).forEach(System.out::println);

		Consumer<Person> action = p -> System.out.println(p.getName() + ", " + p.getAge());

		// List.sort()
		personList.sort(Comparator.comparing(Person::getAge));
		personList.stream().forEach(action);

		// Stream.sorted()
		personList.stream().sorted(Comparator.comparing(Person::getName).thenComparing(Person::getAge).reversed())
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
