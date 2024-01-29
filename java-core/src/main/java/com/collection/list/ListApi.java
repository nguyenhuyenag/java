package com.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Các phương thức trong List
 */
public class ListApi {

    // Cập nhật giá trị của List<List<Integer>>
    public static void updateInnerListValue() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>(Arrays.asList(1, 2, 3));
        list.add(innerList);
        list.get(0).add(1000);
        System.out.println("list = " + Arrays.deepToString(list.toArray()));
    }

    public static void main(String[] args) {
        updateInnerListValue();
    }

}
