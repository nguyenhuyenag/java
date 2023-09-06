package com.basic.passed;

import common.object.User;

/**
 * Tham số kiểu tham chiếu
 */
public class ByReference {

	public static void toDo(User user) {
		user.setAge(2000);
	}

	public static void main(String[] args) throws Exception {
		User user = new User("Java", 1995);
		System.out.println("Before: " + user.getAge());
		toDo(user);
		System.out.println("After: " + user.getAge());
	}

}
