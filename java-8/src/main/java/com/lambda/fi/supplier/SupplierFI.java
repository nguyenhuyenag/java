package com.lambda.fi.supplier;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*-
 * - T get(): Trả về giá trị trong context mà nó đang được sử dụng bằng phương thức get().
 */
public class SupplierFI {

	static Random random = new Random();

	public static void withoutLambda() {
		Stream.generate(new Supplier<Integer>() {
			@Override
			public Integer get() {
				return random.nextInt(10);
			}
		}).limit(5).forEach(System.out::print);
	}

	public static void useLambda() {
		Stream.generate(() -> random.nextInt(10)) //
				.limit(5) //
				.forEach(System.out::print);

	}

	public static void main(String[] args) {
		useLambda();
		withoutLambda();
	}

}
