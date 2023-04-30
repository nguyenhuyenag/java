package com.optional;

import java.util.Optional;

class Student {

	private String name;
	private int age;

	public Student() {

	}

	public Student(String name, int age) {
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

}

public class OfNullable {

	static Student getNullStudent() {
		return new Student();
	}

	static Student getReallStudent() {
		return new Student("java8.com", 25);
	}

	static void preJava8() {
		Student student = getReallStudent();
		if (student != null) {
			System.out.println(student.getName());
		}
	}

	static void Java8GetAndIsPresent() {
		Student student = getReallStudent();
		Optional<Student> opt = Optional.ofNullable(student);
		if (opt.isPresent()) {
			System.out.println(opt.get().toString());
		}
	}

	static void Java8IfPresent() {
		Student student = getReallStudent();
		Optional<Student> opt = Optional.ofNullable(student);
		opt.ifPresent(s -> System.out.println(s.toString()));
	}

	public static void main(String[] args) {
		Java8GetAndIsPresent();
		Java8IfPresent();
	}

}
