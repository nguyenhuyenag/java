package com.basic.json.time;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DateFormatOM {

	public static void main(String[] agrs) throws IOException, ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

		String toParse = "20-12-2014 02:30";
		Date date = df.parse(toParse);
		Event event = new Event("party", date);

		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(df);

		String result = mapper.writeValueAsString(event);
		System.out.println(result);

	}

}
