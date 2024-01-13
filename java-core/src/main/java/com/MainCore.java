package com;

import java.sql.Array;
import java.util.*;

public class MainCore {

//    public static void rotate(int[][] matrix) {
//        int n = matrix.length;
//        // Hoán đổi các phần tử qua đường chéo chính (transpose the matrix)
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//
//        printMatrix(matrix);
//
//        // Reverse each row
//        for (int i = 0; i < n; i++) {
//            int left = 0, right = n - 1;
//            while (left < right) {
//                int temp = matrix[i][left];
//                matrix[i][left] = matrix[i][right];
//                matrix[i][right] = temp;
//                left++;
//                right--;
//            }
//        }
//    }
//
//    public static void printMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("-------------------");
//    }
//
//    public static void mai1n(String[] args) {
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//
//        printMatrix(matrix);
//
//        rotate(matrix);
//
//        printMatrix(matrix);
//    }

//    public static int countCommonElements(char[] array1, char[] array2) {
//        Set<Character> set1 = new HashSet<>();
//        Set<Character> set2 = new HashSet<>();
//        for (int i = 0; i < array1.length; i++) {
//            set1.add(array1[i]);
//            set2.add(array2[i]);
//        }
//        set1.retainAll(set2);
//        return set1.size();
//    }

    // chuyển t thành s
    public static int minSteps(String s, String t) {
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        // Arrays.sort(arr1);
        // Arrays.sort(arr2);
        int[] mark = new int[26];

        for (char ch : arr1) {
            mark[ch - 'a']++;
        }

        for (char ch : arr2) {
            mark[ch - 'a']--;
        }

        int count = Arrays.stream(mark).filter(v -> v > 0).sum();

        System.out.println(count);

        System.out.println("array1 = " + Arrays.toString(arr1));
        System.out.println("array2 = " + Arrays.toString(arr2));
        System.out.println(Arrays.toString(mark));

        return 1;
    }

    public static void main(String[] args) {
        // minSteps("bab", "aba");
        // minSteps("leetcode", "practice");
        minSteps("anagram", "mangaar");
    }

}
