package com.stream;

import java.util.Arrays;
import java.util.List;

/*-
 * 	
 *		T result = stream.reduce(T identity, BinaryOperator<T> accumulator);
 * 
 * 		<U> U reduce(U identity, 
 *            			BiFunction<U,? super T,U> accumulator, 
 *            			BinaryOperator<U> combiner);
 * 
 * Với:
 * 
 * + identity 	 -> Giá trị khởi tạo của phép tính tổng hợp. Nó là giá ban đầu của
 * 				 	reduction operation. Mặc khác nó cũng là giá trị mặc định khi Stream rỗng.
 * 
 * + accumulator -> Hàm tích luỹ, được thực hiện trên từng phần tử của Stream.
 * 					Hàm này có kiểu dữ liệu là BiFunction<T, ? super U, T> với T là kiểu dữ liệu
 * 					của phần tử trong Stream, và U là kiểu dữ liệu của identity.
 */
public class Reduce {

	public static void findSum() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int result = numbers //
				.stream() //
				.reduce(0, (subtotal, element) -> {
					System.out.println("subtotal: " + subtotal + ", element: " + element);
					return subtotal + element;
				});
		
		System.out.println("Sum: " + result);
	}

	public static void findMax() {
		List<Integer> numbers = Arrays.asList(11, 13, 9, 20, 7, 3, 30);
		int result = numbers //
				.stream() //
				.reduce(Integer.MIN_VALUE, (max, element) -> {
					System.out.println("Max: " + max + ", element: " + element);
					return Math.max(max, element);
				});
		
		// Optional<Integer> max = numbers.stream().reduce(Integer::max);
		System.out.println("Max: " + result);
	}

	public static void main(String[] args) {
		// findSum();
		findMax();
	}

}
