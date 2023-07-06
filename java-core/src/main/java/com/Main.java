package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		String str = "org.apache.commons.lang3.StringUtils";
		String result  = StringUtils.replace(str, ".", "_", 3);
		System.out.println(result);
	}

}
