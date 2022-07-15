package com.basic.thread;

import java.util.concurrent.CountDownLatch;

class MyDevTeam extends Thread {

	private CountDownLatch countDownLatch;

	public MyDevTeam(CountDownLatch countDownLatch, String name) {
		super(name);
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("Task assigned to development team " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("Task finished by development team " + Thread.currentThread().getName());
		this.countDownLatch.countDown();
	}
}

public class CountDownLatchDemo {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(3);
		countDown.
	}

}
