package com.basic.time;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * Java Locale List: https://www.viralpatel.net/java-locale-list-tutorial/
 */
public class ListTimeZone {

	public static void list3() {
		Locale locales[] = SimpleDateFormat.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			Locale c = locales[i];
			if (StringUtils.isNotEmpty(c.toString())) {
				System.out.printf("%10s - %s, %s \n", c.toString(), c.getDisplayName(), c.getDisplayCountry());
			}
		}
	}

	public static void list1() {
		boolean SORT_BY_REGION = true;
		Map<String, String> sortedMap = new LinkedHashMap<>();
		Map<String, String> allZoneIdsAndItsOffSet = getAllZoneIdsAndItsOffSet();
		// sort map by key
		if (SORT_BY_REGION) {
			allZoneIdsAndItsOffSet.entrySet().stream().sorted(Map.Entry.comparingByKey())
					.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
		} else {
			// sort by value, descending order
			allZoneIdsAndItsOffSet.entrySet().stream().sorted(Map.Entry.<String, String>comparingByValue().reversed())
					.forEachOrdered(e -> sortedMap.put(e.getKey(), e.getValue()));
		}
		// print map
		sortedMap.forEach((k, v) -> {
			String out = String.format("UTC%s / %s %n", v, k);
			System.out.printf(out);
		});
	}

	public static void list2() {
		List<String> zoneIds = ZoneId.getAvailableZoneIds().stream()
				.sorted()
				.collect(Collectors.toList());
		for (String zoneId : zoneIds) {
			ZoneId zone = ZoneId.of(zoneId);
			ZonedDateTime now = ZonedDateTime.now(zone);
			String timeZone = now.getOffset().toString();
			// timeZone = timeZone.replaceFirst("^([+-]\\d{2}):(00)$", "$1");
			String formattedLine = String.format("%-30s | %s", zoneId, timeZone);
			System.out.println(formattedLine);
		}
	}

	private static Map<String, String> getAllZoneIdsAndItsOffSet() {
		Map<String, String> result = new HashMap<>();
		LocalDateTime localDateTime = LocalDateTime.now();
		for (String zoneId : ZoneId.getAvailableZoneIds()) {
			ZoneId id = ZoneId.of(zoneId);
			// LocalDateTime -> ZonedDateTime
			ZonedDateTime zonedDateTime = localDateTime.atZone(id);
			// ZonedDateTime -> ZoneOffset
			ZoneOffset zoneOffset = zonedDateTime.getOffset();
			// Replace Z to +00:00
			String offset = zoneOffset.getId().replaceAll("Z", "+00:00");
			result.put(id.toString(), offset);
		}
		return result;
	}

	public static void VNAndUTC() {
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		DateTimeFormatter ft = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		System.out.println("UTC = " + utc.format(ft));
		ZonedDateTime vn = ZonedDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
		System.out.println("Viet Nam = " + vn.format(ft));
	}

	public static void main(String[] args) {
		list1();
		list2();
		list3();
		// VNAndUTC();
	}

}
