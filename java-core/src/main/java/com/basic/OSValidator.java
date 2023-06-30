package com.basic;

import org.apache.commons.lang3.SystemUtils;

public class OSValidator {

	public static void main(String[] args) {
		if (SystemUtils.IS_OS_WINDOWS) {
			System.out.println("It's a Windows OS");
		}
		if (SystemUtils.IS_OS_LINUX) {
			System.out.println("It's a Linux OS");
		}
	}

}
