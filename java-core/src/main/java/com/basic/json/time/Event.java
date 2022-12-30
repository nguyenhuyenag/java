package com.basic.json.time;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import common.util.JSONUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {

	private String name;
	private Date eventDate;

	/**
	 * Mặc định Jackson sẽ chuyển Date sang Timestamp (tính từ 01 – 01 – 1970 UTC)
	 * khi serialize sang Json
	 */
	public static void main(String[] agrs) throws IOException, ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		df.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date date = df.parse("01-01-1970 01:00");
		Event event = new Event("party", date);
		
		System.out.println(JSONUtils.toJSON(event));
	}

}
