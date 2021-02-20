package learn.recursion.backtracking;

/**
 * Cho chuỗi S, liệt kê tất cả các hoán vị của S
 */
public class HoanViChuoi {

	static void show(char[] arr) {
		System.out.print(new String(arr) + " ");
	}

	static void swap(char[] arr, int i, int j) {
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
	}

	static void permute(char[] arr, int start, int n) {
		if (start == n) {
			show(arr);
		} else {
			for (int i = start; i <= n; i++) {
				swap(arr, start, i);
				permute(arr, start + 1, n);
				swap(arr, start, i);
			}
		}
	}

	public static void main(String[] args) {
		String str = "abcd";
		char[] arr = str.toCharArray();
		int n = arr.length;
		permute(arr, 0, n - 1);
	}
}
