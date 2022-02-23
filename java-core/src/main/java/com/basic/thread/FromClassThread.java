package com.basic.thread;

/**
 * Có 2 cách tạo thread là `extends Thread` hoặc `implements Runnable`
 */
public class FromClassThread extends Thread {

	private Thread t;
	private String threadName;

	FromClassThread(String name) {
		this.threadName = name;
		System.out.println("Thread " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(50); // thread sleep
			}
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public static void main(String args[]) {
		FromClassThread T1 = new FromClassThread("Thread-1-HR-Database");
		T1.start();

		FromClassThread T2 = new FromClassThread("Thread-2-Send-Email");
		T2.start();

		System.out.println("==> Main thread stopped!!! ");
	}

}
