package com.optional;

import java.util.Optional;

public class Init {

	/*-
	 * - Tạo một đối tượng Optional rỗng (emtpy):
	 * 
	 * 		Optional<String> optional = Optional.empty();
	 * 
	 * - Tạo một đối tượng Optional chứa giá trị non-null:
	 * 
	 * 		Optional<String> optional = Optional.of(str);
	 * 
	 * - Tạo một đối tượng Optional chứa giá trị có thể null:
	 * 
	 * 		Optional<String> optional = Optional.ofNullable(obj);
	 */

	public static void main(String[] args) {

		// get()
		Optional<String> opt = Optional.of("Java 8");
		System.out.println(opt.get());

		// isPresent()
		Optional<String> optional = Optional.empty();
		System.out.println(optional.isPresent());

		Optional<String> optNull = Optional.ofNullable(null);
		System.out.println(optNull.isPresent());

		// ifPresent()
		optNull.ifPresent(System.out::println);
	}

}
