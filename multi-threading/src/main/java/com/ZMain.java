package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		System.out.println("Hello from MyRunnable!");
	}

}

public class ZMain {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		MyRunnable myRunnable = new MyRunnable();
		// Thread thread = new Thread(myRunnable);
		// thread.start();
		// myRunnable.run();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(myRunnable);
		executor.shutdown();
	}

}
