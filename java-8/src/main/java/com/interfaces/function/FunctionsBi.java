package com.interfaces.function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 *		R apply(T t, U u); 
 */
public class FunctionsBi {

	public static void main(String[] args) {

		BiFunction<String, String, Integer> biFunc = (s1, s2) -> s1.length() + s2.length();
		System.out.println("Length: " + biFunc.apply("public", "static"));

		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println(add.apply(1, 2));

		Function<Integer, Integer> squared = n -> n * n;
		BiFunction<Integer, Integer, Integer> andThen = add.andThen(squared);
		System.out.println("AndThen: " + andThen.apply(5, 2));

		Map<String, String> map = new HashMap<>();
		map.forEach((k, v) -> System.out.println(k + v));

	}

}
