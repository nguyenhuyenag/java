package lambda.fi;

/**
 * Functional Interface: Là interface có duy nhất một phương thức abstract
 */
@FunctionalInterface // <- có thể có hoặc không
interface StringProcessor {

	String process(String s);

}

public class FunctionInterface {

	public static String todo(String input, StringProcessor processor) {
		return processor.process(input);
	}

	public static void withoutLambda() { // anonymous function
		String s = todo("Without lambda", new StringProcessor() {
			@Override
			public String process(String s) {
				return s.toUpperCase();
			}
		});
		System.out.println(s);
	}

	public static void useLambda() {
		System.out.println(todo("Use lambda", s -> s.toUpperCase()));
	}

	public static void methodReference() {
		System.out.println(todo("Method reference", String::toUpperCase));
	}

	public static void test() {
		String len = todo("Java", new StringProcessor() {
			@Override
			public String process(String s) {
				return s.length() + "";
			}
		});
		System.out.println(len);
	}

	public static void main(String[] args) {
		withoutLambda();
		useLambda();
		methodReference();
		test();
	}

}
