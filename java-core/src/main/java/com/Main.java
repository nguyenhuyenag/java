package com;

public class Main {

	final int MAX_VALUE;
	Main() {
        MAX_VALUE = 99;
    }
	
	void test() {
		System.out.println(this);
	}

	public static void main(String[] args) {
		Main m =  new Main();
		m.test();
	}

}
