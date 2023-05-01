package com.interfaces.fi;

@FunctionalInterface // <- có thể có hoặc không
interface StringUtils {
	int process(String s);
}

public class FunctionInterface {

	/**
	 * Sử dụng interface làm tham số và xử lý input
	 */
	public static int doAction(String input, StringUtils processor) {
		return processor.process(input);
	}

	public static int withoutLambda() { // <- anonymous function
		return doAction("Hello Java", new StringUtils() {
			@Override
			public int process(String s) {
				return s.length();
			}
		});
	}

	public static int useLambda() {
		return doAction("Use lambda", s -> s.length());
	}

	public static int methodReference() {
		return doAction("Method reference", String::length);
	}

	public static void main(String[] args) {
		int length = useLambda();
		// int length = withoutLambda();
		// int length = methodReference();
		System.out.println(length);
	}

}
