package com;

public class Main {

	public static final String[] WHITE_LIST = { "/v1/**", "/auth/**" };

	public static void main(String[] args) {
		// System.out.println(false & false);
		String url = "/v1/slow-service";
		for (int i = 0; i < WHITE_LIST.length; i++) {
			WHITE_LIST[i] = WHITE_LIST[i].replaceAll("\\*", "");
			if (url.startsWith(WHITE_LIST[i])) {
				System.out.println("In white list");
			}
		}
	}

}
