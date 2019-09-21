package learn.basic;

public class Continue {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello how are you?");
		int count = 0;
		int length = sb.length();
		for (int i = 0; i < length; i++) {
			if (sb.charAt(i) != 'h') {
				continue;
			}
			count++;
			sb.setCharAt(i, 'h');
		}
		System.out.println("Found " + count + " h's in the string.");
		System.out.println(sb);

	}
}
