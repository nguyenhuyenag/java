package com;

import java.io.IOException;

public class Main {

	static void find(int n, int X[], int T[], int i) {
		int j, k;
		for (j = X[i - 1]; j <= (n - T[i - 1]); j++) { // X[i-1] <= X[i] <= n - T[i-1]
			X[i] = j;
			T[i] = T[i - 1] + j;
			if (T[i] == n) { // nếu T[i] = n
				// int k;
				for (k = 1; k <= i; k++) { // in ra từ X[1] tới X[i]
					System.out.print(X[k] + " ");
				}
				System.out.println();
			} else {
				find(n, X, T, i + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		int n = 5;
		int[] X = new int[n + 1]; // mảng X có N + 1 phần tử
		int[] T = new int[n + 1];
		X[0] = 1;
		T[0] = 0;
		find(n, X, T, 1); // mảng nghiệm tính từ i = 1
	}

}
