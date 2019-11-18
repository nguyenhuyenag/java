package com.basic.thread;

/**
 * Sau khi start một thread, sẽ không start lại được nữa. Nếu không sẽ xảy ra
 * ngoại lệ IllegalThreadStateException
 */
public class TheadSimple extends Thread {

	@Override
	public void run() {
		System.out.println("Extend thread ...");
	}

	public static void main(String[] args) {
		TheadSimple t = new TheadSimple();
		t.start();
	}

}
