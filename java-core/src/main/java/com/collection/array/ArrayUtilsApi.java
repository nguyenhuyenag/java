package com.collection.array;

import static org.apache.commons.lang3.ArrayUtils.contains;
import static org.apache.commons.lang3.ArrayUtils.indexOf;
import static org.apache.commons.lang3.ArrayUtils.insert;
import static org.apache.commons.lang3.ArrayUtils.isEmpty;
import static org.apache.commons.lang3.ArrayUtils.removeAllOccurences;
import static org.apache.commons.lang3.ArrayUtils.reverse;
import static org.apache.commons.lang3.ArrayUtils.shift;
import static org.apache.commons.lang3.ArrayUtils.shuffle;
import static org.apache.commons.lang3.ArrayUtils.subarray;
import static org.apache.commons.lang3.ArrayUtils.swap;
import static org.apache.commons.lang3.ArrayUtils.toObject;
import static org.apache.commons.lang3.ArrayUtils.toPrimitive;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.math.NumberUtils;

@SuppressWarnings("unused")
public class ArrayUtilsApi {

	public static void show(String method, int[] A1, int[] A2) {
		System.out.printf("%s: %s -> %s\n", method, Arrays.toString(A1), Arrays.toString(A2));
	}

	public static void shows(String method, int[] A1, int[] A2) {
		System.out.printf("%s: %s -> %s \n\n", method, Arrays.toString(A1), Arrays.toString(A2));
	}

	/**
	 * - isSorted: Kiểm tra 1 mảng đã được sắp xếp theo thứ tự tăng dần hay không
	 * 
	 * - isArrayIndexValid(int[], index): Kiểm tra index có thuộc mảng không
	 */
	private static void api() {
		/**
		 * - subarray: Tạo mảng con
		 */
		int[] intArr = { 1, 2, 3, 1, 4, 5 };
		int[] subarray = subarray(intArr, 2, 5);
		shows("SubArray", intArr, subarray);

		/**
		 * - reverse: Đảo mảng
		 */
		int[] clone = ArrayUtils.clone(intArr);
		reverse(clone);
		shows("Reverse", intArr, clone);

		/**
		 * shuffle: Trộn mảng
		 */
		clone = ArrayUtils.clone(intArr);
		shuffle(clone);
		shows("Shuffle", intArr, clone);

		/**
		 * swap: Đổi vị trị 2 phân tử
		 */
		clone = ArrayUtils.clone(intArr);
		swap(clone, 0, 1);
		shows("Swap", intArr, clone);

		/**
		 * - shift: Dịch chuyển các phần tử theo chiều kim đồng hồ hoặc ngược lại
		 */
		clone = ArrayUtils.clone(intArr);
		shift(clone, 2);
		show("Shift left", intArr, clone);
		clone = ArrayUtils.clone(intArr);
		shift(clone, -2);
		shows("Shift right", intArr, clone);

		/**
		 * - indexOf: Tìm vị trí đầu tiên của một phần tử trong một mảng
		 * 
		 * - indexOf(int[], target, fromIndex): Tìm từ vị trí fromIndex
		 * 
		 * - Tương tự có lastIndexOf
		 */
		int valueToFind = 3;
		int indexOf = indexOf(intArr, 3);
		System.out.printf("IndexOf `valueToFind = %d` is `%d` \n\n", valueToFind, indexOf);

		/**
		 * - contains: Tìm phần tử trong mảng
		 */
		boolean contains = contains(intArr, 3);
		System.out.printf("Contains `valueToFind = %d` is `%s`\n\n", valueToFind, contains);

		/**
		 * - toPrimitive: Chuyển mảng đối tượng về mảng primitive
		 * 
		 * - toObject: Ngược lại
		 */
		Integer[] integerArray = { 1, 2, 3, 4, 5 };
		int[] toPrimitive = toPrimitive(integerArray);
		Integer[] toObject = toObject(toPrimitive);
		System.out.println("ToObject: int[] -> Integer[]");
		System.out.println("ToPrimitive: Integer[] -> int[]\n");

		/**
		 * - isEmpty, isNotEmpty: Check array empty
		 */
		System.out.println("Check empty: " + isEmpty(toPrimitive) + "\n");

		/**
		 * - add, addAll: Thêm phần tử vào cuối mảng
		 */
		clone = ArrayUtils.clone(intArr);
		int[] result = ArrayUtils.addAll(clone, -1, -2);
		shows("AddAll", intArr, result);

		/**
		 * - remove: Remove by index
		 * 
		 * - removeElement: Remove by value
		 * 
		 * - removeAll(int[], v1, v2,...): Remove all v1, v2,...
		 * 
		 * - removeAllOccurences(int[], x): Remove all x values in array
		 */
		clone = ArrayUtils.clone(intArr);
		// remove
		ArrayUtils.remove(clone, 4);
		show("RemoveByIndex", intArr, clone);
		// removeElement
		ArrayUtils.removeElement(clone, 1);
		System.out.println("RemoveByValue: ");
		// removeAll
		ArrayUtils.removeAll(clone, 1);
		System.out.println("RemoveAll: ");
		// removeAllOccurences
		clone = ArrayUtils.clone(intArr);
		result = removeAllOccurences(clone, 1);
		shows("RemoveAllOccurences", intArr, result);

		/**
		 * insert: Chèn phần tử vào vị trí chỉ định
		 */
		clone = ArrayUtils.clone(intArr);
		int index = 1;
		int inserValue = -11;
		result = insert(index, clone, inserValue);
		shows("Insert", intArr, result);
		
		/**
		 * min, max: Tìm min, max của phần tử
		 */
		int min = NumberUtils.min(intArr);
		int max = NumberUtils.max(intArr);
		System.out.println("Min: " + Arrays.toString(intArr) + " -> " + min);
		System.out.println("Max: " + Arrays.toString(intArr) + " -> " + max);
	}

	public static void main(String[] args) {
		api();
	}

}
