package com.lombox;

import lombok.Getter;

class Test {

	@Getter // = isRunning()
	private boolean running;

	@Getter // = getStatus()
	private Boolean status;

}

public class BooleanGetter {

	public static void main(String[] args) {
		Test t = new Test();
		System.out.println(t.isRunning());
		System.out.println(t.getStatus());
	}

}
