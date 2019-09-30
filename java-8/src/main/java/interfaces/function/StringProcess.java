package interfaces.function;

@FunctionalInterface
interface StringProcessor {
	public String process(String str);
}

public class StringProcess {

	public static String getStr(String input, StringProcessor processor) {
		return processor.process(input);
	}

	public static void main(String[] args) {

		// without lambda
		System.out.println(getStr("java", new StringProcessor() {
			@Override
			public String process(String str) {
				return str.toUpperCase();
			}
		}));

		System.out.println(getStr("JAVA", new StringProcessor() {
			@Override
			public String process(String str) {
				return str.toLowerCase();
			}
		}));

		// with lambda
		System.out.println(getStr("java", s -> s.toUpperCase()));
		System.out.println(getStr("JAVA", s -> s.toLowerCase()));
		System.out.println(getStr("functional", s -> {
			s += " interface";
			return s.toUpperCase();
		}));
		
		// method reference
		System.out.println(getStr("java", String::toUpperCase));

	}

}
