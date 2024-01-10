package com.basic.bit;

import java.util.ArrayList;
import java.util.List;

public class Bitwise {

    /**
     * Lặp qua mọi tập con của tập cho trước
     */
    public static void loopSubset(List<Integer> list) {
        for (int mask = 0; mask < (1 << list.size()); mask++) {
            List<Integer> a = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if ((mask & (1 << i)) != 0) {
                    a.add(list.get(i));
                }
            }
            // Thực hiện thao tác gì đó với tập con A
            System.out.println("Subset " + a);
            // Thêm code thực hiện thao tác với tập con A tại đây
        }
    }

    public static void main(String[] args) {
        List<Integer> inputSet = List.of(1, 2, 3, 4);
        loopSubset(inputSet);
    }

}
