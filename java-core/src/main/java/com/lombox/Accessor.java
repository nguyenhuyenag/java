package com.lombox;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
// @Accessors(fluent = true)
@Accessors(chain = true)
class User {

	private String name;
	private int age;

}

public class Accessor {

	public static void main(String[] args) {
		User user = new User();
		// user.name("Alice").age(30); 		// Accessors fluent
		user.setName("Alice").setAge(30); 	// Accessors chain
		System.out.println(user);
	}

}
