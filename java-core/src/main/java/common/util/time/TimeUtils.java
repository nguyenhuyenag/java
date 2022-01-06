package common.util.time;

import java.util.Date;

public class TimeUtils {

	private TimeUtils() {

	}

	public static BeforeDateTime before() {
		return BeforeDateTime.getInstance();
	}

	public static AfterDateTime after() {
		return AfterDateTime.getInstance();
	}

	public static void main(String[] args) {
		Date after = TimeUtils.after().day(1);
		Date before = TimeUtils.before().day(1);
		System.out.println(after);
		System.out.println(before);
	}

}
