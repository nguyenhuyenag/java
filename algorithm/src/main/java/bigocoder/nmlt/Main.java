package bigocoder.nmlt;

public class Main {

	public static void main(String[] args) {
		int i = 1; // or i = 1
		int count = 0;
		while (count < 4) {
			int k = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					k += j;
				}
			}
			if (k == i) {
				count++;
				System.out.println(k);
			}
			i++;
		}
	}

}
