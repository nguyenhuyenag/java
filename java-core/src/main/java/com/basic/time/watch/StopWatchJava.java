package com.basic.time.watch;

import java.time.Duration;
import java.time.Instant;

public class StopWatchJava {

	public static void main(String[] args) {
		Instant start = Instant.now();
		// CODE HERE
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println(timeElapsed);
	}

}
