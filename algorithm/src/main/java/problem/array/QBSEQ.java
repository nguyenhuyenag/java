package problem.array;

import java.util.Scanner;

public class QBSEQ {

	static int n, k, i, j, s = 0;
	static int[] a = new int[1000];
	static int[][] f = new int[1001][1001];

	static int o(int x) {
		return (x >= 0) ? x : (x + k);
	}

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			n = io.nextInt();
			k = io.nextInt();
			for (i = 1; i <= n; i++) {
				a[i] = io.nextInt();
				a[i] %= k;
				s = (s + a[i]) % k;
			}
			f[0][0] = 0;
			int inf = -(int) Math.pow(10, 9);
			for (int i = 1; i < k; i++) {
				f[0][i] = inf;
			}
			for (i = 1; i <= n; i++) {
				for (j = 0; j < k; j++) {
					f[i][j] = Math.min(f[i - 1][j], f[i - 1][o(j - a[i])] + 1);
				}
			}
			System.out.println(n - f[n][s % k]);
		}
	}

}
