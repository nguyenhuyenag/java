package collection.array;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

public class ArraysApi {
	
	private static String print(String[]... args) {
		return Arrays.stream(args) //
				.map(Arrays::deepToString) //
				.collect(Collectors.joining(" + "));
	}

	// So sánh mảng
	public static void compareArray() {
		int[] arr1 = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		int[] arr3 = { 1, 2, 3, 4 };
		System.out.println("arr1 == arr2 ? => " + Arrays.equals(arr1, arr2));
		System.out.println("arr1 == arr3 ? => " + Arrays.equals(arr1, arr3));
	}

	// Sao chép mảng
	public static void copyArray() {
		int[] arr = { 1, 2, 3, 4, 5, 2, 4, 1, 0, 5, 5 };

		int[] copyOf = Arrays.copyOf(arr, 5); // Nếu mảng đã cho không đủ sẽ thêm số 0
		int[] copyOfRange = Arrays.copyOfRange(arr, 0, 3);
		System.out.println(Arrays.toString(copyOf));
		System.out.println(Arrays.toString(copyOfRange));

		// Use Object.clone()
		int[] copyArr2 = arr.clone();
		System.out.println(Arrays.toString(copyArr2));

		// Use Java 8 stream
		Integer[] copiedArray = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		System.out.println(Arrays.toString(copiedArray));
	}

	// Gộp mảng
	public static void joinArray() {
		String[] arr1 = { "a", "b", "c" };
		String[] arr2 = new String[] { "d", "e", "f" };
		String[] join = ArrayUtils.addAll(arr1, arr2);
		System.out.println(print(arr1, arr2) + " = " + print(join));
	}

	public static void setValue() {
		int[] arr = new int[10]; // = {0, 0, 0, 0, 0,...}

		// fill
		Arrays.fill(arr, -1);
		// Arrays.fill(arr, fromIndex, toIndex, value);
		System.out.println("Fill: " + Arrays.toString(arr) + "\n");

		// setAll, parallelSetAll -> Lặp qua index của mảng
		int[] arr2 = { 1, 0, 2, 2 };
		Arrays.setAll(arr2, index -> arr2[index] * arr2[index]);
		// Arrays.setAll(arr2, p -> p > 9 ? 0 : p);
		System.out.println("SetAll: " + Arrays.toString(arr2) + "\n");

		// parallelPrefix
		int[] arr3 = { -1, 4, 0, 3 };
		System.out.println("ParallelPrefix");
		System.out.println("Start: " + Arrays.toString(arr3));
		Arrays.parallelPrefix(arr3, (left, right) -> {
			System.out.println("left=" + left + ", right=" + right + " -> " + Arrays.toString(arr3));
			return left + right;
		});
		System.out.println("End: " + Arrays.toString(arr3));
	}

	public static void arraysApi() {
		// mismatch -> Tìm vị trí đầu tiên mà hai mảng không khớp (khác nhau)
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {1, 2, 3, 6, 5};
		int mismatchIndex = Arrays.mismatch(array1, array2);
		System.out.println(mismatchIndex); // Output: 3
	}

	public static void main(String[] args) {
		// arraysApi();
		// joinArray();
		// copyArray();
		// compareArray();
		setValue();
	}
}
