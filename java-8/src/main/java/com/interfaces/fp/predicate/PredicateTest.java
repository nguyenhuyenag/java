package com.interfaces.fp.predicate;

import java.util.function.Predicate;

/*-
 * boolean test(): Trả về true nếu đối số đầu vào khớp với biến predicate (điều kiện
 * kiểm tra), nếu không trả về false
 */
public class PredicateTest {

	public static <T> void test(T s, Predicate<T> p) {
		System.out.println(p.test(s));
	}

	public static void main(String[] args) {
		Predicate<String> p = s -> s.equals("java");

		// TEST
		test("java", p); // true
		test("oracle.com", p); // false

		// AND
		Predicate<String> and = p.and(s -> s.length() == 4);
		test("java", and); // true
		test("java.com", and); // false

		// OR
		Predicate<String> or = p.or(s -> s.length() == 8);
		test("java.com", or); // true

		// NEGATE
		Predicate<String> negate = p.negate();
		test("java", negate); // false

		// MULTI PREDICATE
		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i < 20;
		test(15, p1.and(p2)); // true
	}

}
