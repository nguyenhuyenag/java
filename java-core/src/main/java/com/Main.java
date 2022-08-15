package com;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

import common.util.Base64Utils;

public class Main {

	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int x : nums) {
			if (!set.add(x)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// Path header = Paths.get("C:/Users/huyennv/Desktop/tax-conver/Header.xlsx");
		// System.out.println(Base64Utils.encodeToString(header).trim());
		Path tokhai = Paths.get("C:/Users/huyennv/Desktop/tax-conver/03_TNDN_TT80_251.xlsx");
		System.out.println(Base64Utils.encodeToString(tokhai).trim());
		// System.out.println(containsDuplicate(new int[] { 1, 2, 3, 4 }));
	}

}
