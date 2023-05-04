package com.string;

public class StringApi {

	public static void join() {
		String[] strings = { "a", "b", "c", "d", "e" };
		String join = String.join("|", strings);
		System.out.println(join);
	}

	public static void main(String[] args) {
		join();
	}

}
