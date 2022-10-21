package com.basic.thread;

public class VolatileExample {

	private volatile static int COUNT = 0; // chay chuong trinh khi co va khong co volatile

	public static void main(String[] args) {
		new ChangeListener().start();
		new ChangeMaker().start();
	}

	static class ChangeMaker extends Thread {
		@Override
		public void run() {
			int i = 0;
			while (COUNT < 5) {
				System.out.println("Increasing value of count variable to " + (i + 1));
				COUNT = ++i;
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int value = COUNT;
			// Khi giá trị của biến COUNT nhỏ hơn 5, thread này sẽ lặp mãi mãi để kiểm tra
			// giá trị của biến này
			while (value < 5) {
				if (value != COUNT) {
					System.out.println("Count variable changed to : " + COUNT);
					value = COUNT;
				}
			}
		}
	}
}
