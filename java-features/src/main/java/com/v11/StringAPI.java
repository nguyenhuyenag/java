package com.v11;

public class StringAPI {

	public static void main(String[] args) {
		String sample = " abc ";
		System.out.println(sample.repeat(3)); 			// 	" abc abc abc "
		System.out.println(sample.isBlank()); 			// 	false
		System.out.println("".isBlank()); 				// 	true
		System.out.println("   ".isBlank()); 			// 	true
		System.out.println(sample.strip()); 			// 	"abc"
		System.out.println(sample.stripLeading()); 		// 	"abc "
		System.out.println(sample.stripTrailing());		// 	" abc"
		
		sample = "This\nis\na\nmultiline\ntext.";
		sample.lines().forEach(line -> System.out.println(line));
	}

}
