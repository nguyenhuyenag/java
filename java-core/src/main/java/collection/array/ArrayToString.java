package collection.array;

import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

public class ArrayToString {

	public static void main(String[] args) {
		String[] arr = { "a", "b", "c", "d" };

		// Java 8
		String joined = String.join(",", arr);
		System.out.println("Java 8: " + joined);

		// Apache
		String joined2 = StringUtils.join(arr, ",");
		System.out.println("Apache: " + joined2);

		// StringJoiner
		StringJoiner joiner = new StringJoiner(",", "{", "}");
		for (String s : arr) {
			joiner.add(s);
		}
		System.out.println("StringJoiner: " + joiner);
	}

}
