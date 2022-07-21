package com;

import java.nio.file.Path;
import java.nio.file.Paths;

import common.util.Base64Utils;

public class Main {

	public static void main(String[] args) {
//		for (int i = 0; i < 4; i++) {
//			System.out.println(UUID.randomUUID().toString().toUpperCase().replaceAll("-", ""));
//		}
//		for (int i = 0; i < 4; i++) {
//			System.out.println(RandomStringUtils.randomAlphanumeric(32).toUpperCase());
//		}
		Path path = Paths.get("C:\\Users\\huyennv\\Desktop\\tax-conver\\04_GTGT_TT80_2022.xlsx");
		System.out.println(Base64Utils.encodeToString(path).trim());
	}

}
