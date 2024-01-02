package com;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 5, 2, 4));
        System.out.println("list = " + list.remove());
    }

}
