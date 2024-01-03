package com.collection.list;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * LinkedList là hàng đợi 2 đầu
 */
public class LinkedListData {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 5, 2, 4));

        /**
         * INSERT DATA:
         *      add(index, value)
         *      addFirst()
         *      addLast()
         */
        list.add(2, 3);
        System.out.println("insert (3): " + list + "\n");
        list.addFirst(0);
        System.out.println("addFirst: " + list);
        list.addLast(5);
        System.out.println("addLast: " + list + "\n");

        /**
         * GET BUT DON'T REMOVE
         */
        // Phần tử đầu tiên: getFirst -> Exeption nếu list rỗng
        System.out.println("getFirst: " + list + " -> " + list.getFirst());
        System.out.println("getLast: " + list + " -> " + list.getLast());
        // Cuối cùng: peek -> null nếu list rỗng
        System.out.println("peek: " + list + " -> " + list.peek());
        System.out.println("peekFirst: " + list + " -> " + list.peekFirst());
        System.out.println("peekLast: " + list + " -> " + list.peekLast() + "\n");


        // indexOf và lastIndexOf
        System.out.println("indexOf (5): " + list + " -> " + list.indexOf(5));
        System.out.println("lastIndexOf (5): " + list + " -> " + list.lastIndexOf(5) + "\n");


        /**
         * Get và xóa dữ liệu
         */
        // Get & remove first item: -> null nếu list rỗng
        System.out.println("poll -> " + list.poll() + ", list = " + list);
        System.out.println("pollLast -> " + list.pollLast() + ", list = " + list);
        // -> NoSuchElementException nếu list rỗng
        System.out.println("pop -> " + list.pop() + ", list = " + list);

        /**
         * Xóa dữ liệu:
         *  remove()         =       removeFirst()
         *  remove(int)      ->      remove by index
         *  removeLast()     ->      Remove the last element
         */
        System.out.println("remove -> " + list.remove(0) + ", list = " + list);
    }

}
