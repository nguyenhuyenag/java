package com.lombox.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StudentBuilder {

	private String firstName;
	private String lastName;
	private Long studentId;
	private String email;
	private String phoneNumber;
	private String address;
	private String country;
	private int age;

	public static void main(String[] args) {
		StudentBuilder john = StudentBuilder.builder() //
				.firstName("John") //
				.lastName("Doe") //
				.email("john@doe.com") //
				.country("England") //
				.age(20) //
				.build();
		System.out.println(john);
	}
}
