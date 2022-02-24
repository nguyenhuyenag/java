package com.basic.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		BaeldungSynchronizedMethods summation = new BaeldungSynchronizedMethods();

		IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(summation.getSum());
	}

}
