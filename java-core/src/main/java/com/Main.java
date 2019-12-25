package com;

public class Main {

	public static void main(String[] args) {
		double a = 1.2345;
		double roundOff = (double) Math.round(a * 100) / 100;
		System.out.println(roundOff);
	}

}
