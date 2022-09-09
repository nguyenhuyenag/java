package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.basic.ClipboardUtils;

import common.util.Base64Utils;

public class Main {

	public static void main(String[] args) {
		Path path = Paths.get("C:/Users/huyennv/Desktop/tax-conver/05_GTGT_TT80_2022.xlsx");
		String base64 = Base64Utils.encodeToString(path);
		System.out.println(base64.trim());
		ClipboardUtils.copy(base64);
	}

}
