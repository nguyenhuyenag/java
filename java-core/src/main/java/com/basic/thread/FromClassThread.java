package com.basic.thread;

/**
 * Có 2 cách tạo thread là `extends Thread` hoặc `implements Runnable`
 */
public class FromClassThread extends Thread {

	@Override
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(i);
				Thread.sleep(100); // thread sleep
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Hết giờ");
	}

	public static void cach1() {
		FromClassThread c = new FromClassThread();
		Thread t = new Thread(c);
		t.start();
	}

	public static void cach2() {
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					for (int i = 5; i > 0; i--) {
						System.out.println(i);
						Thread.sleep(100); // thread sleep
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hết giờ");
			}
		};
		t.start();
	}

	public static void main(String args[]) {
		// cach1();
		cach2();
	}

}
