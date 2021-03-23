package com.collection.iterable;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Xem thêm ListIterators.java
 */
public class IterableLoop {

	public static void loopByWhile(Iterable<Integer> iterable) {
		Iterator<Integer> itr = iterable.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
	}

	public static void loopByForEach(Iterable<Integer> iterable) {
		iterable.forEach(t -> System.out.print(t + " "));
	}

	public static void main(String[] args) {
		Iterable<Integer> iterable = Arrays.asList(1, 2, 3, 4, 5);
		// loopByWhile(iterable);
		loopByForEach(iterable);
	}

}
