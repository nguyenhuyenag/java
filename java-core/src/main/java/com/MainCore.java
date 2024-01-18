package com;

public class MainCore {

    public static int findLargestNumber(int k) {
        if (k == 1) {
            return 10;
        }
        int[] result = new int[1];
        boolean[] usedDigits = new boolean[10];
        findLargestNumberHelper(k, 0, usedDigits, result);
        return result[0];
    }

    private static void findLargestNumberHelper(int k, int currentNumber, boolean[] usedDigits, int[] result) {
        if (sumOfDigits(currentNumber) == k) {
            result[0] = Math.max(result[0], currentNumber);
            return;
        }
        for (int digit = 9; digit > 0; digit--) {
            if (!usedDigits[digit]) {
                int nextNumber = currentNumber * 10 + digit;
                usedDigits[digit] = true;
                findLargestNumberHelper(k, nextNumber, usedDigits, result);
                usedDigits[digit] = false;
            }
        }
    }

    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test với k = 23
        int kValue = 23;
        int result = findLargestNumber(kValue);
        System.out.println("Số lớn nhất với tổng các chữ số bằng " + kValue + ": " + result);
    }

}
