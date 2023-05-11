package com.collection.generic;

import java.util.Arrays;

// Interface generic
interface ISort<T> {
	void sort(T[] array);
}

// Implements
class ISortImpl<T> implements ISort<T> {

	@Override
	public void sort(T[] array) {
		System.out.println("Before:\t" + Arrays.toString(array));
		Arrays.sort(array);
		System.out.println("After:\t" + Arrays.toString(array));
	}

}

// Use
public class InterfaceGeneric<T> extends ISortImpl<T> {

	public static void main(String[] args) {

		// Sort String
		String[] array = { "1", "a", "2", "b" };
		InterfaceGeneric<String> sSort = new InterfaceGeneric<>();
		sSort.sort(array);

		// Sort Integer
		// int[] arr = { 1, 3, 5}; // <- error
		Integer[] arr = { 1, 3, 5, 7, 9, 2 };
		InterfaceGeneric<Integer> iSort = new InterfaceGeneric<>();
		iSort.sort(arr);
	}

}
