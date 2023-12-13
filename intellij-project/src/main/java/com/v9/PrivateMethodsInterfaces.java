package com.v9;

interface Foo {

	default void bar() {
		System.out.print("Hello ");
		baz();
	}

	static void buzz() {
		System.out.print("Hello");
		staticBaz();
	}

	private void baz() {
		System.out.println("world!");
	}

	private static void staticBaz() {
		System.out.println(" static world!");
	}

}

public class PrivateMethodsInterfaces implements Foo {

	public static void main(String... args) {
		Foo customFoo = new PrivateMethodsInterfaces();
		customFoo.bar();
		Foo.buzz();
	}

}
