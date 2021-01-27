package codewars.string;

// getName		=> get Name
// camelCasing 	=> camel Casing
public class BreakCamelCase {

	public static String camelCase(String input) {
		String result = "";
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isUpperCase(c)) {
				result += " " + c;
			} else {
				result += c;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(camelCase("camelCasing"));
	}

}
