package problem.string;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*-
 * Đếm các ký tự cùng xuất hiện ở cả 2 chuỗi
 * Input:	<Chuỗi 1>
 * 			<Chuỗi 2>
 */
public class CharCommon {

	static public void main(String[] args) {
		try (Scanner in = new Scanner(System.in);) {
			String s1 = in.next();
			String s2 = in.next();
			char[] a = s1.toCharArray(), b = s2.toCharArray();
			Set<Character> set = new HashSet<>();
			for (char c : a) {
				set.add(c);
			}
			int count = 0;
			for (char c : b) {
				if (set.contains(c)) {
					count++;
					set.remove(c);
				}
			}
			System.out.print(count);
		}
	}

}
