package interfaces.function.api;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*-
 * - T get(): method này không có tham số nhưng trả về một kết quả
 */
public class Suppliers {

	public static void main(String[] args) {

		Random random = new Random();

		Stream.generate(new Supplier<Integer>() {
			@Override
			public Integer get() {
				return random.nextInt(10);
			}
		}).limit(5) //
				.forEach(t -> System.out.print(t + " "));
		
		System.out.println();

		// lambda
		Stream.generate(() -> random.nextInt(10)) //
				.limit(5) //
				.forEach(t -> System.out.print(t + " "));

	}

}
