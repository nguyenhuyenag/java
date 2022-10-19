package com;

import java.util.HashSet;
import java.util.Set;

public class Main {

//	public static void test() {
//		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/892_03_TNDN_TT80_251.xlsx");
//		String base64 = Base64Utils.encodeToString(path);
//		System.out.println(base64.trim());
//		ClipboardUtils.copy(base64);
//	}

	// nums[i] < nums[j] < nums[k]
	public static boolean increasingTriplet(int[] nums) {
		int len = nums.length;
		Set<Integer> set = new HashSet<>();
		for (int x : nums) {
			set.add(x);
		}
		if (set.size() < 3) {
			return false;
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				if (nums[i] >= nums[j]) {
					continue;
				}
				for (int k = j + 1; k < len; k++) {
					if (nums[i] >= nums[k] || nums[j] >= nums[k]) {
						continue;
					}
					if (nums[i] < nums[j] && nums[j] < nums[k]) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// test();
		// int[] nums = { 2, 1, 5, 0, 4, 6 };
		// System.out.println(increasingTriplet(nums));
		int i1 = 123456;
		int i2 = 123_456;
		short binary= 0b0101;
		System.out.println(binary); // true
	}

}
