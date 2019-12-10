package interfaces.function;

/**
 * Functional Interface: Là interface có duy nhất một phương thức abstract.
 */
@FunctionalInterface // <- optional
interface StringProcessor {
	String process(String s);
}

public class FunctionInterface {

	public static String getStr(String input, StringProcessor processor) {
		return processor.process(input);
	}

	public static void withoutLambda() {
		System.out.println(getStr("without lambda", new StringProcessor() {
			@Override
			public String process(String s) {
				return s.toUpperCase();
			}
		}));
	}

	public static void useLambda() {
		System.out.println(getStr("use lambda", s -> s.toUpperCase()));
	}

	public static void methodReference() {
		System.out.println(getStr("method reference", String::toUpperCase));
	}

	public static void main(String[] args) {
		withoutLambda();
		useLambda();
		methodReference();
	}

}
