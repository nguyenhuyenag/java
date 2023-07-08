package com.collection.array;

import static org.apache.commons.lang3.ArrayUtils.reverse;
import static org.apache.commons.lang3.ArrayUtils.shift;
import static org.apache.commons.lang3.ArrayUtils.subarray;
import static org.apache.commons.lang3.ArrayUtils.swap;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayUtilsApi {

	public static void show(String method, int[] A1, int[] A2) {
		System.out.printf("%s: %s -> %s\n", method, Arrays.toString(A1), Arrays.toString(A2));
	}

	public static void shows(String method, int[] A1, int[] A2) {
		System.out.printf("%s: %s -> %s \n\n", method, Arrays.toString(A1), Arrays.toString(A2));
	}

	private static void api() {
		/**
		 * - subarray: Tạo mảng con
		 */
		int[] intArr = { 1, 2, 3, 4, 5 };
		int[] subarray = subarray(intArr, 2, 5);
		shows("Subarray", intArr, subarray);

		/**
		 * - reverse: Đảo mảng
		 */
		int[] clone = ArrayUtils.clone(intArr);
		reverse(clone);
		shows("Reverse", intArr, clone);

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
		int indexOf = ArrayUtils.indexOf(intArr, 3);
		System.out.println("IndexOf: " + indexOf);
		
		/**
		 * - contains
		 */
	}

	public static void main(String[] args) {
		api();
	}

}
