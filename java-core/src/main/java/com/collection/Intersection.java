package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

/*-
 * - Tìm giao của 2 Collection
 * 
 * 0 có trong listA, có trong listB => giữa lại
 * 2 có trong listA, có trong listB => giữ lại
 * 4 có trong listA, không có trong listB => xóa
 * 
 * Kết quả = [0, 2]
 */
public class Intersection {

	static List<Integer> listA = new ArrayList<>(Arrays.asList(0, 2, 4));
	static List<Integer> listB = new ArrayList<>(Arrays.asList(0, 1, 2, 3));

	/*-
	 * Xóa những phần tử của A không có trong B
	 *	0 có trong listA, có trong listB => giữa lại
	 * 	2 có trong listA, có trong listB => giữ lại
	 * 	4 có trong listA, không có trong listB => xóa
	 * 	=> kết quả là [0, 2]
	 */
	public static void useRetainAll() {
		listA.retainAll(listB);
	}

	// for loop
	public static void other() {
		ArrayList<Integer> common = new ArrayList<>();
		for (int temp : listA) {
			if (listB.contains(temp)) {
				common.add(temp);
			}
		}
		System.out.println("Common elements: " + common);
	}

	// stream api
	public static void useStreamApi() {
		listA.stream().filter(listB::contains).collect(Collectors.toList());
	}

	// apache commons
	public static void useApacheCommons() {
		CollectionUtils.intersection(listA, listB);
	}

	public static void main(String[] args) {
		System.out.println("A = " + listA);
		System.out.println("B = " + listB);
		listA.retainAll(listB);
		System.out.println("A = " + listA);
	}
}
