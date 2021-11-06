package com;

import org.apache.commons.lang3.SystemUtils;

public class OSValidator {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void main(String[] args) {
//		System.out.println(OS);
//		System.out.println(OS);
//
//		if (isWindows()) {
//			System.out.println("This is Windows");
//		} else if (isMac()) {
//			System.out.println("This is MacOS");
//		} else if (isUnix()) {
//			System.out.println("This is Unix or Linux");
//		} else if (isSolaris()) {
//			System.out.println("This is Solaris");
//		} else {
//			System.out.println("Your OS is not supported!!");
//		}
		if(SystemUtils.IS_OS_WINDOWS_7)
            System.out.println("It's a Windows 7 OS");
        if(SystemUtils.IS_OS_WINDOWS_8)
            System.out.println("It's a Windows 8 OS");
        if(SystemUtils.IS_OS_LINUX)
            System.out.println("It's a Linux OS");
        if(SystemUtils.IS_OS_MAC)
            System.out.println("It's a MAC OS");
	}

	public static boolean isWindows() {
		return OS.contains("win");
	}

	public static boolean isMac() {
		return OS.contains("mac");
	}

	public static boolean isUnix() {
		return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
	}

	public static boolean isSolaris() {
		return OS.contains("sunos");
	}

	public static String getOS() {
		if (isWindows()) {
			return "win";
		} else if (isMac()) {
			return "osx";
		} else if (isUnix()) {
			return "uni";
		} else if (isSolaris()) {
			return "sol";
		} else {
			return "err";
		}
	}

}
