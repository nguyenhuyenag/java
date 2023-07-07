package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		String str = null;
        String defaultStr = "Default";
        String defaultIfEmpty = StringUtils.defaultIfEmpty(str, defaultStr);
        System.out.println(defaultIfEmpty); // Kết quả: "Default String"
        String defaultIfBlank = StringUtils.defaultIfBlank(str, defaultStr);
        System.out.println(defaultIfBlank); // Kết quả: "Default String"
	}

}
