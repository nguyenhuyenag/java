package com.lambda.fi.function;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*-
	- Functional Interface (FI) là interface có duy nhất một phương thức abstract

		public interface Function<T, R> {
			R apply(T t);
		}
	
	- Với, T là kiểu dữ liệu của tham số và R là kiểu dữ liệu trả về. Khi sử dụng FI, ta 
	chỉ cần triển khai lại phương thức apply() để thực hiện các tính toán cần thiết và trả
	về giá trị đúng kiểu dữ liệu R.
*/
public class Functions {

	public static void main(String[] args) {

		// List<String> -> List<Integer>
		List<String> list = new ArrayList<>();
		list.stream().map(Integer::parseInt).collect(Collectors.toList());

		// String -> Integer
		Function<String, Integer> numberConverter = s -> Integer.parseInt(s);
		System.out.println(numberConverter.apply("1"));

		// LocalDate -> String
		Function<LocalDate, String> dateConverter = d -> d.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(dateConverter.apply(LocalDate.now()));

	}

}
