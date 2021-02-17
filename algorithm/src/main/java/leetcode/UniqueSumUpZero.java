package leetcode;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
public class UniqueSumUpZero {

	public static int[] sumZero(int n) {
		int[] arr = new int[n];
		if (n % 2 == 0) {
			int i = 0;
			while (i < n) {
				arr[i] = (i + 1);
				arr[i + 1] = -arr[i];
				i = i + 2;
			}
		} else {
			int i = 1;
			while (i < n) {
				arr[i] = (i + 1);
				arr[i + 1] = -arr[i];
				i = i + 2;
			}
		}
		return arr;
	}

}
