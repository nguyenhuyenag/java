package com;

public class Main {
	
	@SafeVarargs
	public static void processItems(String... items) {
	    
	}

	public static void main(String[] args) {
		String[] arr = {"1", "2"};
		processItems("1", "2");
		processItems(arr);
	}

}
