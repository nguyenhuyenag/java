package lambda.predicate;

import java.util.function.Predicate;

public class Predicates {

	/**
	 * test(): Trả về true nếu đối số đầu vào khớp với biến predicate (điều kiện
	 * kiểm tra), nếu không trả về false
	 * @see interfaces.function.api.Predicates
	 */
	public static void main(String[] args) {

		Predicate<String> predicateTest = s -> s.equals("java");

		// TEST
		System.out.println(predicateTest.test("java")); // true
		System.out.println(predicateTest.test("oracle.com")); // false

		// AND
		Predicate<String> predicateAnd = predicateTest.and(s -> s.length() == 4);
		System.out.println(predicateAnd.test("java")); // true
		System.out.println(predicateAnd.test("java.com")); // false

		// OR
		Predicate<String> predicateOr = predicateTest.or(s -> s.length() == 8);
		System.out.println(predicateOr.test("java.com")); // true

		// NEGATE
		Predicate<String> predicateNegate = predicateTest.negate();
		System.out.println(predicateNegate.test("java")); // false

		// MULTI PREDICATE
		Predicate<Integer> greaterThanTen = i -> i > 10;
		Predicate<Integer> lessThanTwenty = i -> i < 20;
		System.out.println(greaterThanTen.and(lessThanTwenty).test(15)); // true

	}

}
