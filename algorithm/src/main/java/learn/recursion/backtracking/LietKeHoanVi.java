package learn.recursion.backtracking;

/**
 * Liệt kê hoán vị của n phần tử của một tập gồm các số từ 1 -> n
 * 
 * Với n = 3 => 123 132 213 231 312 321
 */
public class LietKeHoanVi {

	static void output() {
		StringBuilder builder = new StringBuilder();
		for (int k : res) {
			if (k != 0) {
				builder.append(k);
			}
		}
		System.out.println(builder.toString());
	}

	public static void quaylui(int i) {
		if (i > n) {
			output();
		} else {
			for (int j = 1; j <= n; j++) {
				if (dd[j] == false) {
					dd[j] = true;
					res[i] = j;
					quaylui(i + 1);
					dd[j] = false;
				}
			}
		}
	}

	static int n;
	static int[] arr = new int[n];
	static boolean[] dd = new boolean[10];
	static int[] res = new int[10];

	public static void main(String[] args) {
		n = 3;
		quaylui(1);
	}
}
