package common.util.time;

public class TimeUtils {

	private TimeUtils() {

	}

	public static BeforeDateTime before() {
		return new BeforeDateTime();
	}

	public static AfterDateTime after() {
		return new AfterDateTime();
	}

}
