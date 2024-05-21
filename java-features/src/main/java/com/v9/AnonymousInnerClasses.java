package com.v9;

abstract class ABCD<T> {
    abstract T show(T a, T b);
}

public class AnonymousInnerClasses {

    public static void oldSyntax() {
        ABCD<String> a = new ABCD<String>() { // diamond operator is not empty
            String show(String a, String b) {
                return a + b;
            }
        };
        String result = a.show("Java", "9");
        System.out.println(result);
    }

    public static void newSyntax() {
        ABCD<String> a = new ABCD<>() { // diamond operator is empty, compiler infer type
            String show(String a, String b) {
                return a + b;
            }
        };
        String result = a.show("Java", "9");
        System.out.println(result);
    }

    public static void main(String[] args) {
        oldSyntax();
        newSyntax();
    }
}
