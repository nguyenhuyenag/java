package com.interfaces.fi;

interface Hello {
	void sayHello(String name);
}

public class InterfaceImplByLambda {

	public void useAnonymous() {
		Hello h = new Hello() {
			@Override
			public void sayHello(String name) {
				System.out.println("Hello " + name);
			}
		};
		h.sayHello("Java");
	}

	public static void useLambda() {
		Hello h = (String name) -> System.out.println("Hello " + name);
		h.sayHello("Java");
	}

}
