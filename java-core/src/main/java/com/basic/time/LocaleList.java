package com.basic.time;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;

/**
 * Java Locale List: https://www.viralpatel.net/java-locale-list-tutorial/
 */
public class LocaleList {

	public static void main(String[] args) {
		Locale locales[] = SimpleDateFormat.getAvailableLocales();
		for (int i = 0; i < locales.length; i++) {
			Locale c = locales[i];
			if (StringUtils.isNotEmpty(c.toLanguageTag())) {
				System.out.printf("%10s - %s, %s \n", c.toString(), c.getDisplayName(), c.getDisplayCountry());
			}
		}
	}

}
