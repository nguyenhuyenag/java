package com.basic.thread.basic;

public class ThreadJoin implements Runnable {

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("This is message #" + i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				System.out.println("I'm about to stop");
				return;
			}
		}
	}

	/**
	 * The current thread (main thread) waits for the thread t1 to complete
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadJoin());
		t1.start();
		try {
			t1.join(); // <- block main thread and wait t1 to complete
		} catch (InterruptedException ex) {
			// do nothing
		}
		System.out.println("I'm " + Thread.currentThread().getName());
	}

}
