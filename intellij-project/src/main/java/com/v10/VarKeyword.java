package com.v10;

import java.util.List;

// LocalVariableTypeInference
public class VarKeyword {

	public static void main(String[] args) {
		String s1 	= "Java"; 			// old
		var s2 		= "Java"; 			// new
		System.out.println("Compare: " + s1.equals(s2));

		var names = List.of("Julie", "Robert", "Chris", "Joseph");
		for (var name : names) {
			System.out.println(name);
		}
	}

}
