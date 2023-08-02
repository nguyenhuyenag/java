package com;

import java.io.IOException;
import java.util.Optional;

public class Main {

	public static void main(String[] args) throws IOException {
		Optional<String> valueOptional = Optional.of("Hello");

		// Sử dụng map() để biến đổi giá trị trong Optional từ kiểu String sang kiểu
		// Integer
		Optional<String> lengthOptional = valueOptional.map(str -> str + "123");

		if (lengthOptional.isPresent()) {
			System.out.println("Length of the value: " + lengthOptional.get());
		} else {
			System.out.println("No value found.");
		}
	}
}
