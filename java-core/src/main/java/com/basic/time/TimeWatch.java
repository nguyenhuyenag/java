package com.basic.time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeWatch {

	private static long after;

	private TimeWatch() {

	}

	public static void setTime(TimeUnit unit, int limit) {
		long amount = unit.toMillis(limit);
		Date date = new Date(System.currentTimeMillis() + amount);
		after = date.getTime();
	}

	public static boolean hasNext() {
		return (after != System.currentTimeMillis());
	}

	static void todo(String message, TimeUnit unit, long time) {
		while (true) {
			System.out.println(message);
			try {
				unit.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
//		TimeWatch.setTime(TimeUnit.SECONDS, 5);
//		long i = 0;
//		while (TimeWatch.hasNext()) {
//			i++;
//		}
//		System.out.println(i);

		todo("Hi you", TimeUnit.SECONDS, 2);
	}

}
