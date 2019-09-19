package patterns.creational.singleton.init;

public class ThreadSafeUpgrade {

	private static volatile ThreadSafeUpgrade instance;

	private ThreadSafeUpgrade() {

	}

	public static ThreadSafeUpgrade getInstance() {
		if (instance == null) {
			synchronized (ThreadSafeUpgrade.class) {
				if (instance == null) {
					instance = new ThreadSafeUpgrade();
				}
			}
		}
		return instance;
	}

}
