package learn.string;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

public class CongSoLon {

	public static String add(String n1, String n2) {
		StringBuilder str = new StringBuilder();
		StringBuilder s1 = new StringBuilder(n1).reverse();
		StringBuilder s2 = new StringBuilder(n2).reverse();
		int len1 = s1.length(), len2 = s2.length();
		int max = Math.max(len1, len2);
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
		// thuc hien phep cong
		int soGhiNho = 0;
		for (int i = 0; i < max; i++) {
			int tong = 0;
			// charAt ky tu tai vi tri thu i trong xau
			tong = s1.charAt(i) - '0' + s2.charAt(i) - '0' + soGhiNho;
			str.append(tong % 10);
			soGhiNho = tong / 10;
		}
		if (soGhiNho == 1) {
			str.append("1");
		}
		return str.reverse().toString(); // dao xau truoc khi xuat
	}

	public static String test(String n1, String n2) {
		return new BigInteger(n1).add(new BigInteger(n2)).toString();
	}

	@Test
	public void testMethod() {
		String n1 = "555555555555959595959526147812314787946914";
		String n2 = "121212121564644847947916161616136131313165464";
		assertEquals(test(n1, n2), add(n1, n2));
	}

}
