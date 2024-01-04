package com;

import java.util.Arrays;

public class MainCore {

    // [1, 2, 3, 4, 5, 6, 7] -> [7, 1, 2, 3, 4, 5, 6]
    public static void oneStep(int[] nums) {
        int len = nums.length;
        int lastItem = nums[len - 1];
        for (int i = len - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = lastItem;
        // System.out.println("arr = " + Arrays.toString(nums));
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        int k = 3;
        // Duyệt ngược mảng và in ra k phần tử cuối cùng
        for (int i = arr.length - k; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < arr.length - k; i++) {
            System.out.print(arr[i] + " ");
        }

    }

}
