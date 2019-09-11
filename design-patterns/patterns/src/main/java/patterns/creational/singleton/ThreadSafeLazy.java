package patterns.creational.singleton;

public class ThreadSafeLazy {

	private static volatile ThreadSafeLazy instance;

	private ThreadSafeLazy() {

	}

	public static synchronized ThreadSafeLazy getInstance() {
		if (instance == null) {
			instance = new ThreadSafeLazy();
		}
		return instance;
	}

}
