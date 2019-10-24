package learn.basic;

import java.util.concurrent.TimeUnit;

public class Sleep {

	public static void useTimeUnit() {
		try {
			for (int i = 1; i <= 3; i++) {
				System.out.println(i + "\nWaiting...");
				// Pause for 1 second
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void useThread() {
		try {
			for (int i = 1; i <= 3; i++) {
				System.out.println(i + "\nWaiting...");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// useThread();
		useTimeUnit();
	}

}
