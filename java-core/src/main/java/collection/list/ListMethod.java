package collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Các phương thức trong List
 */
public class ListMethod {

    /**
     * remove(int index): Remove by index
     *
     * remove(Object o): Remove by value
     */
    public static void remove() {
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 3, 4, 5));
        int v1 = 2;
        Integer v2 = 2;
        Integer remove = list.remove(v1);
        boolean remove1 = list.remove(v2);
        System.out.println("list = " + list);
    }

    // Cập nhật giá trị của List<List<Integer>>
    public static void updateInnerListValue() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> innerList = new ArrayList<>(Arrays.asList(1, 2, 3));
        list.add(innerList);
        list.get(0).add(1000);
        System.out.println("list = " + Arrays.deepToString(list.toArray()));
    }

    public static void main(String[] args) {
        remove();
        // updateInnerListValue();
    }

}
