package leetcode.array;

import java.util.Arrays;

/*-
 * - Tao 1 mang n so nguyen khong giong nhau co tong = 0
 * 
 * https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
 */
public class UniqueSumUpZero {

	public static int[] sumZero(int n) {
		int sum = 0;
		int[] arr = new int[n];
		for (int i = 0; i < arr.length - 1; i++) {
			arr[i] = i;
			sum += i;
		}
		arr[n - 1] = -sum;
		return arr;
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sumZero(7)));
	}

}
