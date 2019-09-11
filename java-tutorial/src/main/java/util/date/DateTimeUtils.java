package util.date;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {

	public static String asDate(Date date) {
		String pattern = "dd-MM-yyyy HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static void main(String[] args) {

		Date date = new Date();
		
		//System.out.println(asDate(date));
		
		//Date date = new Date();
	    LocalDate ldate = LocalDate.from(date.toInstant().atZone(ZoneOffset.UTC));
	    String s = DateTimeFormatter.ISO_DATE.format(ldate); // uuuu-MM-dd

	    System.out.println(s);
	    
	}

}
