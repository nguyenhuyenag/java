package com;

import java.util.Random;

public class Main {

	public static void infinity() {
		double p = 1;
		System.out.println(p / 0); // Infinity
	}

	public static void main(String[] args) {
		Random ran = new Random();
		int cur, pre = ran.nextInt(4);
		for (int i = 0; i < 10; i++) {
			cur = ran.nextInt(4);
			while (cur == pre) {
				cur = ran.nextInt(4);
			}
			pre = cur;
			System.out.println(cur);
		}

	}

}
