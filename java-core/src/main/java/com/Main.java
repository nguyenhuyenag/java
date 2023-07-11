package com;

public class Main {

	public static void main(String[] args) {
		// double input = 123.456;
		// String pattern  = "%a";
		
		// boolean input = true;
		// String pattern  = "%b";
		
		 // char input = 'a';
		 // String pattern  = "%c";
		
		// double input = 123456789;
		// String pattern  = "%e";
		
		double input = 123456789;
		String pattern  = "%f";

		
		String output = String.format(pattern, input);
		System.out.println(output);
	}

}
