package com.iterface.fp.predicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RemoveIf {

	/**
	 * Lệnh removeIf sẽ thực hiện duyệt từng phần tử, nếu method test của Predicate
	 * trả về true thì sẽ remove phần tử đó khỏi list
	 */
	public static <T> void removeWithLambda(List<T> list, Predicate<T> p) {
		list.removeIf(t -> p.test(t));
	}

//	public static <T> void removeWithoutLambda(List<T> list, Predicate<T> p) {
//		list.removeIf(new Predicate<T>() {
//			@Override
//			public boolean test(T t) {
//				return p.test(t);
//			}
//		});
//	}

	public static <T> List<T> eval(List<T> list, Predicate<T> p) {
		return list.stream()  //
				.filter(t -> p.test(t)) //
				.toList();
	}

	// filter() = !removeIf()
	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.addAll(Arrays.asList(-1, 2, 0, 3, 8, 4 - 9, 11, -3, 10, -22, 27));

		/**
		 * filter() -> Return a new list
		 */
		// Predicate<Integer> conditon = t -> true; 		// pass all
		// Predicate<Integer> conditon = t -> t % 2 != 0;	// odd number
		nums = eval(nums, t -> t % 2 == 0); 				// even numbers

		/**
		 * removeIf() -> Return this list
		 */
		// removeWithLambda(nums, t -> t < 0); 				// remove negative numbers
		// removeWithLambda(nums, t -> t > 0); 				// remove positive numbers
		
		System.out.println(nums);
	}

}
