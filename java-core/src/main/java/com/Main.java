package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		String str = null;
        String defaultStr = "Default";
        String result = StringUtils.defaultString(str, defaultStr);
        System.out.println(result); // Kết quả: "Default String"
	}

}
