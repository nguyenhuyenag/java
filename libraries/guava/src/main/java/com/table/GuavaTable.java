package com.table;

import java.util.Map;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

@SuppressWarnings("unused")
public class GuavaTable {

	public static void main(String[] args) {
		Table<String, String, Integer> universityCourseSeatTable = HashBasedTable.create();
		universityCourseSeatTable.put("Mumbai", "Chemical", 120);
		universityCourseSeatTable.put("Mumbai", "IT", 60);
		universityCourseSeatTable.put("Harvard", "Electrical", 60);
		universityCourseSeatTable.put("Harvard", "IT", 120);

		int seatCount = universityCourseSeatTable.get("Mumbai", "IT");
		Integer seatCountForNoEntry = universityCourseSeatTable.get("Oxford", "IT");
		boolean entryIsPresent = universityCourseSeatTable.contains("Mumbai", "IT");
		boolean courseIsPresent = universityCourseSeatTable.containsColumn("IT");
		boolean universityIsPresent = universityCourseSeatTable.containsRow("Mumbai");
		boolean seatCountIsPresent = universityCourseSeatTable.containsValue(60);
		int remove = universityCourseSeatTable.remove("Mumbai", "IT");

		Map<String, Integer> universitySeatMap = universityCourseSeatTable.column("IT");
	}

}
