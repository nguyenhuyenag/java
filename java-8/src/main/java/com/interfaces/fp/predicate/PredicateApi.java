package com.interfaces.fp.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

// And, Or, Negate (phủ định)
public class PredicateApi {

	private static List<String> list = Arrays.asList("Java", "Quora", "C", "C#", "PHP");

	public static List<String> and() {
		Predicate<String> p1 = s -> s.endsWith("a");
		Predicate<String> p2 = s -> s.startsWith("J");
		return list.stream().filter(p2.and(p1)).toList();
	}

	public static List<String> or() {
		Predicate<String> p1 = s -> s.startsWith("J");
		Predicate<String> p2 = s -> s.startsWith("Q");
		return list.stream().filter(p1.or(p2)).toList();
	}

	public static List<String> negate() {
		Predicate<String> p = s -> s.contains("a");
		return list.stream().filter(p.negate()).toList();
	}

	public static List<String> not() {
		Predicate<String> p = s -> s.contains("a");
		return list.stream().filter(p.negate()).toList();
	}

	public static void main(String[] args) {
		// List<String> list = sample();
		// List<String> list = and();
		// List<String> list = or();
		List<String> list = negate();
		System.out.println(list);
	}

}
