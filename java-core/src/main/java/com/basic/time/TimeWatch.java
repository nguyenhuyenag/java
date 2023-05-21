package com.basic.time;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TimeWatch {

	private static long after;

	private TimeWatch() {

	}

	public static void setTime(int limit, TimeUnit unit) {
		long amount = unit.toMillis(limit);
		Date date = new Date(System.currentTimeMillis() + amount);
		after = date.getTime();
	}

	public static boolean hasNext() {
		return (after != System.currentTimeMillis());
	}

//	public static void todo(String message, long time, TimeUnit unit) {
//		while (true) {
//			System.out.println(message);
//			try {
//				unit.sleep(time);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}

	public static void main(String[] args) {
		TimeWatch.setTime(5, TimeUnit.SECONDS);
		long i = 0;
		while (TimeWatch.hasNext()) {
			i++;
		}
		System.out.println(i);
		// todo("Hi you", 2, TimeUnit.SECONDS);
	}

}
