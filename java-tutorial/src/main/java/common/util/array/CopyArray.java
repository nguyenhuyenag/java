package common.util.array;

import java.util.Arrays;

public class CopyArray {

	public static void main(String[] args) {

		String[] arr = { "1", "2", "3", "4", "5" };

		// Arrays.copyOf()
		String[] copyArr1 = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(copyArr1));

		// Object.clone()
		String[] copyArr2 = arr.clone();
		System.out.println(Arrays.toString(copyArr2));

		// Java 8 stream
		String[] copiedArray = Arrays.stream(arr).toArray(String[]::new);
		System.out.println(Arrays.toString(copiedArray));

	}

}
