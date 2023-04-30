package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Permute {

	private static int factorial(final int num) {
		return IntStream.rangeClosed(2, num) //
				.reduce(1, (x, y) -> x * y);
	}

	public static <T> Stream<Stream<T>> of(final List<T> list) {
		return IntStream.range(0, factorial(list.size())) //
				.mapToObj(i -> permutation(i, list).stream());
	}

	private static <T> List<T> permutation(final int count, final LinkedList<T> input, final List<T> output) {
		if (input.isEmpty()) {
			return output;
		}
		final int factorial = factorial(input.size() - 1);
		output.add(input.remove(count / factorial));
		return permutation(count % factorial, input, output);
	}

	private static <T> List<T> permutation(final int count, final List<T> list) {
		return permutation(count, new LinkedList<>(list), new ArrayList<>());
	}

	public static void main(String[] args) {
		Permute.of(Arrays.asList(1, 2, 3, 4, 5)).forEach(p -> {
			p.forEach(System.out::print);
			System.out.print(" ");
		});
	}

}
