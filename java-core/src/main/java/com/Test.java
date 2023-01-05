package com;

import common.object.User;

public class Test {

	static void swap(User u1, User u2) {
		User t = u1;
		u1 = u2;
		u2 = t;
	}

	public static void main(String[] args) {
		User j = new User(25, "Java");
		User m = new User(20, "MYSQL");
		swap(j, m);
		System.out.println(j.getName());
	}

}
