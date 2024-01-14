package com;

import java.sql.Array;
import java.util.*;

public class MainCore {

    public static void main(String[] args) {
        // String s = ")()())";
        String inputString = "()(()";

        // System.out.println("s = " + s.indexOf("()"));
        while (inputString.contains("()")) {
            inputString = inputString.replace("()", "__");
        }

        int currentSpaceLength = 0;
        int maxSpaceLength = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);
            if (currentChar == '_') {
                // Nếu là khoảng trắng, tăng độ dài của khoảng trắng hiện tại
                currentSpaceLength++;
            } else {
                // Nếu không phải khoảng trắng, kiểm tra xem độ dài hiện tại có lớn hơn max không
                if (currentSpaceLength > maxSpaceLength) {
                    maxSpaceLength = currentSpaceLength;
                }
                // Reset độ dài của khoảng trắng hiện tại
                currentSpaceLength = 0;
            }
        }

        System.out.println("s = " + inputString);

        // Kiểm tra lại sau vòng lặp cuối cùng
        if (currentSpaceLength > maxSpaceLength) {
            maxSpaceLength = currentSpaceLength;
        }

        System.out.println("Độ dài của khoảng trắng dài nhất là: " + maxSpaceLength);
    }

}
