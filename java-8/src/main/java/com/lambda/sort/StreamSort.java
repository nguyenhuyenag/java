package com.lambda.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.util.User;

public class StreamSort {

	public static List<User> init() {
		List<User> list = new ArrayList<>();
		list.add(new User("Jame", 5));
		list.add(new User("Aman", 5));
		list.add(new User("Rahul", 40));
		list.add(new User("Dan", 27));
		list.add(new User("Dan", 17));
		list.add(new User("Shekhar", 26));
		list.add(new User("Amitabh", 20));
		list.add(new User("Shahrukh", 18));
		return list;
	}

	public static void sort(List<User> list) {
		// list.sort(Comparator.comparing(User::getAge));
		// list.sort((u1, u2) -> u1.getAge() - u2.getAge());
		Collections.sort(list, (u1, u2) -> u1.getAge() - u2.getAge());
		System.out.println(list);
	}

	public static void sortMiltipleValue(List<User> list) {
		Comparator<User> comparing = Comparator.comparing(User::getName) //
				.thenComparing(Comparator.comparing(User::getAge));
		list.sort(comparing);
		// list.stream().sorted(comparing); // <- Return a new list
		System.out.println(list);
	}

	public static void main(String[] args) {
		List<User> list = init();
		// sort(list);
		sortMiltipleValue(list);
	}

}
