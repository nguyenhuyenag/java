package com.v9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Immutable {

	public static void beforeJava9() {
		List<String> imtList = Arrays.asList("a", "b", "c");
		imtList = Collections.unmodifiableList(imtList);
		imtList.forEach(t -> System.out.println(t));
		imtList.add("E"); // -> UnsupportedOperationException
	}
	
	// List.of(), Set.of(), Map.of()
	public static void fromJava9() {
		List<String> imtList = List.of("A", "B", "C", "D");
		imtList.forEach(t -> System.out.println(t));
		imtList.add("E"); // -> UnsupportedOperationException
	}

	public static void ex2() {
		List<String> imtList1 = List.of("A1", "B1", "C1");
		List<String> imtList2 = List.of("A2", "B2", "C2");
		List<List<String>> imtFinalList = List.of(imtList1, imtList2);
		System.out.println(imtFinalList);
	}
	
	public static void ex3() {
		Map<String, Integer> stringMap = Map.of("a", 1, "b", 2, "c", 3);
		System.out.println(stringMap);
	}

	public static void main(String[] args) {
		// fromJava9();
		// ex2();
		ex3();
	}

}
