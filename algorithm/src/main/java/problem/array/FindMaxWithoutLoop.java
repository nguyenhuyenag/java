package problem.array;

public class FindMaxWithoutLoop {

	public static int findMax(int[] arr, int len) {
		int max;
		if (len == 0) {
			return arr[0];
		}
		max = arr[len - 1];
		return Math.max(max, findMax(arr, len - 1));
	}

	public static void main(String[] args) {
		int[] arr = { -9, 0, 12, 8, -22, 0, 0 };
		System.out.println(findMax(arr, arr.length));
	}

}
