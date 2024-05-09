package basic.strings;

@SuppressWarnings("unused")
public class StringVsStringBuilder {

	public static void main(String[] args) {

		String s = "";
		StringBuilder builder = new StringBuilder();

		long start, end;
		final int N = 10000;

		// String
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			s += " ";
		}
		end = System.currentTimeMillis();
		System.out.println("String: " + (int) (end - start) + "ms");

		// StringBuilder
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			builder.append(" ");
		}
		end = System.currentTimeMillis();
		System.out.println("StringBuilder: " + (int) (end - start) + "ms");
	}

}
