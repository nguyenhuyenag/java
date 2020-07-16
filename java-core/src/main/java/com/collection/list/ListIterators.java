package com.collection.list;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class ListIterators {

	public static void main(String[] args) throws Exception {
		List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5);
		
		ListIterator<Integer> itr = list.listIterator();

		// Duyệt xuôi
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();

		// Duyệt ngượcc
		while (itr.hasPrevious()) {
			System.out.print(itr.previous() + " ");
		}
	}

}


