package com.collection.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Stack (ngăn xếp) với cơ chế vào sau ra trước (last in first out)
 */
public class StackSample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.addAll(Arrays.asList(1, 2, 3, 4, 5));
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}

}
