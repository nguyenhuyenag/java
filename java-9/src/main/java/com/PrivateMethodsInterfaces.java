package com;

interface Foo {

	default void bar() {
		System.out.print("Hello ");
		baz();
	}

	private void baz() {
		System.out.println("world!");
	}
	
	static void buzz() {
        System.out.print("Hello");
        staticBaz();
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