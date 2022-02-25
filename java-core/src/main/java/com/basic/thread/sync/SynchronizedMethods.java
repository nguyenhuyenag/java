package com.basic.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SynchronizedMethods {

	private int sum = 0;

	public void calculate() {
		setSum(getSum() + 1);
	}

	public synchronized void syncCalculate() {
		setSum(getSum() + 1);
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(3);
		SynchronizedMethods summation = new SynchronizedMethods();
		IntStream.range(0, 1000).forEach(count -> service.submit(summation::calculate));
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(summation.getSum());
	}

}
