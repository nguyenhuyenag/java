package com.v16;

import lombok.Data;

@Data
class Journaldev {

	String author;

}

public class PatternMatchingInstanceOf {

	public static void oldStyle() {
		Object obj = new Object();
		if (obj instanceof Journaldev) {
			Journaldev jd = (Journaldev) obj;
			System.out.println(jd.getAuthor());
		}
	}

	public static void newStyle() {
		Object object = "";
		if (object instanceof String str && str.length() > 5) {
			System.out.println(str);
		}
	}

	public static void main(String[] args) {
		// oldStyle();
		newStyle();
	}

}
