package com.collection.map;

import java.util.AbstractMap;

public class PairClass {

    public static void main(String[] args) throws Exception {
        AbstractMap.SimpleEntry<Integer, String> entry = new AbstractMap.SimpleEntry<>(1, "one");
        Integer key = entry.getKey();
        String value = entry.getValue();
        System.out.println("key = " + key + ", value = " + value);
    }

}
