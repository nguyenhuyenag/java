package com.collection.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Stack (ngăn xếp): Hoạt động theo cơ chế LIFO (last in first out)
 */
public class StackApi {

	public static void stackApi() {
		Stack<Integer> stack = new Stack<>();
		stack.addAll(Arrays.asList(1, 2, 1, 3));

		// Thêm phần tử vào đỉnh
		stack.push(0);

		// Lấy & xóa phần tử ở đỉnh, EmptyStackException nếu stack rỗng
		stack.pop();

		// Tương tự pop() nhưng không xóa
		stack.peek();

		// Kiểm tra stack rỗng
		stack.empty();

		// Trả về vị trí gần đỉnh nhất của phần tử cần tìm, -1 nếu không tìm thấy
		stack.search(1);

		System.out.println(stack);
	}

	public static void main(String[] args) {
		stackApi();
	}

}
