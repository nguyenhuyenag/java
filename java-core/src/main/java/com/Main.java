package com;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void start(TimeUnit unit, int limit) {
		long time = unit.toMillis(limit);
		System.out.println(time);
	}

	public static void main(String[] args) {

	}

}
