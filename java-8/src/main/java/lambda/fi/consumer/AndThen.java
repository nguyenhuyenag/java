package lambda.fi.consumer;

import java.util.function.Consumer;

public class AndThen {

	static Consumer<Integer> times    = t -> System.out.println(2 * t);
	static Consumer<Integer> squared  = t -> System.out.println(t * t);
	static Consumer<Integer> isOdd    = t -> System.out.println(t % 2 == 1);

	public static void withoutAndThen() {
		times.accept(5);	// 10
		squared.accept(5); 	// 25
		isOdd.accept(5); 	// true
	}

	public static void andThen1() {
		Consumer<Integer> combineConsumer = times.andThen(squared).andThen(isOdd);
		combineConsumer.accept(5); // 10, 25, true
	}

	public static void andThen2() {
		Consumer<String> c1 = s -> System.out.println(s + " Java");
		Consumer<String> c2 = s -> System.out.println(s + " Oracle");
		c1.andThen(c2).accept("Hello");
	}

	public static void main(String[] args) {
		// withoutAndThen();
		// andThen1();
		andThen2();
	}

}
