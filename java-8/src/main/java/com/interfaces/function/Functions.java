package com.interfaces.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class Functions {

	public static void main(String[] args) {
		// String -> Integer
		Function<String, Integer> numberConverter = s -> Integer.parseInt(s);
		System.out.println(numberConverter.apply("1"));

		// LocalDate -> String
		Function<LocalDate, String> dateConverter = d -> d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dateConverter.apply(LocalDate.now()));

	}

}
