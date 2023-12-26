package com.basic.charstring;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.String.copyValueOf;

public class StringClassApi {

    static String s1 = "This is a string";
    static String s2 = "1abc";

    public static void main(String[] args) {
        // charAt(): Trả về ký tự ở vị trí i
        System.out.println("charAt: " + s1.charAt(0));

        // chars(): Trả về luồng các mã unicode của các ký tự
        chars();

        // compareTo(): So sánh 2 chuỗi:
        compare();

        // concat(): Nối chuỗi
        System.out.println("concat: " + s1.concat(s2));

        // contains(): Check chuỗi con
        System.out.println("contains: " + s1.contains(s2));

        // copyValueOf(): Tạo chuỗi từ mảng ký tự
        copyValueOf();
    }

    /**
     * copyValueOf(char[]);
     * copyValueOf(char[], int offset, int count);
     */
    private static void copyValueOf() {
        char[] charArray = {'H', 'e', 'l', 'l', 'o'};
        // Sử dụng copyValueOf(char[] data) để tạo chuỗi từ mảng ký tự
        String str1 = String.copyValueOf(charArray);
        System.out.println("copyValueOf: " + str1);
        // Hoặc
        String str2 = String.copyValueOf(charArray, 0, 3);
        System.out.println("copyValueOf: " + str2);
    }

    public static void chars() {
        IntStream chars = s1.chars();
        System.out.println("chars: " + Arrays.toString(chars.toArray()));
    }

    /**
     * kq < 0 => s1 < s2
     * kq = 0 => s1 = s2
     * kq > 0 => s1 > s2
     */
    public static void compare() {
        String s3 = "1Abc";
        System.out.println("compareTo: " + s1.compareTo(s2));
        System.out.println("compareToIgnoreCase: " + s2.compareToIgnoreCase(s3));
    }

}
