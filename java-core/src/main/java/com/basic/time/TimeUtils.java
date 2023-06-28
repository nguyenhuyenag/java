package com.basic.time;
//package common.util;
//
//public class TimeUtils {
//
//	private TimeUtils() {
//
//	}
//
////	public static Date now() {
////		return new Date();
////	}
////
////	public static BeforeDateTime before() {
////		return BeforeDateTime.getInstance();
////	}
////
////	public static AfterDateTime after() {
////		return AfterDateTime.getInstance();
////	}
////
////	public static String format(Date date, String pattern) {
////		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
////		return sdf.format(date);
////	}
//
////	private static class Handle {
////
////		private Date get(int timeType, int amount) {
////			Calendar calendar = Calendar.getInstance();
////			calendar.add(timeType, amount);
////			return calendar.getTime();
////		}
////
////		public Date day(int amount) {
////			return get(Calendar.DATE, amount);
////		}
////
////		public Date minute(int amount) {
////			return get(Calendar.MINUTE, amount);
////		}
////
////		public Date second(int amount) {
////			return get(Calendar.SECOND, amount);
////		}
////
////	}
//
////	public static class AfterDateTime extends Handle {
////
////		private AfterDateTime() {
////
////		}
////
////		private static class SingletonHelper {
////			private static final AfterDateTime INSTANCE = new AfterDateTime();
////		}
////
////		static AfterDateTime getInstance() {
////			return SingletonHelper.INSTANCE;
////		}
////
////	}
////
////	public static class BeforeDateTime extends Handle {
////
////		private BeforeDateTime() {
////
////		}
////
////		private static class SingletonHelper {
////			private static final BeforeDateTime INSTANCE = new BeforeDateTime();
////		}
////
////		static BeforeDateTime getInstance() {
////			return SingletonHelper.INSTANCE;
////		}
////	}
//
////	public static void main(String[] args) {
////		Date after = TimeUtils.after().day(1);
////		Date before = TimeUtils.before().day(1);
////		System.out.println(after);
////		System.out.println(before);
////	}
//
////	private Date get(int timeType, int amount) {
////		Calendar calendar = Calendar.getInstance();
////		calendar.add(timeType, amount);
////		return calendar.getTime();
////	}
//
////	public static Date before(TimeUnit unit, int amount) {
////		long time = unit.toMillis(amount);
////		return new Date(System.currentTimeMillis() - time);
////	}
////
////	public static Date after(TimeUnit unit, int amount) {
////		long time = unit.toMillis(amount);
////		return new Date(System.currentTimeMillis() + time);
////	}
//	
////	/**
////	 * Get later date
////	 * <pre>
////	 * getLaterDate(ONE_HOURS)		= 1 giờ sau
////	 * getLaterDate( ONE_DAYS )		= 1 ngày sau
////	 * </pre>
////	 * @param amounts là thời gian
////	 * @return Date
////	 */
////	private static Date later(int amount) {
////		// return new Date(System.currentTimeMillis() + amounts);
////		Calendar calendar = Calendar.getInstance();
////		calendar.add(Calendar.HOUR, amount);
////		return calendar.getTime();
////	}
//	
////	public static enum CalendarEnums {
////		HOUR, MINUTE, SECOND;
////	}
////	
////	public static Date later(CalendarEnums ce, int amount) {
////		// return new Date(System.currentTimeMillis() + amounts);
////		Calendar calendar = Calendar.getInstance();
////		switch (ce) {
////			case HOUR:
////				calendar.add(Calendar.HOUR, amount);
////				break;
////			case MINUTE:
////				calendar.add(Calendar.MINUTE, amount);
////				break;
////			case SECOND:
////				calendar.add(Calendar.SECOND, amount);
////				break;
////			default:
////				break;
////		}
////		return calendar.getTime();
////	}
//
////	public static void main(String[] args) {
////		Date date = new Date();
////		Date before = before(TimeUnit.HOURS, 2);
////		Date after = after(TimeUnit.HOURS, 1);
////		System.out.println("Now:\t" + DateTimeUtils.format(date, "dd-MM-yyyy HH:mm:ss"));
////		System.out.println("Before:\t" + DateTimeUtils.format(before, "dd-MM-yyyy HH:mm:ss"));
////		System.out.println("After:\t" + DateTimeUtils.format(after, "dd-MM-yyyy HH:mm:ss"));
////	}
//
//}
