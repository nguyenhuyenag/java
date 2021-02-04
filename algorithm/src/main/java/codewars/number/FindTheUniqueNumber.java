package codewars.number;

import java.util.Arrays;

public class FindTheUniqueNumber {

	public static double findUniq(double[] arr) {
		int index = -1;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int count = 0;
			double x = arr[i];
			for (int j = 0; j < n; j++) {
				if (x == arr[j]) {
					count++;
				}
				if (count > 1) {
					break;
				}
			}
			if (count == 1) {
				index = i;
			}
		}
		return arr[index];
	}

	public static double _findUniq(double[] arr) {
		Arrays.sort(arr);
		return arr[0] != arr[1] ? arr[0] : arr[arr.length - 1];
	}

}
