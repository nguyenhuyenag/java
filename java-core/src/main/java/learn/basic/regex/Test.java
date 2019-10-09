package learn.basic.regex;

public class Test {

	public static void main(String[] args) {

		// String str = "5";
		// String regex = "^[a-z0-9_-]{3,15}";
		// System.out.println(str.matches(regex));

		// System.out.println("d".matches("[^abc]"));

		// System.out.println("abc".matches("^a.+"));
		// System.out.println("abc".matches("[abc].*"));
		// System.out.println("a".matches("^[abc]"));
		// System.out.println("12a3".matches("\\d+"));
		// System.out.println(" ".matches("\\s*"));
		// System.out.println("hello world".matches("hello\b"));
		// System.out.println("helloWorld".matches(regex));
		String[] arr = "The fat cat sat on the mat".split("\\s+");
		// System.out.println(Arrays.toString(arr));
		for (String s : arr) {
			if (s.matches("(T|t)he(?=\\sfat)")) {
				System.out.println(s);
			}
		}
	}

}
