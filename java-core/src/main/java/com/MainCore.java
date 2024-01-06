package com;

import java.util.Arrays;
import java.util.Stack;

public class MainCore {

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(0);
        stack.push(0);
        stack.push(9);
        stack.push(4);
        stack.push(8);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

}
