package com.basic.time;

import static org.apache.commons.lang3.time.DateUtils.parseDateStrictly;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class FormatWithManyPattern {

	public static void parseDate() {
		String date = "2022-12-04";
		DateTimeFormatterBuilder dateTimeFormatterBuilder = new DateTimeFormatterBuilder()
				.append(DateTimeFormatter.ofPattern("[MM/dd/yyyy]" + "[dd-MM-yyyy]" + "[yyyy-MM-dd]"));
		DateTimeFormatter dateTimeFormatter = dateTimeFormatterBuilder.toFormatter();
		LocalDate parse = LocalDate.parse(date, dateTimeFormatter);
		System.out.println(parse);
	}

	public static void apacheCommonsDateUtils() throws ParseException {
		Date date = parseDateStrictly("2022-12-29", "yyyy/MM/dd", "dd/MM/yyyy", "yyyy-MM-dd");
		System.out.println(date);
	}

	public static void main(String[] args) throws ParseException {
		// parseDate();
		apacheCommonsDateUtils();
	}

}
