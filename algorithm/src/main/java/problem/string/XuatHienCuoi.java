package problem.string;

import java.util.Scanner;

/**
 * Vị trí xuất hiện cuối cùng của s2 trong s1
 */
public class XuatHienCuoi {

	public static void main(String[] args) {
		try (Scanner io = new Scanner(System.in);) {
			String s1 = io.nextLine(), s2 = io.nextLine();
			int i = 0, index = -1;
			int len = s1.length(), len2 = s2.length();
			while (i + len2 <= len) {
				if (s2.equals(s1.substring(i, i + len2))) {
					index = i;
				}
				i++;
			}
			System.out.println(index);
		}
	}

}
