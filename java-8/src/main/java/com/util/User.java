package com.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String name;
	private int age;

	public static int compareByNameThenAge(User u1, User u2) {
		if (u1.name.equals(u2.name)) {
			return u1.age - u2.age;
		}
		return u1.name.compareTo(u2.name);
	}

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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

}
