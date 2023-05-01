package com.interfaces.fi;

@FunctionalInterface // <- có thể có hoặc không
interface StringUtils {
	int process(String s);
}

public class FunctionInterface {

	/**
	 * Sử dụng interface làm tham số và xử lý input
	 */
	public static int setup(String input, StringUtils processor) {
		return processor.process(input);
	}

	public static void withoutLambda() { // <- anonymous function
		int length = setup("Hello Java", new StringUtils() {
			@Override
			public int process(String s) {
				return s.length();
			}
		});
		System.out.println(length);
	}

	public static void useLambda() {
		int length = setup("Use lambda", s -> s.length());
		System.out.println(length);
	}

	public static void methodReference() {
		int length = setup("Method reference", String::length);
		System.out.println(length);
	}

	public static void main(String[] args) {
		useLambda();
		withoutLambda();
		methodReference();
	}

}
