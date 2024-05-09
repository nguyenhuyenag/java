package basic.enums;

import java.util.EnumMap;

public class EnumCollectionMap {

	private enum Days {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
	}

	public static void main(String[] args) {
		EnumMap<Days, String> tasks = new EnumMap<>(Days.class);

		// Thêm các nhiệm vụ cho các ngày trong tuần
		tasks.put(Days.MONDAY, "Clean the house");
		tasks.put(Days.TUESDAY, "Go grocery shopping");
		tasks.put(Days.WEDNESDAY, "Attend a meeting");
		tasks.put(Days.THURSDAY, "Finish report");
		tasks.put(Days.FRIDAY, "Prepare for presentation");

		// In ra nhiệm vụ của mỗi ngày
		for (Days day : Days.values()) {
			System.out.println(day + ": " + tasks.get(day));
		}

		// Kiểm tra xem một ngày có trong EnumMap hay không
		if (tasks.containsKey(Days.SATURDAY)) {
			System.out.println("Saturday is present in the EnumMap");
		} else {
			System.out.println("Saturday isn't present in the EnumMap");
		}

		// Xóa một nhiệm vụ
		tasks.remove(Days.WEDNESDAY);

		// In ra nhiệm vụ của mỗi ngày sau khi xóa
		System.out.println("Tasks after removal:");
		for (Days day : Days.values()) {
			System.out.println(day + ": " + tasks.get(day));
		}
	}

}
