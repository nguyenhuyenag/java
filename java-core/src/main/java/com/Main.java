package com;

import static org.apache.commons.lang3.StringUtils.rotate;

public class Main {

	public static void main(String[] args) {
		// Example 1
        String s1 = "ABCDEF";
        int numberOfTimes = 2;
        System.out.printf("'%s' -> '%s'", s1, rotate(s1, numberOfTimes));
        System.out.println();

        // Example 2
        String s2 = "ABCDEF";
        numberOfTimes = -3;
        System.out.printf("'%s' -> '%s'", s2, rotate(s2, numberOfTimes));
        System.out.println();
	}

}
