package com.basic.number;

public class MathJava {

    // Convert `long` -> `int`
    public static void longToInt() {
        long longValue = 123;
        int intValue = Math.toIntExact(longValue);
        System.out.println(intValue);
    }

    public static void main(String[] args) {
        // longToInt();
        System.out.println((int) Math.signum(-1));
    }

}
