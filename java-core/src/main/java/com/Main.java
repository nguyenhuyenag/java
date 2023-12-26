package com;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'f'};
        int[] charCount = new int[256];

        for (char c : arr) {
            charCount[c]++;
        }

        for (int i = 0; i < charCount.length; i++) {
            // Ví dụ: charCount[i] = charCount['a']
            if (Character.isLetter(i)) {
                System.out.println(i + ", " + (char) i + " : " + charCount[i]);
            }
        }
    }

}
