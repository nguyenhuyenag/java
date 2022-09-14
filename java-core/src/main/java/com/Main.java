package com;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.basic.ClipboardUtils;

import common.util.Base64Utils;

public class Main {

	public static void test() {
		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/05_GTGT_TT80_2022.xlsx");
		String base64 = Base64Utils.encodeToString(path);
		System.out.println(base64.trim());
		ClipboardUtils.copy(base64);
	}

	public static void todo(int[] A) {
		int t = A[0];
		A[0] = A[1];
		A[1] = t;
	}

	public static void main(String[] args) {
		// test();
		int[] arr = { 1, 2, 3 };
		todo(arr);
		System.out.println(Arrays.toString(arr));
	}

}
