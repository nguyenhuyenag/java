package com.lombox;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.With;

@AllArgsConstructor
@Getter
class Person {
	private final String name;
	private final int age;

	@With
	private final String job;
}

public class Withs {

	public static void main(String[] args) {
		Person person = new Person("Alice", 30, "Software Engineer");
		Person newPerson = person.withJob("Product Manager");

		System.out.println(person.getName() + " is a " + person.getJob());
		System.out.println(newPerson.getName() + " is a " + newPerson.getJob());
	}

}
