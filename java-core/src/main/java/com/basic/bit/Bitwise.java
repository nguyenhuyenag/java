package com.basic.bit;

import java.util.ArrayList;
import java.util.List;

public class Bitwise {

//    /**
//     * Lặp qua mọi tập con của tập cho trước
//     */
//    public static void loopSubset(List<Integer> list) {
//        for (int mask = 0; mask < (1 << list.size()); mask++) {
//            List<Integer> result = new ArrayList<>();
//            for (int i = 0; i < list.size(); i++) {
//                if ((mask & (1 << i)) != 0) {
//                    result.add(list.get(i));
//                }
//            }
//            // Thực hiện thao tác gì đó với tập con A
//            System.out.println("Subset " + result);
//            // Thêm code thực hiện thao tác với tập con A tại đây
//        }
//    }
//
//    public static void main(String[] args) {
//        List<Integer> inputSet = List.of(1, 2, 3, 4);
//        loopSubset(inputSet);
//    }

//    // Function to generate all subsets of an array with a specified size using bitwise operations
//    public static void generateSubsets(int[] arr, int k) {
//        int n = arr.length;
//        // Total number of subsets is 2^n
//        int totalSubsets = 1 << n;
//        // Iterate through all possible subsets
//        for (int i = 0; i < totalSubsets; i++) {
//            // Count the number of set bits in the current subset bitmask
//            int count = Integer.bitCount(i);
//            // Check if the count matches the specified size
//            if (count == k) {
//                System.out.print("Subset " + (i + 1) + ": {");
//                // Include elements in the subset
//                for (int j = 0; j < n; j++) {
//                    if ((i & (1 << j)) != 0) {
//                        System.out.print(arr[j] + " ");
//                    }
//                }
//                System.out.println("}");
//            }
//        }
//    }

    // Print all subsets of given set[]
    public static void printSubsets(char[] set) {
        int n = set.length;
        // Run a loop for printing all 2^n subsets one by one
        for (int i = 0; i < (1 << n); i++) {
            System.out.print("{ ");
            // Print current subset
            for (int j = 0; j < n; j++)
                // (1<<j) is a number with j-th bit 1 so when we 'and' them with the subset
                // number we get which numbers are present in the subset and which are not
                if ((i & (1 << j)) > 0)
                    System.out.print(set[j] + " ");
            System.out.println("}");
        }
    }

    public static void main(String[] args) {
        char[] set = {'4', '2', '3', '4'};
        printSubsets(set);
    }

}
