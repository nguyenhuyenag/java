package com.lambda.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Suppliers {

	/**
	 * T get(): Phương thức get() sẽ return một giá trị cụ thể
	 */
	private static void print(Supplier<?> supplier) {
		System.out.println(supplier.get());
	}

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "Oracle", "Sun");
		list.stream().forEach(x -> print(() -> x));
	}

}
