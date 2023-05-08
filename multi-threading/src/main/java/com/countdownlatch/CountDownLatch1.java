package com.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class Sevice1 extends Thread {

	private CountDownLatch countDownLatch;

	public Sevice1(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Thread 1 done, Id = " + Thread.currentThread().getId());
		this.countDownLatch.countDown();
	}

}

class Sevice2 extends Thread {

	private CountDownLatch countDownLatch;

	public Sevice2(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Thread 2 done, Id = " + Thread.currentThread().getId());
		this.countDownLatch.countDown();
	}

}

class Sevice3 extends Thread {

	private CountDownLatch countDownLatch;

	public Sevice3(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Thread 3 done, Id = " + Thread.currentThread().getId());
		this.countDownLatch.countDown();
	}

}

/**
 * - CountDownLatch vs Executors
 * 
 * + Nếu CountDownLatch khởi tạo giá trị ban đầu là 3 thì bắt buộc phải
 * countdown về 0 thì main thread mới thực thi. CountDownLatch thực sự hữu ích
 * khi biết chính xác số lượng Thread.
 * 
 * + Đối với Executor, ta có thể khởi tạo giá trị ban đầu là 4, queue là 20. Nếu
 * số lượng thread là 5 hay 10 thì nó có thể thêm vào queue để thực thi sau
 */
public class CountDownLatch1 {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);

		Thread service1 = new Thread(new Sevice1(latch));
		Thread service2 = new Thread(new Sevice2(latch));
		Thread service3 = new Thread(new Sevice3(latch));

		service1.start();
		service2.start();
		service3.start();

		// latch waits till the count becomes 0
		// this way we can make sure that the execution of main thread only
		// finishes ones 3 services have executed
		try {
			System.out.println("Waiting for 3 services have started ... ");
			latch.await(30, TimeUnit.SECONDS); //
			System.out.println("Starting main Thread, id = " + Thread.currentThread().getId());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done!!!");
	}

}
