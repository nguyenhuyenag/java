package com.basic.charstring;

import java.util.HashSet;
import java.util.Set;

public class CollectionToCharArray {
	
	public static void main(String[] args) {
		Set<Character> set = new HashSet<>();
		set.add('a');
		set.add('b');
		set.add('c');
		StringBuilder sb = new StringBuilder();
		set.forEach(sb::append);
		char[] arr = sb.toString().toCharArray();
		for (char c : arr) {
			System.out.println(c);
		}
	}
	
}
