package com.collection.map;

import java.util.List;
import java.util.TreeMap;

/**
 * TreeMap giữ cho các cặp key-value TĂNG DẦN theo key
 */
public class TreeMapExample {

    public static void treeMap() {
        TreeMap<String, Integer> treeMap = init();
        System.out.println("TreeMap = " + treeMap);

        drawlines();
        // descendingKeySet(): Trả về danh sách key đảo ngược
        System.out.println("Danh sách key: " + treeMap.navigableKeySet());
        System.out.println("Đảo ngược Key: " + treeMap.descendingKeySet());
        System.out.println("Đảo ngược Map: " + treeMap.descendingMap());


        drawlines();
        System.out.println("Cắt Map từ đầu đến E:");
        // subMap trong khoảng [0, E), [0, E]
        System.out.println("\t[0, E): " + treeMap.headMap("seven"));
        System.out.println("\t[0, E]: " + treeMap.headMap("seven", true));
        System.out.println("Cắt Map từ E đến cuối:");
        // subMap trong khoảng [E, end], (E, end]
        System.out.println("\t[E, end]: " + treeMap.tailMap("six"));
        System.out.println("\t(E, end]: " + treeMap.tailMap("six", false));
        // Cắt map bất kỳ
        System.out.println("Cắt một đoạn bất kỳ:");
        System.out.println("\t[M, N): " + treeMap.subMap("five", "six"));
        System.out.println("\t(M, N): " + treeMap.subMap("five", false, "six", false));


        drawlines();
        // Tương tự có: higherKey(), higherEntry(), lowerKey(), lowerEntry()
        System.out.println("Tìm chặn trê, chặn dưới của một key: ");
        // ceilingKey(): Key (Entry) nhỏ nhất >= X
        System.out.println("Key nhỏ nhất >= 'one': " + treeMap.ceilingKey("one"));
        System.out.println("Entry nhỏ nhất có key >= 'one': {" + treeMap.ceilingEntry("one") + "}");
        // floorKey(): Key (Entry) lớn nhất <= X
        System.out.println("Key lớn nhất <= 'six': " + treeMap.floorKey("six"));
        System.out.println("Entry lớn nhất có key <= 'six': {" + treeMap.floorEntry("six") + "}");


        drawlines();
        // firstKey(): Key nhỏ nhất
        System.out.println("Key nhỏ nhất: " + treeMap.firstKey());
        System.out.println("Entry có key nhỏ nhất: {" + treeMap.firstEntry() + "}");
        // lastKey(): Key lớn nhất
        System.out.println("Key lớn nhất: " + treeMap.lastKey());
        System.out.println("Entry có key lớn nhất: {" + treeMap.lastEntry() + "}");


        drawlines();
        System.out.println("Get and remove MIN entry: {" + treeMap.pollFirstEntry() + "}");
        System.out.println("Get and remove MAX entry: {" + treeMap.pollLastEntry() + "}");

    }

    public static void main(String[] args) {
        treeMap();
    }

    public static void drawlines() {
        int n = 60;
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static TreeMap<String, Integer> init() {
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven", "eleven");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (String s : list) {
            treeMap.put(s, s.length());
        }
        return treeMap;
    }

}
