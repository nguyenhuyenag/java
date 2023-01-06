package com;

import java.util.Arrays;

import common.object.User;

public class Test {

	static void todo(User u1) {
		u1.setName("Java2");
	}

	public static void main(String[] args) {
		String s = "abc";
		System.out.println(Arrays.toString(s.getBytes()));
		System.out.println((byte) 'a');
	}

}
