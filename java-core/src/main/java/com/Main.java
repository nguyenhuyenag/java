package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.Base64Utils;

public class Main {

//	public static boolean containsDuplicate(int[] nums) {
//		Set<Integer> set = new HashSet<>();
//		for (int x : nums) {
//			if (!set.add(x)) {
//				return true;
//			}
//		}
//		return false;
//	}

//	public boolean isAnagram(String s, String t) {
//		int n = s.length();
//		if (n != t.length())
//			return false;
//		char[] arrs = s.toCharArray();
//		char[] arrt = t.toCharArray();
//		Arrays.sort(arrs);
//		Arrays.sort(arrt);
//		for (int i = 0; i < n; i++) {
//			if (arrs[i] != arrt[i]) {
//				return false;
//			}
//		}
//		return true;
//	}

	public static void main(String[] args) {
		// Path header = Paths.get("C:/Users/huyennv/Desktop/tax-conver/Header.xlsx");
		// System.out.println(Base64Utils.encodeToString(header).trim());
		Path tokhai = Paths.get("C:/Users/huyennv/Desktop/tax-conver/05_QTT_TNCN_TT80_251.xlsx");
		System.out.println(Base64Utils.encodeToString(tokhai).trim());
		// System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
	}

}
