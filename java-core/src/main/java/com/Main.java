package com;

import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		  StringTokenizer st = new StringTokenizer("this is a test");
		     while (st.hasMoreTokens()) {
		         System.out.println(st.nextToken());
		     }
	}

}
