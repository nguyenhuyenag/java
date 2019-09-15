package basic;

import java.text.ParseException;
import java.util.Date;

import common.util.DateTimeUtils;

public class AMain {

	public static void main(String[] args) throws ParseException {
		String str = "2018-08-08 08:08:08";
		Date date = DateTimeUtils.asDate(str, DateTimeUtils.YYYYMMDD_HHMMSS);
		System.out.println(DateTimeUtils.formatDate(date));
	}
}
