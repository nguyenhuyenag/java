package com.basic.thread.basic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Thread bị ngắt (interrupted) bởi một thread khác
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThreadInterrupt implements Runnable {

	private String threadname;

	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.println("This is message #" + i);
			try {
				Thread.sleep(1000);
				continue;
			} catch (InterruptedException ex) {
				System.out.println("I'm resumed");
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new ThreadInterrupt());
		t1.start();
		try {
			Thread.sleep(3000);
			t1.interrupt();
		} catch (InterruptedException ex) {

		}
	}
}