package com;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	static int totalThreads = 4;

	static void split1(List<Integer> list) {
		int totalMessages = list.size();
		int msgPerThread = totalMessages / totalThreads;
		if (msgPerThread == 0) {
			msgPerThread = totalMessages;
		}
		if (totalThreads > totalMessages) {
			totalThreads = 1;
		}
		for (int i = 0; i < totalThreads; i++) {
			System.out.println(
					Arrays.toString(list.subList(msgPerThread * i, msgPerThread * i + msgPerThread).toArray()));
		}
	}

	public static <T> void splitList(List<T> list, int page) {
		int total = list.size();
		if (total % page == 0) {
			int start = 0, end = page;
			while (end <= total) {
				List<T> subList = list.subList(start, end);
				start = end;
				end = start + page;
				System.out.println(Arrays.toString(subList.toArray()));
			}
		} else {
			System.out.println("Lẻ");
			System.out.println(total / page);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = IntStream.rangeClosed(1, 10) //
				.boxed() //
				.collect(Collectors.toList());
		System.out.println(Arrays.toString(list.toArray()));
		splitList(list, 3);
		// (page - 1)*x
	}

}
