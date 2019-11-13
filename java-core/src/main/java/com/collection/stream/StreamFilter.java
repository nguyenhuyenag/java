package com.collection.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.math3.primes.Primes;

public class StreamFilter {

	@SafeVarargs
	public static <T> List<T> matchAll(List<T> list, Predicate<T>... listPreds) {
		Stream<T> stream = list.stream();
		for (Predicate<T> pre : listPreds) {
			stream = stream.filter(pre);
		}
		return stream.collect(Collectors.toList());
	}

	static boolean isPrime(int n) {
		return Primes.isPrime(n);
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5, 7, 9, 11, 13, 14, 21, 28, 35, 42, 49, 56, 63, 70, 71);
		Predicate<Integer> p0 = n -> n > 10;
		Predicate<Integer> p1 = n -> n % 2 != 0;
		Predicate<Integer> p2 = n -> isPrime(n);
		System.out.println(matchAll(list, p0, p1, p2));
	}

}
