package com.basic.thread;

public class RunnableSimple implements Runnable {

	@Override
	public void run() {
		System.out.println("Implement runnable ...");
	}

	public static void main(String[] args) {
		RunnableSimple r = new RunnableSimple();
		Thread t = new Thread(r);
		t.start();
	}

}
