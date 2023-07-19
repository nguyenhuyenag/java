package com.trick;

public class InitValueInIfCondition {
	
	public static boolean init(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) { // <- here
            return true;
        }
        System.out.println("Length: " + strLen);
        return true;
    }
	
	public static void main(String[] args) {
		String input = "Java123";
		init(input);
	}
	
}
