package com.lambda.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.util.User;

public class SortNatural {

	public Comparator<User> comparing() {
		return Comparator.comparing(User::getName) //
				.thenComparing(User::getAge);
	}

	public void sortMiltipleValue(List<User> list) {
		// list.sort(comparing());
		// list.sort(User::compareByNameThenAge);
		list = list.stream().sorted(comparing()).toList(); // <- Return a new list
		System.out.println(list);
	}

	public void sort(List<User> list) {
		// list.sort(Comparator.comparing(User::getAge));
		// list.sort((u1, u2) -> u1.getAge() - u2.getAge());
		// Collections.sort(list, Comparator.comparing(User::getName));
		Collections.sort(list, (u1, u2) -> u1.getAge() - u2.getAge());
		System.out.println(list);
	}

}
