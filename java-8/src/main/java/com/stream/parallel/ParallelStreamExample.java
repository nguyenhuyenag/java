package com.stream.parallel;

import java.util.Arrays;
import java.util.logging.Logger;


public class ParallelStreamExample {
	
	private static Logger LOG = Logger.getLogger(ParallelStreamExample.class.getName());
	
	public static void main(String[] args) {
		// Tạo một luồng từ một mảng
		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Arrays.stream(numbers) //
				.parallel() // Chuyển đổi thành luồng song song
				.forEach(t -> LOG.info(String.valueOf(t)));
	}

}
