package com.basic.time;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * Java Locale List: https://www.viralpatel.net/java-locale-list-tutorial/
 */
public class LocaleList {

	public static void test1() {
		Locale locales[] = SimpleDateFormat.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			Locale c = locales[i];
			if (StringUtils.isNotEmpty(c.toString())) {
				System.out.printf("%10s - %s, %s \n", c.toString(), c.getDisplayName(), c.getDisplayCountry());
			}
		}
	}
	
	public static void test2() {
		System.out.println("List of all ZoneIds:");
		List<String> zoneIds = ZoneId.getAvailableZoneIds().stream().sorted().toList();
        for (String zoneId : zoneIds) {
            // System.out.println(zoneId);
        	ZoneId zone = ZoneId.of(zoneId);
            ZonedDateTime now = ZonedDateTime.now(zone);
            String timeZone = now.getOffset().toString();
            System.out.println(zoneId + " (" + timeZone + ")");
        }
	}
	
	public static void main(String[] args) {
		test2();
	}

}
