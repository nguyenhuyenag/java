package com.lambda.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Human {

	private String name;
	private int age;

	public Human(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static int compareByNameThenAge(Human lhs, Human rhs) {
		if (lhs.name.equals(rhs.name)) {
			return lhs.age - rhs.age;
		} else {
			return lhs.name.compareTo(rhs.name);
		}
	}
}

public class SortWithoutLambda {

	public static void main(String[] args) {

		List<Human> list = Arrays.asList(new Human("Sarah", 10), new Human("Jack", 12));

		list.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
		list.sort(Human::compareByNameThenAge);
		Collections.sort(list, Comparator.comparing(Human::getName));

		// reversed
		Comparator<Human> comparator = (h1, h2) -> h1.getName().compareTo(h2.getName());
		list.sort(comparator.reversed());

		// multi condition
		list.sort(Comparator.comparing(Human::getName).thenComparing(Human::getAge));

		list.forEach(h -> System.out.println(h.getName() + ", " + h.getAge()));
	}

}
