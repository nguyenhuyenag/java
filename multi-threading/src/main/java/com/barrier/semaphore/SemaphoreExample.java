package com.barrier.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

	private static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) {
		// ExecutorService threadPool = Executors.newFixedThreadPool(6);
		for (int i = 1; i <= 6; i++) {
			WorkerThread worker = new WorkerThread(semaphore, i);
			// threadPool.submit(worker);
			worker.start();
		}
		// threadPool.shutdown();
	}

}
