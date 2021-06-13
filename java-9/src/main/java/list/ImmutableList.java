package list;

import java.util.List;

public class ImmutableList {

	public static void ex1() {
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

	public static void main(String[] args) {
		// ex1();
		ex2();
	}

}
