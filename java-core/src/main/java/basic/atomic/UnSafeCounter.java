package basic.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class Counter extends Thread {

	int count = 0;

	public void run() {
		final int MAX = 1_000_000;
		for (int i = 0; i < MAX; i++) {
			count++;
		}
	}
}

class SyncCounter extends Thread {

	int count = 0;

	public synchronized void run() {
		final int MAX = 1_000_000;
		for (int i = 0; i < MAX; i++) {
			count++;
		}
	}
}

class AtomicCounter extends Thread {

	AtomicInteger count;

	AtomicCounter() {
		count = new AtomicInteger();
	}

	public synchronized void run() {
		final int MAX = 1_000_000;
		for (int i = 0; i < MAX; i++) {
			count.addAndGet(1);
		}
	}
}

public class UnSafeCounter {

	public static void ex1() throws InterruptedException {
		SyncCounter c = new SyncCounter();
		Thread t1 = new Thread(c, "Thread 1");
		Thread t2 = new Thread(c, "Thread 2");
		t1.start();
		t2.start();
		// main thread will wait for both threads to get completed
		t1.join();
		t2.join();
		System.out.println(c.count);
	}

	public static void ex2() throws InterruptedException {
		SyncCounter c = new SyncCounter();
		Thread t1 = new Thread(c, "Thread 1");
		Thread t2 = new Thread(c, "Thread 2");
		t1.start();
		t2.start();
		// main thread will wait for both threads to get completed
		t1.join();
		t2.join();
		System.out.println(c.count);
	}

	public static void ex3() throws InterruptedException {
		AtomicCounter c = new AtomicCounter();
		Thread t1 = new Thread(c, "Thread 1");
		Thread t2 = new Thread(c, "Thread 2");
		t1.start();
		t2.start();
		// main thread will wait for both threads to get completed
		t1.join();
		t2.join();
		System.out.println(c.count);
	}

	public static void main(String[] args) throws InterruptedException {
		// ex1();
		ex2();
		ex3();
	}

}
