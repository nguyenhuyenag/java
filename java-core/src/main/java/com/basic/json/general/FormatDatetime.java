package com.basic.json.general;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.util.JSONUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormatDatetime {

	private String name;
	private Date eventDate;

	public static void main(String[] args) throws IOException, ParseException {
		test1();
		test2();
	}

	/**
	 * Mặc định Jackson sẽ chuyển Date sang Timestamp (long) tính từ 01 – 01 – 1970
	 * UTC khi serialize sang Json
	 */
	public static void test1() throws IOException, ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm");
		// df.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date date = df.parse("01-01-2020 00:00");
		FormatDatetime event = new FormatDatetime("party", date);
		System.out.println(JSONUtils.toJSON(event));
	}

	public static void test2() throws IOException, ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
		// String toParse = "20-12-2014 02:30";
		Date date = df.parse("20-12-2022 02:30");
		FormatDatetime event = new FormatDatetime("party", date);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(df);
		String result = mapper.writeValueAsString(event);
		System.out.println(result);

	}

}
