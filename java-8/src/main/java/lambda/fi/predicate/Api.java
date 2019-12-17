package lambda.fi.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Api {

	static List<String> list = Arrays.asList("Java", "Quora", "C", "C#", "Jara");

	public static void example() {
		list.stream().filter(s -> s.endsWith("a")).forEach(System.out::println);
	}

	public static void and() {
		Predicate<String> p1 = s -> s.startsWith("J");
		Predicate<String> p2 = s -> s.endsWith("a");
		list.stream().filter(p1.and(p2)).forEach(System.out::println);
	}

	public static void or() {
		Predicate<String> p1 = s -> s.startsWith("J");
		Predicate<String> p2 = s -> s.startsWith("Q");
		list.stream().filter(p1.or(p2)).forEach(System.out::println);
	}

	public static void negate() {
		Predicate<String> p = s -> s.startsWith("J");
		list.stream().filter(p.negate()).forEach(System.out::println);
	}

	public static void main(String[] args) {
		// example();
		// and();
		// or();
		negate();
	}

}
