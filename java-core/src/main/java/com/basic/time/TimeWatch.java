package com.basic.time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeWatch {

	private static long after;

	private TimeWatch() {

	}

	public static void start(TimeUnit unit, int limit) {
		long amount = unit.toMillis(limit);
		Date date = new Date(System.currentTimeMillis() + amount);
		after = date.getTime();
	}

	public static boolean hasNext() {
		return (after != System.currentTimeMillis());
	}

	public static void main(String[] args) {
		TimeWatch.start(TimeUnit.SECONDS, 2);
		long i = 0;
		while (TimeWatch.hasNext()) {
			i++;
		}
		System.out.println(i);
	}

}
