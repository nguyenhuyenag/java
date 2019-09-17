package learn.basic.string;

public class DeleteCharacter {

	public static String removeByIndex(String s, int index) {
		if (index < 0 || index > s.length()) {
			throw new StringIndexOutOfBoundsException("String index out of range");
		}
		return s.substring(0, index) + s.substring(index + 1);
	}

	public static void main(String[] args) {
		int index = 5;
		String str = "This is Java";
		System.out.println(removeByIndex(str, index));
	}

}
