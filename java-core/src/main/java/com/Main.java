package com;

import org.apache.commons.lang3.StringUtils;

public class Main {

	public static void main(String[] args) {
		String str = "abc     b       c";
		String deleteWhitespace = StringUtils.deleteWhitespace(str);
		System.out.println(deleteWhitespace);
	}

}
