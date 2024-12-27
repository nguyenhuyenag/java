package com.iterface;

public class InterfaceImplByLambda {

    interface Hello {

        void sayHello(String name);

    }

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
