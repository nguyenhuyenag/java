package com.basic;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Student {
	private String id;
	private String name;
	private String email;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student another = (Student) obj;
			if (this.id.equals(another.id)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return this.id.hashCode();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}

public class HashCodeAndEquals {

	public static void main(String[] args) {
		
		Student student1 = new Student("123", "Cong", "cong@gmail.com");
		Student student2 = new Student("123", "Cong", "cong@gmail.com");
		Student student3 = new Student("456", "Dung", "dung@gmail.com");

		Set<Student> setStudents = new HashSet<>();
		setStudents.add(student1);
		setStudents.add(student2);
		setStudents.add(student3);

		for (Student student : setStudents) {
			System.out.println(student);
		}
	}

}
