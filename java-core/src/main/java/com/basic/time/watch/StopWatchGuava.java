package com.basic.time.watch;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class StopWatchGuava {

	public static void main(String[] args) {
		Stopwatch stopwatch = Stopwatch.createStarted();
		// delay for 2 seconds
		while (stopwatch.elapsed(TimeUnit.SECONDS) < 2) {
			int i = Integer.MIN_VALUE;
			while (i < Integer.MAX_VALUE) {
				i++;
			}
		}
		// Dừng đồng hồ và lấy thời gian đã trôi qua
        long elapsedTime = stopwatch.elapsed().toMillis();
        System.out.println("Thời gian thực hiện: " + elapsedTime + " milliseconds");
	}

}
