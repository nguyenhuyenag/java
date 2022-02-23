package com.basic.thread;

public class FromRunnable implements Runnable {

	private Thread t;
	private String threadName; // tên thread

	public FromRunnable(String name) {
		this.threadName = name;
		System.out.println("Thread " + threadName);
	}

	@Override
	public void run() {
		System.out.println("Running " + threadName);
		try {
			for (int i = 4; i > 0; i--) {
				System.out.println("Thread: " + threadName + ", " + i);
				Thread.sleep(50); // Let the thread sleep for a while
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
		FromRunnable R1 = new FromRunnable("Thread-1-HR-Database");
		R1.start();

		FromRunnable R2 = new FromRunnable("Thread-2-Send-Email");
		R2.start();

		System.out.println("==> Main thread stopped!!! ");
	}

}
