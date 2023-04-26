package com.basic.thread.synchronize;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import lombok.Getter;
import lombok.Setter;

/**
 * - Mutual Exclusive (synchronized): Có thể hiểu là Loại trừ lẫn nhau. Cách này
 * hệ thống sẽ ưu tiên một thread và ngăn chặn các thread khác khỏi nguy cơ xung
 * đột với nhau.
 * 
 * - Cooperation: Có thể hiểu là Cộng tác với nhau. Cách này bản thân các thread
 * sẽ bắt tay với nhau, cùng nhau điều tiết thứ tự ưu tiên để có thể tự bản thân
 * chúng tránh sự xung đột.
 */
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
		SynchronizedMethods summation = new SynchronizedMethods();
		ExecutorService service = Executors.newFixedThreadPool(3);
		// .forEach(count -> service.submit(summation::calculate));
		IntStream.range(0, 1000).forEach(t -> {
			service.submit(() -> {
				// summation.calculate();
				summation.syncCalculate();
			});
		});
		service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		System.out.println(summation.getSum());
	}

}
