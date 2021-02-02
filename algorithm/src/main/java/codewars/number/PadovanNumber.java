package codewars.number;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

// https://www.codewars.com/kata/5819f1c3c6ab1b2b28000624
public class PadovanNumber {

	// 1, 1, 1, 2, 2, 3, 4, 5, 7, 9, 12, 16
	// P(0) = P(1) = P(2) = 1, P(n) = P(n-2) + P(n-3)
//	public static int get(int n) {
//		int pPrevPrev = 1, pPrev = 1, pCurr = 1, pNext = 1;
//		for (int i = 3; i <= n; i++) {
//			pNext = pPrevPrev + pPrev;
//			pPrevPrev = pPrev;
//			pPrev = pCurr;
//			pCurr = pNext;
//		}
//		return pNext;
//	}
	
	public static String daoXau(String str) {
		return new StringBuilder(str).reverse().toString();
	}

	public static String add(String s1, String s2) {
		String s = "";
		int len1 = s1.length(), len2 = s2.length();
		int max = Math.max(len1, len2); // ham max length xuat ra gia tri chieu dai lon nhat trong 2 chuoi
		s1 = daoXau(s1); s2 = daoXau(s2);
		// thuc hien noi them so 0 vao chuoi voi muc dich lam cho 2 chuoi so bang nhau
		if (max > len1) {
			for (int i = max; i >= len1; i--) {
				s1 += "0";
			}
		}
		if (max > len2) {
			for (int i = max; i >= len2; i--) {
				s2 += "0";
			}
		}
		// thuc hien phep cong
		int soGhiNho = 0;
		for (int i = 0; i < max; i++) {
			int tong = 0;
			// charAt ky tu tai vi tri thu i trong xau
			tong = s1.charAt(i) - '0' + s2.charAt(i) - '0' + soGhiNho;
			s += tong % 10;
			soGhiNho = tong / 10;
		}
		if (soGhiNho == 1) {
			s += 1;
		}
		return daoXau(s); // dao xau truoc khi xuat
	}

	public static BigInteger Get(long n) {
		String pPrevPrev = "1", pPrev = "1", pCurr = "1", pNext = "1";
		for (int i = 3; i <= n; i++) {
			pNext = add(pPrevPrev, pPrev);
			pPrevPrev = pPrev;
			pPrev = pCurr;
			pCurr = pNext;
		}
		return new BigInteger(pNext);
	}

	@Test
	public void ValueTest1() {
		assertEquals(new BigInteger("1"), PadovanNumber.Get(1));
		assertEquals(new BigInteger("1"), PadovanNumber.Get(2));
		assertEquals(new BigInteger("2"), PadovanNumber.Get(3));
		assertEquals(new BigInteger("2"), PadovanNumber.Get(4));
	}

	@Test
	public void ValueTest() {
		assertEquals(new BigInteger("1177482265857"), PadovanNumber.Get(100));
	}

	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}

//	public static void main(String[] args) {
//		
//		String str = RandomStringUtils.randomAlphabetic(50000);
//		
//		long start = System.currentTimeMillis();
//		daoXau(str);
//		long end = System.currentTimeMillis();
//		System.out.println(end - start);
//		
//		start = System.currentTimeMillis();
//		reverse(str);
//		end = System.currentTimeMillis();
//		System.out.println(end - start);
//
//	}

}
