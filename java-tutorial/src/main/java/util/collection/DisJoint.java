package util.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DisJoint {

	public static void main(String[] args) {

		// create two lists
		List<String> src = new ArrayList<String>(5);
		List<String> des = new ArrayList<String>(10);

		// populate two lists
		src.add("Java");
		src.add("is");
		src.add("best");

		des.add("C++");
		des.add("is not");
		des.add("older");

		// check elements in both collections
		boolean iscommon = Collections.disjoint(src, des);
		System.out.println("No commom elements: " + iscommon);

	}

}
