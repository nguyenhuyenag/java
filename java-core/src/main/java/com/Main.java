package com;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.basic.ClipboardUtils;

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
		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/05_GTGT_TT80_2022.xlsx");
		String base64 = Base64Utils.encodeToString(path);
		System.out.println(base64.trim());
		ClipboardUtils.copy(base64);
	}

}
