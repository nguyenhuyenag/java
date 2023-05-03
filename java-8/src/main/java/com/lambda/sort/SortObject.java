package com.lambda.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class Human {

	private String name;
	private int age;

	public static int compareByNameThenAge(Human lhs, Human rhs) {
		if (lhs.name.equals(rhs.name)) {
			return lhs.age - rhs.age;
		} else {
			return lhs.name.compareTo(rhs.name);
		}
	}
}

public class SortObject {

	public static void main(String[] args) {

		List<Human> list = new ArrayList<>();
		list.add(new Human("Sarah", 10));
		list.add(new Human("Jack", 12));

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
