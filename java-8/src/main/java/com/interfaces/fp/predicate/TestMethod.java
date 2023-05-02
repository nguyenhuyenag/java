package com.interfaces.fp.predicate;

import java.util.function.Predicate;

/**
 * test(): Trả về true nếu đối số đầu vào khớp với biến predicate (điều kiện
 * kiểm tra), nếu không trả về false
 * 
 * - Thường dùng trong stream filter
 */
public class TestMethod {

	public static <T> void test(Predicate<T> p, T s) {
		System.out.println(p.test(s));
	}

	public static void main(String[] args) {
		Predicate<String> p = s -> s.equals("java");

		// TEST
		test(p, "java"); // true
		test(p, "oracle.com"); // false

		// AND
		Predicate<String> and = p.and(s -> s.length() == 4);
		test(and, "java"); // true
		test(and, "java.com"); // false

		// OR
		Predicate<String> or = p.or(s -> s.length() == 8);
		test(or, "java.com"); // true

		// NEGATE
		Predicate<String> negate = p.negate();
		test(negate, "java"); // false

		// MULTI PREDICATE
		Predicate<Integer> p1 = i -> i > 10;
		Predicate<Integer> p2 = i -> i < 20;
		test(p1.and(p2), 15); // true
	}

}
