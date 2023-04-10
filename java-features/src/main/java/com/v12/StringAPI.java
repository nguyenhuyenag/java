package com.v12;

public class StringAPI {
	
	public static void main(String[] args) {
		String text = "Hello!\nThis is Java 12 article.";

		text = text.indent(4);
		System.out.println(text);

		text = text.indent(-10);
		System.out.println(text);
	}
	
}
