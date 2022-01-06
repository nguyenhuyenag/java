package common.util.time;

import java.util.Calendar;
import java.util.Date;

public class AfterDateTime {

	private Date get(int timeType, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(timeType, amount);
		return calendar.getTime();
	}

	public Date minute(int amount) {
		return get(Calendar.MINUTE, amount);
	}

	public Date day(int amount) {
		return get(Calendar.DATE, amount);
	}

}
