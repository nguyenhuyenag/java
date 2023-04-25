package com.lombox.builder;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
// @Builder(toBuilder = true)
public class BuilderBasic {

	private String email;
	private String address;
	private String country;
	private int age;

	public static void main(String[] args) {
		BuilderBasic john = BuilderBasic.builder() //
				.email("john@doe.com") //
				.country("England") //
				.age(20) //
				.build();
		System.out.println(john);
		// System.out.println(john.toBuilder()); // Need @Builder(toBuilder = true)
	}
}
