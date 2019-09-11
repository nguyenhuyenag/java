package patterns.creational.singleton;

public class ThreadSafeUpgrade {

	private static volatile ThreadSafeUpgrade instance;

	private ThreadSafeUpgrade() {

	}

	public static ThreadSafeUpgrade getInstance() {
		// Do something before get instance ...
		if (instance == null) {
			// Do the task too long before create instance ...
			// Block so other threads cannot come into while initialize
			synchronized (ThreadSafeUpgrade.class) {
				// Re-check again. Maybe another thread has initialized before
				if (instance == null) {
					instance = new ThreadSafeUpgrade();
				}
			}
		}
		// Do something after get instance ...
		return instance;
	}

}
