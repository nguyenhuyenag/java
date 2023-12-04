package com.iterface.fi;

@FunctionalInterface
interface StringUtils {
	int process(String s);
	// int process2(String s); // Đóng/mở để thấy sự khác biệt
}

/**
 * Functional Interface là một interface chỉ có duy nhất một phương thức trừu
 * tượng (abstract method ~ abstract function) hoặc single abstract method
 * (SAM). Ví dụ Predicate, Function, Runnable, Callable,...
 */
public class FunctionInterface {

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
