package util;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// List<String> list = List.of("a", "b", "c", "d");
		
		List<Integer> list = List.of(1, 2, 3, 4,5 );
		
		list.forEach(t -> System.out.println(t));
		
		list.add(6);
	}

}
