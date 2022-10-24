package com;

import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Stream.iterate(0, i -> i < 10, i -> i + 1).forEach(System.out::println);
	}

}
