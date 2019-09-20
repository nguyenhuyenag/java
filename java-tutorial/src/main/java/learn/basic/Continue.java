package learn.basic;

public class Continue {

	public static void main(String[] args) {
		StringBuilder builder = new StringBuilder("hello how are you?");
		int count = 0;
		int length = builder.length();
		for (int i = 0; i < length; i++) {
			if (builder.charAt(i) != 'h') {
				continue;
			}
			count++;
			builder.setCharAt(i, 'h');
		}
		System.out.println("Found " + count + " h's in the string.");
		System.out.println(builder);

	}
}
