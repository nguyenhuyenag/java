package com.collection.set;

import java.util.TreeSet;

/**
 * Lưu giữ các giá trị theo thứ tự TĂNG DẦN và không trùng nhau
 */
public class TreeSetExample {

    public static void treeSet() {
        TreeSet<Integer> treeSet = init();
        System.out.println("TreeSet = " + treeSet);

        drawlines();
        System.out.println("Trả về tập hợp dạng đảo ngược tập hợp: " + treeSet.descendingSet());

        drawlines();
        System.out.println("Tìm chặn trên, chặn dưới: ");
        // ceiling(): Phần tử nhỏ nhất >= 6
        System.out.println("ceiling = " + treeSet.ceiling(6));
        // higher(): Phần tử nhỏ nhất > 6
        System.out.println("higher = " + treeSet.higher(6));

        // floor(): Phần tử lớn nhất <= 6
        System.out.println("floor = " + treeSet.floor(6));
        // lower(): Phần tử lớn nhất < 6
        System.out.println("lower = " + treeSet.lower(6));

        drawlines();
        System.out.println("Tìm MIN, MAX của tập hợp: ");
        // first(): Phần tử nhỏ nhất trong tập hợp
        System.out.println("min = " + treeSet.first());
        // last(): Phần tử lớn nhất trong tập hợp
        System.out.println("max = " + treeSet.last());

        drawlines();
        System.out.println("Tìm tập con nào đó:");
        // headSet(): Trả về tập hợp những phần tử < k hoặc <= k
        System.out.println("Những số < k: " + treeSet.headSet(5)); // < k
        System.out.println("Những số <= k: " + treeSet.headSet(5, true)); // <= k

        // tailSet(): Trả về tập hợp những phần tử > k hoặc >= k
        System.out.println("Những số > k: " + treeSet.tailSet(5)); // > k
        System.out.println("Những số >= k " + treeSet.tailSet(5, true)); // >= k

        // subSet(): Trả về các phần tử thuộc [m, n], (m, n), [m, n), (m, n]
        System.out.println("Thuộc khoảng [2, 7): " + treeSet.subSet(2, 7));
        System.out.println("Thuộc khoảng [2, 7]: " + treeSet.subSet(2, true, 7, true));
        System.out.println("Thuộc khoảng (2, 7): " + treeSet.subSet(2, false, 7, false));

        drawlines();
        System.out.println("Các phép toán trên tập hợp:");
        // pollFirst(): Lấy ra và xóa phần tử nhỏ nhất
        System.out.println("Get and remove MIN: " + treeSet.pollFirst());
        // pollLast(): Lấy ra và xóa phần tử lớn nhất
        System.out.println("Get and remove MAX = " + treeSet.pollLast());
        // remove(): Xóa một phần tử được chỉ định
        System.out.println("remove = " + treeSet.remove(4));
        System.out.println("Current TreeSet = " + treeSet);

    }

    public static void main(String[] args) {
        treeSet();
    }

    public static void drawlines() {
        int n = 45;
        for (int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static TreeSet<Integer> init() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            treeSet.add(i);
        }
        return treeSet;
    }

}
