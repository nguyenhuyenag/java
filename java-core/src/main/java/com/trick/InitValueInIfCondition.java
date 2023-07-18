package com.trick;

public class InitValueInIfCondition {
	
	public static boolean init(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) { // <- here
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            // 
        }
        return true;
    }
	
}
