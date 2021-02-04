package codewars.incomplete;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

// https://www.codewars.com/kata/5819f1c3c6ab1b2b28000624
public class BigPadovanNumber {

	private static Map<String, String> map = new HashMap<>();

	public static long keyMax() {
		return map.keySet().stream().mapToLong(Long::parseLong).max().orElse(0);
	}

	public static String add(String n1, String n2) {
		StringBuilder str = new StringBuilder();
		StringBuilder s1 = new StringBuilder(n1).reverse();
		StringBuilder s2 = new StringBuilder(n2).reverse();
		int len1 = s1.length(), len2 = s2.length();
		int max = (len1 >= len2) ? len1 : len2;
		// lam cho 2 chuoi bang nhau
		if (max > len1) {
			for (int i = max; i >= len1; i--) {
				s1.append("0");
			}
		}
		if (max > len2) {
			for (int i = max; i >= len2; i--) {
				s2.append("0");
			}
		}
		// phep cong
		int soGhiNho = 0;
		for (int i = 0; i < max; i++) {
			int tong = 0;
			tong = s1.charAt(i) - '0' + s2.charAt(i) - '0' + soGhiNho;
			str.append(tong % 10);
			soGhiNho = tong / 10;
		}
		if (soGhiNho == 1) {
			str.append("1");
		}
		return str.reverse().toString(); // dao xau truoc khi xuat
	}

	public static BigInteger Get(long n) {
		long keyMax = 0;
		String vn = String.valueOf(n);
		String pdv = map.get(vn);
		if (pdv != null) {
			return new BigInteger(pdv);
		}
		keyMax = keyMax();
		if (keyMax < 3) {
			keyMax = 2;
			map.put("0", "1");
			map.put("1", "1");
			map.put("2", "1");
		}
		for (long i = keyMax + 1; i <= n; i++) {
			String i2 = map.get(String.valueOf(i - 2));
			String i3 = map.get(String.valueOf(i - 3));
			map.put(String.valueOf(i), add(i2.toString(), i3.toString()));
		}
		return new BigInteger(map.get(vn));
	}

	@Test
	public void ValueTest1() {
		assertEquals(new BigInteger("1"), BigPadovanNumber.Get(1));
		assertEquals(new BigInteger("1"), BigPadovanNumber.Get(2));
		assertEquals(new BigInteger("2"), BigPadovanNumber.Get(3));
		assertEquals(new BigInteger("2"), BigPadovanNumber.Get(4));
		assertEquals(new BigInteger("1177482265857"), BigPadovanNumber.Get(100));
	}

	public static void main(String[] args) {
		System.out.println(BigPadovanNumber.Get(9));
		System.out.println(BigPadovanNumber.Get(14));
		System.out.println(BigPadovanNumber.Get(4));
	}

}
