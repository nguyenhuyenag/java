package problem.string;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;

// Đếm các ký tự cùng xuất hiện ở cả 2 chuỗi
public class CharCommon {

	public static void main(String[] args) {
		int n = 20;
		String s1 = RandomStringUtils.randomAlphanumeric(n);
		String s2 = RandomStringUtils.randomAlphanumeric(n);
		System.out.println(s1 + "\n" + s2);
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
