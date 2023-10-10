package com.basic.time.watch;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchApache {

	public static void main(String[] args) {
		final StopWatch watch = new StopWatch();
		
		watch.start();
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (final InterruptedException ex) {
		}
		
		System.out.println(watch.getTime(TimeUnit.SECONDS));
		System.out.println(watch.getTime());
		
		watch.stop();
	}

}
