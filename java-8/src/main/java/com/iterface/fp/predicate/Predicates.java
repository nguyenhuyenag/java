package com.iterface.fp.predicate;

import java.util.function.Predicate;

/*-
	test(): Trả về true nếu đối số đầu vào khớp với biến predicate (điều kiện
 	kiểm tra), nếu không trả về false.
 */
public class Predicates {

	public static <T> void test(T s, Predicate<T> p) {
		System.out.println(p.test(s));
	}

	public static void main(String[] args) {
		Predicate<String> p = s -> s.equals("java");

		// TEST
		test("java", p); 		// true
		test("oracle.com", p); 	// false

		// AND
		Predicate<String> and = p.and(s -> s.length() == 4);
		test("java", and); 		// true
		test("java.com", and); 	// false

		// OR
		test("java.com", p.or(p2 -> p2.length() == 8)); // true

		// NEGATE
		test("java", p.negate()); 						// false

		// MULTI PREDICATE
		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i < 20;
		test(15, p1.and(p2)); // true
	}

}
