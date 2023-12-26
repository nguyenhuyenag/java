package com.basic.charstring;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StringClassApi {

    static String s1 = "This is a string";
    static String s2 = "1abc";

    public static void main(String[] args) {
        // charAt(): Trả về ký tự ở vị trí i
        System.out.println("charAt: " + s1.charAt(0));

        // chars(): Trả về luồng các mã unicode của các ký tự
        chars();

        // getBytes(): Chuyển thành mảng byte (mã unicode)
        System.out.println("getBytes: " + Arrays.toString(s1.getBytes()));

        // compareTo(): So sánh 2 chuỗi:
        compare();

        // concat(): Nối chuỗi
        System.out.println("concat: " + s1.concat(s2));

        // contains(): Check chuỗi con
        System.out.println("contains: " + s1.contains(s2));

        // copyValueOf(): Tạo chuỗi từ mảng ký tự
        copyValueOf();

        // endsWith(): Kiểm tra xem chuỗi có kết thúc bằng một chuỗi con nào đó
        System.out.println("endsWith: " + s1.endsWith("ing"));

        // indent(): Thụt đầu dòng
        indent();

        // indexOf(): Vị trí của chuỗi hoặc ký tự trong chuỗi khác
        indexOf();

        // join(): Ghép 'nhiều chuỗi, mảng, Collections<? extends CharSequence>' thành chuỗi
        join();

        // matches(): Kiểm tra xem chuỗi có khớp với một biểu thức chính quy
        matches();

        // repeat(): Lặp chuỗi n lần
        System.out.println("repeat: " + "xyz".repeat(3));
    }

    public static void matches() {
        String email = "example@email.com";
        boolean isEmail = email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        System.out.println("matches (email): " + isEmail);
    }

    public static void join() {
        System.out.println("join: " + String.join("-", "A", "B", "C"));
        System.out.println("join: " + String.join("*", List.of("A", "B", "C", "D")));
    }

    /**
     * indexOf(int ch)
     * indexOf(int ch, int fromIndex)
     * <p>
     * lastIndexOf()
     */
    public static void indexOf() {
        int idx1 = s1.indexOf('i');
        System.out.println("indexOf (1st): " + idx1);
        System.out.println("indexOf (2nd): " + s1.indexOf("i", idx1 + 1));
        System.out.println("lastIndexOf: " + s1.lastIndexOf("i"));
    }

    public static void indent() {
        String originalString = "This is a\nmulti-line\nstring.";
        // Sử dụng phương thức indent() để thụt lề mỗi dòng
        String indentedString = originalString.indent(4);
        // In ra chuỗi ban đầu và chuỗi đã thụt lề
        System.out.println("\nindent:\n" + indentedString);
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
