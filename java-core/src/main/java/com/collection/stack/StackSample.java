package com.collection.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackSample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.addAll(Arrays.asList(1, 2, 3, 4, 5));
		System.out.println(stack);
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}

}
