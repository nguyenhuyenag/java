package com.basic.time.other;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortStringDateTime {
	
	public static void main(String[] args) {
		List<String> dtStrings = Arrays.asList(
		  "01/20/2013 06:16",
		  "01/20/2013 10:48",
		  "01/21/2013 10:41",
		  "01/21/2013 16:37",
		  "01/21/2013 17:16",
		  "01/21/2013 17:19",
		  "01/22/2013 06:19",
		  "01/22/2013 15:13"
		);
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		Collections.sort(dtStrings, new Comparator<String>() {
			@Override
			public int compare(String d1, String d2) {
				try {
					return format.parse(d1).compareTo(format.parse(d2));
				} catch (ParseException e) {
					throw new IllegalArgumentException(e);
				}
			}
		});
		
		// OR
		final DateTimeFormatter dfm2 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		dtStrings.sort(Comparator.comparing(s -> LocalDateTime.parse(s, dfm2)));
		
		// OR
		// DateTimeFormatter dfm3 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
		Map<LocalDateTime, String> dateFormatMap = new TreeMap<>();
		dtStrings.forEach(s -> dateFormatMap.put(LocalDateTime.parse(s, dfm2), s));
		List<String> result = new ArrayList<>(dateFormatMap.values());
		System.out.println(result.toArray());
	}
	
}
