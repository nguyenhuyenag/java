package com.basic.thread.create;

public class UsingRunnable implements Runnable {

	@Override
	public void run() {
		System.out.println("Running thread");
	}

	public static void main(String args[]) {
		Runnable r1 = new UsingRunnable();
		r1.run();
	}

}
