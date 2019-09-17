package learn.basic.string;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringToBytes {

	/**
	 * @see more ASCII
	 */
	public static void main(String[] args) {

		String str = "Java 8";

		// String to byte
		byte[] bytes = str.getBytes(StandardCharsets.UTF_8);

		// Byte to String
		String value = new String(bytes, StandardCharsets.UTF_8);
		System.out.println(value + " <=> " + Arrays.toString(bytes));

	}

}
