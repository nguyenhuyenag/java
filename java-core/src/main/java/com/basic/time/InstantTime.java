//package com.basic.time;
//
//import java.time.Instant;
//import java.time.ZoneId;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//
//public class InstantTime {
//
//	public static void main(String[] args) {
//		Instant instant = Instant.now();
//		System.out.println("Now: " + instant);
//
//		// Add & minus time by unit
//		Instant plus = instant.plus(30, ChronoUnit.DAYS);
//		Instant minus = instant.plus(20, ChronoUnit.DAYS);
//		System.out.println("Adding 30 DAYS: " + plus);
//		System.out.println("Minus 20 DAYS: " + minus);
//
//		// Add & minus time by second
//		instant = Instant.now().plusSeconds(84000);
//		instant = Instant.now().minusSeconds(84000);
//
//		// Format
//		DateTimeFormatter formatter = DateTimeFormatter //
//				.ofPattern("yyyy-MM-dd HH:mm:ss") //
//				.withZone(ZoneId.systemDefault());
//		String instantStr = formatter.format(instant);
//		System.out.println("Instant in String format: " + instantStr);
//		
//		// Get range of MILLI_OF_SECOND field
//		// ValueRange milliRange = Instant.now().range(ChronoField.MILLI_OF_SECOND);
//		// System.out.println("Range of MILLI_OF_SECOND: " + milliRange);
//		
//		Instant instant2 = Instant.now().plusMillis(1000);
//		System.out.println(instant.equals(instant2));
//		System.out.println(instant.isAfter(instant2));
//		System.out.println(instant.isBefore(instant2));
//	}
//
//}
