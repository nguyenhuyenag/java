package com.v10;

import java.util.List;

public class LocalVariableTypeInference {

	public static void main(String[] args) {
		String s1 = "Welcome to"; 	// old
		var s2 = "Java 10"; 		// new
		System.out.printf("%s %s", s1, s2);

		var names = List.of("Julie", "Robert", "Chris", "Joseph");
		for (var name : names) {
			System.out.println(name);
		}
	}

}
