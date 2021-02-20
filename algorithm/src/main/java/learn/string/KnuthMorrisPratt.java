package learn.string;

public class KnuthMorrisPratt {

	public static int[] preKMP(char[] x) {
		int[] kmpNext = new int[x.length + 1];
		int i = 0;
		int j = -1;
		kmpNext[0] = -1;
		while (i < x.length - 1) {
			while (j > -1 && x[i] != x[j]) {
				j = kmpNext[j];
			}
			i++;
			j++;
			if (x[i] == x[j]) {
				kmpNext[i] = kmpNext[j];
			} else {
				kmpNext[i] = j;
			}
		}
		return kmpNext;
	}

	public static void search(char[] x, char[] y) {
		int[] kmpNext = preKMP(x);
		int i = 0; // the position of character in x
		int m = 0; // the beginning of the current match in y
		while (m <= y.length - x.length) {
			if (x[i] == y[m + i]) {
				i++;
				if (i == x.length) {
					System.out.print(m + "    ");
					m = m + i - kmpNext[i];
					i = kmpNext[i];
				}
			} else {
				m = m + i - kmpNext[i];
				i = 0;
			}
		}
	}

	public static void main(String[] args) {
		String x = "GCAGAGAG";
		char[] X = x.toCharArray();
		String y = "GCATCGCAGAGAGTATACAGTACG";
		char[] Y = y.toCharArray();
		System.out.print("Các vị trí xuất hiện của x trong y là: ");
		search(X, Y);
	}
}
